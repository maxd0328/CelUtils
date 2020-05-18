package celutils.beans.observable;

import celutils.beans.property.Property;
import celutils.misc.Event;

/**
 * A class defining a given precondition, and two possible
 * outcomes of that condition. The precondition is represented
 * as a boolean property: <a href="#{@link}">{@link Property}</a>.
 * <p>
 * Each outcome is specified by the <a href="#{@link}">{@link
 * Event}</a> interface accompanied by a <a href="#{@link}">
 * {@link Continuity}</a> value describing how often to perform
 * the event if the underlying precondition is true.
 * 
 * @see Event
 * @see Continuity
 * @author Max D
 */
public final class EventListener implements java.io.Serializable {
	
	private static final long serialVersionUID = 4820269319572005544L;
	
	/**
	 * The precondition upon which the events responses are based.
	 */
	private Property<Boolean> condition;
	
	/*
	 * The event and its corresponding continuity that is to be
	 * performed when the precondition is true.
	 */
	private Event whenTrue;
	private Continuity continuity0;
	
	/**
	 * The event and its corresponding continuity that is to be
	 * performed when the precondition is false.
	 */
	private Event whenFalse;
	private Continuity continuity1;
	
	/**
	 * Package-visible constructor
	 */
	EventListener() {
	}
	
	/**
	 * Binds the value of the precondition to the value of the
	 * argument and returns this <a href="#{@link}">{@link
	 * EventListener}</a>. Note that if the precondition is null,
	 * no event will ever be executed.
	 * 
	 * @param condition	The precondition to bind to this listener
	 * @return			This <a href="#{@link}">{@link EventListener}</a>
	 */
	public EventListener when(Property<Boolean> condition) {
		this.condition = condition;
		return this;
	}
	
	/**
	 * Binds this event to the <i>when-true</i> value of this
	 * event's precondition. It will be performed when the condition
	 * is true according to its continuity.
	 * 
	 * @param event			The event to be performed when the precondition is true
	 * @param continuity	The continuity value of the corresponding event
	 * @return				This <a href="#{@link}">{@link EventListener}</a>
	 */
	public EventListener then(Event event, Continuity continuity) {
		this.whenTrue = event;
		this.continuity0 = continuity;
		return this;
	}
	
	/**
	 * Binds this event to the <i>when-false</i> value of this
	 * event's precondition, It will be performed when the condition
	 * is false according to its continuity.
	 * 
	 * @param event			The event to be performed when the precondition is false
	 * @param continuity	The continuity value of the corresponding event
	 * @return				This <a href="#{@link}">{@link EventListener}</a>
	 */
	public EventListener otherwise(Event event, Continuity continuity) {
		this.whenFalse = event;
		this.continuity1 = continuity;
		return this;
	}
	
	/**
	 * Returns the property value of this event's precondition.
	 * 
	 * @return	This event's precondition
	 */
	public Property<Boolean> getCondition() {
		return condition;
	}
	
	/**
	 * Returns either of the two events attached to this listener.
	 * The event returned is the when-true event or when-false event,
	 * given that the condition parameter is true or false, respectively.
	 * 
	 * @param condition	Which event to be returned by this method
	 * @return			The corresponding <a href="#{@link}">{@link Event}</a>
	 */
	public Event getEvent(boolean condition) {
		if(condition)
			return whenTrue;
		else
			return whenFalse;
	}
	
	/**
	 * Returns either of the two continuity values that are attached to
	 * each event of this listener. The continuity returned is the when-true
	 * continuity or when-false continuity, given that the condition parameter
	 * is true or false, respectively.
	 * 
	 * @param condition	Which event to be returned by this method
	 * @return			The corresponding <a href="#{@link}">{@link Event}</a>
	 */
	public Continuity getContinuity(boolean condition) {
		if(condition)
			return continuity0;
		else
			return continuity1;
	}
	
	/**
	 * Executes this event listener, therefore performing either the when-true
	 * or when-false event, given the current state of the precondition. Note
	 * that if the precondition is null, no event will ever be executed.
	 * <p>
	 * If the call to this method is a continuous call, an event will only be
	 * executed if the event's corresponding continuity value is set to <a
	 * href="#{@link}">{@link Continuity#ALWAYS}</a>.
	 * 
	 * @param continuous
	 */
	public void execute(boolean continuous) {
		if(condition == null) return;
		
		if(condition.get()) {
			if(!continuous && continuity0 == Continuity.ONCE)
				whenTrue.perform(this);
			else if(continuous && continuity0 == Continuity.ALWAYS)
				whenTrue.perform(this);
		}
		else {
			if(!continuous && continuity1 == Continuity.ONCE)
				whenFalse.perform(this);
			else if(continuous && continuity1 == Continuity.ALWAYS)
				whenFalse.perform(this);
		}
	}
	
}
