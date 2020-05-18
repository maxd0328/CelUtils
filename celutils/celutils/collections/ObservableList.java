package celutils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import celutils.beans.observable.ChangeListener;
import celutils.beans.observable.EventListener;
import celutils.beans.observable.ObservableImpl;

/**
 * A simple implementation of the List interface which wraps
 * another list type inside of an observable implementation.
 * <p>
 * This list can be observed with listeners similar to any
 * other observable value.
 * 
 * @param <E> the type of elements in this list
 * 
 * @see List
 * @author Max D
 */
public abstract class ObservableList<E> extends ObservableImpl<List<E>> implements List<E> {
	
	private static final long serialVersionUID = 3550282726273645892L;
	
	/**
	 * Creates a new observable list with an initial
	 * official list value.
	 * 
	 * @param initialList	The official list that serves as the initial value.
	 */
	protected ObservableList(List<E> initialList) {
		super(new ArrayList<ChangeListener<List<E>>>(), new ArrayList<EventListener>(), initialList);
	}
	

	/**
	 * Returns the official list that is to be wrapped by this
	 * observable implementation.
	 * 
	 * @return	The official list used by this observable implementation.
	 * @see List
	 */
	protected abstract List<E> getList();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return getList().size();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return getList().isEmpty();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(Object o) {
		return getList().contains(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() {
		return getList().iterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() {
		return getList().toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return getList().toArray(a);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(E e) {
		return getList().add(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Object o) {
		return getList().remove(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return getList().containsAll(c);
	}
	
	/**
	 * A vararg adaptation of the <a href="#{@link}">
	 * {@link List#containsAll(Collection)}</a> method.
	 * 
	 * @param c	The vararg collection of objects
	 * @return	{@code true} if this list contains all of the elements of the
     * 			specified collection
	 */
	public boolean containsAll(@SuppressWarnings("unchecked") E... c) {
		return containsAll(Arrays.asList(c));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		return getList().addAll(c);
	}
	
	/**
	 * A vararg adaptation of the <a href="#{@link}">
	 * {@link List#addAll(Collection)}</a> method.
	 * 
	 * @param c	The vararg collection of objects
	 * @return	{@code true} if this list changed as a result of the call
	 */
	public boolean addAll(@SuppressWarnings("unchecked") E... c) {
		return addAll(Arrays.asList(c));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return getList().addAll(index, c);
	}
	
	/**
	 * A vararg adaptation of the <a href="#{@link}">
	 * {@link List#addAll(int, Collection)}</a> method.
	 * 
	 * @param c	The vararg collection of objects
	 * @return	{@code true} if this list changed as a result of the call
	 */
	public boolean addAll(int index, @SuppressWarnings("unchecked") E... c) {
		return addAll(index, Arrays.asList(c));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return getList().removeAll(c);
	}
	
	/**
	 * A vararg adaptation of the <a href="#{@link}">
	 * {@link List#removeAll(int, Collection)}</a> method.
	 * 
	 * @param c	The vararg collection of objects
	 * @return	{@code true} if this list changed as a result of the call
	 */
	public boolean removeAll(@SuppressWarnings("unchecked") E... c) {
		return removeAll(Arrays.asList(c));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return getList().retainAll(c);
	}
	
	/**
	 * A vararg adaptation of the <a href="#{@link}">
	 * {@link List#retainAll(int, Collection)}</a> method.
	 * 
	 * @param c	The vararg collection of objects
	 * @return	{@code true} if this list changed as a result of the call
	 */
	public boolean retainAll(@SuppressWarnings("unchecked") E... c) {
		return retainAll(Arrays.asList(c));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		getList().clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E get(int index) {
		return getList().get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E set(int index, E element) {
		return getList().set(index, element);
	}
	
	/**
	 * Sets this list to be equivalent to the given
	 * list.
	 * 
	 * @param c	The list to set equal to.
	 */
	public void set(Collection<? extends E> c) {
		clear();
		addAll(c);
	}
	
	/**
	 * A vararg adaptation of the <a href="#{@link}">
	 * {@link ObservableList#set(Collection)}</a> method.
	 * 
	 * @param c	The vararg collection of objects.
	 */
	public void set(@SuppressWarnings("unchecked") E... c) {
		clear();
		addAll(c);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(int index, E element) {
		getList().add(index, element);
	}
	
	/**
	 * @see ObservableList#add(int, E)
	 * 
	 * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
	 */
	public void insert(int index, E element) {
		add(index, element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E remove(int index) {
		return getList().remove(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int indexOf(Object o) {
		return getList().indexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int lastIndexOf(Object o) {
		return getList().lastIndexOf(o);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<E> listIterator() {
		return getList().listIterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		return getList().listIterator(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return getList().subList(fromIndex, toIndex);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<E> getValue() {
		return getList();
	}
	
}
