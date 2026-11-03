/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IObject With Speed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed#getSpeed <em>Speed</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithSpeed()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IObjectWithSpeed extends EObject {
	/**
	 * Returns the value of the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed</em>' attribute.
	 * @see #setSpeed(double)
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getIObjectWithSpeed_Speed()
	 * @model
	 * @generated
	 */
	double getSpeed();

	/**
	 * Sets the value of the '{@link ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed#getSpeed <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed</em>' attribute.
	 * @see #getSpeed()
	 * @generated
	 */
	void setSpeed(double value);

} // IObjectWithSpeed
