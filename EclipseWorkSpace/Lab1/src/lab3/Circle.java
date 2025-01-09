package lab3;

public class Circle implements IShape{
	int x;
	int y;
	int radius;
  String color;
 
  Circle(int x, int y, int radius, String color) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.color = color;
  }
  public double area() {
    return Math.PI * this.radius * this.radius;
  }
  
  public double distanceToOrigin() {
  	return Math.sqrt(this.x * this.x + this.y * this.y) - this.radius;
  }
}
