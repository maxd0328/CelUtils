package celutils.beans.property;

import java.util.Collection;

import celutils.beans.observable.ChangeListener;
import celutils.beans.observable.EventListener;

/**
 * A utility class used for creating property implementations
 * that are primarily used as binding catalysts to set values
 * of pre-existing properties.
 * <p>
 * This class supports property implementations that have certain
 * values when certain conditions are met.
 * 
 * @author Max D
 */
public final class Bindings {
	
	/**
	 * Returns a new catalyst boolean-property that is bound to
	 * the value of the given boolean property.
	 * <p>
	 * These catalyst properties are used as conditions for other
	 * conditionally-based properties in this class.
	 * 
	 * @param condition	The condition upon which the catalyst-property will be bound.
	 * @return			The new catalyst boolean-property.
	 */
	public static BindingCondition when(Property<Boolean> condition) {
		return new BindingCondition(condition);
	}
	
	/**
	 * Returns a new catalyst boolean-property that is bound to the
	 * inverse of the value of the given boolean property.
	 * <p>
	 * These catalyst properties are used as conditions for other
	 * conditionally-based properties in this class.
	 * 
	 * @param condition	The inverse-condition upon which the catalyst-property will be bound.
	 * @return			The new catalyst boolean-property.
	 */
	public static BindingCondition whenNot(Property<Boolean> condition) {
		return new BindingCondition(Properties.asInverse(condition));
	}
	
	/**
	 * Returns a new catalyst boolean-property that will always be
	 * set to true.
	 * 
	 * @return	The new catalyst boolean-property.
	 */
	public static BindingCondition ifTrue() {
		return when(Properties.createBooleanProperty(true));
	}
	
	/**
	 * Returns a new catalyst boolean-property that will always be
	 * set to false.
	 * 
	 * @return	The new catalyst boolean-property.
	 */
	public static BindingCondition ifFalse() {
		return when(Properties.createBooleanProperty(false));
	}
	
	/**
	 * Creates a new special-purpose property designed for fluent
	 * property binding.
	 * 
	 * @param <T>	The type of data that this property will hold.
	 * @return		The newly created special-purpose property.
	 */
	public static <T> PropertyBinding<T> create() {
		return new PropertyBinding<T>();
	}
	
	/**
	 * A special-purpose property class used for binding conditions for
	 * other special-purpose binding properties.
	 * 
	 * @author Max D
	 */
	public static final class BindingCondition implements Property<Boolean> {
		
		private static final long serialVersionUID = 887185735094188407L;
		
		/**
		 * The conditional property upon which this condition is based
		 */
		private final Property<Boolean> condition;
		
		/**
		 * Creates a new binding condition based on the given condition.
		 * 
		 * @param condition	The condition upon which the binding is based.
		 */
		
		private BindingCondition(Property<Boolean> condition) {
			this.condition = condition;
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void addListener(ChangeListener<Boolean> listener) {
			throw new UnsupportedOperationException("addListener");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void removeListener(ChangeListener<Boolean> listener) {
			throw new UnsupportedOperationException("removeListener");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public Collection<ChangeListener<Boolean>> getListeners() {
			throw new UnsupportedOperationException("getListeners");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void addEventListener(EventListener listener) {
			throw new UnsupportedOperationException("addEventListener");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void removeEventListener(EventListener listener) {
			throw new UnsupportedOperationException("removeEventListener");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public Collection<EventListener> getEventListeners() {
			throw new UnsupportedOperationException("getEventListeners");
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Boolean get() {
			return condition.get();
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void set(Boolean value) {
			throw new UnsupportedOperationException("set");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void bind(Property<Boolean> property, BindingOrder order) {
			throw new UnsupportedOperationException("bind");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void unbind(Property<Boolean> property) {
			throw new UnsupportedOperationException("unbind");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: This method has no effect in this property implementation
		 */
		@Override
		public void update() {
		}
		
		/**
		 * Returns a new binding-intended property based upon this condition.
		 * 
		 * @param <T>	The type of data that this property will contain
		 * @param value	The when-true value of this property.
		 * @return		The newly created binding-intended property.
		 */
		public <T> PropertyBinding<T> then(T value) {
			return new PropertyBinding<T>().when(this).then(value);
		}
		
	}
	
	public static final class PropertyBinding<T> implements Property<T> {
		
		private static final long serialVersionUID = 3391680427931946069L;
		
		/**
		 * The condition upon which this property is based.
		 */
		private BindingCondition condition;
		
		/**
		 * The values that this property will reflect when the condition
		 * is true or false, respectively.
		 */
		private T whenTrue;
		private T whenFalse;
		
		/**
		 * Creates a new property with no conditions or values.
		 */
		private PropertyBinding() {
			this.condition = null;
			this.whenTrue = null;
			this.whenFalse = null;
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void addListener(ChangeListener<T> listener) {
			throw new UnsupportedOperationException("addListener");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void removeListener(ChangeListener<T> listener) {
			throw new UnsupportedOperationException("removeListener");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public Collection<ChangeListener<T>> getListeners() {
			throw new UnsupportedOperationException("getListeners");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void addEventListener(EventListener listener) {
			throw new UnsupportedOperationException("addEventListener");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void removeEventListener(EventListener listener) {
			throw new UnsupportedOperationException("removeEventListener");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public Collection<EventListener> getEventListeners() {
			throw new UnsupportedOperationException("getEventListeners");
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public T get() {
			return condition == null || condition.get() ? whenTrue : whenFalse;
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void set(T value) {
			throw new UnsupportedOperationException("set");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void bind(Property<T> property, BindingOrder order) {
			throw new UnsupportedOperationException("bind");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: Unsupported operation for this property implementation.
		 */
		@Override
		public void unbind(Property<T> property) {
			throw new UnsupportedOperationException("unbind");
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: This method has no effect in this property implementation
		 */
		@Override
		public void update() {
		}
		
		/**
		 * Sets the condition of this property.
		 * 
		 * @param condition	The condition that this property will contain.
		 * @return			This property.
		 */
		public PropertyBinding<T> when(BindingCondition condition) {
			this.condition = condition;
			return this;
		}
		
		/**
		 * Sets the <i>when-true</i> value of this property.
		 * 
		 * @param value	The <i>when-true</i> that this property will contain.
		 * @return		This property.
		 */
		public PropertyBinding<T> then(T value) {
			this.whenTrue = value;
			return this;
		}
		
		/**
		 * Sets the <i>when-false</i> value of this property.
		 * 
		 * @param value	The <i>when-false</i> that this property will contain.
		 * @return		This property.
		 */
		public PropertyBinding<T> otherwise(T value) {
			this.whenFalse = value;
			return this;
		}
		
	}
	
}
