package celutils.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * An <a href="#{@link}">{@link Vector}</a> implementation
 * of the <a href="#{@link}">{@link ObservableList}</a> class.
 * 
 * @param <E> the type of elements in this list
 * 
 * @author Max D
 */
public class ObservableVectorList<E> extends ObservableList<E> {
	
	private static final long serialVersionUID = -3449968700927151503L;
	
	/**
	 * The list used by this observable list.
	 */
	private final Vector<E> list;
	
	/**
	 * Creates a new ObservableVectorList given the list
	 * argument.
	 * 
	 * @param list	The list to create this list from.
	 */
	private ObservableVectorList(Vector<E> list) {
		super(list);
		this.list = list;
	}
	
	/**
	 * Creates a new empty ObservableVectorList.
	 */
	public ObservableVectorList() {
		this(new Vector<E>());
	}
	
	/**
	 * Creates a new ObservableVectorList given the list
	 * argument.
	 * 
	 * @param list	The list to create this list from.
	 */
	public ObservableVectorList(Collection<? extends E> c) {
		this(new Vector<E>(c));
	}
	
	/**
	 * Creates a new ObservableVectorList given the vararg
	 * argument.
	 * 
	 * @param list	The vararg array to create this list from.
	 */
	@SafeVarargs
	public ObservableVectorList(E... c) {
		this(new Vector<E>(Arrays.asList(c)));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<E> getList() {
		return list;
	}
	
}
