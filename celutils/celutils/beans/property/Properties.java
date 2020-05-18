package celutils.beans.property;

import java.util.Collection;

import celutils.beans.observable.ChangeListener;
import celutils.beans.observable.EventListener;
import celutils.misc.IGetter;
import celutils.misc.ISetter;

/**
 * A utility class containing several implementations
 * of internal and external properties, allowing for the
 * creation and management of properties with virtually
 * any type.
 * <p>
 * This class also contains utility methods to manipulate
 * properties, such as creating inverse properties for
 * boolean properties.
 * 
 * @author Max D
 */
public final class Properties {
	
	/**
	 * A boolean implementation for the <a href="#{@link}">
	 * {@link ExternalProperty}</a> class.
	 * 
	 * @see ExternalProperty
	 * @author Max D
	 */
	public static final class ExternalBooleanProperty extends ExternalProperty<Boolean> {
		
		private static final long serialVersionUID = 7569118361404635221L;
		
		/**
		 * Creates a new external boolean property given the getter
		 * and setter implementations.
		 * 
		 * @param getter	The getter implementation for this property.
		 * @param setter	The setter implementation for this property.
		 */
		public ExternalBooleanProperty(IGetter<Boolean> getter, ISetter<Boolean> setter) {
			super(getter, setter);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Boolean> getPropertyType() {
			return Boolean.class;
		}
		
	}
	
	/**
	 * A byte implementation for the <a href="#{@link}">
	 * {@link ExternalProperty}</a> class.
	 * 
	 * @see ExternalProperty
	 * @author Max D
	 */
	public static final class ExternalByteProperty extends ExternalProperty<Byte> {
		
		private static final long serialVersionUID = -7550178385986834464L;
		
		/**
		 * Creates a new external byte property given the getter
		 * and setter implementations.
		 * 
		 * @param getter	The getter implementation for this property.
		 * @param setter	The setter implementation for this property.
		 */
		public ExternalByteProperty(IGetter<Byte> getter, ISetter<Byte> setter) {
			super(getter, setter);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Byte> getPropertyType() {
			return Byte.class;
		}
		
	}
	
	/**
	 * A short implementation for the <a href="#{@link}">
	 * {@link ExternalProperty}</a> class.
	 * 
	 * @see ExternalProperty
	 * @author Max D
	 */
	public static final class ExternalShortProperty extends ExternalProperty<Short> {
		
		private static final long serialVersionUID = -3831593166215310485L;
		
		/**
		 * Creates a new external short property given the getter
		 * and setter implementations.
		 * 
		 * @param getter	The getter implementation for this property.
		 * @param setter	The setter implementation for this property.
		 */
		public ExternalShortProperty(IGetter<Short> getter, ISetter<Short> setter) {
			super(getter, setter);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Short> getPropertyType() {
			return Short.class;
		}
		
	}
	
	/**
	 * An integer implementation for the <a href="#{@link}">
	 * {@link ExternalProperty}</a> class.
	 * 
	 * @see ExternalProperty
	 * @author Max D
	 */
	public static final class ExternalIntegerProperty extends ExternalProperty<Integer> {
		
		private static final long serialVersionUID = -8783379683673127084L;
		
		/**
		 * Creates a new external integer property given the getter
		 * and setter implementations.
		 * 
		 * @param getter	The getter implementation for this property.
		 * @param setter	The setter implementation for this property.
		 */
		public ExternalIntegerProperty(IGetter<Integer> getter, ISetter<Integer> setter) {
			super(getter, setter);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Integer> getPropertyType() {
			return Integer.class;
		}
		
	}
	
	/**
	 * A long implementation for the <a href="#{@link}">
	 * {@link ExternalProperty}</a> class.
	 * 
	 * @see ExternalProperty
	 * @author Max D
	 */
	public static final class ExternalLongProperty extends ExternalProperty<Long> {
		
		private static final long serialVersionUID = 2038728305568708339L;
		
		/**
		 * Creates a new external long property given the getter
		 * and setter implementations.
		 * 
		 * @param getter	The getter implementation for this property.
		 * @param setter	The setter implementation for this property.
		 */
		public ExternalLongProperty(IGetter<Long> getter, ISetter<Long> setter) {
			super(getter, setter);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Long> getPropertyType() {
			return Long.class;
		}
		
	}
	
