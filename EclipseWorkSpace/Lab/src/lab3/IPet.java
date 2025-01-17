package lab3;

import tester.Tester;

public interface IPet {
	boolean hasName(String name);
}

class Person{
	String name;
	IPet pet;
	int age;
	
	Person(String name, IPet pet, int age){
		this.name = name;
		this.pet = pet;
		this.age = age;
	}
	
	boolean isOlder(Person other) {
		return this.age >= other.age;
	}
	
	boolean sameNamePet(String name) {
		return this.pet.hasName(name);
	}
	
	Person perish() {
		return new Person(this.name, new NoPet(), this.age);
	}
}

class NoPet implements IPet{
	public boolean hasName(String name) {
		// TODO Auto-generated method stub
		return false;
	}
}


class Cat implements IPet {
	String name;
	String kind;
	boolean longhaired;
	
	Cat(String name, String kind, boolean longhaired){
		this.name = name;
		this.kind = kind;
		this.longhaired = longhaired;
	}
	public boolean hasName(String name) {
		return this.name.equals(name);
	}
}

class Dog implements IPet {
	String name;
	String kind;
	boolean male;
	
	Dog(String name, String kind, boolean male){
		this.name = name;
		this.kind = kind;
		this.male = male;
	}
	
	public boolean hasName(String name) {
		return this.name.equals(name);	
		}
}

class ExamplesPerson {
  IPet whiskers = new Cat("Whiskers", "Tabby", true); // Lingered cat
  IPet mittens = new Cat("Mittens", "Siamese", false); // Short hair cat
  IPet rover = new Dog("Rover", "Golden Retriever", true); // Male dog
  IPet bella = new Dog("Bella", "Labrador", false); // Female dog
  IPet noPet = new NoPet();

  // Person examples
  Person alice = new Person("Alice", whiskers, 25);
  Person bob = new Person("Bob", mittens, 30);
  Person charlie = new Person("Charlie", rover, 20);
  Person diana = new Person("Diana", bella, 35);
  Person eve = new Person("Eve", noPet, 40);
  
  boolean testerIsOlder(Tester t) {
  	return t.checkExpect(charlie.isOlder(alice), false);
  }
  boolean testerHasName(Tester t) {
  	return t.checkExpect(alice.sameNamePet("Whiskers"), true);
  }
  boolean testPerish(Tester t) {
  	Person aliceNoPet = alice.perish();
  	return t.checkExpect(aliceNoPet.pet instanceof NoPet, true);
  }
}
