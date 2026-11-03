/**
 */
package ca.mcmaster.mt4sg.models.scenegraph.impl;

import ca.mcmaster.mt4sg.models.scenegraph.Distance;
import ca.mcmaster.mt4sg.models.scenegraph.Edge;
import ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions;
import ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation;
import ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation;
import ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed;
import ca.mcmaster.mt4sg.models.scenegraph.Lane;
import ca.mcmaster.mt4sg.models.scenegraph.LaneSegment;
import ca.mcmaster.mt4sg.models.scenegraph.LateralRSSViolation;
import ca.mcmaster.mt4sg.models.scenegraph.LongitudinalRSSViolation;
import ca.mcmaster.mt4sg.models.scenegraph.Node;
import ca.mcmaster.mt4sg.models.scenegraph.RSSViolation;
import ca.mcmaster.mt4sg.models.scenegraph.Road;
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraph;
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelFactory;
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage;
import ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue;
import ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue;
import ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition;
import ca.mcmaster.mt4sg.models.scenegraph.Vehicle;
import ca.mcmaster.mt4sg.models.scenegraph.VehicleInLaneSegment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SceneGraphModelPackageImpl extends EPackageImpl implements SceneGraphModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sceneGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iObjectWithLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iObjectWithDimensionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vehicleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass laneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass laneSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spatialPositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vehicleInLaneSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rssViolationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longitudinalRSSViolationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lateralRSSViolationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iObjectWithSpeedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iObjectWithOrientationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum semanticDistanceValueEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum semanticSpatialPositionValueEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SceneGraphModelPackageImpl() {
		super(eNS_URI, SceneGraphModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link SceneGraphModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SceneGraphModelPackage init() {
		if (isInited)
			return (SceneGraphModelPackage) EPackage.Registry.INSTANCE.getEPackage(SceneGraphModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSceneGraphModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SceneGraphModelPackageImpl theSceneGraphModelPackage = registeredSceneGraphModelPackage instanceof SceneGraphModelPackageImpl
				? (SceneGraphModelPackageImpl) registeredSceneGraphModelPackage
				: new SceneGraphModelPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theSceneGraphModelPackage.createPackageContents();

		// Initialize created meta-data
		theSceneGraphModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSceneGraphModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SceneGraphModelPackage.eNS_URI, theSceneGraphModelPackage);
		return theSceneGraphModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSceneGraph() {
		return sceneGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSceneGraph_Id() {
		return (EAttribute) sceneGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSceneGraph_Nodes() {
		return (EReference) sceneGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSceneGraph_Edges() {
		return (EReference) sceneGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_Id() {
		return (EAttribute) nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdge_Source() {
		return (EReference) edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdge_Target() {
		return (EReference) edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIObjectWithLocation() {
		return iObjectWithLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIObjectWithLocation_X() {
		return (EAttribute) iObjectWithLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIObjectWithLocation_Y() {
		return (EAttribute) iObjectWithLocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIObjectWithDimensions() {
		return iObjectWithDimensionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIObjectWithDimensions_Length() {
		return (EAttribute) iObjectWithDimensionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIObjectWithDimensions_Width() {
		return (EAttribute) iObjectWithDimensionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVehicle() {
		return vehicleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVehicle_VLongitudinal() {
		return (EAttribute) vehicleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVehicle_VLateral() {
		return (EAttribute) vehicleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRoad() {
		return roadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoad_Lanes() {
		return (EReference) roadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLane() {
		return laneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLane_LaneSegments() {
		return (EReference) laneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLaneSegment() {
		return laneSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDistance() {
		return distanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDistance_Value() {
		return (EAttribute) distanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpatialPosition() {
		return spatialPositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSpatialPosition_Value() {
		return (EAttribute) spatialPositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVehicleInLaneSegment() {
		return vehicleInLaneSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRSSViolation() {
		return rssViolationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLongitudinalRSSViolation() {
		return longitudinalRSSViolationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLateralRSSViolation() {
		return lateralRSSViolationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIObjectWithSpeed() {
		return iObjectWithSpeedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIObjectWithSpeed_Speed() {
		return (EAttribute) iObjectWithSpeedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIObjectWithOrientation() {
		return iObjectWithOrientationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIObjectWithOrientation_Heading() {
		return (EAttribute) iObjectWithOrientationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSemanticDistanceValue() {
		return semanticDistanceValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSemanticSpatialPositionValue() {
		return semanticSpatialPositionValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SceneGraphModelFactory getSceneGraphModelFactory() {
		return (SceneGraphModelFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		sceneGraphEClass = createEClass(SCENE_GRAPH);
		createEAttribute(sceneGraphEClass, SCENE_GRAPH__ID);
		createEReference(sceneGraphEClass, SCENE_GRAPH__NODES);
		createEReference(sceneGraphEClass, SCENE_GRAPH__EDGES);

		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__ID);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__SOURCE);
		createEReference(edgeEClass, EDGE__TARGET);

		iObjectWithLocationEClass = createEClass(IOBJECT_WITH_LOCATION);
		createEAttribute(iObjectWithLocationEClass, IOBJECT_WITH_LOCATION__X);
		createEAttribute(iObjectWithLocationEClass, IOBJECT_WITH_LOCATION__Y);

		iObjectWithDimensionsEClass = createEClass(IOBJECT_WITH_DIMENSIONS);
		createEAttribute(iObjectWithDimensionsEClass, IOBJECT_WITH_DIMENSIONS__LENGTH);
		createEAttribute(iObjectWithDimensionsEClass, IOBJECT_WITH_DIMENSIONS__WIDTH);

		vehicleEClass = createEClass(VEHICLE);
		createEAttribute(vehicleEClass, VEHICLE__VLONGITUDINAL);
		createEAttribute(vehicleEClass, VEHICLE__VLATERAL);

		roadEClass = createEClass(ROAD);
		createEReference(roadEClass, ROAD__LANES);

		laneEClass = createEClass(LANE);
		createEReference(laneEClass, LANE__LANE_SEGMENTS);

		laneSegmentEClass = createEClass(LANE_SEGMENT);

		distanceEClass = createEClass(DISTANCE);
		createEAttribute(distanceEClass, DISTANCE__VALUE);

		spatialPositionEClass = createEClass(SPATIAL_POSITION);
		createEAttribute(spatialPositionEClass, SPATIAL_POSITION__VALUE);

		vehicleInLaneSegmentEClass = createEClass(VEHICLE_IN_LANE_SEGMENT);

		rssViolationEClass = createEClass(RSS_VIOLATION);

		longitudinalRSSViolationEClass = createEClass(LONGITUDINAL_RSS_VIOLATION);

		lateralRSSViolationEClass = createEClass(LATERAL_RSS_VIOLATION);

		iObjectWithSpeedEClass = createEClass(IOBJECT_WITH_SPEED);
		createEAttribute(iObjectWithSpeedEClass, IOBJECT_WITH_SPEED__SPEED);

		iObjectWithOrientationEClass = createEClass(IOBJECT_WITH_ORIENTATION);
		createEAttribute(iObjectWithOrientationEClass, IOBJECT_WITH_ORIENTATION__HEADING);

		// Create enums
		semanticDistanceValueEEnum = createEEnum(SEMANTIC_DISTANCE_VALUE);
		semanticSpatialPositionValueEEnum = createEEnum(SEMANTIC_SPATIAL_POSITION_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		vehicleEClass.getESuperTypes().add(this.getIObjectWithDimensions());
		vehicleEClass.getESuperTypes().add(this.getIObjectWithLocation());
		vehicleEClass.getESuperTypes().add(this.getIObjectWithSpeed());
		vehicleEClass.getESuperTypes().add(this.getNode());
		vehicleEClass.getESuperTypes().add(this.getIObjectWithOrientation());
		roadEClass.getESuperTypes().add(this.getNode());
		laneEClass.getESuperTypes().add(this.getNode());
		laneSegmentEClass.getESuperTypes().add(this.getIObjectWithDimensions());
		laneSegmentEClass.getESuperTypes().add(this.getIObjectWithLocation());
		laneSegmentEClass.getESuperTypes().add(this.getNode());
		laneSegmentEClass.getESuperTypes().add(this.getIObjectWithOrientation());
		distanceEClass.getESuperTypes().add(this.getEdge());
		spatialPositionEClass.getESuperTypes().add(this.getEdge());
		vehicleInLaneSegmentEClass.getESuperTypes().add(this.getEdge());
		rssViolationEClass.getESuperTypes().add(this.getEdge());
		longitudinalRSSViolationEClass.getESuperTypes().add(this.getRSSViolation());
		lateralRSSViolationEClass.getESuperTypes().add(this.getRSSViolation());

		// Initialize classes, features, and operations; add parameters
		initEClass(sceneGraphEClass, SceneGraph.class, "SceneGraph", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSceneGraph_Id(), ecorePackage.getEString(), "id", null, 0, 1, SceneGraph.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSceneGraph_Nodes(), this.getNode(), null, "nodes", null, 0, -1, SceneGraph.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSceneGraph_Edges(), this.getEdge(), null, "edges", null, 0, -1, SceneGraph.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Id(), ecorePackage.getEString(), "id", null, 0, 1, Node.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeEClass, Edge.class, "Edge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_Source(), this.getNode(), null, "source", null, 1, 1, Edge.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getEdge_Target(), this.getNode(), null, "target", null, 1, 1, Edge.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(iObjectWithLocationEClass, IObjectWithLocation.class, "IObjectWithLocation", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIObjectWithLocation_X(), ecorePackage.getEDouble(), "x", null, 0, 1,
				IObjectWithLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIObjectWithLocation_Y(), ecorePackage.getEDouble(), "y", null, 0, 1,
				IObjectWithLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iObjectWithDimensionsEClass, IObjectWithDimensions.class, "IObjectWithDimensions", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIObjectWithDimensions_Length(), ecorePackage.getEDouble(), "length", null, 0, 1,
				IObjectWithDimensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIObjectWithDimensions_Width(), ecorePackage.getEDouble(), "width", null, 0, 1,
				IObjectWithDimensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vehicleEClass, Vehicle.class, "Vehicle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVehicle_VLongitudinal(), ecorePackage.getEDouble(), "vLongitudinal", null, 0, 1,
				Vehicle.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getVehicle_VLateral(), ecorePackage.getEDouble(), "vLateral", null, 0, 1, Vehicle.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(roadEClass, Road.class, "Road", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoad_Lanes(), this.getLane(), null, "lanes", null, 1, -1, Road.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(laneEClass, Lane.class, "Lane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLane_LaneSegments(), this.getLaneSegment(), null, "laneSegments", null, 1, -1, Lane.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(laneSegmentEClass, LaneSegment.class, "LaneSegment", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(distanceEClass, Distance.class, "Distance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDistance_Value(), this.getSemanticDistanceValue(), "value", null, 1, 1, Distance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(spatialPositionEClass, SpatialPosition.class, "SpatialPosition", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpatialPosition_Value(), this.getSemanticSpatialPositionValue(), "value", null, 1, 1,
				SpatialPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(vehicleInLaneSegmentEClass, VehicleInLaneSegment.class, "VehicleInLaneSegment", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rssViolationEClass, RSSViolation.class, "RSSViolation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(longitudinalRSSViolationEClass, LongitudinalRSSViolation.class, "LongitudinalRSSViolation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lateralRSSViolationEClass, LateralRSSViolation.class, "LateralRSSViolation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iObjectWithSpeedEClass, IObjectWithSpeed.class, "IObjectWithSpeed", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIObjectWithSpeed_Speed(), ecorePackage.getEDouble(), "speed", null, 0, 1,
				IObjectWithSpeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(iObjectWithOrientationEClass, IObjectWithOrientation.class, "IObjectWithOrientation", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIObjectWithOrientation_Heading(), ecorePackage.getEDouble(), "heading", null, 0, 1,
				IObjectWithOrientation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(semanticDistanceValueEEnum, SemanticDistanceValue.class, "SemanticDistanceValue");
		addEEnumLiteral(semanticDistanceValueEEnum, SemanticDistanceValue.PRE_COLLISION);
		addEEnumLiteral(semanticDistanceValueEEnum, SemanticDistanceValue.SUPER_NEAR);
		addEEnumLiteral(semanticDistanceValueEEnum, SemanticDistanceValue.VERY_NEAR);
		addEEnumLiteral(semanticDistanceValueEEnum, SemanticDistanceValue.NEAR);
		addEEnumLiteral(semanticDistanceValueEEnum, SemanticDistanceValue.VISIBLE);

		initEEnum(semanticSpatialPositionValueEEnum, SemanticSpatialPositionValue.class,
				"SemanticSpatialPositionValue");
		addEEnumLiteral(semanticSpatialPositionValueEEnum, SemanticSpatialPositionValue.LEFT);
		addEEnumLiteral(semanticSpatialPositionValueEEnum, SemanticSpatialPositionValue.FRONT_LEFT);
		addEEnumLiteral(semanticSpatialPositionValueEEnum, SemanticSpatialPositionValue.FRONT);
		addEEnumLiteral(semanticSpatialPositionValueEEnum, SemanticSpatialPositionValue.FRONT_RIGHT);
		addEEnumLiteral(semanticSpatialPositionValueEEnum, SemanticSpatialPositionValue.RIGHT);
		addEEnumLiteral(semanticSpatialPositionValueEEnum, SemanticSpatialPositionValue.REAR_RIGHT);
		addEEnumLiteral(semanticSpatialPositionValueEEnum, SemanticSpatialPositionValue.REAR);
		addEEnumLiteral(semanticSpatialPositionValueEEnum, SemanticSpatialPositionValue.REAR_LEFT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// org.eclipse.viatra.query.querybasedfeature
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation(this, source, new String[] { "settingDelegates", "org.eclipse.viatra.query.querybasedfeature" });
	}

	/**
	 * Initializes the annotations for <b>org.eclipse.viatra.query.querybasedfeature</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.eclipse.viatra.query.querybasedfeature";
		addAnnotation(getVehicle_VLongitudinal(), source,
				new String[] { "patternFQN", "ca.mcmaster.mt4sg.queries.vLongitudinal" });
		addAnnotation(getVehicle_VLateral(), source,
				new String[] { "patternFQN", "ca.mcmaster.mt4sg.queries.vLateral" });
	}

} //SceneGraphModelPackageImpl
