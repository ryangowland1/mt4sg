<#
.SYNOPSIS
    One-click launcher for CARLA scenarios under mt4sg/carla/src/.

.DESCRIPTION
    Resolves scenario_<name>.py inside ../src/, picks the project venv as
    the interpreter, optionally pre-cleans stray vehicles in the CARLA
    world to prevent "Could not spawn" failures from prior crashed runs,
    then execs the scenario. Extra positional args after <name> are
    forwarded to the scenario script unchanged.

    The project venv at ../.venv is preferred. Fallbacks are global
    Python 3.12 then 3.10 then plain `python`.

.EXAMPLE
    .\scripts\run_scenario.ps1                       # list available scenarios
    .\scripts\run_scenario.ps1 ego_follow
    .\scripts\run_scenario.ps1 ego_follow -NoClean
    .\scripts\run_scenario.ps1 traffic --ticks 100
#>
param(
    [Parameter(Position=0)][string]$Name,
    [switch]$NoClean,
    [string]$CarlaAddress = "127.0.0.1",
    [int]$Port = 2000,
    [Parameter(ValueFromRemainingArguments=$true)]$ScenarioArgs
)

$ErrorActionPreference = "Stop"

$srcDir = [System.IO.Path]::GetFullPath((Join-Path $PSScriptRoot "..\src"))

$scenarios = Get-ChildItem -Path $srcDir -Filter "scenario_*.py" |
    ForEach-Object { $_.BaseName -replace "^scenario_", "" } |
    Sort-Object

if (-not $Name) {
    Write-Host "Available scenarios:" -ForegroundColor Cyan
    foreach ($s in $scenarios) { Write-Host "  $s" }
    Write-Host ""
    Write-Host "Usage: .\scripts\run_scenario.ps1 <name> [extra args...]" -ForegroundColor Yellow
    exit 0
}

$script = Join-Path $srcDir "scenario_$Name.py"
if (-not (Test-Path $script)) {
    Write-Host "Scenario not found: $script" -ForegroundColor Red
    Write-Host "Available:" -ForegroundColor Cyan
    foreach ($s in $scenarios) { Write-Host "  $s" }
    exit 1
}

function Test-PythonHasCarla {
    param([string]$Exe, [string[]]$ExtraArgs = @())
    try {
        & $Exe @ExtraArgs -c "import carla" 2>$null
        return ($LASTEXITCODE -eq 0)
    } catch { return $false }
}

$venvPy = [System.IO.Path]::GetFullPath((Join-Path $PSScriptRoot "..\.venv\Scripts\python.exe"))
$python = $null
$pyArgs = @()
$candidates = @()
if (Test-Path $venvPy) { $candidates += ,@($venvPy, @()) }
$candidates += ,@("py",     @("-3.12"))
$candidates += ,@("py",     @("-3.10"))
$candidates += ,@("python", @())
foreach ($c in $candidates) {
    if (Test-PythonHasCarla -Exe $c[0] -ExtraArgs $c[1]) {
        $python = $c[0]; $pyArgs = $c[1]; break
    }
}
if (-not $python) {
    Write-Host "No Python with carla installed was found." -ForegroundColor Red
    Write-Host "Expected venv at: $venvPy" -ForegroundColor Yellow
    exit 1
}

Write-Host "==[ CARLA scenario: $Name ]==" -ForegroundColor Cyan
Write-Host "Python  : $python $($pyArgs -join ' ')"
Write-Host "Script  : $script"

if (-not $NoClean) {
    Write-Host "Cleanup : destroying stray vehicles..." -ForegroundColor DarkGray
    $cleanupSnippet = @"
import sys, os, glob, time
api = os.path.abspath(os.path.join(r'$srcDir', '..', 'PythonAPI', 'carla'))
for w in glob.glob(os.path.join(api, 'dist', 'carla-*.whl')):
    if w not in sys.path: sys.path.append(w)
sys.path.append(api)
try:
    import carla
    client = carla.Client('$CarlaAddress', $Port)
    client.set_timeout(5.0)
    world = client.get_world()
    for _ in range(5):
        actors = list(world.get_actors().filter('vehicle.*'))
        if not actors: break
        for a in actors:
            try: a.destroy()
            except: pass
        time.sleep(0.5)
    print('  remaining:', len(world.get_actors().filter('vehicle.*')))
except Exception as e:
    print(f'  skipped (CARLA not reachable): {e}')
"@
    & $python @pyArgs -c $cleanupSnippet
}

Write-Host ""
Write-Host "Launching. Ctrl+C to stop." -ForegroundColor Green
Write-Host ""
& $python @pyArgs $script @ScenarioArgs
