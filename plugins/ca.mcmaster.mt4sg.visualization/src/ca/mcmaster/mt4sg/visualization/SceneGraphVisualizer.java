package ca.mcmaster.mt4sg.visualization;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.mcmaster.mt4sg.models.scenegraph.Distance;
import ca.mcmaster.mt4sg.models.scenegraph.Edge;
import ca.mcmaster.mt4sg.models.scenegraph.Lane;
import ca.mcmaster.mt4sg.models.scenegraph.LaneSegment;
import ca.mcmaster.mt4sg.models.scenegraph.LateralRSSViolation;
import ca.mcmaster.mt4sg.models.scenegraph.LongitudinalRSSViolation;
import ca.mcmaster.mt4sg.models.scenegraph.Node;
import ca.mcmaster.mt4sg.models.scenegraph.Road;
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraph;
import ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition;
import ca.mcmaster.mt4sg.models.scenegraph.Vehicle;
import ca.mcmaster.mt4sg.models.scenegraph.VehicleInLaneSegment;

/**
 * Writes debug live-view snapshots (HTML or plain text) of a {@link SceneGraph}
 * to disk. This is a diagnostic aid only — it never mutates the model, and it
 * is entirely independent of the JSON parsing / diffing logic that updates the
 * model itself (see {@link JsonModelUpdater}).
 *
 * <p>Controlled by {@code -Dscenegraph.output.file=/path/to/file.html} (or
 * {@code .txt}). If not set, falls back to the {@code SCENEGRAPH_OUTPUT_FILE}
 * env var, then to {@code carla/data/stream/live_view.html} relative to the
 * working dir.
 *
 * <p>HTML output overwrites the file every {@link #HTML_WRITE_EVERY_N_TICKS}
 * calls so a browser can auto-refresh it. Text output appends one snapshot
 * per call.
 *
 * <p>{@code Road.lanes} / {@code Lane.laneSegments} are containment
 * references, so {@code Lane}/{@code LaneSegment} are no longer direct
 * {@code scene.getNodes()} children — they're reached by walking each
 * {@code Road}'s {@code lanes} and each {@code Lane}'s {@code laneSegments}.
 * The HTML view only plots a {@code LaneSegment} if it's connected to a
 * {@code Vehicle} via a {@code VehicleInLaneSegment}, plus that segment's
 * parent {@code Lane} and parent {@code Road} for context — every other
 * {@code Lane}/{@code Road}/{@code LaneSegment} is left out entirely so the
 * view isn't cluttered with the whole road network.
 *
 * <p>Start of AI generated visualization code.
 */
public class SceneGraphVisualizer {

    // Human-readable labels used only by the debug live-view writer below.
    private static final String EDGE_LABEL_DISTANCE = "distance";
    private static final String EDGE_LABEL_SPATIAL = "spatial";
    private static final String EDGE_LABEL_LANE = "lane";
    private static final String EDGE_LABEL_RSS_LONGITUDINAL = "rss_longitudinal";
    private static final String EDGE_LABEL_RSS_LATERAL = "rss_lateral";

    private static final String[] DISTANCE_LABELS =
            {"PreCollision", "SuperNear", "VeryNear", "Near", "Visible"};
    private static final String[] SPATIAL_LABELS =
            {"Left", "FrontLeft", "Front", "FrontRight", "Right", "RearRight", "Rear", "RearLeft"};

    // Write an HTML snapshot every N calls; keeps I/O low without starving the view.
    private static final int HTML_WRITE_EVERY_N_TICKS = 3;

    private final SceneGraph scene;
    private int liveViewUpdateCounter = 0;

    public SceneGraphVisualizer(SceneGraph scene) {
        this.scene = scene;
    }

