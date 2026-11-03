/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Semantic Spatial Position Value</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getSemanticSpatialPositionValue()
 * @model
 * @generated
 */
public enum SemanticSpatialPositionValue implements Enumerator {
	/**
	 * The '<em><b>LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	LEFT(0, "LEFT", "LEFT"),

	/**
	 * The '<em><b>FRONT LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRONT_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	FRONT_LEFT(1, "FRONT_LEFT", "FRONT_LEFT"),

	/**
	 * The '<em><b>FRONT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRONT_VALUE
	 * @generated
	 * @ordered
	 */
	FRONT(2, "FRONT", "FRONT"),

	/**
	 * The '<em><b>FRONT RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRONT_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	FRONT_RIGHT(3, "FRONT_RIGHT", "FRONT_RIGHT"),

	/**
	 * The '<em><b>RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	RIGHT(4, "RIGHT", "RIGHT"),

	/**
	 * The '<em><b>REAR RIGHT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAR_RIGHT_VALUE
	 * @generated
	 * @ordered
	 */
	REAR_RIGHT(5, "REAR_RIGHT", "REAR_RIGHT"),

	/**
	 * The '<em><b>REAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAR_VALUE
	 * @generated
	 * @ordered
	 */
	REAR(6, "REAR", "REAR"),

	/**
	 * The '<em><b>REAR LEFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAR_LEFT_VALUE
	 * @generated
	 * @ordered
	 */
	REAR_LEFT(7, "REAR_LEFT", "REAR_LEFT");

	/**
	 * The '<em><b>LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LEFT_VALUE = 0;

	/**
	 * The '<em><b>FRONT LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRONT_LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRONT_LEFT_VALUE = 1;

	/**
	 * The '<em><b>FRONT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRONT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRONT_VALUE = 2;

	/**
	 * The '<em><b>FRONT RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRONT_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRONT_RIGHT_VALUE = 3;

	/**
	 * The '<em><b>RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RIGHT_VALUE = 4;

	/**
	 * The '<em><b>REAR RIGHT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAR_RIGHT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REAR_RIGHT_VALUE = 5;

	/**
	 * The '<em><b>REAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REAR_VALUE = 6;

	/**
	 * The '<em><b>REAR LEFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAR_LEFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REAR_LEFT_VALUE = 7;

	/**
	 * An array of all the '<em><b>Semantic Spatial Position Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SemanticSpatialPositionValue[] VALUES_ARRAY = new SemanticSpatialPositionValue[] { LEFT,
			FRONT_LEFT, FRONT, FRONT_RIGHT, RIGHT, REAR_RIGHT, REAR, REAR_LEFT, };

	/**
	 * A public read-only list of all the '<em><b>Semantic Spatial Position Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SemanticSpatialPositionValue> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Semantic Spatial Position Value</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SemanticSpatialPositionValue get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SemanticSpatialPositionValue result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Semantic Spatial Position Value</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SemanticSpatialPositionValue getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SemanticSpatialPositionValue result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Semantic Spatial Position Value</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SemanticSpatialPositionValue get(int value) {
		switch (value) {
		case LEFT_VALUE:
			return LEFT;
		case FRONT_LEFT_VALUE:
			return FRONT_LEFT;
		case FRONT_VALUE:
			return FRONT;
		case FRONT_RIGHT_VALUE:
			return FRONT_RIGHT;
		case RIGHT_VALUE:
			return RIGHT;
		case REAR_RIGHT_VALUE:
			return REAR_RIGHT;
		case REAR_VALUE:
			return REAR;
		case REAR_LEFT_VALUE:
			return REAR_LEFT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SemanticSpatialPositionValue(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //SemanticSpatialPositionValue
