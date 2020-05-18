package demos.celutil;

import celutils.beans.property.Properties;
import celutils.beans.property.Property;

public class PropertyDemo {
	
	private static int someExternalValue = 23; // For external properties
	
	public static void main(String[] args) {
		
		// Internal Properties
		
		Property<Integer> myProperty = Properties.createIntegerProperty();
		myProperty.set(0); // Setting property
		int value = myProperty.get(); // Getting property
		
		Property<Float> myOtherProperty = Properties.createFloatProperty(value);
		myOtherProperty.set(10f);
		
		// External Properties
		
		Property<Integer> myExternalProperty = Properties.createIntegerProperty(() -> someExternalValue, s -> someExternalValue = s); // Getter and setter
		System.out.println(myExternalProperty.get()); // Should be 23
		
		myExternalProperty.set(50);
		System.out.println(myExternalProperty.get()); // Should be 50
		System.out.println(someExternalValue); // Should also be 50
		
		Property<Integer> testProperty = Properties.createIntegerProperty();
		testProperty.bind(myExternalProperty); // Should always have the same value as myExternalProperty now
		
		System.out.println(testProperty.get()); // Should be 50
		myExternalProperty.set(70);
		testProperty.update(); // Update binding with myExternalProperty
		System.out.println(testProperty.get()); // Should be 70
		
		// Adding change listeners
		
		myProperty.addListener((obs, _old, _new) -> System.out.println("My property changed! Old value is " + _old + " and new value is " + _new));
		// Should do that every time myProperty changes
		
		myProperty.set(20);
		myProperty.update(); // Update and run change listener because it just changed
							 // Should execute change listener
		
	}
	
}
