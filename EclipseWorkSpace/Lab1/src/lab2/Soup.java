package lab2;

public class Soup implements IMenuItem{
	String name;
	int price;
	boolean isVegetarian;
	
	//Constructor
	public Soup(String name, int price, boolean isVegetarian) {
		this.name = name;
		this.price = price;
		this.isVegetarian = isVegetarian;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public String toString() {
		return "Soup: " + name + ", Price: " + price + "cents, Vegetarian: " + isVegetarian;
	}
}
