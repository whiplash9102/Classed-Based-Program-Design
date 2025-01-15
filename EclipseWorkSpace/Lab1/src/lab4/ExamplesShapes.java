package lab4;

import tester.*;

public class ExamplesShapes {
  CartPt pt1 = new CartPt(0, 0);
  CartPt pt2 = new CartPt(3, 4);
  CartPt pt3 = new CartPt(7, 1);
 
  IShape c1 = new Circle(new CartPt(50, 50), 10, "red");
  IShape c2 = new Circle(new CartPt(50, 50), 30, "red");
  IShape c3 = new Circle(new CartPt(30, 100), 30, "blue");
 
  IShape s1 = new Square(new CartPt(50, 50), 30, "red");
  IShape s2 = new Square(new CartPt(50, 50), 50, "red");

	// Test the method area in the classes that implement IShape
	boolean testIShapeArea(Tester t) {
		return t.checkInexact(this.c1.area(), 314.15, 0.01)
				&& t.checkInexact(this.s1.area(), 900.0, 0.01);
	}

	boolean testCircleGrow(Tester t) {
		return t.checkExpect(this.c1.grow(20), this.c2);
	}
}
