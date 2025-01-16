package Assignment_1;

public class Carriage extends Transportation {
	int tonnageLimit;
	
	//Constructor
	public Carriage(Housing from, Housing to, int tonnageLimit) {
		super(from, to);
		this.tonnageLimit = tonnageLimit;
	}
}
