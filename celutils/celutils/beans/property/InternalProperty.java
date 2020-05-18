package celutils.beans.property;

import celutils.beans.observable.ObservableImpl;
import celutils.collections.ObservableArrayList;

/**
 * A classification of property in which the property's value
 * is held inside of the property object.
 * <p>
 * This is best used for properties in which the value does not
 * exist elsewhere and is easily created within the property object.
 * <p>
 * This property implementation contains complete features for
 * observable features as well as property binding.
 * 
 * @param <T>	The type of value that this property will hold.
 * 
 * @see Property
 * @author Max D
 */
public abstract class InternalProperty<T> extends ObservableImpl<T> implements Property<T> {
	
	private static final long serialVersionUID = 7919615663581843930L;
	
	/**
	 * The property's value
	 */
	private T value;
	
	/**
	 * The list of this property's bindings
	 */
	private final ObservableArrayList<Binding<T>> bindings;
	
	/**
	 * Creates a new internal property with a default value of
	 * {@code null}.
	 */
	public InternalProperty() {
		this(null);
	}
	
	/**
	 * Creates a new internal property with a value specified
	 * by the value argument.
	 * 
	 * @param value	The initial value of this property.
	 */
	protected InternalProperty(T value) {
		super(new ObservableArrayList<>(), new ObservableArrayList<>(), value);
		this.value = value;
		this.bindings = new ObservableArrayList<Binding<T>>();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public T get() {
		return value;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void set(T value) {
		this.value = value;
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