	/**
	 * A float implementation for the <a href="#{@link}">
	 * {@link ExternalProperty}</a> class.
	 * 
	 * @see ExternalProperty
	 * @author Max D
	 */
	public static final class ExternalFloatProperty extends ExternalProperty<Float> {
		
		private static final long serialVersionUID = -9039745132367507761L;
		
		/**
		 * Creates a new external float property given the getter
		 * and setter implementations.
		 * 
		 * @param getter	The getter implementation for this property.
		 * @param setter	The setter implementation for this property.
		 */
		public ExternalFloatProperty(IGetter<Float> getter, ISetter<Float> setter) {
			super(getter, setter);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Float> getPropertyType() {
			return Float.class;
		}
		
	}
	
	/**
	 * A double implementation for the <a href="#{@link}">
	 * {@link ExternalProperty}</a> class.
	 * 
	 * @see ExternalProperty
	 * @author Max D
	 */
	public static final class ExternalDoubleProperty extends ExternalProperty<Double> {
		
		private static final long serialVersionUID = 8373518500454512820L;
		
		/**
		 * Creates a new external double property given the getter
		 * and setter implementations.
		 * 
		 * @param getter	The getter implementation for this property.
		 * @param setter	The setter implementation for this property.
		 */
		public ExternalDoubleProperty(IGetter<Double> getter, ISetter<Double> setter) {
			super(getter, setter);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Double> getPropertyType() {
			return Double.class;
		}
		
	}
	
	/**
	 * A string implementation for the <a href="#{@link}">
	 * {@link ExternalProperty}</a> class.
	 * 
	 * @see ExternalProperty
	 * @author Max D
	 */
	public static final class ExternalStringProperty extends ExternalProperty<String> {
		
		private static final long serialVersionUID = 5432055301085778871L;
		
		/**
		 * Creates a new external string property given the getter
		 * and setter implementations.
		 * 
		 * @param getter	The getter implementation for this property.
		 * @param setter	The setter implementation for this property.
		 */
		public ExternalStringProperty(IGetter<String> getter, ISetter<String> setter) {
			super(getter, setter);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<String> getPropertyType() {
			return String.class;
		}
		
	}
	
	/**
	 * A generic implementation for the <a href="#{@link}">
	 * {@link ExternalProperty}</a> class.
	 * 
	 * @see ExternalProperty
	 * @author Max D
	 */
	public static final class GenericExternalProperty<T> extends ExternalProperty<T> {
		
		private static final long serialVersionUID = 3693985355289297052L;
		
		/**
		 * The class type for this generic property.
		 */
		private final Class<T> type;
		
		/**
		 * Creates a new external generic property given the getter
		 * and setter implementations.
		 * 
		 * @param type		The default class type for this property.
		 * @param getter	The getter implementation for this property.
		 * @param setter	The setter implementation for this property.
		 */
		public GenericExternalProperty(Class<T> type, IGetter<T> getter, ISetter<T> setter) {
			super(getter, setter);
			this.type = type;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<T> getPropertyType() {
			return type;
		}
		
	}
	
	public static final class InternalBooleanProperty extends InternalProperty<Boolean> {
		
		private static final long serialVersionUID = 5398337310320077685L;
		
		/**
		 * Creates a new internal boolean property with a default
		 * boolean value.
		 */
		public InternalBooleanProperty() {
			super(false);
		}
		
		/**
		 * Creates a new internal boolean property with the given
		 * value argument.
		 * 
		 * @param value	The initial value for this property.
		 */
		public InternalBooleanProperty(boolean value) {
			super(value);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Boolean> getPropertyType() {
			return Boolean.class;
		}
		
	}
	
	public static final class InternalByteProperty extends InternalProperty<Byte> {
		
		private static final long serialVersionUID = -683697087119876345L;
		
		/**
		 * Creates a new internal byte property with a default
		 * byte value.
		 */
		public InternalByteProperty() {
			super((byte) 0);
		}
		
		/**
		 * Creates a new internal byte property with the given
		 * value argument.
		 * 
		 * @param value	The initial value for this property.
		 */
		public InternalByteProperty(byte value) {
			super(value);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Byte> getPropertyType() {
			return Byte.class;
		}
		
	}
	
	public static final class InternalShortProperty extends InternalProperty<Short> {
		
		private static final long serialVersionUID = 6609379420573565028L;
		
