package Assignment_1;

public class Horse extends Transportation{
	String name;
	String color;
	
	public Horse(Housing from, Housing to, String name, String color) {
		super(from, to);
		this.name = name;
		this.color = color;
	}
	
}
