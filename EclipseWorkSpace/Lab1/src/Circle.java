public class Circle implements IShape {
	int x; //Represent the center of the circle
	int y;
	int radius;
	String color;
	
	Circle(int x, int y, int radius, String color){
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}
	// calculate the area of the circle
	public double area() {
		return Math.PI * this.radius * this.radius;
	}
	//distance from the origin
	public double distanceToOrigin() {
		return Math.sqrt(this.x * this.x + this.y* this.y) - this.radius;
	}
	// increase the size of circle with given radius
	public IShape grow(int inc) {
		// create new circle with an increase radius
		return new Circle(this.x, this.y, this.radius + inc, this.color);
	}
	
	public boolean isBiggerThan(IShape that) {
		return this.area() > that.area();
	}

}