    /**
     * Writes the next throttled snapshot for {@link #scene} to whichever
     * output path is configured. Safe to call once per model-update tick;
     * internally decides (via its own counter) whether this call actually
     * produces I/O.
     */
    public void writeSnapshot() {
        // NOTE: the counter is incremented unconditionally so the throttle is
        //       stable regardless of whether the property is set.
        int updateCycle = liveViewUpdateCounter++;

        try {
            String outPath = System.getProperty("scenegraph.output.file");
            if (outPath == null || outPath.trim().isEmpty()) {
                outPath = System.getenv("SCENEGRAPH_OUTPUT_FILE");
            }
            if (outPath == null || outPath.trim().isEmpty()) {
                outPath = "carla/data/stream/live_view.html";
            }
            outPath = outPath.trim();

            // Throttle: only write HTML every N ticks to reduce I/O.
            boolean isHtml = outPath.toLowerCase().endsWith(".html");
            if (isHtml && (updateCycle % HTML_WRITE_EVERY_N_TICKS) != 0) {
                return;
            }

            Path p = outPath.startsWith("file:")
                ? Paths.get(java.net.URI.create(outPath))
                : Paths.get(outPath);
            if (p.getParent() != null) {
                Files.createDirectories(p.getParent());
            }

            if (isHtml) {
                writeHtmlSnapshot(p, updateCycle);
            } else {
                writeTextSnapshot(p);
            }

        } catch (SecurityException se) {
            // Running in a sandbox that forbids property reads — skip silently.
        } catch (IOException ioe) {
            System.err.println("[SceneGraphVisualizer] Failed to prepare output path: " + ioe);
        } catch (RuntimeException rte) {
            System.err.println("[SceneGraphVisualizer] Unexpected error writing snapshot: " + rte);
        }
    }

    // ── Node selection ──────────────────────────────────────────────────────

    /**
     * Holds the result of {@link #selectNodesToRender()}: which nodes to
     * render, plus (for LaneSegment -> Lane and Lane -> Road) the id of
     * each node's containment parent, so the HTML view can draw a visual
     * connection for a containment relationship even though it has no
     * {@link Edge} of its own in the model.
     */
    private static final class Selection {
        final List<Node> nodes;
        final Map<String, String> parentIds;

        Selection(List<Node> nodes, Map<String, String> parentIds) {
            this.nodes = nodes;
            this.parentIds = parentIds;
        }
    }

    /**
     * Builds the list of nodes the live view should render: every
     * {@link Vehicle}, plus only the {@link LaneSegment}s connected to a
     * vehicle via a {@link VehicleInLaneSegment} — and, for each such
     * segment, its parent {@link Lane} and that lane's parent {@link Road}
     * (each added at most once). Every other {@code Road}/{@code Lane}/
     * {@code LaneSegment} in the model is left out.
     */
    private Selection selectNodesToRender() {
        Set<String> connectedSegmentIds = new HashSet<>();
        for (Object o : scene.getEdges()) {
            if (o instanceof VehicleInLaneSegment) {
                VehicleInLaneSegment e = (VehicleInLaneSegment) o;
                if (e.getSource() != null && e.getTarget() != null) {
                    connectedSegmentIds.add(e.getTarget().getId());
                }
            }
        }

        List<Node> result = new ArrayList<>();
        Set<String> addedIds = new HashSet<>();
        Map<String, String> parentIds = new HashMap<>();

        for (Node n : scene.getNodes()) {
            if (n instanceof Vehicle) {
                if (addedIds.add(n.getId())) {
                    result.add(n);
                }
            } else if (n instanceof Road) {
                Road road = (Road) n;
                boolean roadHasConnectedSegment = false;

                for (Lane lane : road.getLanes()) {
                    boolean laneHasConnectedSegment = false;

                    for (LaneSegment seg : lane.getLaneSegments()) {
                        if (connectedSegmentIds.contains(seg.getId()) && addedIds.add(seg.getId())) {
                            result.add(seg);
                            laneHasConnectedSegment = true;
                            parentIds.put(seg.getId(), lane.getId());
                        }
                    }

                    if (laneHasConnectedSegment) {
                        roadHasConnectedSegment = true;
                        if (addedIds.add(lane.getId())) {
                            result.add(lane);
                        }
                        parentIds.put(lane.getId(), road.getId());
                    }
                }

                if (roadHasConnectedSegment && addedIds.add(road.getId())) {
                    result.add(road);
                }
            }
        }

        return new Selection(result, parentIds);
    }

    // ── Snapshot writers ────────────────────────────────────────────────────

