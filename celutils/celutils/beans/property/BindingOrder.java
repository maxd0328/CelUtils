package celutils.beans.property;

/**
 * This enum describes binding precedence for two or more
 * bound properties.
 * <p>
 * It controls which property will have value precedence over
 * the other in a two-way binding when the values are initially
 * not equal or when both values happen to change at the exact
 * same time.
 * <p>
 * Bindings can set to be one way bindings using this enum, or
 * bidirectional with certain precedence in the event of
 * simultaneous change.
 * 
 * @author Max D
 */
public enum BindingOrder {
	
	/**
	 * Indicates that the root property of this binding should
	 * have total precedence over the other, and should therefore
	 * never change its value in lieu of the other property.
	 * <p>
	 * The guest property will always have its value changed by
	 * a root property with a dominant binding order.
	 */
	DOMINANT,
	
	/**
	 * Indicates that the guest property of this binding should
	 * have total precedence over the root property, and therefore
	 * the root property should always change its value to match
	 * that of the guest property.
	 * <p>
	 * The guest property will never have its value changed by
	 * a root property with a recessive binding order.
	 */
	RECESSIVE,
	
	/**
	 * Indicates that the this binding should be a bidirectional
	 * binding and that both properties should change in lieu of
	 * the other.
	 * <p>
	 * In the event that both properties are initially different,
	 * or both change at the same time, the root property will always
	 * take precedence with a bidirectional-dominant binding order.
	 */
	BIDIRECTIONAL_DOMINANT,
	
	/**
	 * Indicates that the this binding should be a bidirectional
	 * binding and that both properties should change in lieu of
	 * the other.
	 * <p>
	 * In the event that both properties are initially different,
	 * or both change at the same time, the root property will never
	 * take precedence with a bidirectional-recessive binding order,
	 * and therefore will be set to the value of the guest property.
	 */
	BIDIRECTIONAL_RECESSIVE;
	
}
