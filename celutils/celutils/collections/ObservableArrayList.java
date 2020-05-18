package celutils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * An <a href="#{@link}">{@link ArrayList}</a> implementation
 * of the <a href="#{@link}">{@link ObservableList}</a> class.
 * 
 * @param <E> the type of elements in this list
 * 
 * @author Max D
 */
public class ObservableArrayList<E> extends ObservableList<E> {
	
	private static final long serialVersionUID = -8365516987538696282L;
	
	/**
	 * The list used by this observable list.
	 */
	private final ArrayList<E> list;
	
	/**
	 * Creates a new ObservableArrayList given the list
	 * argument.
	 * 
	 * @param list	The list to create this list from.
	 */
	private ObservableArrayList(ArrayList<E> list) {
		super(list);
		this.list = list;
	}
	
	/**
	 * Creates a new empty ObservableArrayList.
	 */
	public ObservableArrayList() {
		this(new ArrayList<E>());
	}
	
	/**
	 * Creates a new ObservableArrayList given the list
	 * argument.
	 * 
	 * @param list	The list to create this list from.
	 */
	public ObservableArrayList(Collection<? extends E> c) {
		this(new ArrayList<E>(c));
	}
	
	/**
	 * Creates a new ObservableArrayList given the vararg
	 * argument.
	 * 
	 * @param list	The vararg array to create this list from.
	 */
	@SafeVarargs
	public ObservableArrayList(E... c) {
		this(new ArrayList<E>(Arrays.asList(c)));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<E> getList() {
		return list;
	}
	
}
