<#
.SYNOPSIS
    Complete one-file setup script for the CARLA Scene Graph + VIATRA project.

.DESCRIPTION
    This script automates all post-clone setup steps:
    - Downloads CARLA 0.9.16 into carla\CARLA_0.9.16
    - Creates Python virtual environment (.venv)
    - Installs CARLA wheel from included source
    - Installs pyzmq (required by the carla2ecore publisher and replay_scenes.py)
    - Verifies directory structure
    - Validates all components

    PREREQUISITES: See QUICKSTART.md step 1 before running this script.

.EXAMPLE
    .\SETUP.ps1

.EXAMPLE
    .\SETUP.ps1 -NoCarla
    Skips the CARLA download, for replaying recordings only.

.NOTES
    - Requires Python 3.12 in PATH (matches the included CARLA wheel cp312)
    - Python 3.13+ is NOT supported
    - Requires PowerShell ExecutionPolicy set to RemoteSigned (or run it with -ExecutionPolicy Bypass)
    - Run from repository root directory
#>

param(
    [switch]$SkipPythonCheck = $false,
    [switch]$Force = $false,
    [switch]$NoCarla = $false
)

$ErrorActionPreference = "Stop"
$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$repoRoot = $scriptDir
$carlaRoot = Join-Path $repoRoot 'carla'
if (-not (Test-Path $carlaRoot)) { New-Item -ItemType Directory -Path $carlaRoot -Force | Out-Null }

Write-Host ""
Write-Host "CARLA Scene Graph + VIATRA Setup" -ForegroundColor Cyan
Write-Host "CARLA 0.9.16" -ForegroundColor DarkGray
Write-Host ""

function Check-Prerequisite {
    param(
        [Parameter(Mandatory = $true)][string]$Name,
        [Parameter(Mandatory = $true)][string]$Command,
        [Parameter(Mandatory = $true)][string]$ErrorMsg
    )

    Write-Host "  Checking: $Name ... " -NoNewline

    try {
        $result = Invoke-Expression "$Command 2>&1"
        if ($LASTEXITCODE -eq 0 -or $result) {
            Write-Host "[OK]" -ForegroundColor Green
            return $true
        }
        else {
            Write-Host "[FAILED]" -ForegroundColor Red
            Write-Host "  Error: $ErrorMsg" -ForegroundColor Yellow
            return $false
        }
    }
    catch {
        Write-Host "[FAILED]" -ForegroundColor Red
        Write-Host "  Error: $ErrorMsg" -ForegroundColor Yellow
        return $false
    }
}

# curl resumes a broken download and shows progress, and tar unpacks far faster than
# Expand-Archive. Named in full, since Git can put its own tar on the PATH.
function Get-Archive {
    param(
        [Parameter(Mandatory = $true)][string]$Url,
        [Parameter(Mandatory = $true)][string]$Zip,
        [Parameter(Mandatory = $true)][string]$Destination
    )

    & "$env:WINDIR\System32\curl.exe" -L --fail --retry 3 -C - -o $Zip $Url
    if ($LASTEXITCODE -ne 0) { throw "Download failed: $Url" }
    Write-Host "  Unpacking (this may take several minutes)..."
    New-Item -ItemType Directory -Force $Destination | Out-Null
    & "$env:WINDIR\System32\tar.exe" -xf $Zip -C $Destination
    if ($LASTEXITCODE -ne 0) { throw "Could not unpack $Zip" }
    Remove-Item $Zip -Force
}

function Check-File {
    param(
        [Parameter(Mandatory = $true)][string]$Path,
        [Parameter(Mandatory = $true)][string]$Description
    )

    Write-Host "  Checking: $Description ... " -NoNewline

    if (Test-Path $Path) {
        Write-Host "[OK]" -ForegroundColor Green
        return $true
    }
    else {
        Write-Host "[NOT FOUND]" -ForegroundColor Red
        Write-Host "  Expected: $Path" -ForegroundColor Yellow
        return $false
    }
}

Write-Host "[STEP 1] Verifying Prerequisites" -ForegroundColor Cyan

$checks = @()

