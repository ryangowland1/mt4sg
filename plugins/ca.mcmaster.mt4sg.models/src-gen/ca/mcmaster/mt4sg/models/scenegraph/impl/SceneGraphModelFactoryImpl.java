/**
 */
package ca.mcmaster.mt4sg.models.scenegraph.impl;

import ca.mcmaster.mt4sg.models.scenegraph.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SceneGraphModelFactoryImpl extends EFactoryImpl implements SceneGraphModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SceneGraphModelFactory init() {
		try {
			SceneGraphModelFactory theSceneGraphModelFactory = (SceneGraphModelFactory) EPackage.Registry.INSTANCE
					.getEFactory(SceneGraphModelPackage.eNS_URI);
			if (theSceneGraphModelFactory != null) {
				return theSceneGraphModelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SceneGraphModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SceneGraphModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case SceneGraphModelPackage.SCENE_GRAPH:
			return createSceneGraph();
		case SceneGraphModelPackage.VEHICLE:
			return createVehicle();
		case SceneGraphModelPackage.ROAD:
			return createRoad();
		case SceneGraphModelPackage.LANE:
			return createLane();
		case SceneGraphModelPackage.LANE_SEGMENT:
			return createLaneSegment();
		case SceneGraphModelPackage.DISTANCE:
			return createDistance();
		case SceneGraphModelPackage.SPATIAL_POSITION:
			return createSpatialPosition();
		case SceneGraphModelPackage.VEHICLE_IN_LANE_SEGMENT:
			return createVehicleInLaneSegment();
		case SceneGraphModelPackage.RSS_VIOLATION:
			return createRSSViolation();
		case SceneGraphModelPackage.LONGITUDINAL_RSS_VIOLATION:
			return createLongitudinalRSSViolation();
		case SceneGraphModelPackage.LATERAL_RSS_VIOLATION:
			return createLateralRSSViolation();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case SceneGraphModelPackage.SEMANTIC_DISTANCE_VALUE:
			return createSemanticDistanceValueFromString(eDataType, initialValue);
		case SceneGraphModelPackage.SEMANTIC_SPATIAL_POSITION_VALUE:
			return createSemanticSpatialPositionValueFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case SceneGraphModelPackage.SEMANTIC_DISTANCE_VALUE:
			return convertSemanticDistanceValueToString(eDataType, instanceValue);
		case SceneGraphModelPackage.SEMANTIC_SPATIAL_POSITION_VALUE:
			return convertSemanticSpatialPositionValueToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SceneGraph createSceneGraph() {
		SceneGraphImpl sceneGraph = new SceneGraphImpl();
		return sceneGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vehicle createVehicle() {
		VehicleImpl vehicle = new VehicleImpl();
		return vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Road createRoad() {
		RoadImpl road = new RoadImpl();
		return road;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Lane createLane() {
		LaneImpl lane = new LaneImpl();
		return lane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LaneSegment createLaneSegment() {
		LaneSegmentImpl laneSegment = new LaneSegmentImpl();
		return laneSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Distance createDistance() {
		DistanceImpl distance = new DistanceImpl();
		return distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpatialPosition createSpatialPosition() {
		SpatialPositionImpl spatialPosition = new SpatialPositionImpl();
		return spatialPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VehicleInLaneSegment createVehicleInLaneSegment() {
		VehicleInLaneSegmentImpl vehicleInLaneSegment = new VehicleInLaneSegmentImpl();
		return vehicleInLaneSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RSSViolation createRSSViolation() {
		RSSViolationImpl rssViolation = new RSSViolationImpl();
		return rssViolation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LongitudinalRSSViolation createLongitudinalRSSViolation() {
		LongitudinalRSSViolationImpl longitudinalRSSViolation = new LongitudinalRSSViolationImpl();
		return longitudinalRSSViolation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LateralRSSViolation createLateralRSSViolation() {
		LateralRSSViolationImpl lateralRSSViolation = new LateralRSSViolationImpl();
		return lateralRSSViolation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticDistanceValue createSemanticDistanceValueFromString(EDataType eDataType, String initialValue) {
		SemanticDistanceValue result = SemanticDistanceValue.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSemanticDistanceValueToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticSpatialPositionValue createSemanticSpatialPositionValueFromString(EDataType eDataType,
			String initialValue) {
		SemanticSpatialPositionValue result = SemanticSpatialPositionValue.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSemanticSpatialPositionValueToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SceneGraphModelPackage getSceneGraphModelPackage() {
		return (SceneGraphModelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SceneGraphModelPackage getPackage() {
		return SceneGraphModelPackage.eINSTANCE;
	}

} //SceneGraphModelFactoryImpl
