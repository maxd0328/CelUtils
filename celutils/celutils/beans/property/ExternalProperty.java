package celutils.beans.property;

import celutils.beans.observable.ObservableImpl;
import celutils.collections.ObservableArrayList;
import celutils.misc.IGetter;
import celutils.misc.ISetter;

/**
 * A classification of property in which the property's value is
 * held externally and only referenced from inside the property
 * object.
 * <p>
 * This type of property is best used for pre-existing variables
 * or third-party libraries in which the variables are directly
 * accessible or are not already contained in a property object.
 * It allows for essentially any form of data to be adapted into
 * a property object no matter its container or origin.
 * <p>
 * This property implementation contains complete features for
 * observable features as well as property binding.
 * <p>
 * All that is required to implement an external property is a
 * get/set implementation for the external variable.
 * 
 * @param <T>	The type of value that this property will hold.
 * 
 * @author Max D
 */
public abstract class ExternalProperty<T> extends ObservableImpl<T> implements Property<T> {
	
	private static final long serialVersionUID = -4569256417236941487L;
	
	/**
	 * The getter and setter for this property's referenced variable.
	 */
	private final IGetter<T> getter;
	private final ISetter<T> setter;
	
	/**
	 * The list of this property's bindings
	 */
	private final ObservableArrayList<Binding<T>> bindings;
	
	/**
	 * Creates a new external property given the getter and setter
	 * implementations. This will connect the external variable to
	 * the property and will allow it to function as any other internal
	 * property.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 */
	protected ExternalProperty(IGetter<T> getter, ISetter<T> setter) {
		super(new ObservableArrayList<>(), new ObservableArrayList<>(), getter.get());
		this.getter = getter;
		this.setter = setter;
		this.bindings = new ObservableArrayList<Binding<T>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T get() {
		return getter.get();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void set(T value) {
		if(setter != null)
			this.setter.set(value);
	}
	
	/**
	 * Returns the getter implementation for this external property.
	 * 
	 * @return	This property's getter implementation.
	 */
	public IGetter<T> getter() {
		return getter;
	}
	
	/**
	 * Returns the setter implementation for this external property.
	 * 
	 * @return	This property's setter implementation.
	 */
	public ISetter<T> setter() {
		return setter;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected T getValue() {
		return get();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void bind(Property<T> property, BindingOrder order) {
		this.bindings.add(new Binding<T>(this, property, order));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void unbind(Property<T> property) {
		this.bindings.removeIf(binding -> binding.getGuest() == property);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update() {
		super.update();
		for(Binding<T> binding : bindings)
			binding.update();
	}
	
	/**
	 * Returns the default class object for this property's type.
	 * Used for testing class compatibility in place of the
	 * {@code instanceof} operator, as per Java's object generic
	 * type erasure.
	 * 
	 * @return	The default class object for this property's type.
	 */
	public abstract Class<T> getPropertyType();
	
}
