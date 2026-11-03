# MT4SG: incremental model transformations over scene graphs

MT4SG monitors the safety of driving scenes in real time. It keeps a typed scene graph of the scene in EMF and updates it in place as the simulator reports changes. VIATRA graph queries and event-driven model transformations then keep the spatial, distance, lane, and Responsibility-Sensitive Safety (RSS) relations between vehicles up to date incrementally, and record every RSS violation as an edge in the scene graph.

This is the tool of the paper _Real-time Safety Monitoring of Autonomous Vehicles by Incremental Model Transformations over Scene Graphs_.

| You want to | Go to |
|---|---|
| Run the safety monitoring on a recording or a live CARLA scenario | This repository, starting at [Quick start](#quick-start) |
| Reproduce the results of the paper | The [replication package](https://github.com/ssm-lab/mt4sg-replication-package) |
| Stream CARLA into your own EMF model, without the safety monitoring | Carla2Ecore, which works on its own |

## Quick start

You need Windows, Git, Python 3.12, Eclipse Modeling Tools 2025-06 with Xtext and VIATRA 2.9.1, and about 50 GB of free disk space. Clone this repository and Carla2Ecore into a folder named `mt4sg-tools`, in a short path such as `C:\`, then run this from the `mt4sg` folder:

```powershell
powershell -ExecutionPolicy Bypass -File SETUP.ps1
```

`SETUP.ps1` downloads CARLA with its additional maps and creates the Python environment. Then unzip Eclipse into `mt4sg-tools`, import the `mt4sg-tools` folder, and run **Mt4sgReplayPipeline**. [QUICKSTART.md](QUICKSTART.md) walks through every step, including the Eclipse install.

## How it works

```
CARLA simulator, running any scenario
      |
      v
Carla2Ecore publisher.py    Python: reads the vehicles and road network, publishes what changed as JSON over ZeroMQ
      |
      v
ca.mcmaster.carla2ecore     Java: receives the messages and applies them to the EMF scene graph
      |
      v
ca.mcmaster.mt4sg.core      VIATRA queries and event-driven transformation rules derive the edges
      |
      v
Eclipse console (created and removed edges) and a live view in the browser
```

The bridge between CARLA and EMF, Carla2Ecore, is a separate repository that mt4sg depends on. It reads the CARLA world as an extra client, so it works with any scenario that runs in CARLA: ScenarioRunner (including OpenSCENARIO files), the [CARLA Scenario Editor](https://github.com/McSCert/CARLA-Scenario-Editor), the Traffic Manager, or your own scripts. Its README describes the message format.

## Repository layout

| Folder | What it holds |
|---|---|
| `plugins/ca.mcmaster.mt4sg.models` | The scene graph metamodel (`model/sceneGraphModel.ecore`) and its generated EMF code |
| `plugins/ca.mcmaster.mt4sg.queries` | The VIATRA graph queries (`scenegraph.vql`), the RSS formulas (`SceneGraphHelper.java`), and the generated query code |
| `plugins/ca.mcmaster.mt4sg.core` | The Runner application and the event-driven transformation rules |
| `plugins/ca.mcmaster.mt4sg.visualization` | The browser live view of the scene graph |
| `plugins/ca.mcmaster.mt4sg.boot` | The Eclipse launch configurations |
| `carla/` | The Python side: a replay tool, an example scenario, and helper scripts that start CARLA and the Carla2Ecore publisher |
| `examples/` | Recorded runs and scenario files of the paper's 2 driving scenarios |

The generated EMF, VIATRA, and Xtend code is included, so the projects build as soon as they are imported.

## Examples

### 1. Replay a recorded scenario, no CARLA needed

`examples/recordings` holds 1 recorded run of each driving scenario of the paper, with 10 external vehicles: Scenario A, where the lead vehicle brakes, and Scenario B, where a vehicle cuts in.

In Eclipse, choose **Run > Run Configurations > Launch Group > Mt4sgReplayPipeline** and pick a recording. The listener starts, then the recording replays at its original pace of 10 scenes per second. The console shows every edge as it is created, updated, or removed:

```
INFO: Subscribed to tcp://127.0.0.1:5556
[15:18:37.221] Transformations - Created SpatialEdge: veh-ego -> veh-other1 (FRONT)
[15:18:37.238] Transformations - Created LongitudinalRSSViolation: veh-ext-0 -> veh-ext-1
```

To watch the scene graph, run `.\carla\scripts\open_live_view.ps1` while it replays. From a terminal, the replay is `python carla\src\replay_scenes.py examples\recordings\scenario-b-cut-in-10-external.jsonl.gz`, with the `Mt4sgViatraListener` launch running.

### 2. A live CARLA scenario

Run **Mt4sgFullPipeline**. It starts CARLA, waits for it to load, starts the publisher, and then the listener. Then drive a scenario:

```powershell
.\carla\.venv\Scripts\Activate.ps1
python .\carla\src\scenario_ego_follow.py
```

The ego vehicle follows a lead vehicle, and the console and live view update with every scene.

### 3. The paper's scenarios in the CARLA Scenario Editor

`examples/scenarios` holds the 2 scenarios of the paper as [CARLA Scenario Editor](https://github.com/McSCert/CARLA-Scenario-Editor) files. Run one in the editor while the publisher and the listener run, as in example 2.

## Versioning

The plug-ins follow the [Eclipse version numbering guidelines](https://wiki.eclipse.org/Version_Numbering). Every plug-in's `Bundle-Version` in `META-INF/MANIFEST.MF` has 4 segments, `major.minor.service.qualifier`:

| Segment | Increases when |
|---|---|
| major | the API breaks |
| minor | a release adds features that other plug-ins can see |
| service | a release keeps the API compatible, such as a bug fix or a small addition |
| qualifier | the plug-in is built. PDE replaces `qualifier` with the build's timestamp. |

All plug-ins of a release share 1 version. Versions below 1.0.0 are incubation versions, so the plug-ins may still change before a stable 1.0.0. Each release has a git tag, such as `v0.1.0`, equal to its `Bundle-Version` without the qualifier. A dependency on a plug-in of another repository gives the version it needs up to the next major version, as `ca.mcmaster.mt4sg.core` does for Carla2Ecore with `bundle-version="[0.1.0,1.0.0)"`.

## License

MIT, see [LICENSE](LICENSE).
