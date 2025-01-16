package Assignment_1;

public class EmptyServing implements IceCream {
	private boolean cone;
	
	public EmptyServing(boolean cone) {
		this.cone = cone;
	}
	
	//Getter
	public boolean isCone() {
		return cone;
	}
}
