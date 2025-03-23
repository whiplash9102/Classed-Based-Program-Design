package lab16;

interface IFunction<A, R> {
	R apply (A  first);
}

//another interface
interface IVisitorShape<R>{
	R visitCircle(Circle circle);
	R visitRect(Rect rect);
}

class VisitorShape implements IVisitorShape<Double>, IFunction <IShape, Double> {

	@Override
	public Double visitCircle(Circle circle) {
		// TODO Auto-generated method stub
		return Math.PI * circle.radius * circle.radius;
	}

	@Override
	public Double visitRect(Rect rect) {
		// TODO Auto-generated method stub
		return rect.w * rect.h * 1.0;
	}
	
	@Override
	public Double apply(IShape shape) {
		// TODO Auto-generated method stub
		return shape.accept(this);
	}
	
}
class VisitorString implements IVisitorShape<String>, IFunction <IShape, String> {

	@Override
	public String apply(IShape first) {
		// TODO Auto-generated method stub
		return first.accept(this);
	}

	@Override
	public String visitCircle(Circle circle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitRect(Rect rect) {
		// TODO Auto-generated method stub
		return null;
	}
	
}