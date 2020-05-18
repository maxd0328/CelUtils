package celutils.beans.observable;

import celutils.beans.property.Properties;
import celutils.beans.property.Property;
import celutils.misc.Event;

/**
 * A container class that contains methods to instantiate
 * event listeners based on certain preconditions. This is
 * the primary class used to create event listeners, as the
 * <a href="#{@link}">{@link EventListener}</a> constructor
 * has package-level visibility.
 * 
 * @see EventListener
 * @author Max D
 */
public final class Events {
	
	/**
	 * Returns a new <a href="#{@link}">{@link EventListener}</a>
	 * that is based on a given precondition, specified by the
	 * condition argument.
	 * 
	 * @param condition	The condition upon which the event listener is based.
	 * @return			The newly created event listener.
	 */
	public static EventListener when(Property<Boolean> condition) {
		return new EventListener().when(condition);
	}
	
	/**
	 * Returns a new <a href="#{@link}">{@link EventListener}</a>
	 * that is based on an automatic precondition that is always
	 * set to true.
	 * 
	 * @return	The newly create event listener with an always-true precondition.
	 */
	public static EventListener ifTrue() {
		return new EventListener().when(Properties.createBooleanProperty(true));
	}
	
	/**
	 * Returns a new <a href="#{@link}">{@link EventListener}</a>
	 * that is based on an automatic precondition that is always
	 * set to false.
	 * 
	 * @return	The newly create event listener with an always-false precondition.
	 */
	public static EventListener ifFalse() {
		return new EventListener().when(Properties.createBooleanProperty(false));
	}
	
	/**
	 * Returns a new <a href="#{@link}">{@link EventListener}</a>
	 * that is based on any given precondition.
	 * <p>
	 * It is set to have a given <i>when-true</i> event, that has a
	 * continuity of <a href="#{@link}">{@link Continuity#ONCE}</a>,
	 * meaning that it will only execute when the precondition is
	 * changed.
	 * 
	 * @param precondition	The precondition upon which the event is based.
	 * @param event			The event that will be executed on any given change.
	 * @return				The newly created event listener.
	 */
	public static EventListener onChange(Property<Boolean> precondition, Event event) {
		return when(precondition).then(event, Continuity.ONCE).otherwise(event, Continuity.ONCE);
	}
	
	/**
	 * Returns a new <a href="#{@link}">{@link EventListener}</a>
	 * that is based on an automatic <i>always-true</i> precondition.
	 * <p>
	 * The given event will always be executed as long as this event
	 * listener continues to exist.
	 * 
	 * @param event	The event to continuously execute.
	 * @return		The newly created event listener.
	 */
	public static EventListener always(Event event) {
		return ifTrue().then(event, Continuity.ALWAYS);
	}
	
	/**
	 * Returns a new <a href="#{@link}">{@link EventListener}</a>
	 * that is based on an automatic <i>always-false</i> precondition.
	 * <p>
	 * The given event will never be executed, and is primarily used
	 * as a gateway for always-false conditions.
	 * 
	 * @param event	The gateway event that will never be executed.
	 * @return		The newly created event listener.
	 */
	public static EventListener never(Event event) {
		return ifFalse().then(event, Continuity.ALWAYS);
	}
	
}
