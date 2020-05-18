package celutils.beans.property;

/**
 * A package-level class that represents a binding between
 * two properties.
 * <p>
 * It manages the binding of these two properties and ensures
 * that their values are always the same at all times. This
 * is done through a regular binding update.
 * 
 * @param <T>	The property type of the two bound properties.
 * 
 * @author Max D
 */
public final class Binding<T> implements java.io.Serializable {
	
	private static final long serialVersionUID = -3727508078202590800L;
	
	/**
	 * The previous values of each bound property. Used for detecting value changes.
	 */
	private T rootOld;
	private T guestOld;
	
	/**
	 * Both bound properties. The root property is the one that owns the property
	 * binding. See <a href="#{@link}">{@link Property#bind(Property, BindingOrder)}</a>.
	 * The guest property is the alternate property that has been attached to the
	 * binding.
	 */
	private final Property<T> root;
	private final Property<T> guest;
	
	/**
	 * The binding order for this binding. It defines which properties take precedence
	 * in the binding.
	 */
	private final BindingOrder order;
	
	/**
	 * Package-level constructor.
	 * <p>
	 * Creates a new binding given the root property, guest property, and its associated
	 * binding order.
	 * 
	 * @param root	The root property to attach to this binding.
	 * @param guest	The guest property to attach to this binding.
	 * @param order	The binding order to associate with this binding.
	 */
	Binding(Property<T> root, Property<T> guest, BindingOrder order) {
		if(order == null) throw new NullPointerException("order");
		this.root = root;
		this.guest = guest;
		this.order = order;
		
		sync();
		rootOld = root.get();
		guestOld = guest.get();
	}
	
	/**
	 * Returns the root property of this binding. The root property is typically the
	 * property that owns this binding.
	 * 
	 * @return	The root property of this binding.
	 */
	public Property<T> getRoot() {
		return root;
	}
	
	/**
	 * Returns the guest property of this binding. The guest property is typically the
	 * disconnected property that is bound to the root property.
	 * 
	 * @return	The guest property of this binding.
	 */
	public Property<T> getGuest() {
		return guest;
	}
	
	/**
	 * Returns the binding order associated with this binding.
	 * 
	 * @return	The binding order associated with this binding.
	 */
	public BindingOrder getOrder() {
		return order;
	}
	
	/**
	 * Updates this binding.
	 * <p>
	 * During a binding update, changes in both properties are determined
	 * and if any changes have occurred, then both bindings are set to be equal
	 * with a precedence determined by the binding order. If no changes have
	 * occurred, then a property synchronization occurs. During property
	 * synchronization, if the properties are not equal, then the property
	 * without precedence according to the binding order is set to the value
	 * of the property with precedence.
	 */
	public void update() {
		T rootNew = root.get();
		T guestNew = guest.get();
		
		switch(order) {
		case BIDIRECTIONAL_DOMINANT:
			if(!root.equals(rootOld, rootNew) && !root.equals(guestNew, rootNew)) {
				guest.set(rootNew);
				guestNew = rootNew;
			}
			else if(!root.equals(guestOld, guestNew) && !root.equals(guestNew, rootNew)) {
				root.set(guestNew);
				rootNew = guestNew;
			}
			break;
		case BIDIRECTIONAL_RECESSIVE:
			if(!root.equals(guestOld, guestNew) && !root.equals(guestNew, rootNew)) {
				root.set(guestNew);
				rootNew = guestNew;
			}
			else if(!root.equals(rootOld, rootNew) && !root.equals(guestNew, rootNew)) {
				guest.set(rootNew);
				guestNew = rootNew;
			}
			break;
		case DOMINANT:
		case RECESSIVE:
		default:
			break;
		}
		
		sync();
		rootOld = rootNew;
		guestOld = guestNew;
	}
	
	/**
	 * This method performs property synchronization.
	 * <p>
	 * During synchronization, the property without precedence according to the
	 * binding order is set to the value of the property with precedence if they
	 * are not already equal.
	 */
	private void sync() {
		if(root.equals(root.get(), guest.get())) return;
		if(order == BindingOrder.DOMINANT || order == BindingOrder.BIDIRECTIONAL_DOMINANT) {
			guest.set(root.get());
		}
		else {
			root.set(guest.get());
		}
	}
	
}
