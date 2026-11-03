/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IObject With Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation#getX <em>X</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation#getY <em>Y</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithLocation()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IObjectWithLocation extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(double)
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithLocation_X()
	 * @model
	 * @generated
	 */
	double getX();

	/**
	 * Sets the value of the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(double value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(double)
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithLocation_Y()
	 * @model
	 * @generated
	 */
	double getY();

	/**
	 * Sets the value of the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(double value);

} // IObjectWithLocation
