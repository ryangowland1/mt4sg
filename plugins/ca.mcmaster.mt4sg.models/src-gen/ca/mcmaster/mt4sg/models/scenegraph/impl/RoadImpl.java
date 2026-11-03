/**
 */
package ca.mcmaster.mt4sg.models.scenegraph.impl;

import ca.mcmaster.mt4sg.models.scenegraph.Lane;
import ca.mcmaster.mt4sg.models.scenegraph.Road;
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
 * An implementation of the model object '<em><b>Road</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.RoadImpl#getLanes <em>Lanes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoadImpl extends NodeImpl implements Road {
	/**
	 * The cached value of the '{@link #getLanes() <em>Lanes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanes()
	 * @generated
	 * @ordered
	 */
	protected EList<Lane> lanes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SceneGraphModelPackage.Literals.ROAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Lane> getLanes() {
		if (lanes == null) {
			lanes = new EObjectContainmentEList<Lane>(Lane.class, this, SceneGraphModelPackage.ROAD__LANES);
		}
		return lanes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SceneGraphModelPackage.ROAD__LANES:
			return ((InternalEList<?>) getLanes()).basicRemove(otherEnd, msgs);
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
		case SceneGraphModelPackage.ROAD__LANES:
			return getLanes();
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
		case SceneGraphModelPackage.ROAD__LANES:
			getLanes().clear();
			getLanes().addAll((Collection<? extends Lane>) newValue);
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
		case SceneGraphModelPackage.ROAD__LANES:
			getLanes().clear();
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
		case SceneGraphModelPackage.ROAD__LANES:
			return lanes != null && !lanes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoadImpl
