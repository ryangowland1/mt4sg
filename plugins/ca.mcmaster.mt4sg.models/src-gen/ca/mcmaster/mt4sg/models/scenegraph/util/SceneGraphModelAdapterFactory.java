/**
 */
package ca.mcmaster.mt4sg.models.scenegraph.util;

import ca.mcmaster.mt4sg.models.scenegraph.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage
 * @generated
 */
public class SceneGraphModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SceneGraphModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SceneGraphModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SceneGraphModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SceneGraphModelSwitch<Adapter> modelSwitch = new SceneGraphModelSwitch<Adapter>() {
		@Override
		public Adapter caseSceneGraph(SceneGraph object) {
			return createSceneGraphAdapter();
		}

		@Override
		public Adapter caseNode(Node object) {
			return createNodeAdapter();
		}

		@Override
		public Adapter caseEdge(Edge object) {
			return createEdgeAdapter();
		}

		@Override
		public Adapter caseIObjectWithLocation(IObjectWithLocation object) {
			return createIObjectWithLocationAdapter();
		}

		@Override
		public Adapter caseIObjectWithDimensions(IObjectWithDimensions object) {
			return createIObjectWithDimensionsAdapter();
		}

		@Override
		public Adapter caseVehicle(Vehicle object) {
			return createVehicleAdapter();
		}

		@Override
		public Adapter caseRoad(Road object) {
			return createRoadAdapter();
		}

		@Override
		public Adapter caseLane(Lane object) {
			return createLaneAdapter();
		}

		@Override
		public Adapter caseLaneSegment(LaneSegment object) {
			return createLaneSegmentAdapter();
		}

		@Override
		public Adapter caseDistance(Distance object) {
			return createDistanceAdapter();
		}

		@Override
		public Adapter caseSpatialPosition(SpatialPosition object) {
			return createSpatialPositionAdapter();
		}

		@Override
		public Adapter caseVehicleInLaneSegment(VehicleInLaneSegment object) {
			return createVehicleInLaneSegmentAdapter();
		}

		@Override
		public Adapter caseRSSViolation(RSSViolation object) {
			return createRSSViolationAdapter();
		}

		@Override
		public Adapter caseLongitudinalRSSViolation(LongitudinalRSSViolation object) {
			return createLongitudinalRSSViolationAdapter();
		}

		@Override
		public Adapter caseLateralRSSViolation(LateralRSSViolation object) {
			return createLateralRSSViolationAdapter();
		}

		@Override
		public Adapter caseIObjectWithSpeed(IObjectWithSpeed object) {
			return createIObjectWithSpeedAdapter();
		}

		@Override
		public Adapter caseIObjectWithOrientation(IObjectWithOrientation object) {
			return createIObjectWithOrientationAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph <em>Scene Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraph
	 * @generated
	 */
	public Adapter createSceneGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation <em>IObject With Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation
	 * @generated
	 */
	public Adapter createIObjectWithLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions <em>IObject With Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions
	 * @generated
	 */
	public Adapter createIObjectWithDimensionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.Vehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Vehicle
	 * @generated
	 */
	public Adapter createVehicleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.Road <em>Road</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Road
	 * @generated
	 */
	public Adapter createRoadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.Lane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Lane
	 * @generated
	 */
	public Adapter createLaneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.LaneSegment <em>Lane Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.LaneSegment
	 * @generated
	 */
	public Adapter createLaneSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.Distance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.Distance
	 * @generated
	 */
	public Adapter createDistanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition <em>Spatial Position</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition
	 * @generated
	 */
	public Adapter createSpatialPositionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.VehicleInLaneSegment <em>Vehicle In Lane Segment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.VehicleInLaneSegment
	 * @generated
	 */
	public Adapter createVehicleInLaneSegmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.RSSViolation <em>RSS Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.RSSViolation
	 * @generated
	 */
	public Adapter createRSSViolationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.LongitudinalRSSViolation <em>Longitudinal RSS Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.LongitudinalRSSViolation
	 * @generated
	 */
	public Adapter createLongitudinalRSSViolationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.LateralRSSViolation <em>Lateral RSS Violation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.LateralRSSViolation
	 * @generated
	 */
	public Adapter createLateralRSSViolationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed <em>IObject With Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed
	 * @generated
	 */
	public Adapter createIObjectWithSpeedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation <em>IObject With Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation
	 * @generated
	 */
	public Adapter createIObjectWithOrientationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SceneGraphModelAdapterFactory
