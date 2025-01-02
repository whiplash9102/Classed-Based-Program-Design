package lab1;

public class Person {
	String name;
	int age;
	String gender;
  Address address;
	
	//Constructor
	public Person(String name, int age, String gender, Address address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	public String toString() {
		return "Name: " + this.name + " - " + "Age: " + this.age + " - " + "Gender: " + this.gender;
	}
	
}
