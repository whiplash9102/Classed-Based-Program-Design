package Assignment_1;

public class Hut extends Housing {
	public String name;
	
	//Constructor
	public Hut(String name, int capacity, int population) {
		super(capacity, population);
		this.name = name;
	}
	
	public Hut(int capacity, int population) {
		super(capacity, population);
		this.name ="";
	}
}										
