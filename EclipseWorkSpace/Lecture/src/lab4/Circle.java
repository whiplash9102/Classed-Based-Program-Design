package lab4;
public class Circle implements IShape {
	CartPt center;
	int radius;
	String color;
	
	Circle(CartPt center ,int radius, String color){
		this.center = center;
		this.radius = radius;
		this.color = color;
	}
	// calculate the area of the circle
	public double area() {
		return Math.PI * this.radius * this.radius;
	}
	//distance from the origin
	public double distanceToOrigin() {
		return this.center.distanceToOrigin() - this.radius;
	}
	// increase the size of circle with given radius
	public IShape grow(int inc) {
		// create new circle with an increase radius
		return new Circle(this.center, this.radius + inc, this.color);
	}
	
	public boolean isBiggerThan(IShape that) {
		return this.area() > that.area();
	}
	
	public boolean contains(CartPt point) {
		double distance = Math.sqrt(Math.pow(point.x - this.center.x, 2) + Math.pow(point.y - this.center.y, 2));
    return distance <= this.radius;
	}

}
