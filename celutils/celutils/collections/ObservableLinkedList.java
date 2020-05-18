package celutils.collections;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * An <a href="#{@link}">{@link LinkedList}</a> implementation
 * of the <a href="#{@link}">{@link ObservableList}</a> class.
 * 
 * @param <E> the type of elements in this list
 * 
 * @author Max D
 */
public class ObservableLinkedList<E> extends ObservableList<E> {
	
	private static final long serialVersionUID = -8930766429167415188L;
	
	/**
	 * The list used by this observable list.
	 */
	private final LinkedList<E> list;
	
	/**
	 * Creates a new ObservableLinkedList given the list
	 * argument.
	 * 
	 * @param list	The list to create this list from.
	 */
	private ObservableLinkedList(LinkedList<E> list) {
		super(list);
		this.list = list;
	}
	
	/**
	 * Creates a new empty ObservableLinkedList.
	 */
	public ObservableLinkedList() {
		this(new LinkedList<E>());
	}
	
	/**
	 * Creates a new ObservableLinkedList given the list
	 * argument.
	 * 
	 * @param list	The list to create this list from.
	 */
	public ObservableLinkedList(Collection<? extends E> c) {
		this(new LinkedList<E>(c));
	}
	
	/**
	 * Creates a new ObservableLinkedList given the vararg
	 * argument.
	 * 
	 * @param list	The vararg array to create this list from.
	 */
	@SafeVarargs
	public ObservableLinkedList(E... c) {
		this(new LinkedList<E>(Arrays.asList(c)));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<E> getList() {
		return list;
	}
	
}