# The CARLA wheel needs Python 3.12, and `python` may be another version.
$pythonExe = "python"
$pythonArgs = @()
if (-not $SkipPythonCheck) {
    try {
        if ((& py -3.12 --version 2>&1) -match "Python 3\.12") {
            $pythonExe = "py"
            $pythonArgs = @("-3.12")
        }
    }
    catch {
        # No Python launcher, so `python` has to be 3.12.
    }
    $checks += Check-Prerequisite -Name "Python 3.12" -Command "$pythonExe $pythonArgs --version | Select-String 'Python 3\.12'" `
        -ErrorMsg "Python 3.12 not found. See QUICKSTART.md step 1"
}

if ($checks -contains $false) {
    Write-Host ""
    Write-Host "[X] SETUP FAILED: Some prerequisites are missing." -ForegroundColor Red
    Write-Host "  Please follow QUICKSTART.md step 1 before running this script." -ForegroundColor Red
    exit 1
}

Write-Host ""
Write-Host "[OK] All prerequisites found" -ForegroundColor Green
Write-Host ""

Write-Host "[STEP 2] Installing CARLA 0.9.16" -ForegroundColor Cyan

$carlaPath = "$carlaRoot\CARLA_0.9.16"
$carlaExe = "$carlaPath\CarlaUE4.exe"

if ($NoCarla) {
    Write-Host "  Skipped (-NoCarla)"
}
elseif (Test-Path $carlaExe) {
    Write-Host "  [OK] CARLA 0.9.16 already installed at: $carlaPath" -ForegroundColor Green
}
else {
    Write-Host "  Downloading CARLA 0.9.16 (8 GB, 20 GB once unpacked)..."
    $carlaUrl = "https://carla-releases.s3.us-east-005.backblazeb2.com/Windows/CARLA_0.9.16.zip"
    try {
        Get-Archive -Url $carlaUrl -Zip "$carlaRoot\CARLA_0.9.16.zip" -Destination $carlaPath
    }
    catch {
        Write-Host "  [X] FAILED to download/install CARLA: $($_.Exception.Message)" -ForegroundColor Red
        Write-Host "  Run this script again to resume the download." -ForegroundColor Yellow
        exit 1
    }
    if (-not (Test-Path $carlaExe)) {
        Write-Host "  [X] CARLA installation verification failed" -ForegroundColor Red
        Write-Host "  Expected executable at: $carlaExe" -ForegroundColor Yellow
        exit 1
    }
    Write-Host "  [OK] CARLA installed at: $carlaPath" -ForegroundColor Green
}

# The paper's scenarios run on Town06, which isn't in the base CARLA package.
if (-not $NoCarla) {
    if (Test-Path "$carlaPath\CarlaUE4\Content\Carla\Maps\Town06.umap") {
        Write-Host "  [OK] CARLA's additional maps already installed" -ForegroundColor Green
    }
    else {
        Write-Host "  Downloading CARLA's additional maps (7 GB)..."
        try {
            Get-Archive -Zip "$carlaRoot\AdditionalMaps_0.9.16.zip" -Destination $carlaPath `
                -Url "https://carla-releases.s3.us-east-005.backblazeb2.com/Windows/AdditionalMaps_0.9.16.zip"
        }
        catch {
            Write-Host "  [X] FAILED to download/install the maps: $($_.Exception.Message)" -ForegroundColor Red
            Write-Host "  Run this script again to resume the download." -ForegroundColor Yellow
            exit 1
        }
        Write-Host "  [OK] CARLA's additional maps installed" -ForegroundColor Green
    }
}

Write-Host ""

Write-Host "[STEP 3] Setting Up Python Virtual Environment" -ForegroundColor Cyan

$venvPath = Join-Path $carlaRoot ".venv"

if (Test-Path $venvPath) {
    Write-Host "  Virtual environment already exists at: $venvPath"
    if (-not $Force) {
        $response = Read-Host "  Remove and recreate? (y/n)"
        if ($response -ne "y") {
            Write-Host "  Skipping venv recreation"
        }
        else {
            Write-Host "  Removing old venv ... " -NoNewline
            Remove-Item -Recurse -Force $venvPath | Out-Null
            Write-Host "[OK]" -ForegroundColor Green
            & $pythonExe @pythonArgs -m venv $venvPath
        }
    }
}
else {
    Write-Host "  Creating virtual environment at: $venvPath"
    & $pythonExe @pythonArgs -m venv $venvPath
    if ($LASTEXITCODE -ne 0) {
        Write-Host "[X] FAILED to create venv" -ForegroundColor Red
        exit 1
    }
    Write-Host "  [OK] Virtual environment created" -ForegroundColor Green
}

# Activate venv
$activateScript = Join-Path $venvPath "Scripts\Activate.ps1"
if (-not (Test-Path $activateScript)) {
    Write-Host "[X] FAILED: Cannot find activation script" -ForegroundColor Red
    exit 1
}

Write-Host "  Activating virtual environment ... " -NoNewline
& $activateScript
Write-Host "[OK]" -ForegroundColor Green

Write-Host ""

Write-Host "[STEP 4] Installing Python Dependencies" -ForegroundColor Cyan

