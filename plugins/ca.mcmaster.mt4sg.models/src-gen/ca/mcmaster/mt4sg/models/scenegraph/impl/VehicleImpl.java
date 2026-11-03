/**
 */
package ca.mcmaster.mt4sg.models.scenegraph.impl;

import ca.mcmaster.mt4sg.models.scenegraph.IObjectWithLocation;
import ca.mcmaster.mt4sg.models.scenegraph.IObjectWithOrientation;
import ca.mcmaster.mt4sg.models.scenegraph.IObjectWithSpeed;
import ca.mcmaster.mt4sg.models.scenegraph.Node;
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage;
import ca.mcmaster.mt4sg.models.scenegraph.Vehicle;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl#getLength <em>Length</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl#getX <em>X</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl#getY <em>Y</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl#getSpeed <em>Speed</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl#getId <em>Id</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl#getHeading <em>Heading</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl#getVLongitudinal <em>VLongitudinal</em>}</li>
 *   <li>{@link ca.mcmaster.mt4sg.models.scenegraph.impl.VehicleImpl#getVLateral <em>VLateral</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VehicleImpl extends MinimalEObjectImpl.Container implements Vehicle {
	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final double LENGTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected double length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final double WIDTH_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected double width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final double X_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected double x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final double Y_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected double y = Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final double SPEED_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected double speed = SPEED_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeading() <em>Heading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeading()
	 * @generated
	 * @ordered
	 */
	protected static final double HEADING_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHeading() <em>Heading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeading()
	 * @generated
	 * @ordered
	 */
	protected double heading = HEADING_EDEFAULT;

	/**
	 * The cached setting delegate for the '{@link #getVLongitudinal() <em>VLongitudinal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVLongitudinal()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate VLONGITUDINAL__ESETTING_DELEGATE = ((EStructuralFeature.Internal) SceneGraphModelPackage.Literals.VEHICLE__VLONGITUDINAL)
			.getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getVLateral() <em>VLateral</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVLateral()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate VLATERAL__ESETTING_DELEGATE = ((EStructuralFeature.Internal) SceneGraphModelPackage.Literals.VEHICLE__VLATERAL)
			.getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SceneGraphModelPackage.Literals.VEHICLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLength(double newLength) {
		double oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SceneGraphModelPackage.VEHICLE__LENGTH, oldLength,
					length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(double newWidth) {
		double oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SceneGraphModelPackage.VEHICLE__WIDTH, oldWidth,
					width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setX(double newX) {
		double oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SceneGraphModelPackage.VEHICLE__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setY(double newY) {
		double oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SceneGraphModelPackage.VEHICLE__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSpeed() {
		return speed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpeed(double newSpeed) {
		double oldSpeed = speed;
		speed = newSpeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SceneGraphModelPackage.VEHICLE__SPEED, oldSpeed,
					speed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SceneGraphModelPackage.VEHICLE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getHeading() {
		return heading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeading(double newHeading) {
		double oldHeading = heading;
		heading = newHeading;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SceneGraphModelPackage.VEHICLE__HEADING, oldHeading,
					heading));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getVLongitudinal() {
		return (Double) VLONGITUDINAL__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getVLateral() {
		return (Double) VLATERAL__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SceneGraphModelPackage.VEHICLE__LENGTH:
			return getLength();
		case SceneGraphModelPackage.VEHICLE__WIDTH:
			return getWidth();
		case SceneGraphModelPackage.VEHICLE__X:
			return getX();
		case SceneGraphModelPackage.VEHICLE__Y:
			return getY();
		case SceneGraphModelPackage.VEHICLE__SPEED:
			return getSpeed();
		case SceneGraphModelPackage.VEHICLE__ID:
			return getId();
		case SceneGraphModelPackage.VEHICLE__HEADING:
			return getHeading();
		case SceneGraphModelPackage.VEHICLE__VLONGITUDINAL:
			return getVLongitudinal();
		case SceneGraphModelPackage.VEHICLE__VLATERAL:
			return getVLateral();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SceneGraphModelPackage.VEHICLE__LENGTH:
			setLength((Double) newValue);
			return;
		case SceneGraphModelPackage.VEHICLE__WIDTH:
			setWidth((Double) newValue);
			return;
		case SceneGraphModelPackage.VEHICLE__X:
			setX((Double) newValue);
			return;
		case SceneGraphModelPackage.VEHICLE__Y:
			setY((Double) newValue);
			return;
		case SceneGraphModelPackage.VEHICLE__SPEED:
			setSpeed((Double) newValue);
			return;
		case SceneGraphModelPackage.VEHICLE__ID:
			setId((String) newValue);
			return;
		case SceneGraphModelPackage.VEHICLE__HEADING:
			setHeading((Double) newValue);
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
		case SceneGraphModelPackage.VEHICLE__LENGTH:
			setLength(LENGTH_EDEFAULT);
			return;
		case SceneGraphModelPackage.VEHICLE__WIDTH:
			setWidth(WIDTH_EDEFAULT);
			return;
		case SceneGraphModelPackage.VEHICLE__X:
			setX(X_EDEFAULT);
			return;
		case SceneGraphModelPackage.VEHICLE__Y:
			setY(Y_EDEFAULT);
			return;
		case SceneGraphModelPackage.VEHICLE__SPEED:
			setSpeed(SPEED_EDEFAULT);
			return;
		case SceneGraphModelPackage.VEHICLE__ID:
			setId(ID_EDEFAULT);
			return;
		case SceneGraphModelPackage.VEHICLE__HEADING:
			setHeading(HEADING_EDEFAULT);
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
		case SceneGraphModelPackage.VEHICLE__LENGTH:
			return length != LENGTH_EDEFAULT;
		case SceneGraphModelPackage.VEHICLE__WIDTH:
			return width != WIDTH_EDEFAULT;
		case SceneGraphModelPackage.VEHICLE__X:
			return x != X_EDEFAULT;
		case SceneGraphModelPackage.VEHICLE__Y:
			return y != Y_EDEFAULT;
		case SceneGraphModelPackage.VEHICLE__SPEED:
			return speed != SPEED_EDEFAULT;
		case SceneGraphModelPackage.VEHICLE__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case SceneGraphModelPackage.VEHICLE__HEADING:
			return heading != HEADING_EDEFAULT;
		case SceneGraphModelPackage.VEHICLE__VLONGITUDINAL:
			return VLONGITUDINAL__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		case SceneGraphModelPackage.VEHICLE__VLATERAL:
			return VLATERAL__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IObjectWithLocation.class) {
			switch (derivedFeatureID) {
			case SceneGraphModelPackage.VEHICLE__X:
				return SceneGraphModelPackage.IOBJECT_WITH_LOCATION__X;
			case SceneGraphModelPackage.VEHICLE__Y:
				return SceneGraphModelPackage.IOBJECT_WITH_LOCATION__Y;
			default:
				return -1;
			}
		}
		if (baseClass == IObjectWithSpeed.class) {
			switch (derivedFeatureID) {
			case SceneGraphModelPackage.VEHICLE__SPEED:
				return SceneGraphModelPackage.IOBJECT_WITH_SPEED__SPEED;
			default:
				return -1;
			}
		}
		if (baseClass == Node.class) {
			switch (derivedFeatureID) {
			case SceneGraphModelPackage.VEHICLE__ID:
				return SceneGraphModelPackage.NODE__ID;
			default:
				return -1;
			}
		}
		if (baseClass == IObjectWithOrientation.class) {
			switch (derivedFeatureID) {
			case SceneGraphModelPackage.VEHICLE__HEADING:
				return SceneGraphModelPackage.IOBJECT_WITH_ORIENTATION__HEADING;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IObjectWithLocation.class) {
			switch (baseFeatureID) {
			case SceneGraphModelPackage.IOBJECT_WITH_LOCATION__X:
				return SceneGraphModelPackage.VEHICLE__X;
			case SceneGraphModelPackage.IOBJECT_WITH_LOCATION__Y:
				return SceneGraphModelPackage.VEHICLE__Y;
			default:
				return -1;
			}
		}
		if (baseClass == IObjectWithSpeed.class) {
			switch (baseFeatureID) {
			case SceneGraphModelPackage.IOBJECT_WITH_SPEED__SPEED:
				return SceneGraphModelPackage.VEHICLE__SPEED;
			default:
				return -1;
			}
		}
		if (baseClass == Node.class) {
			switch (baseFeatureID) {
			case SceneGraphModelPackage.NODE__ID:
				return SceneGraphModelPackage.VEHICLE__ID;
			default:
				return -1;
			}
		}
		if (baseClass == IObjectWithOrientation.class) {
			switch (baseFeatureID) {
			case SceneGraphModelPackage.IOBJECT_WITH_ORIENTATION__HEADING:
				return SceneGraphModelPackage.VEHICLE__HEADING;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (length: ");
		result.append(length);
		result.append(", width: ");
		result.append(width);
		result.append(", x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", speed: ");
		result.append(speed);
		result.append(", id: ");
		result.append(id);
		result.append(", heading: ");
		result.append(heading);
		result.append(')');
		return result.toString();
	}

} //VehicleImpl
