

import tester.*;

public class ExamplesShapes {
		IShape c1 = new Circle(50, 50, 10, "red");
		IShape s1 = new Square(50, 50, 30, "red");
		
		// Test the method area in the classes that implement IShape
		boolean testIShapeArea(Tester t) {
			return t.checkInexact(this.c1.area(), 314.15, 0.01) && t.checkInexact(this.s1.area(), 900.0, 0.01);
		}
}