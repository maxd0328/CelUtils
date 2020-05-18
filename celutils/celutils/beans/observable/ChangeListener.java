package celutils.beans.observable;

/**
 * This interface defines a response to a change in an observable
 * value detected since a previous update. Change listeners are
 * used in the <a href="#{@link}">{@link Observable}</a> interface.
 * <p>
 * Typically, these listeners are checked and evaluated on a regular
 * update sequence on either the CelUtils management thread, or
 * manually on a separate thread.
 * 
 * @param <T>	The type specified by the observable value
 * 
 * @see Observable
 * @author Max D
 */
public interface ChangeListener<T> extends java.io.Serializable {
	
	/**
	 * Called once during any given update sequence when it is
	 * confirmed that the observable value containing this change
	 * listener has undergone a change of value since the last
	 * update.
	 * <p>
	 * A change of value for any object that implements the
	 * <a href="#{@link}">{@link Observable}</a> interface is
	 * defined by {@link Object#equals(Object)}, between the old
	 * and new values. In the event that one of those values is
	 * null, a simple {@code old == new} check is done instead.
	 * 
	 * @param observable	The object implementing <a href="#{@link}">
	 * 						{@link Observable}</a> that has changed
	 * @param _old			The old value of the observable object
	 * @param _new			The new value of the observable object
	 */
	public void changed(Observable<T> observable, T _old, T _new);
	
}
