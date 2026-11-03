/**
 */
package ca.mcmaster.mt4sg.models.scenegraph.util;

import ca.mcmaster.mt4sg.models.scenegraph.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage
 * @generated
 */
public class SceneGraphModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SceneGraphModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SceneGraphModelSwitch() {
		if (modelPackage == null) {
			modelPackage = SceneGraphModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case SceneGraphModelPackage.SCENE_GRAPH: {
			SceneGraph sceneGraph = (SceneGraph) theEObject;
			T result = caseSceneGraph(sceneGraph);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.NODE: {
			Node node = (Node) theEObject;
			T result = caseNode(node);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.EDGE: {
			Edge edge = (Edge) theEObject;
			T result = caseEdge(edge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.IOBJECT_WITH_LOCATION: {
			IObjectWithLocation iObjectWithLocation = (IObjectWithLocation) theEObject;
			T result = caseIObjectWithLocation(iObjectWithLocation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.IOBJECT_WITH_DIMENSIONS: {
			IObjectWithDimensions iObjectWithDimensions = (IObjectWithDimensions) theEObject;
			T result = caseIObjectWithDimensions(iObjectWithDimensions);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.VEHICLE: {
			Vehicle vehicle = (Vehicle) theEObject;
			T result = caseVehicle(vehicle);
			if (result == null)
				result = caseIObjectWithDimensions(vehicle);
			if (result == null)
				result = caseIObjectWithLocation(vehicle);
			if (result == null)
				result = caseIObjectWithSpeed(vehicle);
			if (result == null)
				result = caseNode(vehicle);
			if (result == null)
				result = caseIObjectWithOrientation(vehicle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.ROAD: {
			Road road = (Road) theEObject;
			T result = caseRoad(road);
			if (result == null)
				result = caseNode(road);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.LANE: {
			Lane lane = (Lane) theEObject;
			T result = caseLane(lane);
			if (result == null)
				result = caseNode(lane);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.LANE_SEGMENT: {
			LaneSegment laneSegment = (LaneSegment) theEObject;
			T result = caseLaneSegment(laneSegment);
			if (result == null)
				result = caseIObjectWithDimensions(laneSegment);
			if (result == null)
				result = caseIObjectWithLocation(laneSegment);
			if (result == null)
				result = caseNode(laneSegment);
			if (result == null)
				result = caseIObjectWithOrientation(laneSegment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.DISTANCE: {
			Distance distance = (Distance) theEObject;
			T result = caseDistance(distance);
			if (result == null)
				result = caseEdge(distance);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.SPATIAL_POSITION: {
			SpatialPosition spatialPosition = (SpatialPosition) theEObject;
			T result = caseSpatialPosition(spatialPosition);
			if (result == null)
				result = caseEdge(spatialPosition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.VEHICLE_IN_LANE_SEGMENT: {
			VehicleInLaneSegment vehicleInLaneSegment = (VehicleInLaneSegment) theEObject;
			T result = caseVehicleInLaneSegment(vehicleInLaneSegment);
			if (result == null)
				result = caseEdge(vehicleInLaneSegment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.RSS_VIOLATION: {
			RSSViolation rssViolation = (RSSViolation) theEObject;
			T result = caseRSSViolation(rssViolation);
			if (result == null)
				result = caseEdge(rssViolation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.LONGITUDINAL_RSS_VIOLATION: {
			LongitudinalRSSViolation longitudinalRSSViolation = (LongitudinalRSSViolation) theEObject;
			T result = caseLongitudinalRSSViolation(longitudinalRSSViolation);
			if (result == null)
				result = caseRSSViolation(longitudinalRSSViolation);
			if (result == null)
				result = caseEdge(longitudinalRSSViolation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.LATERAL_RSS_VIOLATION: {
			LateralRSSViolation lateralRSSViolation = (LateralRSSViolation) theEObject;
			T result = caseLateralRSSViolation(lateralRSSViolation);
			if (result == null)
				result = caseRSSViolation(lateralRSSViolation);
			if (result == null)
				result = caseEdge(lateralRSSViolation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.IOBJECT_WITH_SPEED: {
			IObjectWithSpeed iObjectWithSpeed = (IObjectWithSpeed) theEObject;
			T result = caseIObjectWithSpeed(iObjectWithSpeed);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SceneGraphModelPackage.IOBJECT_WITH_ORIENTATION: {
			IObjectWithOrientation iObjectWithOrientation = (IObjectWithOrientation) theEObject;
			T result = caseIObjectWithOrientation(iObjectWithOrientation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scene Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scene Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSceneGraph(SceneGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObject With Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObject With Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObjectWithLocation(IObjectWithLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObject With Dimensions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObject With Dimensions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObjectWithDimensions(IObjectWithDimensions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vehicle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVehicle(Vehicle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Road</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Road</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoad(Road object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lane</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lane</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLane(Lane object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lane Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lane Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLaneSegment(LaneSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Distance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Distance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDistance(Distance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spatial Position</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spatial Position</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpatialPosition(SpatialPosition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vehicle In Lane Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vehicle In Lane Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVehicleInLaneSegment(VehicleInLaneSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RSS Violation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RSS Violation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRSSViolation(RSSViolation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Longitudinal RSS Violation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Longitudinal RSS Violation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongitudinalRSSViolation(LongitudinalRSSViolation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lateral RSS Violation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lateral RSS Violation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLateralRSSViolation(LateralRSSViolation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObject With Speed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObject With Speed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObjectWithSpeed(IObjectWithSpeed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObject With Orientation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObject With Orientation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObjectWithOrientation(IObjectWithOrientation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SceneGraphModelSwitch
