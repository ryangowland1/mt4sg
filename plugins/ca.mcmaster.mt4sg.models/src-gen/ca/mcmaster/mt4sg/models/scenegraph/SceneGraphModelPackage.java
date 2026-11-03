/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore settingDelegates='org.eclipse.viatra.query.querybasedfeature'"
 * @generated
 */
public interface SceneGraphModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scenegraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mcscert.ca/mt4sg/scenegraph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ca.mcmaster.mt4sg.models.scenegraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SceneGraphModelPackage eINSTANCE = ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphImpl <em>Scene Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getSceneGraph()
	 * @generated
	 */
	int SCENE_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE_GRAPH__ID = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE_GRAPH__NODES = 1;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE_GRAPH__EDGES = 2;

	/**
	 * The number of structural features of the '<em>Scene Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE_GRAPH_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Scene Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE_GRAPH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.NodeImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.EdgeImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation <em>IObject With Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getIObjectWithLocation()
	 * @generated
	 */
	int IOBJECT_WITH_LOCATION = 3;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_LOCATION__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_LOCATION__Y = 1;

	/**
	 * The number of structural features of the '<em>IObject With Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_LOCATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>IObject With Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_LOCATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions <em>IObject With Dimensions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getIObjectWithDimensions()
	 * @generated
	 */
	int IOBJECT_WITH_DIMENSIONS = 4;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_DIMENSIONS__LENGTH = 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_DIMENSIONS__WIDTH = 1;

	/**
	 * The number of structural features of the '<em>IObject With Dimensions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>IObject With Dimensions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_DIMENSIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl <em>Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getVehicle()
	 * @generated
	 */
	int VEHICLE = 5;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__LENGTH = IOBJECT_WITH_DIMENSIONS__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__WIDTH = IOBJECT_WITH_DIMENSIONS__WIDTH;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__X = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__Y = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__SPEED = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__ID = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Heading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__HEADING = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>VLongitudinal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__VLONGITUDINAL = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>VLateral</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__VLATERAL = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_FEATURE_COUNT = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_OPERATION_COUNT = IOBJECT_WITH_DIMENSIONS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.RoadImpl <em>Road</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.RoadImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getRoad()
	 * @generated
	 */
	int ROAD = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD__LANES = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Road</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Road</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROAD_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.LaneImpl <em>Lane</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.LaneImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getLane()
	 * @generated
	 */
	int LANE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Lane Segments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__LANE_SEGMENTS = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Lane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.LaneSegmentImpl <em>Lane Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.LaneSegmentImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getLaneSegment()
	 * @generated
	 */
	int LANE_SEGMENT = 8;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SEGMENT__LENGTH = IOBJECT_WITH_DIMENSIONS__LENGTH;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SEGMENT__WIDTH = IOBJECT_WITH_DIMENSIONS__WIDTH;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SEGMENT__X = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SEGMENT__Y = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SEGMENT__ID = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Heading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SEGMENT__HEADING = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Lane Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SEGMENT_FEATURE_COUNT = IOBJECT_WITH_DIMENSIONS_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Lane Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_SEGMENT_OPERATION_COUNT = IOBJECT_WITH_DIMENSIONS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.DistanceImpl <em>Distance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.DistanceImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getDistance()
	 * @generated
	 */
	int DISTANCE = 9;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE__SOURCE = EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE__TARGET = EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE__VALUE = EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Distance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Distance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTANCE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.SpatialPositionImpl <em>Spatial Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SpatialPositionImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getSpatialPosition()
	 * @generated
	 */
	int SPATIAL_POSITION = 10;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_POSITION__SOURCE = EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_POSITION__TARGET = EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_POSITION__VALUE = EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Spatial Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_POSITION_FEATURE_COUNT = EDGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Spatial Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_POSITION_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleInLaneSegmentImpl <em>Vehicle In Lane Segment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleInLaneSegmentImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getVehicleInLaneSegment()
	 * @generated
	 */
	int VEHICLE_IN_LANE_SEGMENT = 11;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_IN_LANE_SEGMENT__SOURCE = EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_IN_LANE_SEGMENT__TARGET = EDGE__TARGET;

	/**
	 * The number of structural features of the '<em>Vehicle In Lane Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_IN_LANE_SEGMENT_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Vehicle In Lane Segment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_IN_LANE_SEGMENT_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.RSSViolationImpl <em>RSS Violation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.RSSViolationImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getRSSViolation()
	 * @generated
	 */
	int RSS_VIOLATION = 12;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RSS_VIOLATION__SOURCE = EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RSS_VIOLATION__TARGET = EDGE__TARGET;

	/**
	 * The number of structural features of the '<em>RSS Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RSS_VIOLATION_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>RSS Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RSS_VIOLATION_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.LongitudinalRSSViolationImpl <em>Longitudinal RSS Violation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.LongitudinalRSSViolationImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getLongitudinalRSSViolation()
	 * @generated
	 */
	int LONGITUDINAL_RSS_VIOLATION = 13;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONGITUDINAL_RSS_VIOLATION__SOURCE = RSS_VIOLATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONGITUDINAL_RSS_VIOLATION__TARGET = RSS_VIOLATION__TARGET;

	/**
	 * The number of structural features of the '<em>Longitudinal RSS Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONGITUDINAL_RSS_VIOLATION_FEATURE_COUNT = RSS_VIOLATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Longitudinal RSS Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONGITUDINAL_RSS_VIOLATION_OPERATION_COUNT = RSS_VIOLATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.LateralRSSViolationImpl <em>Lateral RSS Violation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.LateralRSSViolationImpl
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getLateralRSSViolation()
	 * @generated
	 */
	int LATERAL_RSS_VIOLATION = 14;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATERAL_RSS_VIOLATION__SOURCE = RSS_VIOLATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATERAL_RSS_VIOLATION__TARGET = RSS_VIOLATION__TARGET;

	/**
	 * The number of structural features of the '<em>Lateral RSS Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATERAL_RSS_VIOLATION_FEATURE_COUNT = RSS_VIOLATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Lateral RSS Violation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LATERAL_RSS_VIOLATION_OPERATION_COUNT = RSS_VIOLATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed <em>IObject With Speed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getIObjectWithSpeed()
	 * @generated
	 */
	int IOBJECT_WITH_SPEED = 15;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_SPEED__SPEED = 0;

	/**
	 * The number of structural features of the '<em>IObject With Speed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_SPEED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IObject With Speed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_SPEED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation <em>IObject With Orientation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getIObjectWithOrientation()
	 * @generated
	 */
	int IOBJECT_WITH_ORIENTATION = 16;

	/**
	 * The feature id for the '<em><b>Heading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_ORIENTATION__HEADING = 0;

	/**
	 * The number of structural features of the '<em>IObject With Orientation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_ORIENTATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>IObject With Orientation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBJECT_WITH_ORIENTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue <em>Semantic Distance Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getSemanticDistanceValue()
	 * @generated
	 */
	int SEMANTIC_DISTANCE_VALUE = 17;

	/**
	 * The meta object id for the '{@link ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue <em>Semantic Spatial Position Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue
	 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getSemanticSpatialPositionValue()
	 * @generated
	 */
	int SEMANTIC_SPATIAL_POSITION_VALUE = 18;

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph <em>Scene Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scene Graph</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraph
	 * @generated
	 */
	EClass getSceneGraph();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getId()
	 * @see #getSceneGraph()
	 * @generated
	 */
	EAttribute getSceneGraph_Id();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getNodes()
	 * @see #getSceneGraph()
	 * @generated
	 */
	EReference getSceneGraph_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getEdges()
	 * @see #getSceneGraph()
	 * @generated
	 */
	EReference getSceneGraph_Edges();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.Node#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Node#getId()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Id();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link ca.mcmaster.mt4sg.models.scenegraph.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link ca.mcmaster.mt4sg.models.scenegraph.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation <em>IObject With Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IObject With Location</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation
	 * @generated
	 */
	EClass getIObjectWithLocation();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation#getX()
	 * @see #getIObjectWithLocation()
	 * @generated
	 */
	EAttribute getIObjectWithLocation_X();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation#getY()
	 * @see #getIObjectWithLocation()
	 * @generated
	 */
	EAttribute getIObjectWithLocation_Y();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions <em>IObject With Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IObject With Dimensions</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions
	 * @generated
	 */
	EClass getIObjectWithDimensions();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions#getLength()
	 * @see #getIObjectWithDimensions()
	 * @generated
	 */
	EAttribute getIObjectWithDimensions_Length();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions#getWidth()
	 * @see #getIObjectWithDimensions()
	 * @generated
	 */
	EAttribute getIObjectWithDimensions_Width();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.Vehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Vehicle
	 * @generated
	 */
	EClass getVehicle();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.Vehicle#getVLongitudinal <em>VLongitudinal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>VLongitudinal</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Vehicle#getVLongitudinal()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_VLongitudinal();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.Vehicle#getVLateral <em>VLateral</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>VLateral</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Vehicle#getVLateral()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_VLateral();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.Road <em>Road</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Road</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Road
	 * @generated
	 */
	EClass getRoad();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcmaster.mt4sg.models.scenegraph.Road#getLanes <em>Lanes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lanes</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Road#getLanes()
	 * @see #getRoad()
	 * @generated
	 */
	EReference getRoad_Lanes();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.Lane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Lane
	 * @generated
	 */
	EClass getLane();

	/**
	 * Returns the meta object for the containment reference list '{@link ca.mcmaster.mt4sg.models.scenegraph.Lane#getLaneSegments <em>Lane Segments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lane Segments</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Lane#getLaneSegments()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_LaneSegments();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.LaneSegment <em>Lane Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane Segment</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.LaneSegment
	 * @generated
	 */
	EClass getLaneSegment();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.Distance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distance</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Distance
	 * @generated
	 */
	EClass getDistance();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.Distance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Distance#getValue()
	 * @see #getDistance()
	 * @generated
	 */
	EAttribute getDistance_Value();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition <em>Spatial Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spatial Position</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition
	 * @generated
	 */
	EClass getSpatialPosition();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition#getValue()
	 * @see #getSpatialPosition()
	 * @generated
	 */
	EAttribute getSpatialPosition_Value();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.VehicleInLaneSegment <em>Vehicle In Lane Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle In Lane Segment</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.VehicleInLaneSegment
	 * @generated
	 */
	EClass getVehicleInLaneSegment();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.RSSViolation <em>RSS Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RSS Violation</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.RSSViolation
	 * @generated
	 */
	EClass getRSSViolation();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.LongitudinalRSSViolation <em>Longitudinal RSS Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Longitudinal RSS Violation</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.LongitudinalRSSViolation
	 * @generated
	 */
	EClass getLongitudinalRSSViolation();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.LateralRSSViolation <em>Lateral RSS Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lateral RSS Violation</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.LateralRSSViolation
	 * @generated
	 */
	EClass getLateralRSSViolation();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed <em>IObject With Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IObject With Speed</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed
	 * @generated
	 */
	EClass getIObjectWithSpeed();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed#getSpeed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed#getSpeed()
	 * @see #getIObjectWithSpeed()
	 * @generated
	 */
	EAttribute getIObjectWithSpeed_Speed();

	/**
	 * Returns the meta object for class '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation <em>IObject With Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IObject With Orientation</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation
	 * @generated
	 */
	EClass getIObjectWithOrientation();

	/**
	 * Returns the meta object for the attribute '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation#getHeading <em>Heading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Heading</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation#getHeading()
	 * @see #getIObjectWithOrientation()
	 * @generated
	 */
	EAttribute getIObjectWithOrientation_Heading();

	/**
	 * Returns the meta object for enum '{@link ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue <em>Semantic Distance Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Semantic Distance Value</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue
	 * @generated
	 */
	EEnum getSemanticDistanceValue();

	/**
	 * Returns the meta object for enum '{@link ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue <em>Semantic Spatial Position Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Semantic Spatial Position Value</em>'.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue
	 * @generated
	 */
	EEnum getSemanticSpatialPositionValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SceneGraphModelFactory getSceneGraphModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphImpl <em>Scene Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getSceneGraph()
		 * @generated
		 */
		EClass SCENE_GRAPH = eINSTANCE.getSceneGraph();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCENE_GRAPH__ID = eINSTANCE.getSceneGraph_Id();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE_GRAPH__NODES = eINSTANCE.getSceneGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE_GRAPH__EDGES = eINSTANCE.getSceneGraph_Edges();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.NodeImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ID = eINSTANCE.getNode_Id();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.EdgeImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation <em>IObject With Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getIObjectWithLocation()
		 * @generated
		 */
		EClass IOBJECT_WITH_LOCATION = eINSTANCE.getIObjectWithLocation();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IOBJECT_WITH_LOCATION__X = eINSTANCE.getIObjectWithLocation_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IOBJECT_WITH_LOCATION__Y = eINSTANCE.getIObjectWithLocation_Y();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions <em>IObject With Dimensions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getIObjectWithDimensions()
		 * @generated
		 */
		EClass IOBJECT_WITH_DIMENSIONS = eINSTANCE.getIObjectWithDimensions();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IOBJECT_WITH_DIMENSIONS__LENGTH = eINSTANCE.getIObjectWithDimensions_Length();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IOBJECT_WITH_DIMENSIONS__WIDTH = eINSTANCE.getIObjectWithDimensions_Width();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl <em>Vehicle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getVehicle()
		 * @generated
		 */
		EClass VEHICLE = eINSTANCE.getVehicle();

		/**
		 * The meta object literal for the '<em><b>VLongitudinal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__VLONGITUDINAL = eINSTANCE.getVehicle_VLongitudinal();

		/**
		 * The meta object literal for the '<em><b>VLateral</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__VLATERAL = eINSTANCE.getVehicle_VLateral();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.RoadImpl <em>Road</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.RoadImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getRoad()
		 * @generated
		 */
		EClass ROAD = eINSTANCE.getRoad();

		/**
		 * The meta object literal for the '<em><b>Lanes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROAD__LANES = eINSTANCE.getRoad_Lanes();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.LaneImpl <em>Lane</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.LaneImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getLane()
		 * @generated
		 */
		EClass LANE = eINSTANCE.getLane();

		/**
		 * The meta object literal for the '<em><b>Lane Segments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANE__LANE_SEGMENTS = eINSTANCE.getLane_LaneSegments();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.LaneSegmentImpl <em>Lane Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.LaneSegmentImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getLaneSegment()
		 * @generated
		 */
		EClass LANE_SEGMENT = eINSTANCE.getLaneSegment();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.DistanceImpl <em>Distance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.DistanceImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getDistance()
		 * @generated
		 */
		EClass DISTANCE = eINSTANCE.getDistance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISTANCE__VALUE = eINSTANCE.getDistance_Value();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.SpatialPositionImpl <em>Spatial Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SpatialPositionImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getSpatialPosition()
		 * @generated
		 */
		EClass SPATIAL_POSITION = eINSTANCE.getSpatialPosition();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPATIAL_POSITION__VALUE = eINSTANCE.getSpatialPosition_Value();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleInLaneSegmentImpl <em>Vehicle In Lane Segment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleInLaneSegmentImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getVehicleInLaneSegment()
		 * @generated
		 */
		EClass VEHICLE_IN_LANE_SEGMENT = eINSTANCE.getVehicleInLaneSegment();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.RSSViolationImpl <em>RSS Violation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.RSSViolationImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getRSSViolation()
		 * @generated
		 */
		EClass RSS_VIOLATION = eINSTANCE.getRSSViolation();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.LongitudinalRSSViolationImpl <em>Longitudinal RSS Violation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.LongitudinalRSSViolationImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getLongitudinalRSSViolation()
		 * @generated
		 */
		EClass LONGITUDINAL_RSS_VIOLATION = eINSTANCE.getLongitudinalRSSViolation();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.impl.LateralRSSViolationImpl <em>Lateral RSS Violation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.LateralRSSViolationImpl
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getLateralRSSViolation()
		 * @generated
		 */
		EClass LATERAL_RSS_VIOLATION = eINSTANCE.getLateralRSSViolation();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed <em>IObject With Speed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getIObjectWithSpeed()
		 * @generated
		 */
		EClass IOBJECT_WITH_SPEED = eINSTANCE.getIObjectWithSpeed();

		/**
		 * The meta object literal for the '<em><b>Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IOBJECT_WITH_SPEED__SPEED = eINSTANCE.getIObjectWithSpeed_Speed();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation <em>IObject With Orientation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getIObjectWithOrientation()
		 * @generated
		 */
		EClass IOBJECT_WITH_ORIENTATION = eINSTANCE.getIObjectWithOrientation();

		/**
		 * The meta object literal for the '<em><b>Heading</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IOBJECT_WITH_ORIENTATION__HEADING = eINSTANCE.getIObjectWithOrientation_Heading();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue <em>Semantic Distance Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getSemanticDistanceValue()
		 * @generated
		 */
		EEnum SEMANTIC_DISTANCE_VALUE = eINSTANCE.getSemanticDistanceValue();

		/**
		 * The meta object literal for the '{@link ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue <em>Semantic Spatial Position Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue
		 * @see ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelPackageImpl#getSemanticSpatialPositionValue()
		 * @generated
		 */
		EEnum SEMANTIC_SPATIAL_POSITION_VALUE = eINSTANCE.getSemanticSpatialPositionValue();

	}

} //SceneGraphModelPackage
