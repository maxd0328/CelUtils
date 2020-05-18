package celutils.misc;

/**
 * A functional interface that describes any event that
 * could take place.
 * <p>
 * This class is used throughout the CelUtils library
 * to implement events of any kind.
 * <p>
 * The event itself takes in a vararg array of objects,
 * making it extremely easy to pass any number of varying
 * arguments to the event when it is performed.
 * 
 * @author Max D
 */
public interface Event extends java.io.Serializable {
	
	/**
	 * This method is called whenever an event is performed.
	 * <p>
	 * It takes in a varying number of {@code Object} arguments,
	 * allowing it to accept nearly any type of data.
	 * 
	 * @param o	Any number of varying arguments that could get
	 * 			passed to the event.
	 */
	public void perform(Object... o);
	
}
