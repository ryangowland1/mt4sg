# Quick start

This guide takes you from a clean Windows machine to a running tool.

## 1. Requirements

| Tool | Download | Check in a new terminal |
|---|---|---|
| Git | https://git-scm.com/download/win | `git --version` |
| Python 3.12 | https://www.python.org/downloads/ | `py -3.12 --version` |
| Eclipse Modeling Tools 2025-06 | Step 3 below | It brings its own Java |

You also need about 50 GB of free disk space.

## 2. Download the code and CARLA

Make a folder named `mt4sg-tools` in a short path, such as `C:\`, since CARLA's Python library won't load from a very long one. Clone this repository and Carla2Ecore into it:

```
mt4sg-tools\
    mt4sg\
    carla2ecore\
```

Then run the setup from the `mt4sg` folder:

```powershell
powershell -ExecutionPolicy Bypass -File SETUP.ps1
```

`SETUP.ps1` downloads CARLA 0.9.16 with its additional maps (15 GB) and creates the Python environment. If a download stops, run it again and it resumes. It ends with `[OK] SETUP COMPLETE!`.

## 3. Install Eclipse

1. Download [Eclipse Modeling Tools 2025-06](https://download.eclipse.org/technology/epp/downloads/release/2025-06/R/eclipse-modeling-2025-06-R-win32-x86_64.zip).
2. Unzip it into `mt4sg-tools`, so that `mt4sg-tools\eclipse\eclipse.exe` exists. You now have:
   ```
   mt4sg-tools\
       mt4sg\          the tool, with CARLA in carla\CARLA_0.9.16\
       carla2ecore\    the bridge between CARLA and EMF
       eclipse\        Eclipse
   ```
3. Start `eclipse.exe`. When it asks for a workspace, enter the folder `workspace` inside `mt4sg-tools`.
4. Install Xtext:
   1. Choose **Help > Install New Software**.
   2. In **Work with**, enter `https://download.eclipse.org/releases/2025-06` and press Enter.
   3. Open **Modeling**, tick **Xtext Complete SDK**, and click **Next** until you can accept the license and click **Finish**.
   4. If Eclipse asks whether to trust the content, accept it. Click **Restart Now** when it offers to.
5. Install VIATRA the same way, with `https://download.eclipse.org/viatra/updates/release/2.9.1` in **Work with**. Open **VIATRA Core** and tick **VIATRA Query and Transformation SDK**.

## 4. Import everything into Eclipse

1. Choose **File > Import > General > Existing Projects into Workspace** and click **Next**.
2. Next to **Select root directory**, click **Browse** and pick the `mt4sg-tools` folder.
3. Eclipse lists 6 projects. Leave them all ticked, leave **Copy projects into workspace** unticked, and click **Finish**:
   - `ca.mcmaster.carla2ecore`
   - `ca.mcmaster.mt4sg.boot`
   - `ca.mcmaster.mt4sg.core`
   - `ca.mcmaster.mt4sg.models`
   - `ca.mcmaster.mt4sg.queries`
   - `ca.mcmaster.mt4sg.visualization`
4. Wait for the build to finish. The **Problems** view should show 0 errors. Warnings are fine.

The generated EMF, VIATRA, and Xtend code is included, so no generator has to run first. If errors remain, choose **Project > Clean > Clean all projects**.

## 5. Check the bridge

In the Package Explorer, open `ca.mcmaster.carla2ecore > examples/src`, right-click `UpdaterCheck`, and choose **Run As > Java Application**. The console ends with `All checks passed`.

## 6. Replay a recording

1. Choose **Run > Run Configurations**, open **Launch Group**, select **Mt4sgReplayPipeline**, and click **Run**.
2. When it asks for a file, pick `mt4sg\examples\recordings\scenario-a-lead-brakes-10-external.jsonl.gz`.

The listener starts, and the recording then plays at 10 scenes per second. The console shows every edge as it's created, updated, or removed:

```
[15:18:34.464] Runner - [Runner] EventDrivenTransformation active.
[15:18:34.470] Runner - [Runner] Subscribing for scene snapshots: tcp://127.0.0.1:5556
INFO: Subscribed to tcp://127.0.0.1:5556
[15:18:37.221] Transformations - Created SpatialEdge: veh-ego -> veh-other1 (FRONT)
[15:18:37.238] Transformations - Created LongitudinalRSSViolation: veh-ext-0 -> veh-ext-1
```

The `WARNING: No attribute` lines are normal: the publisher sends a position for every road and lane, and the metamodel only keeps it for vehicles.

To watch the scene graph in a browser, run `.\carla\scripts\open_live_view.ps1` while it replays. When you're done, click the red **Terminate** button in the Console view.

## 7. Run live with CARLA

Choose **Run > Run Configurations > Launch Group > Mt4sgFullPipeline > Run**. It starts CARLA, waits 60 s for it to load, then starts the publisher and the listener. Once a city shows in the CARLA window, drive a scenario in a terminal, from the `mt4sg` folder:

```powershell
.\carla\.venv\Scripts\Activate.ps1
python .\carla\src\scenario_ego_follow.py
```

To stop, terminate the launch group in the Debug view and close the CARLA window.

## All launches

Every launch lives in the `ca.mcmaster.mt4sg.boot` project and shows up under **Run > Run Configurations**:

| Launch | Category | Purpose |
|---|---|---|
| `Mt4sgReplayPipeline` | Launch Group | Listener, then replay of a recording, no CARLA needed |
| `Mt4sgFullPipeline` | Launch Group | CARLA, then the publisher, then the listener |
| `Mt4sgViatraListener` | Eclipse Application | The Runner on its own |
| `Mt4sgReplay` | External Tools | `carla\src\replay_scenes.py`, asking for a recording |
| `Mt4sgCarlaBridge` | External Tools | `carla\scripts\run_scenegraph_stream.ps1`, which starts the Carla2Ecore publisher |
| `Mt4sgCarlaSim` | External Tools | `carla\CARLA_0.9.16\CarlaUE4.exe` |

## If something goes wrong

| What you see | What to do |
|---|---|
| `SETUP.ps1` can't find Python 3.12 | Install it from step 1 and open a new terminal |
| A download stops | Run `SETUP.ps1` again, and it resumes |
| `DLL load failed ... The filename or extension is too long` | Move `mt4sg-tools` to a shorter path and run `SETUP.ps1` again |
| Eclipse doesn't list 6 projects | Check that you picked the `mt4sg-tools` folder |
| Errors in the Problems view | Check that step 3 installed Xtext and VIATRA, then choose **Project > Clean > Clean all projects** |
| Launch configurations are missing | Check that `ca.mcmaster.mt4sg.boot` was imported |
| The live run prints nothing | Check that the CARLA window has finished loading and that the publisher's console shows `tick=N nodes=X -> zmq` lines |
| CARLA's ports are blocked | Allow ports 2000 and 2001 through Windows Firewall |
