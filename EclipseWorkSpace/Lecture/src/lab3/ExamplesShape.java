package lab3;
import tester.*;

public class ExamplesShape {
  // Instance of the shape to test
  IShape c1 = new Circle(50, 50, 10, "red");

  // Test method for area
  boolean testIShapeArea(Tester t) {
      return t.checkInexact(c1.area(), 314.15, 0.01);
  }

  // Main method
  public static void main(String[] args) {
      ExamplesShape examples = new ExamplesShape();
      Tester.runReport(examples, false, false);
  }
}