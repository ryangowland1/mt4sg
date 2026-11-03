/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scene Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getId <em>Id</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getSceneGraph()
 * @model
 * @generated
 */
public interface SceneGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getSceneGraph_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link ca.mcmaster.mt4sg.models.scenegraph.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getSceneGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link ca.mcmaster.mt4sg.models.scenegraph.Edge}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getSceneGraph_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

} // SceneGraph
