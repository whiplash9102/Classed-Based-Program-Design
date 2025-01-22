package Assignment_2;
import tester.*;

public interface IPicture {
	int getWidth();
	int countShapes();
	int comboDepth();
}

class Shape implements IPicture {
	String kind;
	int size;
	
	Shape(String kind, int size){
		this.kind = kind;
		this.size = size;
	}

	@Override
	public int getWidth() {
		// Get the width of the shapes 
		return this.size;
	}

	@Override
	public int countShapes() {
		// TODO Count the shapes
		return 1;
	}

	@Override
	public int comboDepth() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Combo implements IPicture {
	String picturename;
	String description;
	IPicture picture1;
	IPicture picture2;
	
	Combo(String picturename, String description, IPicture picture1, IPicture picture2){
		this.description = description;
		this.picturename = picturename;
		this.picture1 = picture1;
		this.picture2 = picture2;
	}
	@Override
	public int getWidth() {
	    switch (this.description) {
	        case "scale":
	            return 2 * this.picture1.getWidth();
	        case "beside":
	            return this.picture1.getWidth() + this.picture2.getWidth();
	        case "overlay":
	            return Math.max(this.picture1.getWidth(), this.picture2.getWidth());
	        default:
	            throw new IllegalArgumentException("Unknown operation: " + this.description);
	    }
	}
	@Override
	public int countShapes() {
		// TODO Auto-generated method stub
		int pic1Shapes = this.picture1.countShapes();
		int pic2Shapes = this.picture2.countShapes();
		return pic1Shapes + pic2Shapes;
	}
	@Override
	public int comboDepth() {
		// TODO Auto-generated method stub
		if (this.description.equals("scale")) {
			return 1 + this.picture1.comboDepth();
		} else {
			return 1 + Math.max(
					this.picture1.comboDepth(),
					this.picture2.comboDepth());
		}
	}

}

class ExamplesPicture {
	// Class examples for the picture
	IPicture circle = new Shape("circle", 20);
	IPicture square = new Shape("square", 30);
	
	IPicture circleBig = new Combo("big circle", "scale", circle, null);
	IPicture squareCircle = new Combo("square on circle", "overlay", circle, square);
	IPicture doubleSquareOnCircle = new Combo("square overlay circle", "beside", squareCircle, squareCircle);
	IPicture tripleSquareOnCircle = new Combo("squares overlay circle", "beside", doubleSquareOnCircle, squareCircle);
	boolean testGetWidth(Tester t) {
		return t.checkExpect(circle.getWidth(), 20) &&
				t.checkExpect(circleBig.getWidth(), 40);
	}
	boolean testCountShape(Tester t) {
		return t.checkExpect(doubleSquareOnCircle.countShapes(), 4) &&
				t.checkExpect(tripleSquareOnCircle.countShapes(), 6);
	}
	boolean testerComboDepth(Tester t) {
		return t.checkExpect(tripleSquareOnCircle.comboDepth(), 3) &&
				t.checkExpect(doubleSquareOnCircle.comboDepth(), 3);
	}
}