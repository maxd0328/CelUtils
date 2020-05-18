package celutils.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * An <a href="#{@link}">{@link HashMap}</a> implementation
 * of the <a href="#{@link}">{@link ObservableMap}</a> class.
 * 
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * 
 * @author Max D
 */
public class ObservableHashMap<K, V> extends ObservableMap<K, V> {
	
	private static final long serialVersionUID = 5419087079050176440L;
	
	/**
	 * The map used by this observable map.
	 */
	private final HashMap<K, V> map;
	
	/**
	 * Creates a new ObservableHashMap given the map
	 * argument.
	 * 
	 * @param map	The map to create this map from.
	 */
	private ObservableHashMap(HashMap<K, V> map) {
		super(map);
		this.map = map;
	}
	
	/**
	 * Creates a new empty ObservableHashMap.
	 */
	public ObservableHashMap() {
		this(new HashMap<K, V>());
	}
	
	/**
	 * Creates a new ObservableHashMap given the map
	 * argument.
	 * 
	 * @param map	The map to create this map from.
	 */
	public ObservableHashMap(Map<? extends K, ? extends V> m) {
		this(new HashMap<K, V>(m));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Map<K, V> getMap() {
		return map;
	}
	
}