		/**
		 * Creates a new internal short property with a default
		 * short value.
		 */
		public InternalShortProperty() {
			super((short) 0);
		}
		
		/**
		 * Creates a new internal short property with the given
		 * value argument.
		 * 
		 * @param value	The initial value for this property.
		 */
		public InternalShortProperty(short value) {
			super(value);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Short> getPropertyType() {
			return Short.class;
		}
		
	}
	
	public static final class InternalIntegerProperty extends InternalProperty<Integer> {
		
		private static final long serialVersionUID = 2234518668339170251L;
		
		/**
		 * Creates a new internal integer property with a default
		 * integer value.
		 */
		public InternalIntegerProperty() {
			super(0);
		}
		
		/**
		 * Creates a new internal integer property with the given
		 * value argument.
		 * 
		 * @param value	The initial value for this property.
		 */
		public InternalIntegerProperty(int value) {
			super(value);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Integer> getPropertyType() {
			return Integer.class;
		}
		
	}
	
	public static final class InternalLongProperty extends InternalProperty<Long> {
		
		private static final long serialVersionUID = -3264252549451440435L;
		
		/**
		 * Creates a new internal long property with a default
		 * long value.
		 */
		public InternalLongProperty() {
			super(0L);
		}
		
		/**
		 * Creates a new internal long property with the given
		 * value argument.
		 * 
		 * @param value	The initial value for this property.
		 */
		public InternalLongProperty(long value) {
			super(value);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Long> getPropertyType() {
			return Long.class;
		}
		
	}
	
	public static final class InternalFloatProperty extends InternalProperty<Float> {
		
		private static final long serialVersionUID = -9162381195312555328L;
		
		/**
		 * Creates a new internal float property with a default
		 * float value.
		 */
		public InternalFloatProperty() {
			super(0.0f);
		}
		
		/**
		 * Creates a new internal float property with the given
		 * value argument.
		 * 
		 * @param value	The initial value for this property.
		 */
		public InternalFloatProperty(float value) {
			super(value);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Float> getPropertyType() {
			return Float.class;
		}
		
	}
	
	public static final class InternalDoubleProperty extends InternalProperty<Double> {
		
		private static final long serialVersionUID = -4227540819994208457L;
		
		/**
		 * Creates a new internal double property with a default
		 * double value.
		 */
		public InternalDoubleProperty() {
			super(0.0d);
		}
		
		/**
		 * Creates a new internal double property with the given
		 * value argument.
		 * 
		 * @param value	The initial value for this property.
		 */
		public InternalDoubleProperty(double value) {
			super(value);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<Double> getPropertyType() {
			return Double.class;
		}
		
	}
	
	public static final class InternalStringProperty extends InternalProperty<String> {
		
		private static final long serialVersionUID = 5037525417804245793L;
		
		/**
		 * Creates a new internal string property with a default
		 * string value.
		 */
		public InternalStringProperty() {
			super("");
		}
		
		/**
		 * Creates a new internal string property with the given
		 * value argument.
		 * 
		 * @param value	The initial value for this property.
		 */
		public InternalStringProperty(String value) {
			super(value);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<String> getPropertyType() {
			return String.class;
		}
		
	}
	
	public static final class GenericInternalProperty<T> extends InternalProperty<T> {
		
		private static final long serialVersionUID = -7188254369131332631L;
		
		/**
		 * The class type for this property.
		 */
		private final Class<T> type;
		
		/**
		 * Creates a new internal generic property with a value
		 * of null.
		 */
		public GenericInternalProperty(Class<T> type) {
			this(type, null);
		}
		
		/**
		 * Creates a new internal generic property with the given
		 * value argument.
		 * 
		 * @param type	The default class type for this property.
		 * @param value	The initial value for this property.
		 */
		public GenericInternalProperty(Class<T> type, T value) {
			super(value);
			this.type = type;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Class<T> getPropertyType() {
			return type;
		}
		
	}
	
	/**
	 * Creates a new read-only external property with the given
	 * getter implementation.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @return			The newly created read-only external property.
	 */
	public static ExternalProperty<Boolean> readOnlyBooleanProperty(IGetter<Boolean> getter) {
		return new ExternalBooleanProperty(getter, readOnly());
	}
	
