/**
 */
package ca.mcmaster.mt4sg.models.scenegraph.impl;

import ca.mcmaster.mt4sg.models.scenegraph.Lane;
import ca.mcmaster.mt4sg.models.scenegraph.LaneSegment;
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.LaneImpl#getLaneSegments <em>Lane Segments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LaneImpl extends NodeImpl implements Lane {
	/**
	 * The cached value of the '{@link #getLaneSegments() <em>Lane Segments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLaneSegments()
	 * @generated
	 * @ordered
	 */
	protected EList<LaneSegment> laneSegments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SceneGraphModelPackage.Literals.LANE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LaneSegment> getLaneSegments() {
		if (laneSegments == null) {
			laneSegments = new EObjectContainmentEList<LaneSegment>(LaneSegment.class, this,
					SceneGraphModelPackage.LANE__LANE_SEGMENTS);
		}
		return laneSegments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SceneGraphModelPackage.LANE__LANE_SEGMENTS:
			return ((InternalEList<?>) getLaneSegments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SceneGraphModelPackage.LANE__LANE_SEGMENTS:
			return getLaneSegments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SceneGraphModelPackage.LANE__LANE_SEGMENTS:
			getLaneSegments().clear();
			getLaneSegments().addAll((Collection<? extends LaneSegment>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SceneGraphModelPackage.LANE__LANE_SEGMENTS:
			getLaneSegments().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SceneGraphModelPackage.LANE__LANE_SEGMENTS:
			return laneSegments != null && !laneSegments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LaneImpl
