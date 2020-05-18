package celutils.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * An <a href="#{@link}">{@link TreeMap}</a> implementation
 * of the <a href="#{@link}">{@link ObservableMap}</a> class.
 * 
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * 
 * @author Max D
 */
public class ObservableTreeMap<K, V> extends ObservableMap<K, V> {
	
	private static final long serialVersionUID = -1915228526272213541L;
	
	/**
	 * The map used by this observable map.
	 */
	private final TreeMap<K, V> map;
	
	/**
	 * Creates a new ObservableTreeMap given the map
	 * argument.
	 * 
	 * @param map	The map to create this map from.
	 */
	private ObservableTreeMap(TreeMap<K, V> map) {
		super(map);
		this.map = map;
	}
	
	/**
	 * Creates a new empty ObservableTreeMap.
	 */
	public ObservableTreeMap() {
		this(new TreeMap<K, V>());
	}
	
	/**
	 * Creates a new ObservableTreeMap given the map
	 * argument.
	 * 
	 * @param map	The map to create this map from.
	 */
	public ObservableTreeMap(Map<? extends K, ? extends V> m) {
		this(new TreeMap<K, V>(m));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Map<K, V> getMap() {
		return map;
	}
	
}
