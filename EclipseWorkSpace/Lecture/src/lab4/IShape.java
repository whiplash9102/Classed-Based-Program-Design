package lab4;


public interface IShape {
	
	//Compute the area of a shape
	double area();
	
	//Compute the distance to origin
	double distanceToOrigin();
	
	//increase the size of the shape by given increment
	IShape grow(int inc);
	
	//is the area of this shape bigger than the area of the given shape?
	boolean isBiggerThan(IShape that);
	
	boolean contains(CartPt point); 	
	
	//
}