    private void writeHtmlSnapshot(Path p, int updateCycle) {
        Selection selection = selectNodesToRender();
        List<Node> nodesToRender = selection.nodes;
        Map<String, String> parentIds = selection.parentIds;

        // Counters for the scene-summary panel
        int vehicleCount = 0, laneSegmentCount = 0, laneCount = 0, roadCount = 0;
        int distanceEdgeCount = 0, spatialEdgeCount = 0, laneEdgeCount = 0;
        int rssLongitudinalEdgeCount = 0, rssLateralEdgeCount = 0;

        Set<String> visibleNodeIds = new HashSet<>();
        StringBuilder jsonNodes = new StringBuilder();
        boolean first = true;

        for (Node n : nodesToRender) {
            String nodeType = normalizeType(n.getClass().getSimpleName());
            visibleNodeIds.add(n.getId());

            if ("Vehicle".equals(nodeType))          vehicleCount++;
            else if ("LaneSegment".equals(nodeType)) laneSegmentCount++;
            else if ("Lane".equals(nodeType))        laneCount++;
            else if ("Road".equals(nodeType))        roadCount++;

            String parentId = parentIds.get(n.getId());

            if (!first) jsonNodes.append(",\n"); else first = false;
            jsonNodes.append("    {");
            jsonNodes.append("\"id\": \"").append(escapeJson(n.getId())).append("\"");
            jsonNodes.append(", \"type\": \"").append(escapeJson(nodeType)).append("\"");
            if (parentId != null) {
                jsonNodes.append(", \"parent\": \"").append(escapeJson(parentId)).append("\"");
            }
            jsonNodes.append(" }");
        }

        StringBuilder jsonEdges = new StringBuilder();
        first = true;
        for (Object o : scene.getEdges()) {
            Edge e = (Edge) o;
            String src = e.getSource() == null ? "" : e.getSource().getId();
            String tgt = e.getTarget() == null ? "" : e.getTarget().getId();
            if (src.isEmpty() || tgt.isEmpty()
                    || !visibleNodeIds.contains(src)
                    || !visibleNodeIds.contains(tgt)) {
                continue;
            }

            String edgeLabel;
            String distanceLabel = "";
            String spatialLabel = "";

            if (e instanceof LongitudinalRSSViolation) {
                edgeLabel = EDGE_LABEL_RSS_LONGITUDINAL;
                rssLongitudinalEdgeCount++;
            } else if (e instanceof LateralRSSViolation) {
                edgeLabel = EDGE_LABEL_RSS_LATERAL;
                rssLateralEdgeCount++;
            } else if (e instanceof Distance) {
                edgeLabel = EDGE_LABEL_DISTANCE;
                distanceLabel = enumLabel(DISTANCE_LABELS, ((Distance) e).getValue().getValue());
                distanceEdgeCount++;
            } else if (e instanceof SpatialPosition) {
                edgeLabel = EDGE_LABEL_SPATIAL;
                spatialLabel = enumLabel(SPATIAL_LABELS, ((SpatialPosition) e).getValue().getValue());
                spatialEdgeCount++;
            } else if (e instanceof VehicleInLaneSegment) {
                edgeLabel = EDGE_LABEL_LANE;
                laneEdgeCount++;
            } else {
                edgeLabel = normalizeType(e.getClass().getSimpleName());
            }

            if (!first) jsonEdges.append(",\n"); else first = false;
            jsonEdges.append("    {");
            jsonEdges.append("\"source\": \"").append(escapeJson(src)).append("\"");
            jsonEdges.append(", \"target\": \"").append(escapeJson(tgt)).append("\"");
            jsonEdges.append(", \"type\": \"").append(escapeJson(edgeLabel)).append("\"");
            jsonEdges.append(", \"distance\": \"").append(escapeJson(distanceLabel)).append("\"");
            jsonEdges.append(", \"spatial\": \"").append(escapeJson(spatialLabel)).append("\"");
            jsonEdges.append(" }");
        }

        int visibleNodeCount  = visibleNodeIds.size();
        int visibleEdgeCount  = distanceEdgeCount + spatialEdgeCount + laneEdgeCount
                                + rssLongitudinalEdgeCount + rssLateralEdgeCount;

        String sceneJson = "{\n  \"nodes\": [\n" + jsonNodes + "\n  ],\n"
                         + "  \"edges\": [\n" + jsonEdges + "\n  ]\n}";

        // pedestrianCount is always 0: Pedestrian no longer exists in the metamodel.
        String html = buildHtml(updateCycle,
                vehicleCount, 0, laneSegmentCount, laneCount, roadCount,
                distanceEdgeCount, laneEdgeCount, spatialEdgeCount,
                rssLongitudinalEdgeCount, rssLateralEdgeCount,
                visibleNodeCount, visibleEdgeCount,
                sceneJson);

        try {
            Files.write(p, html.getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ioe) {
            System.err.println("[SceneGraphVisualizer] Failed to write HTML snapshot: " + ioe);
        }
    }

    private void writeTextSnapshot(Path p) {
        List<Node> nodesToRender = selectNodesToRender().nodes;

        StringBuilder sb = new StringBuilder();
        sb.append(Instant.now().toString()).append(" - Scene snapshot\n");
        sb.append("Nodes: ").append(nodesToRender.size())
          .append("   Edges: ").append(scene.getEdges().size()).append('\n');
        for (Node n : nodesToRender) {
            sb.append(String.format("NODE: %s type=%s\n",
                    n.getId(), normalizeType(n.getClass().getSimpleName())));
        }
        for (Object o : scene.getEdges()) {
            Edge e = (Edge) o;
            String src = e.getSource() == null ? "null" : e.getSource().getId();
            String tgt = e.getTarget() == null ? "null" : e.getTarget().getId();
            String label;
            if (e instanceof Distance) {
                label = "distance=" + enumLabel(DISTANCE_LABELS, ((Distance) e).getValue().getValue());
            } else if (e instanceof SpatialPosition) {
                label = "spatial=" + enumLabel(SPATIAL_LABELS, ((SpatialPosition) e).getValue().getValue());
            } else {
                label = "type=" + normalizeType(e.getClass().getSimpleName());
            }
            sb.append(String.format("EDGE: %s -> %s %s\n", src, tgt, label));
        }
        sb.append('\n');
        try {
            Files.write(p, sb.toString().getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            System.err.println("[SceneGraphVisualizer] Failed to write text snapshot: " + ioe);
        }
    }

    // ── HTML builder ────────────────────────────────────────────────────────

    private static String buildHtml(
            int updateCycle,
            int vehicleCount, int pedestrianCount, int laneSegmentCount, int laneCount, int roadCount,
            int distanceEdgeCount, int laneEdgeCount, int spatialEdgeCount,
            int rssLongitudinalEdgeCount, int rssLateralEdgeCount,
            int visibleNodeCount, int visibleEdgeCount,
            String sceneJson) {

        return "<!doctype html>\n"
            + "<html>\n"
            + "<head>\n"
            + "  <meta charset=\"utf-8\" />\n"
            + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n"
            + "  <meta http-equiv=\"refresh\" content=\"0.3\" />\n"
            + "  <title>Scene Graph Live View</title>\n"
            + "  <style>\n"
            + "    html, body { width:100%; height:100%; margin:0; overflow:hidden; }\n"
            + "    body { font-family: Segoe UI, Tahoma, sans-serif; background:#f3f6f9; }\n"
            + "    .wrap { width:100vw; height:100vh; display:flex; flex-direction:column; box-sizing:border-box; }\n"
            + "    .head { padding:10px 16px; border-bottom:1px solid #e5e7eb; flex:0 0 auto;\n"
            + "            display:flex; justify-content:space-between; align-items:flex-start; }\n"
            + "    .head strong { font-size:20px; font-weight:700; }\n"
            + "    .meta { color:#3f4b5b; font-size:13px; margin-top:3px; }\n"
            + "    .scene-panel { flex:0 0 auto; min-width:260px; background:#eff6ff;\n"
            + "                   border:1px solid #bfdbfe; border-radius:8px;\n"
            + "                   padding:8px 12px; margin-left:16px; }\n"
            + "    .scene-title { font-size:13px; font-weight:700; color:#1e293b; margin-bottom:5px; }\n"
            + "    .scene-count { font-size:12px; color:#64748b; margin-bottom:3px; }\n"
            + "    svg { display:block; width:100%; flex:1 1 auto; background:#fcfdff; }\n"
            + "    .legend { display:flex; gap:14px; padding:5px 16px; border-top:1px solid #e5e7eb;\n"
            + "              flex:0 0 auto; font-size:11px; color:#64748b; align-items:center; flex-wrap:wrap; }\n"
            + "    .legend-item { display:flex; align-items:center; gap:4px; }\n"
            + "    .legend-swatch { width:20px; height:3px; border-radius:2px; }\n"
            + "    .legend-swatch-dash { background: repeating-linear-gradient(90deg, #94a3b8 0, #94a3b8 8px, transparent 8px, transparent 14px); }\n"
            + "    .legend-swatch-containment { background: repeating-linear-gradient(90deg, #475569 0, #475569 2px, transparent 2px, transparent 7px); }\n"
            + "    .legend-dot { width:12px; height:12px; border-radius:50%; }\n"
            + "  </style>\n"
            + "</head>\n"
            + "<body>\n"
            + "  <div class=\"wrap\">\n"
            + "    <div class=\"head\">\n"
            + "      <div>\n"
            + "        <strong>CARLA Scene Graph Live View</strong>\n"
            + "        <div class=\"meta\">Cycle: " + updateCycle
                         + " | Vehicles: " + vehicleCount
                         + " | Nodes: " + visibleNodeCount + "</div>\n"
            + "      </div>\n"
            + "      <div class=\"scene-panel\">\n"
            + "        <div class=\"scene-title\">Scene Summary</div>\n"
            + "        <div class=\"scene-count\">Nodes: " + visibleNodeCount + " | Edges: " + visibleEdgeCount + "</div>\n"
            + "        <div class=\"scene-count\">Vehicles: " + vehicleCount
                         + " | Lane segments: " + laneSegmentCount
                         + " | Lanes: " + laneCount
                         + " | Roads: " + roadCount + "</div>\n"
            + "        <div class=\"scene-count\">Distance: " + distanceEdgeCount
                         + " | Spatial: " + spatialEdgeCount
                         + " | Lane: " + laneEdgeCount + "</div>\n"
            + "        <div class=\"scene-count\">RSS Long: " + rssLongitudinalEdgeCount
                         + " | RSS Lat: " + rssLateralEdgeCount + "</div>\n"
            + "      </div>\n"
            + "    </div>\n"
            + "    <svg id=\"view\" viewBox=\"0 0 1600 900\"\n"
            + "         preserveAspectRatio=\"xMidYMid meet\"\n"
            + "         xmlns=\"http://www.w3.org/2000/svg\"></svg>\n"
            + "    <div class=\"legend\">\n"
            + "      <div class=\"legend-item\"><div class=\"legend-swatch\" style=\"background:#dc2626;height:4px;\"></div> RSS Longitudinal</div>\n"
            + "      <div class=\"legend-item\"><div class=\"legend-swatch\" style=\"background:#ea580c;height:4px;\"></div> RSS Lateral</div>\n"
            + "      <div class=\"legend-item\"><div class=\"legend-swatch\" style=\"background:#7c3aed;\"></div> Spatial</div>\n"
            + "      <div class=\"legend-item\"><div class=\"legend-swatch\" style=\"background:#738497;\"></div> Distance</div>\n"
            + "      <div class=\"legend-item\"><div class=\"legend-swatch legend-swatch-dash\"></div> Lane</div>\n"
            + "      <div class=\"legend-item\"><div class=\"legend-swatch legend-swatch-containment\"></div> Containment</div>\n"
            + "      <div class=\"legend-item\"><div class=\"legend-dot\" style=\"background:#2e5cd3;\"></div> Vehicle</div>\n"
            + "      <div class=\"legend-item\"><div class=\"legend-dot\" style=\"background:#e48330;\"></div> LaneSegment</div>\n"
            + "      <div class=\"legend-item\"><div class=\"legend-dot\" style=\"background:#c2703d;\"></div> Lane</div>\n"
            + "      <div class=\"legend-item\"><div class=\"legend-dot\" style=\"background:#8a5a2b;\"></div> Road</div>\n"
            + "    </div>\n"
            + "  </div>\n"
            + "  <script>\n"
            // ── constants ──────────────────────────────────────────────────
            + "  const W = 1600, H = 900;\n"
            + "  const CX = W / 2, CY = H / 2;\n"
            + "  const NODE_R = 52;\n"
            + "  const sceneData = " + sceneJson + ";\n"
            + "\n"
            // ── edge styling ───────────────────────────────────────────────
            // Offset is no longer decided here -- it's assigned per edge by
            // the pair-grouping/slot logic in render() below, based on how
            // many edges actually connect that specific pair of nodes.
            // edgeStyle only supplies the type's visual identity (color,
            // width, dash).
            + "  function edgeStyle(type) {\n"
            + "    switch (type) {\n"
            + "      case 'distance':         return { color:'#738497', width:3.5 };\n"
            + "      case 'rss_longitudinal': return { color:'#dc2626', width:4 };\n"
            + "      case 'rss_lateral':      return { color:'#ea580c', width:4 };\n"
            + "      case 'spatial':          return { color:'#7c3aed', width:3.5 };\n"
            + "      case 'lane':             return { color:'#94a3b8', width:3, dash:'8 6' };\n"
            + "      case 'containment':      return { color:'#475569', width:2, dash:'2 5' };\n"
            + "      default:                 return { color:'#738497', width:3 };\n"
            + "    }\n"
            + "  }\n"
            + "\n"
            // ── layout: every node is placed evenly around a circle of
            // fixed diameter, sized to fit within the SVG viewport (leaving
            // margin for node labels and the header/legend around it). This
            // guarantees a legible, predictable layout regardless of how
            // many nodes are present or what type they are -- no more
            // separating parent/child nodes (e.g. a Lane and its own
            // LaneSegment) into arbitrary rows far apart from each other.
            + "  function layoutNodes(nodes) {\n"
            + "    const positions = {};\n"
            + "    const n = nodes.length;\n"
            + "    if (n === 0) return positions;\n"
            + "\n"
            + "    if (n === 1) {\n"
            + "      positions[nodes[0].id] = { x: CX, y: CY };\n"
            + "      return positions;\n"
            + "    }\n"
            + "\n"
            // Margin leaves room for the node radius, its id label below it,
            // and the header/scene-panel/legend chrome around the SVG.
            + "    const RADIUS = Math.min(W, H) / 2 - 160;\n"
            // Stable id order so a given node lands in the same slot on the
            // circle across snapshots, instead of jittering as other nodes
            // are added/removed.
            + "    const sorted = nodes.slice().sort((a, b) => String(a.id).localeCompare(String(b.id)));\n"
            + "    sorted.forEach((node, i) => {\n"
            + "      const angle = (2 * Math.PI * i) / n - Math.PI / 2;\n"
            + "      positions[node.id] = {\n"
            + "        x: CX + RADIUS * Math.cos(angle),\n"
            + "        y: CY + RADIUS * Math.sin(angle),\n"
            + "      };\n"
            + "    });\n"
            + "\n"
            + "    return positions;\n"
            + "  }\n"
            + "\n"
            // ── renderer ──────────────────────────────────────────────────
            + "  function render(data) {\n"
            + "    const nodes = data.nodes || [];\n"
            // Containment (LaneSegment -> Lane, Lane -> Road) has no Edge of
            // its own in the model -- it's synthesized here from each
            // node's `parent` field (set only on LaneSegment/Lane in the
            // JSON payload) purely so the view can draw a visual connection
            // for it, styled distinctly ('containment') from real
            // scenegraph edges.
            + "    const containmentEdges = nodes\n"
            + "      .filter(n => n.parent)\n"
            + "      .map(n => ({ source: n.parent, target: n.id, type: 'containment' }));\n"
            + "    const edges = (data.edges || []).concat(containmentEdges);\n"
            + "    const pos   = layoutNodes(nodes);\n"
            + "    const view  = document.getElementById('view');\n"
            + "    let svg = '';\n"
            + "\n"
            // Safe drawing bounds for edge labels: clear of the header/scene
            // panel above and the legend strip below, regardless of where the
            // raw perpendicular offset would otherwise place them.
            + "    const LABEL_MIN_Y = 60;\n"
            + "    const LABEL_MAX_Y = H - 40;\n"
            + "    const LABEL_MIN_X = 50;\n"
            + "    const LABEL_MAX_X = W - 50;\n"
            + "\n"
            // Group edges by the unordered pair of nodes they connect, and
            // give each edge within a pair its own evenly spaced "slot" --
            // spacing driven by how many edges actually exist between that
            // specific pair, not a fixed per-type offset. That fixed-offset
            // approach put every distance/spatial pair at the same ~22px gap
            // regardless of how many edge types (and labels) needed to fit
            // between them, so labels crowded and overlapped as soon as more
            // than one or two edge types connected the same pair.
            + "    const SLOT_GAP = 46;\n"
            + "    const pairGroups = {};\n"
            + "    edges.forEach(e => {\n"
            + "      if (!pos[e.source] || !pos[e.target]) return;\n"
            + "      const key = [String(e.source), String(e.target)].sort().join('|');\n"
            + "      (pairGroups[key] = pairGroups[key] || []).push(e);\n"
            + "    });\n"
            + "    Object.values(pairGroups).forEach(group => {\n"
            // Stable order (by type, then distance/spatial label) so the
            // same edge always lands in the same slot across re-renders,
            // instead of jittering as edges are added/removed elsewhere in
            // the scene.
            + "      group.sort((a, b) =>\n"
            + "        String(a.type).localeCompare(String(b.type)) ||\n"
            + "        String(a.distance).localeCompare(String(b.distance)) ||\n"
            + "        String(a.spatial).localeCompare(String(b.spatial)));\n"
            + "      const n = group.length;\n"
            + "      group.forEach((e, i) => {\n"
            + "        e._slotOffset = (i - (n - 1) / 2) * SLOT_GAP;\n"
            + "        e._groupIndex = i;\n"
            + "        e._groupTotal = n;\n"
            + "      });\n"
            + "    });\n"
            + "\n"
            // Draw edges first so nodes sit on top.
            + "    edges.forEach(e => {\n"
            + "      const s = pos[e.source], t = pos[e.target];\n"
            + "      if (!s || !t) return;\n"
            + "      const style = edgeStyle(e.type);\n"
            // Derive the offset direction from a canonical (id-sorted) pair
            // ordering rather than this edge's own source/target order, so
            // every edge type between the same two nodes stacks the same way
            // (and its label sits on the same side as its own line)
            // regardless of which node happens to be the source vs target
            // for that particular edge.
            + "      const firstIsSource = String(e.source) <= String(e.target);\n"
            + "      const a = firstIsSource ? s : t;\n"
            + "      const b = firstIsSource ? t : s;\n"
            + "      const cdx = b.x - a.x, cdy = b.y - a.y;\n"
            + "      const clen = Math.max(1, Math.sqrt(cdx * cdx + cdy * cdy));\n"
            + "      const nx = -cdy / clen, ny = cdx / clen;\n"
            + "      const offset = e._slotOffset || 0;\n"
            + "      const ox = nx * offset;\n"
            + "      const oy = ny * offset;\n"
            + "      const x1 = s.x + ox, y1 = s.y + oy;\n"
            + "      const x2 = t.x + ox, y2 = t.y + oy;\n"
            + "      const dash = style.dash ? ` stroke-dasharray=\"${style.dash}\"` : '';\n"
            + "      svg += `<line x1=\"${x1}\" y1=\"${y1}\" x2=\"${x2}\" y2=\"${y2}\"\n"
            + "               stroke=\"${style.color}\" stroke-width=\"${style.width}\"${dash} />`;\n"
            // Draw midpoint direction arrow for Spatial edges
            + "      if (e.type === 'spatial') {\n"
            + "        const mx = (x1 + x2) / 2, my = (y1 + y2) / 2;\n"
            + "        const dx = x2 - x1, dy = y2 - y1;\n"
            + "        const len = Math.max(1, Math.sqrt(dx * dx + dy * dy));\n"
            + "        const ux = dx / len, uy = dy / len;\n"
            + "        const perpX = -uy, perpY = ux;\n"
            + "        const arrowLen = 14, arrowWidth = 7;\n"
            + "        const p1x = mx + ux * arrowLen, p1y = my + uy * arrowLen;\n"
            + "        const p2x = mx - ux * arrowLen + perpX * arrowWidth, p2y = my - uy * arrowLen + perpY * arrowWidth;\n"
            + "        const p3x = mx - ux * arrowLen - perpX * arrowWidth, p3y = my - uy * arrowLen - perpY * arrowWidth;\n"
            + "        svg += `<polygon points=\"${p1x},${p1y} ${p2x},${p2y} ${p3x},${p3y}\" fill=\"${style.color}\" />`;\n"
            + "      }\n"
            // Edge label (distance + spatial, or type for RSS edges). Sits
            // further out along the SAME normal direction as this edge's own
            // slot offset (not the fixed midpoint used before), so labels
            // for parallel edges between the same pair stack in the same
            // order as their lines, spaced by the same SLOT_GAP instead of
            // collapsing toward a shared midpoint.
            + "      const parts = [];\n"
            + "      if (e.distance) parts.push(e.distance);\n"
            + "      if (e.spatial)  parts.push(e.spatial);\n"
            + "      if (parts.length === 0 && String(e.type || '').toLowerCase().startsWith('rss')) parts.push(e.type);\n"
            + "      if (parts.length > 0) {\n"
            + "        const label = parts.join(' | ');\n"
            + "        const LABEL_EXTRA = 26;\n"
            + "        const dir = offset < 0 ? -1 : 1;\n"
            + "        const labelOffset = offset + dir * LABEL_EXTRA;\n"
            + "        const i = e._groupIndex || 0;\n"
            + "        const n = e._groupTotal || 1;\n"
            + "        const maxTotalSpread = clen * 0.6;\n"
            + "        const stepSpread = n > 1 ? Math.min(100, maxTotalSpread / (n - 1)) : 0;\n"
            + "        const alongShift = (i - (n - 1) / 2) * stepSpread;\n"
            + "        const vx = cdx / clen;\n"
            + "        const vy = cdy / clen;\n"
            + "        const mx = (s.x + t.x) / 2 + vx * alongShift;\n"
            + "        const my = (s.y + t.y) / 2 + vy * alongShift;\n"
            + "        let lx = mx + nx * labelOffset;\n"
            + "        let ly = my + ny * labelOffset;\n"
            + "        lx = Math.min(LABEL_MAX_X, Math.max(LABEL_MIN_X, lx));\n"
            + "        ly = Math.min(LABEL_MAX_Y, Math.max(LABEL_MIN_Y, ly));\n"
            + "        svg += `<text x=\"${lx}\" y=\"${ly}\" font-size=\"18\" fill=\"#1d2430\"\n"
            + "                 text-anchor=\"middle\" dominant-baseline=\"middle\"\n"
            + "                 style=\"paint-order:stroke;stroke:#fff;stroke-width:6px;stroke-linejoin:round;\">\n"
            + "                 ${escHtml(label)}</text>`;\n"
            + "      }\n"
            + "    });\n"
            + "\n"
            // Draw nodes
            + "    nodes.forEach(n => {\n"
            + "      const p = pos[n.id];\n"
            + "      if (!p) return;\n"
            + "      const kind = String(n.type || '').replace(/Impl$/, '');\n"
            + "      const color = kind === 'Vehicle'     ? '#2e5cd3'\n"
            + "                  : kind === 'LaneSegment' ? '#e48330'\n"
            + "                  : kind === 'Lane'        ? '#c2703d'\n"
            + "                  : kind === 'Road'        ? '#8a5a2b'\n"
            + "                  : '#7f8c8d';\n"
            + "      svg += `<g>`\n"
            + "           + `<circle cx=\"${p.x}\" cy=\"${p.y}\" r=\"${NODE_R}\"\n"
            + "                fill=\"${color}\" stroke=\"#222\" stroke-width=\"1.5\"/>`\n"
            + "           + `<text x=\"${p.x}\" y=\"${p.y + NODE_R + 20}\" font-size=\"22\"\n"
            + "                fill=\"#1d2430\" text-anchor=\"middle\"\n"
            + "                style=\"paint-order:stroke;stroke:#fff;stroke-width:5px;\">\n"
            + "                ${escHtml(n.id)}</text>`\n"
            + "           + `</g>`;\n"
            + "    });\n"
            + "\n"
            + "    view.innerHTML = svg;\n"
            + "  }\n"
            + "\n"
            + "  function escHtml(s) {\n"
            + "    return String(s)\n"
            + "      .replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;')\n"
            + "      .replace(/\"/g,'&quot;').replace(/'/g,'&#39;');\n"
            + "  }\n"
            + "\n"
            + "  window.onload = function() { render(sceneData); };\n"
            + "  </script>\n"
            + "</body>\n"
            + "</html>\n";
    }

    // ── Helpers ─────────────────────────────────────────────────────────────

    private static String escapeJson(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "");
    }

    private static String normalizeType(String typeName) {
        if (typeName == null) return "";
        return typeName.endsWith("Impl")
               ? typeName.substring(0, typeName.length() - 4)
               : typeName;
    }

    private static String enumLabel(String[] labels, int value) {
        return (value >= 0 && value < labels.length) ? labels[value] : String.valueOf(value);
    }

    // End of AI generated visualization code
}
