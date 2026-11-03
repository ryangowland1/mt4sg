/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.Vehicle#getVLongitudinal <em>VLongitudinal</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.Vehicle#getVLateral <em>VLateral</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getVehicle()
 * @model
 * @generated
 */
public interface Vehicle
		extends IObjectWithDimensions, IObjectWithLocation, IObjectWithSpeed, Node, IObjectWithOrientation {
	/**
	 * Returns the value of the '<em><b>VLongitudinal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VLongitudinal</em>' attribute.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getVehicle_VLongitudinal()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="org.eclipse.viatra.query.querybasedfeature patternFQN='ca.mcmaster.mt4sg.queries.vLongitudinal'"
	 * @generated
	 */
	double getVLongitudinal();

	/**
	 * Returns the value of the '<em><b>VLateral</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VLateral</em>' attribute.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getVehicle_VLateral()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="org.eclipse.viatra.query.querybasedfeature patternFQN='ca.mcmaster.mt4sg.queries.vLateral'"
	 * @generated
	 */
	double getVLateral();

} // Vehicle
