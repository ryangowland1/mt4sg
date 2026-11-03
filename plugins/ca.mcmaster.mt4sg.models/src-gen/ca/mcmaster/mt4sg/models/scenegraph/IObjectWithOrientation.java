/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IObject With Orientation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation#getHeading <em>Heading</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithOrientation()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IObjectWithOrientation extends EObject {
	/**
	 * Returns the value of the '<em><b>Heading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heading</em>' attribute.
	 * @see #setHeading(double)
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithOrientation_Heading()
	 * @model
	 * @generated
	 */
	double getHeading();

	/**
	 * Sets the value of the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation#getHeading <em>Heading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heading</em>' attribute.
	 * @see #getHeading()
	 * @generated
	 */
	void setHeading(double value);

} // IObjectWithOrientation
