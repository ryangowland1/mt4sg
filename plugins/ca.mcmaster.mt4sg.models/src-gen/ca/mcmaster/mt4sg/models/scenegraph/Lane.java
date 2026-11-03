/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.Lane#getLaneSegments <em>Lane Segments</em>}</li>
 * </ul>
 *
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getLane()
 * @model
 * @generated
 */
public interface Lane extends Node {
	/**
	 * Returns the value of the '<em><b>Lane Segments</b></em>' containment reference list.
	 * The list contents are of type {@link ca.mcmaster.mt4sg.models.scenegraph.LaneSegment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lane Segments</em>' containment reference list.
	 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getLane_LaneSegments()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<LaneSegment> getLaneSegments();

} // Lane
