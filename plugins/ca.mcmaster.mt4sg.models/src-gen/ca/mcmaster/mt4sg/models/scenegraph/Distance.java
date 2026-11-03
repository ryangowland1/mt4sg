/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.Distance#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getDistance()
 * @model
 * @generated
 */
public interface Distance extends Edge {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue
	 * @see #setValue(SemanticDistanceValue)
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getDistance_Value()
	 * @model required="true"
	 * @generated
	 */
	SemanticDistanceValue getValue();

	/**
	 * Sets the value of the '{@link ca.mcmaster.mt4sg.models.scenegraph.Distance#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue
	 * @see #getValue()
	 * @generated
	 */
	void setValue(SemanticDistanceValue value);

} // Distance
