/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spatial Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getSpatialPosition()
 * @model
 * @generated
 */
public interface SpatialPosition extends Edge {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue
	 * @see #setValue(SemanticSpatialPositionValue)
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getSpatialPosition_Value()
	 * @model required="true"
	 * @generated
	 */
	SemanticSpatialPositionValue getValue();

	/**
	 * Sets the value of the '{@link ca.mcmaster.mt4sg.models.scenegraph.SpatialPosition#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue
	 * @see #getValue()
	 * @generated
	 */
	void setValue(SemanticSpatialPositionValue value);

} // SpatialPosition