	/**
	 * Creates a new external property with the given getter and
	 * setter implementations.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 * @return			The newly created external property.
	 */
	public static ExternalProperty<Boolean> createBooleanProperty(IGetter<Boolean> getter, ISetter<Boolean> setter) {
		return new ExternalBooleanProperty(getter, setter);
	}
	
	/**
	 * Creates a new internal property with a default property
	 * value (as specified by Java standard).
	 * 
	 * @return	The newly created internal property.
	 */
	public static InternalProperty<Boolean> createBooleanProperty() {
		return new InternalBooleanProperty();
	}
	
	/**
	 * Creates a new internal property with the given value
	 * argument.
	 * 
	 * @param value	The initial value for this property.
	 * @return		The newly created internal property.
	 */
	public static InternalProperty<Boolean> createBooleanProperty(boolean value) {
		return new InternalBooleanProperty(value);
	}
	
	/**
	 * Creates a new read-only external property with the given
	 * getter implementation.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @return			The newly created read-only external property.
	 */
	public static ExternalProperty<Byte> readOnlyByteProperty(IGetter<Byte> getter) {
		return new ExternalByteProperty(getter, readOnly());
	}
	
	/**
	 * Creates a new external property with the given getter and
	 * setter implementations.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 * @return			The newly created external property.
	 */
	public static ExternalProperty<Byte> createByteProperty(IGetter<Byte> getter, ISetter<Byte> setter) {
		return new ExternalByteProperty(getter, setter);
	}
	
	/**
	 * Creates a new internal property with a default property
	 * value (as specified by Java standard).
	 * 
	 * @return	The newly created internal property.
	 */
	public static InternalProperty<Byte> createByteProperty() {
		return new InternalByteProperty();
	}
	
	/**
	 * Creates a new internal property with the given value
	 * argument.
	 * 
	 * @param value	The initial value for this property.
	 * @return		The newly created internal property.
	 */
	public static InternalProperty<Byte> createByteProperty(byte value) {
		return new InternalByteProperty(value);
	}
	
	/**
	 * Creates a new read-only external property with the given
	 * getter implementation.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @return			The newly created read-only external property.
	 */
	public static ExternalProperty<Short> readOnlyShortProperty(IGetter<Short> getter) {
		return new ExternalShortProperty(getter, readOnly());
	}
	
	/**
	 * Creates a new external property with the given getter and
	 * setter implementations.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 * @return			The newly created external property.
	 */
	public static ExternalProperty<Short> createShortProperty(IGetter<Short> getter, ISetter<Short> setter) {
		return new ExternalShortProperty(getter, setter);
	}
	
	/**
	 * Creates a new internal property with a default property
	 * value (as specified by Java standard).
	 * 
	 * @return	The newly created internal property.
	 */
	public static InternalProperty<Short> createShortProperty() {
		return new InternalShortProperty();
	}
	
	/**
	 * Creates a new internal property with the given value
	 * argument.
	 * 
	 * @param value	The initial value for this property.
	 * @return		The newly created internal property.
	 */
	public static InternalProperty<Short> createShortProperty(short value) {
		return new InternalShortProperty(value);
	}
	
	/**
	 * Creates a new read-only external property with the given
	 * getter implementation.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @return			The newly created read-only external property.
	 */
	public static ExternalProperty<Integer> readOnlyIntegerProperty(IGetter<Integer> getter) {
		return new ExternalIntegerProperty(getter, readOnly());
	}
	
	/**
	 * Creates a new external property with the given getter and
	 * setter implementations.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 * @return			The newly created external property.
	 */
	public static ExternalProperty<Integer> createIntegerProperty(IGetter<Integer> getter, ISetter<Integer> setter) {
		return new ExternalIntegerProperty(getter, setter);
	}
	
	/**
	 * Creates a new internal property with a default property
	 * value (as specified by Java standard).
	 * 
	 * @return	The newly created internal property.
	 */
	public static InternalProperty<Integer> createIntegerProperty() {
		return new InternalIntegerProperty();
	}
	
	/**
	 * Creates a new internal property with the given value
	 * argument.
	 * 
	 * @param value	The initial value for this property.
	 * @return		The newly created internal property.
	 */
	public static InternalProperty<Integer> createIntegerProperty(int value) {
		return new InternalIntegerProperty(value);
	}
	
