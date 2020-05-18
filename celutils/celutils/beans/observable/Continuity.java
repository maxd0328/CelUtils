package celutils.beans.observable;

/**
 * An enumeration describing the continuity of an event. It
 * controls how often an event is re-performed given that the
 * conditions are correct.
 * <p>
 * For example, an event can be set to be performed once after
 * a given condition has become true, or to be performed at a
 * constant rate, given that a condition is true.
 * 
 * @see EventListener
 * @author Max D
 */
public enum Continuity {
	
	/**
	 * Indicates that this event should never be executed. While
	 * this has little practical purpose, it is commonly used to
	 * instantate null-events with a {@code NONE} continuity to
	 * ensure that the null-event is never executed, thus avoiding
	 * a {@code NullPointerException}.
	 */
	NONE,
	
	/**
	 * Indicates that this event should be performed once and only
	 * once when its underlying precondition has undergone a change
	 * that results in its value being set to true. The event will
	 * be re-performed every time this positive change occurs.
	 */
	ONCE,
	
	/**
	 * Indicates that this event should always be performed as long
	 * as its underlying precondition is true. The rate at which the
	 * event is performed can vary, however, as a true update routine
	 * is never officially defined, and is usually up to the programmer
	 * to decide.
	 */
	ALWAYS;
	
}
