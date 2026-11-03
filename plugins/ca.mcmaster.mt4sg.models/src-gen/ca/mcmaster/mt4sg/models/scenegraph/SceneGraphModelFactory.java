/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage
 * @generated
 */
public interface SceneGraphModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SceneGraphModelFactory eINSTANCE = ca.mcmaster.mt4sg.models.scenegraph.impl.SceneGraphModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Scene Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scene Graph</em>'.
	 * @generated
	 */
	SceneGraph createSceneGraph();

	/**
	 * Returns a new object of class '<em>Vehicle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vehicle</em>'.
	 * @generated
	 */
	Vehicle createVehicle();

	/**
	 * Returns a new object of class '<em>Road</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Road</em>'.
	 * @generated
	 */
	Road createRoad();

	/**
	 * Returns a new object of class '<em>Lane</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lane</em>'.
	 * @generated
	 */
	Lane createLane();

	/**
	 * Returns a new object of class '<em>Lane Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lane Segment</em>'.
	 * @generated
	 */
	LaneSegment createLaneSegment();

	/**
	 * Returns a new object of class '<em>Distance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Distance</em>'.
	 * @generated
	 */
	Distance createDistance();

	/**
	 * Returns a new object of class '<em>Spatial Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spatial Position</em>'.
	 * @generated
	 */
	SpatialPosition createSpatialPosition();

	/**
	 * Returns a new object of class '<em>Vehicle In Lane Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vehicle In Lane Segment</em>'.
	 * @generated
	 */
	VehicleInLaneSegment createVehicleInLaneSegment();

	/**
	 * Returns a new object of class '<em>RSS Violation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>RSS Violation</em>'.
	 * @generated
	 */
	RSSViolation createRSSViolation();

	/**
	 * Returns a new object of class '<em>Longitudinal RSS Violation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Longitudinal RSS Violation</em>'.
	 * @generated
	 */
	LongitudinalRSSViolation createLongitudinalRSSViolation();

	/**
	 * Returns a new object of class '<em>Lateral RSS Violation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lateral RSS Violation</em>'.
	 * @generated
	 */
	LateralRSSViolation createLateralRSSViolation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SceneGraphModelPackage getSceneGraphModelPackage();

} //SceneGraphModelFactory
