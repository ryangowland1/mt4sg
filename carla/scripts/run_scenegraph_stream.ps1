param(
    [string]$Carla2Ecore = (Join-Path $PSScriptRoot "..\..\..\carla2ecore"),
    [int]$Ticks = 0,
    [double]$Interval = 0.1,
    [string]$CarlaAddress = "127.0.0.1",
    [int]$Port = 2000,
    [string]$OutDir = ".\data\stream"
)

$ErrorActionPreference = "Stop"

# Pick a Python interpreter that has pyzmq installed.
function Test-PythonHasZmq {
    param([string]$Exe, [string[]]$ExtraArgs = @())
    try {
        $out = & $Exe @ExtraArgs -c "import zmq; print(zmq.__version__)" 2>$null
        return ($LASTEXITCODE -eq 0 -and $out)
    } catch { return $false }
}

$venvPy = [System.IO.Path]::GetFullPath((Join-Path $PSScriptRoot "..\.venv\Scripts\python.exe"))
$python = $null
$pyArgs = @()
$candidates = @()
if (Test-Path $venvPy) { $candidates += ,@($venvPy, @()) }
$candidates += ,@("py",     @("-3.10"))
$candidates += ,@("py",     @("-3.11"))
$candidates += ,@("python", @())
$candidates += ,@("py",     @())
foreach ($c in $candidates) {
    if (Test-PythonHasZmq -Exe $c[0] -ExtraArgs $c[1]) {
        $python = $c[0]; $pyArgs = $c[1]; break
    }
}
if (-not $python) {
    Write-Error "No Python with pyzmq installed was found. Install with:  py -3.10 -m pip install pyzmq"
    exit 1
}

$script = [System.IO.Path]::GetFullPath((Join-Path $Carla2Ecore "python\publisher.py"))
if (-not (Test-Path $script)) {
    Write-Error "carla2ecore not found at $Carla2Ecore. Clone it next to mt4sg."
    exit 1
}

$argsList = @(
    $script,
    "--out-dir", $OutDir,
    "--interval", "$Interval",
    "--ticks", "$Ticks",
    "--carla-address", $CarlaAddress,
    "--port", "$Port"
)

Write-Host "Running the Carla2Ecore publisher..."
Write-Host "  Python: $python $($pyArgs -join ' ')"
Write-Host "  Script: $script"
Write-Host "  Output: $OutDir"

& $python @pyArgs @argsList
