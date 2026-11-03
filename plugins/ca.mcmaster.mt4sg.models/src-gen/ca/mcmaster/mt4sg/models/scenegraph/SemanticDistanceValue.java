/**
 */
package ca.mcmaster.mt4sg.models.scenegraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Semantic Distance Value</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage#getSemanticDistanceValue()
 * @model
 * @generated
 */
public enum SemanticDistanceValue implements Enumerator {
	/**
	 * The '<em><b>PRE COLLISION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRE_COLLISION_VALUE
	 * @generated
	 * @ordered
	 */
	PRE_COLLISION(0, "PRE_COLLISION", "PRE_COLLISION"),

	/**
	 * The '<em><b>SUPER NEAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPER_NEAR_VALUE
	 * @generated
	 * @ordered
	 */
	SUPER_NEAR(1, "SUPER_NEAR", "SUPER_NEAR"),

	/**
	 * The '<em><b>VERY NEAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERY_NEAR_VALUE
	 * @generated
	 * @ordered
	 */
	VERY_NEAR(2, "VERY_NEAR", "VERY_NEAR"),

	/**
	 * The '<em><b>NEAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEAR_VALUE
	 * @generated
	 * @ordered
	 */
	NEAR(3, "NEAR", "NEAR"),

	/**
	 * The '<em><b>VISIBLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VISIBLE_VALUE
	 * @generated
	 * @ordered
	 */
	VISIBLE(4, "VISIBLE", "VISIBLE");

	/**
	 * The '<em><b>PRE COLLISION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRE_COLLISION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRE_COLLISION_VALUE = 0;

	/**
	 * The '<em><b>SUPER NEAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPER_NEAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUPER_NEAR_VALUE = 1;

	/**
	 * The '<em><b>VERY NEAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERY_NEAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERY_NEAR_VALUE = 2;

	/**
	 * The '<em><b>NEAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEAR_VALUE = 3;

	/**
	 * The '<em><b>VISIBLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VISIBLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VISIBLE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Semantic Distance Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SemanticDistanceValue[] VALUES_ARRAY = new SemanticDistanceValue[] { PRE_COLLISION, SUPER_NEAR,
			VERY_NEAR, NEAR, VISIBLE, };

	/**
	 * A public read-only list of all the '<em><b>Semantic Distance Value</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SemanticDistanceValue> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Semantic Distance Value</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SemanticDistanceValue get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SemanticDistanceValue result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Semantic Distance Value</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SemanticDistanceValue getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SemanticDistanceValue result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Semantic Distance Value</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SemanticDistanceValue get(int value) {
		switch (value) {
		case PRE_COLLISION_VALUE:
			return PRE_COLLISION;
		case SUPER_NEAR_VALUE:
			return SUPER_NEAR;
		case VERY_NEAR_VALUE:
			return VERY_NEAR;
		case NEAR_VALUE:
			return NEAR;
		case VISIBLE_VALUE:
			return VISIBLE;
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
	private SemanticDistanceValue(int value, String name, String literal) {
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

} //SemanticDistanceValue
