package Assignment_1;

public class Inn extends Housing{
	String name;
	int stalls;
	
	public Inn(String name, int capacity, int population, int stalls) {
		super(capacity, population);
		this.name = name;
		this.stalls = stalls;
	}
}