	/**
	 * Creates a new read-only external property with the given
	 * getter implementation.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @return			The newly created read-only external property.
	 */
	public static ExternalProperty<Long> readOnlyLongProperty(IGetter<Long> getter) {
		return new ExternalLongProperty(getter, readOnly());
	}
	
	/**
	 * Creates a new external property with the given getter and
	 * setter implementations.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 * @return			The newly created external property.
	 */
	public static ExternalProperty<Long> createLongProperty(IGetter<Long> getter, ISetter<Long> setter) {
		return new ExternalLongProperty(getter, setter);
	}
	
	/**
	 * Creates a new internal property with a default property
	 * value (as specified by Java standard).
	 * 
	 * @return	The newly created internal property.
	 */
	public static InternalProperty<Long> createLongProperty() {
		return new InternalLongProperty();
	}
	
	/**
	 * Creates a new internal property with the given value
	 * argument.
	 * 
	 * @param value	The initial value for this property.
	 * @return		The newly created internal property.
	 */
	public static InternalProperty<Long> createLongProperty(long value) {
		return new InternalLongProperty(value);
	}
	
	/**
	 * Creates a new read-only external property with the given
	 * getter implementation.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @return			The newly created read-only external property.
	 */
	public static ExternalProperty<Float> readOnlyFloatProperty(IGetter<Float> getter) {
		return new ExternalFloatProperty(getter, readOnly());
	}
	
	/**
	 * Creates a new external property with the given getter and
	 * setter implementations.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 * @return			The newly created external property.
	 */
	public static ExternalProperty<Float> createFloatProperty(IGetter<Float> getter, ISetter<Float> setter) {
		return new ExternalFloatProperty(getter, setter);
	}
	
	/**
	 * Creates a new internal property with a default property
	 * value (as specified by Java standard).
	 * 
	 * @return	The newly created internal property.
	 */
	public static InternalProperty<Float> createFloatProperty() {
		return new InternalFloatProperty();
	}
	
	/**
	 * Creates a new internal property with the given value
	 * argument.
	 * 
	 * @param value	The initial value for this property.
	 * @return		The newly created internal property.
	 */
	public static InternalProperty<Float> createFloatProperty(float value) {
		return new InternalFloatProperty(value);
	}
	
	/**
	 * Creates a new read-only external property with the given
	 * getter implementation.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @return			The newly created read-only external property.
	 */
	public static ExternalProperty<Double> readOnlyDoubleProperty(IGetter<Double> getter) {
		return new ExternalDoubleProperty(getter, readOnly());
	}
	
	/**
	 * Creates a new external property with the given getter and
	 * setter implementations.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 * @return			The newly created external property.
	 */
	public static ExternalProperty<Double> createDoubleProperty(IGetter<Double> getter, ISetter<Double> setter) {
		return new ExternalDoubleProperty(getter, setter);
	}
	
	/**
	 * Creates a new internal property with a default property
	 * value (as specified by Java standard).
	 * 
	 * @return	The newly created internal property.
	 */
	public static InternalProperty<Double> createDoubleProperty() {
		return new InternalDoubleProperty();
	}
	
	/**
	 * Creates a new internal property with the given value
	 * argument.
	 * 
	 * @param value	The initial value for this property.
	 * @return		The newly created internal property.
	 */
	public static InternalProperty<Double> createDoubleProperty(double value) {
		return new InternalDoubleProperty(value);
	}
	
	/**
	 * Creates a new read-only external property with the given
	 * getter implementation.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @return			The newly created read-only external property.
	 */
	public static ExternalProperty<String> readOnlyStringProperty(IGetter<String> getter) {
		return new ExternalStringProperty(getter, readOnly());
	}
	
	/**
	 * Creates a new external property with the given getter and
	 * setter implementations.
	 * 
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 * @return			The newly created external property.
	 */
	public static ExternalProperty<String> createStringProperty(IGetter<String> getter, ISetter<String> setter) {
		return new ExternalStringProperty(getter, setter);
	}
	
	/**
	 * Creates a new internal property with a default property
	 * value (as specified by Java standard).
	 * 
	 * @return	The newly created internal property.
	 */
	public static InternalProperty<String> createStringProperty() {
		return new InternalStringProperty();
	}
	
	/**
	 * Creates a new internal property with the given value
	 * argument.
	 * 
	 * @param value	The initial value for this property.
	 * @return		The newly created internal property.
	 */
	public static InternalProperty<String> createStringProperty(String value) {
		return new InternalStringProperty(value);
	}
	
