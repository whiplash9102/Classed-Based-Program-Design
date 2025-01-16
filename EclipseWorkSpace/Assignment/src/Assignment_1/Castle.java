package Assignment_1;

public class Castle extends Housing {
	String name;
	String familyName;
	public int carriageCapacity;
	
	public Castle(String name, String familyName, int population, int carriageCapacity) {
		super(0, population);
		this.name = name;
		this.familyName = familyName;
		this.carriageCapacity = carriageCapacity;
	}
}
