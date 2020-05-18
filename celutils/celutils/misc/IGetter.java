package celutils.misc;

/**
 * A generic interface describing a getter that can return
 * any type of data.
 * <p>
 * The implementation is used for external properties when
 * 3rd-party data is contained outside of an accessible reach
 * and only contains a getter or setter.
 * 
 * @param <T>	The type of data that will be returned.
 * 
 * @author Max D
 */
public interface IGetter<T> extends java.io.Serializable {
	
	/**
	 * Returns the data accessed by this getter implementation.
	 * 
	 * @return	This getter's data.
	 */
	public T get();
	
}
