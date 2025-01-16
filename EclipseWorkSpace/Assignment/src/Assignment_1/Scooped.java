package Assignment_1;

public class Scooped implements IceCream{
	private IceCream more; 
	private String flavor;
	
	//Constructor
	public Scooped(IceCream more, String flavor) {
		this.more = more;
		this.flavor = flavor;
	}
	
	//Getters
	public IceCream getMore() {
		return more;
	}
	
	public String getFlavor() {
		return flavor;
	}
}
