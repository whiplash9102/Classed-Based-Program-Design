package lab1;

public class Address {
	String city;
	String state;
	
	//Constructor
	public Address(String city, String state) {
		this.city = city;
		this.state = state;
	}
	
	//Override toString method for Address
	@Override
	public String toString() {
		return city + ", " + state;
		
	}
}
