package lab2;

public class Salad implements IMenuItem {
	String name;
	int price;
	boolean isVegetarian;
	
	//Constructor
	public Salad(String name, int price, boolean isVegetarian) {
		this.name = name;
		this.price = price;
		this.isVegetarian = isVegetarian;
		}
	
	//Get the name of the salad
	public String getName() {
		return this.name;
	}
	
	//Get the price of the salad
	public int getPrice() {
		return this.price;
	}
	
}