	/**
	 * Creates a new read-only external property with the given
	 * getter implementation.
	 * 
	 * @param type		The default class type for this generic property.
	 * @param getter	The getter implementation for this property.
	 * @return			The newly created read-only external property.
	 */
	public static <T> ExternalProperty<T> readOnlyProperty(Class<T> type, IGetter<T> getter) {
		return new GenericExternalProperty<T>(type, getter, readOnly());
	}
	
	/**
	 * Creates a new external property with the given getter and
	 * setter implementations.
	 * 
	 * @param type		The default class type for this generic property.
	 * @param getter	The getter implementation for this property.
	 * @param setter	The setter implementation for this property.
	 * @return			The newly created external property.
	 */
	public static <T> ExternalProperty<T> createProperty(Class<T> type, IGetter<T> getter, ISetter<T> setter) {
		return new GenericExternalProperty<T>(type, getter, setter);
	}
	
	/**
	 * Creates a new internal property with a default property
	 * value (as specified by Java standard).
	 * 
	 * @param type	The default class type for this generic property.
	 * @return		The newly created internal property.
	 */
	public static <T> InternalProperty<T> createProperty(Class<T> type) {
		return new GenericInternalProperty<T>(type);
	}
	
	/**
	 * Creates a new internal property with the given value
	 * argument.
	 * 
	 * @param type	The default class type for this generic property.
	 * @param value	The initial value for this property.
	 * @return		The newly created internal property.
	 */
	public static <T> InternalProperty<T> createProperty(Class<T> type, T value) {
		return new GenericInternalProperty<T>(type, value);
	}
	
	/**
	 * A simple inverse-boolean property class that shares the
	 * memory bank as a pre-existing boolean property. It will
	 * always return the inverse of the boolean property.
	 * 
	 * @author Max D
	 */
	private static final class InverseBooleanProperty implements Property<Boolean> {
		
		private static final long serialVersionUID = -5841889151474649082L;
		
		/**
		 * The boolean property upon which the inverse property is based.
		 */
		private final Property<Boolean> property;
		
		/**
		 * Creates a new inverse boolean property given the pre-existing
		 * boolean property.
		 * 
		 * @param property	The property upon which the invserse is based.
		 */
		private InverseBooleanProperty(Property<Boolean> property) {
			this.property = property;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void addListener(ChangeListener<Boolean> listener) {
			property.addListener(listener);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void removeListener(ChangeListener<Boolean> listener) {
			property.removeListener(listener);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Collection<ChangeListener<Boolean>> getListeners() {
			return property.getListeners();
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void addEventListener(EventListener listener) {
			property.addEventListener(listener);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void removeEventListener(EventListener listener) {
			property.removeEventListener(listener);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Collection<EventListener> getEventListeners() {
			return property.getEventListeners();
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: For the inverse implementation, this returns the inverse
		 * of the boolean property.
		 */
		@Override
		public Boolean get() {
			return !property.get();
		}
		
		/**
		 * {@inheritDoc}
		 * <p>
		 * NOTE: For the inverse implementation, this sets the boolean property
		 * to the inverse of the provided value.
		 */
		@Override
		public void set(Boolean value) {
			property.set(!value);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void bind(Property<Boolean> property, BindingOrder order) {
			this.property.bind(property, order);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void unbind(Property<Boolean> property) {
			this.property.unbind(property);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void update() {
			property.update();
		}
		
	}
	
	/**
	 * Returns an inverse form of this boolean property.
	 * <p>
	 * It shares the same memory bank and can therefore be used
	 * in the same way, but the get and set methods will always
	 * invert the property value.
	 * 
	 * @param property	The property to create an inverse of.
	 * @return			The inverse form of the property.
	 */
	public static Property<Boolean> asInverse(Property<Boolean> property) {
		return new InverseBooleanProperty(property);
	}
	
	/**
	 * Returns a read-only setter implementation that throws an
	 * <a href="#{@link}">{@link UnsupportedOperationException}</a>.
	 * 
	 * @param <T>	The type of setter to create.
	 * @return		The newly created setter implementation.
	 */
	private static <T> ISetter<T> readOnly() {
		return s -> {
			throw new UnsupportedOperationException("set");
		};
	}
	
}
