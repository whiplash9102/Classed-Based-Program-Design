package lab4;


public class Square implements IShape {
	CartPt topLeft;
	int size;
	String color;
	
	Square(CartPt topLeft, int size, String color) {
		this.topLeft = topLeft;
		this.size = size;
		this.color = color;
	}
	
	
	@Override
	public double area() {
		// Calculate the area of the square
		return this.size * this.size;
	}

	@Override
	public double distanceToOrigin() {
		// TODO Auto-generated method stub
		return this.topLeft.distanceToOrigin();
				// Calculate the area of the square
	}

	@Override
	public IShape grow(int inc) {
		// Return a new square with an increased size
		return new Circle(this.topLeft, this.size + inc, this.color);
	}

	@Override
	public boolean isBiggerThan(IShape that) {
		// Compare the areas of the two shapes
		return this.area() > that.area();
	}
	
	@Override
	public boolean contains(CartPt point) {
	    return point.x >= this.topLeft.x &&
	           point.x <= (this.topLeft.x + this.size) &&
	           point.y >= this.topLeft.y &&
	           point.y <= (this.topLeft.y + this.size);
	}


}
