package celutils.misc;

/**
 * This interface describes a setter for any variable
 * that could exist anywhere in memory.
 * <p>
 * It is designed to access 3rd-party data that is not
 * accessible and only contains a setter. It is often
 * used for external properties.
 * 
 * @param <T>	The type of data that will be set by
 * 				this setter.
 * 
 * @author Max D
 */
public interface ISetter<T> extends java.io.Serializable {
	
	/**
	 * Sets the value accessed by this setter implementation.
	 * 
	 * @param value	The new value of this setter's data.
	 */
	public void set(T value);
	
}
