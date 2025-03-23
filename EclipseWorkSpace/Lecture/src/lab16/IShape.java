package lab16;


public interface IShape{
	<R> R accept(IVisitorShape<R> shape);
}

class Circle implements IShape {
	int x,y;
	int radius;
	String color;
	Circle (int x, int y, int radius , String color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}
	@Override
	public <R> R accept(IVisitorShape<R> shape) {
		return shape.visitCircle(this);
	}
}

class Rect implements IShape {
	int x, y, w, h;
	String color;
	Rect (int x, int y, int w, int h, String color){
		this.color = color;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public <R> R accept(IVisitorShape<R> shape) {
		return shape.visitRect(this);
	}
}

class IShapeExamples {
	IShapeExamples() {}
	
	IList<IShape> shapes = new ConsList<IShape> (new Circle(0, 0, 10, "red"),
												 new ConsList<IShape> (new Rect(0, 0, 10, 10, "blue"), new MtList<IShape>()));
	
	IList<Double> expected = new ConsList<Double>(314.15,
													 new ConsList<Double>(100.0, new MtList<Double>()));
	
	
	
}
