package celutils.beans.observable;

import java.util.Collection;

/**
 * The standard abstract implementation of the <a href="#{@link}">
 * {@link Observable}</a> interface.
 * <p>
 * Any class that implements that interface can instead extend this class,
 * and implement the abstract methods. That will provide the class with a
 * baseline implementation for all observable operations.
 * 
 * @param <E>	The type of data that will be observed.
 * 
 * @author Max D
 */
public abstract class ObservableImpl<E> implements Observable<E> {
	
	private static final long serialVersionUID = -2652347626160703842L;
	
	/**
	 * The list of change listeners attached to this observable value.
	 */
	private final Collection<ChangeListener<E>> listeners;
	
	/**
	 * The list of event listeners attached to this observable value.
	 */
	private final Collection<EventListener> eventListeners;
	
	/**
	 * Last known value of this object's host. Used for detecting changes.
	 */
	private E lastValue;
	
	/**
	 * Creates a new implementation of the observable interface.
	 * <p>
	 * It requires to pre-instantiated collections that it will use to
	 * store the change listeners and event listeners. It also needs an
	 * initial value to store so that instantiation is not registered as
	 * an effective change of value.
	 * 
	 * @param listeners			The instantiated list of change listeners for this observable value.
	 * @param eventListeners	The instantiated list of event listeners for this observable value.
	 * @param initialValue		The initial value to avoid unnecessary execution of change listeners.
	 */
	protected ObservableImpl(Collection<ChangeListener<E>> listeners, Collection<EventListener> eventListeners, E initialValue) {
		this.listeners = listeners;
		this.eventListeners = eventListeners;
		this.lastValue = initialValue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addListener(ChangeListener<E> listener) {
		listeners.add(listener);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeListener(ChangeListener<E> listener) {
		listeners.remove(listener);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<ChangeListener<E>> getListeners() {
		return listeners;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addEventListener(EventListener listener) {
		eventListeners.add(listener);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeEventListener(EventListener listener) {
		eventListeners.remove(listener);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<EventListener> getEventListeners() {
		return eventListeners;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update() {
		E value = getValue();
		
		if(!equals(value, lastValue)) {
			
			for(ChangeListener<E> listener : getListeners())
				listener.changed(this, lastValue, value);
			
		}
		
		lastValue = value;
	}
	
	/**
	 * Returns the effective value of this observable value. Used for
	 * detecting changes for the change listener.
	 * 
	 * @return	The effect value of this observable value.
	 */
	protected abstract E getValue();
	
}
