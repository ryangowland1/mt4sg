/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Road</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.Road#getLanes <em>Lanes</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getRoad()
 * @model
 * @generated
 */
public interface Road extends Node {
	/**
	 * Returns the value of the '<em><b>Lanes</b></em>' containment reference list.
	 * The list contents are of type {@link ca.mcmaster.mt4sg.models.scenegraph.Lane}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lanes</em>' containment reference list.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getRoad_Lanes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Lane> getLanes();

} // Road
