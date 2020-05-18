package celutils.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An <a href="#{@link}">{@link LinkedHashMap}</a> implementation
 * of the <a href="#{@link}">{@link ObservableMap}</a> class.
 * 
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * 
 * @author Max D
 */
public class ObservableLinkedHashMap<K, V> extends ObservableMap<K, V> {
	
	private static final long serialVersionUID = -7190605471962698510L;
	
	/**
	 * The map used by this observable map.
	 */
	private final LinkedHashMap<K, V> map;
	
	/**
	 * Creates a new ObservableLinkedHashMap given the map
	 * argument.
	 * 
	 * @param map	The map to create this map from.
	 */
	private ObservableLinkedHashMap(LinkedHashMap<K, V> map) {
		super(map);
		this.map = map;
	}
	
	/**
	 * Creates a new empty ObservableLinkedHashMap.
	 */
	public ObservableLinkedHashMap() {
		this(new LinkedHashMap<K, V>());
	}
	
	/**
	 * Creates a new ObservableLinkedHashMap given the map
	 * argument.
	 * 
	 * @param map	The map to create this map from.
	 */
	public ObservableLinkedHashMap(Map<? extends K, ? extends V> m) {
		this(new LinkedHashMap<K, V>(m));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Map<K, V> getMap() {
		return map;
	}
	
}
