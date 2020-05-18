package celutils.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import celutils.beans.observable.ObservableImpl;

/**
 * A simple implementation of the Map interface which wraps
 * another map inside of an observable implementation.
 * <p>
 * This map can be observed with listeners similar to any
 * other observable value.
 * 
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * 
 * @see Map
 * @author Max D
 */
public abstract class ObservableMap<K, V> extends ObservableImpl<Map<K, V>> implements Map<K, V> {
	
	private static final long serialVersionUID = -1859581557738586787L;
	
	/**
	 * Creates a new observable map with an initial
	 * official map value.
	 * 
	 * @param initialMap	The official map that serves as the initial value.
	 */
	protected ObservableMap(Map<K, V> initialMap) {
		super(new ObservableArrayList<>(), new ObservableArrayList<>(), initialMap);
	}
	
	/**
	 * Returns the official map that is to be wrapped by this
	 * observable implementation.
	 * 
	 * @return	The official map used by this observable implementation.
	 * @see Map
	 */
	protected abstract Map<K, V> getMap(); 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return getMap().size();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return getMap().isEmpty();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsKey(Object key) {
		return getMap().containsKey(key);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsValue(Object value) {
		return getMap().containsValue(value);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public V get(Object key) {
		return getMap().get(key);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public V put(K key, V value) {
		return getMap().put(key, value);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public V remove(Object key) {
		return getMap().remove(key);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		getMap().putAll(m);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		getMap().clear();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<K> keySet() {
		return getMap().keySet();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<V> values() {
		return getMap().values();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Entry<K, V>> entrySet() {
		return getMap().entrySet();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Map<K, V> getValue() {
		return getMap();
	}
	
}
