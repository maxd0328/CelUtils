package celutils.beans.property;

import celutils.beans.observable.Observable;

/**
 * As an extension of the <a href="#{@link}">{@link Observable}</a>
 * interface, the Property interface defines any value that is
 * categorized as a property.
 * <p>
 * Properties serve as standard wrappers for any pre-existing type,
 * but provide a variety of features.
 * <p>
 * Properties contain all features of observable values, meaning that
 * they can implement event listeners and change listeners. They can
 * also be bound to other properties, effectively linking their values
 * together so that they will always be equal.
 * <p>
 * There are two primary classifications of properties: external and
 * internal properties. External properties are ones that contain their
 * values outside of the property object, while internal properties
 * contain their values within the property object. All property features
 * can be implemented equally using both internal and external properties.
 * 
 * @param <T>	This type of value that this property will hold.
 * 
 * @see InternalProperty
 * @see ExternalProperty
 * @author Max D
 */
public interface Property<T> extends Observable<T> {
	
	/**
	 * Returns the current value of this property.
	 * 
	 * @return	The value of this property.
	 */
	public T get();
	
	/**
	 * Sets the current value of this property. This
	 * is not always supported, as many properties are
	 * categorized as read-only.
	 * 
	 * @param value	The value to assign to this property.
	 */
	public void set(T value);
	
	/**
	 * Binds another property to this one, using this
	 * property object as the root property in the binding.
	 * <p>
	 * The binding order of this binding is specified with
	 * the order argument. Note that the terminology of the
	 * <a href="#{@link}">{@link BindingOrder}</a> argument
	 * applies to this property object, not the guest property
	 * object.
	 * 
	 * @param property	The guest property to bind to this property.
	 * @param order		The binding order to use for this binding.
	 */
	public void bind(Property<T> property, BindingOrder order);
	
	/**
	 * Removes a binding between this property and the given
	 * guest property from this object's list of bindings.
	 * <p>
	 * If no such binding exists, then no action is taken.
	 * 
	 * @param property	The property of which to remove the binding.
	 */
	public void unbind(Property<T> property);
	
	/**
	 * Updates this property.
	 * <p>
	 * This method should first perform all updates of the observable
	 * interface. See <a href="#{@link}">{@link Observable#update()}</a>.
	 * <p>
	 * Then, this method should update all bindings of this property, as
	 * well as perform any update-requiring operation specific to this
	 * particular property.
	 */
	@Override
	public void update();
	
	/**
	 * An alternate method to the <a href="#{@link}">{@link Property#bind
	 * (Property, BindingOrder)}</a> method. It simply calls that method
	 * using the given property with the default binding order of
	 * <a href="#{@link}">{@link BindingOrder#RECESSIVE}</a>. Note that
	 * with this default binding order, this property will then become
	 * subordinate to the bound property.
	 * 
	 * @param property
	 */
	public default void bind(Property<T> property) {
		bind(property, BindingOrder.RECESSIVE);
	}
	
}
