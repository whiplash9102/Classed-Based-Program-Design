package Assignment_1;

public class ExamplesIceCream {
	// Order 1: Cup with scoops
	IceCream order1 = new Scooped(
			new Scooped(new Scooped(new Scooped(new EmptyServing(false), "mint chip"), "coffee"),
					"black raspberry"),
			"caramel swirl");
	
}