/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IObject With Dimensions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions#getLength <em>Length</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions#getWidth <em>Width</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithDimensions()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IObjectWithDimensions extends EObject {
	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(double)
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithDimensions_Length()
	 * @model
	 * @generated
	 */
	double getLength();

	/**
	 * Sets the value of the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(double value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(double)
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithDimensions_Width()
	 * @model
	 * @generated
	 */
	double getWidth();

	/**
	 * Sets the value of the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithDimensions#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(double value);

} // IObjectWithDimensions
