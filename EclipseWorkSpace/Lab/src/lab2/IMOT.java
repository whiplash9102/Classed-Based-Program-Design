package lab2;

import tester.*;

public interface IMOT {
	boolean isMoreFuelEfficientThan(int mpg);
}

class Car implements IMOT {
	String make;
	int mpg;
	
	// constructor
	Car(String make, int mpg){
		this.make = make;
		this.mpg = mpg;
	}
	
	public boolean isMoreFuelEfficientThan(int mpg) {
		return this.mpg < mpg;
	}
}

class Bicycle implements IMOT {
	String brand;
	
	// constructor 
	Bicycle(String brand){
		this.brand = brand;
	}

	@Override
	public boolean isMoreFuelEfficientThan(int mpg) {
		// TODO Auto-generated method stub
		return true;
	}
}

class Person {
	String name;
	IMOT mot;
	
	Person(String name, IMOT mot){
		this.name = name;
		this.mot = mot;
	}
	
	boolean motMeetsFuelEfficiency(int mpg) {
		return this.mot.isMoreFuelEfficientThan(mpg);
	}
}

class ExamplesPerson {
	IMOT diamondback = new Bicycle("Diamonback");
	IMOT toyota = new Car("Toyota", 30);
  IMOT lamborghini = new Car("Lamborghini", 17);
 
  Person bob = new Person("Bob", diamondback);
  Person ben = new Person("Ben", toyota);
  Person becca = new Person("Becca", lamborghini);
  
  boolean testIsFuelEfficient(Tester t) {
  	return t.checkExpect(bob.motMeetsFuelEfficiency(15), true) &&
  			t.checkExpect(ben.motMeetsFuelEfficiency(15),false ) &&
  			t.checkExpect(becca.motMeetsFuelEfficiency(15), false);
  }
}