if (-not $NoCarla) {
    $wheelName = "carla-0.9.16-cp312-cp312-win_amd64.whl"
    $wheelPath = Join-Path $carlaRoot "PythonAPI\carla\dist\$wheelName"

    # If wheel not present in repo (it is excluded from git), search in CARLA distribution
    if (-not (Test-Path $wheelPath)) {
        Write-Host "  Wheel not found in PythonAPI/carla/dist/ - searching CARLA distribution..." -ForegroundColor Yellow
        $found = Get-ChildItem -Path $carlaPath -Filter $wheelName -Recurse -ErrorAction SilentlyContinue | Select-Object -First 1
        if ($found) {
            Write-Host "  Found wheel at: $($found.FullName)" -ForegroundColor Cyan
            $distDir = Split-Path $wheelPath -Parent
            if (-not (Test-Path $distDir)) { New-Item -ItemType Directory -Path $distDir -Force | Out-Null }
            Copy-Item $found.FullName -Destination $wheelPath -Force
            Write-Host "  Copied to: $wheelPath" -ForegroundColor Green
        }
        else {
            Write-Host "  [X] CARLA Python wheel not found." -ForegroundColor Red
            Write-Host "  Copy '$wheelName' to '$wheelPath' and re-run, or install manually." -ForegroundColor Yellow
            Write-Host "  Source: PythonAPI\carla\dist\ from original project folder" -ForegroundColor Yellow
            exit 1
        }
    }

    Write-Host "  Installing: $wheelName"
    Write-Host "  From: $wheelPath"
    Write-Host ""
}

python -m pip install --upgrade pip --quiet 2>&1 | Out-Null
if ($LASTEXITCODE -ne 0) {
    Write-Host "  [WARNING] pip upgrade had issues (continuing)" -ForegroundColor Yellow
}

if (-not $NoCarla) {
    python -m pip install "$wheelPath" --quiet
    if ($LASTEXITCODE -eq 0) {
        Write-Host "  [OK] CARLA wheel installed successfully" -ForegroundColor Green
    }
    else {
        Write-Host "[X] FAILED to install CARLA wheel" -ForegroundColor Red
        Write-Host "  Try running: python -m pip install '$wheelPath'" -ForegroundColor Yellow
        exit 1
    }

    Write-Host ""
}

Write-Host "  Installing: pyzmq (required by the carla2ecore publisher and replay_scenes.py)"
python -m pip install pyzmq --quiet
if ($LASTEXITCODE -eq 0) {
    Write-Host "  [OK] pyzmq installed successfully" -ForegroundColor Green
}
else {
    Write-Host "[X] FAILED to install pyzmq" -ForegroundColor Red
    Write-Host "  Try running: python -m pip install pyzmq" -ForegroundColor Yellow
    exit 1
}

Write-Host ""

Write-Host "[STEP 5] Verifying CARLA Module" -ForegroundColor Cyan

$testScript = @"
try:
    import carla
    print('CARLA module import OK')
    print('SUCCESS')
except Exception as e:
    print(f'ERROR: {e}')
"@

$output = if ($NoCarla) { "" } else { python -c $testScript }

if ($NoCarla) {
    Write-Host "  Skipped (-NoCarla)"
}
elseif ($output -match "SUCCESS") {
    Write-Host "  [OK] CARLA module imports successfully" -ForegroundColor Green
    $versionLine = $output | Select-String "CARLA module"
    if ($versionLine) {
        Write-Host "  $versionLine"
    }
}
else {
    Write-Host "[X] FAILED to import CARLA module" -ForegroundColor Red
    Write-Host "  Output: $output" -ForegroundColor Yellow
    exit 1
}

Write-Host ""

Write-Host "[STEP 6] Verifying Directory Structure" -ForegroundColor Cyan

$requiredDirs = @(
    "carla\data",
    "carla\data\stream",
    "carla\data\stream\snapshots",
    "carla\data\capture",
    "carla\data\results",
    "carla\src",
    "carla\scripts",
    "carla\PythonAPI",
    "carla\logs"
)

$missingDirs = @()

foreach ($dir in $requiredDirs) {
    $fullPath = Join-Path $repoRoot $dir
    if (Test-Path $fullPath) {
        Write-Host "  [OK] $dir" -ForegroundColor Green
    }
    else {
        Write-Host "  [+] $dir (created)" -ForegroundColor Green
        New-Item -ItemType Directory -Path $fullPath -Force | Out-Null
        $missingDirs += $dir
    }
}

if ($missingDirs.Count -gt 0) {
    Write-Host "  Created: $($missingDirs -join ', ')" -ForegroundColor Green
}

Write-Host ""

Write-Host "[STEP 7] Setup Summary" -ForegroundColor Cyan
Write-Host ""
Write-Host "[OK] SETUP COMPLETE!" -ForegroundColor Green
Write-Host ""
Write-Host "Summary:"
Write-Host "  * Python virtual environment: $venvPath"
if ($NoCarla) {
    Write-Host "  * CARLA: skipped. Run .\SETUP.ps1 without -NoCarla to add it later."
}
else {
    Write-Host "  * CARLA server: $carlaPath"
}
Write-Host ""
Write-Host "Next: follow QUICKSTART.md to import the projects into Eclipse and run them." -ForegroundColor Cyan
Write-Host ""
