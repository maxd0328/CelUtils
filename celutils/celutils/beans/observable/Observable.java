package celutils.beans.observable;

import java.util.Collection;

/**
 * This interface defines a foundation for observable values.
 * Observable values are ones that can measure and generate
 * a response any time its host undergoes a change that results
 * in a satisfied precondition.
 * <p>
 * Observable values have support for event listeners, along with
 * change listeners. These features give observable values the
 * ability to be respond to certain stimulus, such as an appropriate
 * change of value.
 * 
 * @param <T>	The type of data that will be observed.
 * 
 * @author Max D
 */
public interface Observable<T> extends java.io.Serializable {
	
	/**
	 * Adds a <a href="#{@link}">{@link ChangeListener}</a> to this
	 * observable value. The listener event will be executed every
	 * time this value undergoes a change from a previous state.
	 * 
	 * @param listener	The change listener to be added.
	 */
	public void addListener(ChangeListener<T> listener);
	
	/**
	 * Removes a pre-existing <a href="#{@link}">{@link ChangeListener}</a>
	 * from this value's list of change listeners. That listener will no
	 * longer be able to measure and detect changes in this observable
	 * value.
	 * 
	 * @param listener	The change listener to be removed.
	 */
	public void removeListener(ChangeListener<T> listener);
	
	/**
	 * Returns the list of all change listeners attached to this
	 * observable value.
	 * 
	 * @return	This value's list of change listeners.
	 */
	public Collection<ChangeListener<T>> getListeners();
	
	/**
	 * Adds an <a href="#{@link}">{@link EventListener}</a> to this
	 * observable value. This listener will then be executed under
	 * this value any time that its underlying condition is met.
	 * 
	 * @param listener	The event listener to be added.
	 */
	public void addEventListener(EventListener listener);
	
	/**
	 * Removes a pre-existing <a href="#{@link}">{@link EventListener}</a>
	 * from this value's list of event listeners. That listener will no
	 * longer be executed under the protected of this observable value.
	 * 
	 * @param listener	The event listener to be removed.
	 */
	public void removeEventListener(EventListener listener);
	
	/**
	 * Returns the list of all event listeners currently attached
	 * to this observable value.
	 * 
	 * @return	This value's list of event listeners.
	 */
	public Collection<EventListener> getEventListeners();
	
	/**
	 * Updates this observable value.
	 * <p>
	 * This will perform all measurements by change listeners and
	 * event listeners and is the time at which any events attached
	 * to these listeners will be executed.
	 */
	public void update();
	
	/**
	 * A simple null-safe wrapper for the <a href="#{@link}">{@link Object
	 * #equals(Object)}</a> check. If either parameter is null, then the
	 * value returned is equal to {@code a == b}. As long as both parameters
	 * are non-null, then the value returned is equal to {@code a.equals(b)}.
	 * 
	 * @param a	The first operand to compare.
	 * @param b	The second operand to compare.
	 * @return	Whether or not these operands are equal.
	 */
	public default boolean equals(Object a, Object b) {
		if(a == null) return b == null;
		if(b == null) return a == null;
		return a.equals(b);
	}
	
}
