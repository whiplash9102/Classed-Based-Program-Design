
public interface ITetrisPiece {

}

abstract class ATetrisPiece implements ITetrisPiece {
	int xPos;
	int yPos;
	
	ATetrisPiece(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	ATetrisPiece(int x){
		this(x, 30);
	}
}

class Square extends ATetrisPiece {
	int topLeftX;
	int topLeftY;
	
	Square(int topLeftX, int topLeftY){
		super(topLeftX, topLeftY);
}
	Square(int topLeftX){
		super(topLeftX);
	}
}

class ExamplesTetris {
	ITetrisPiece square1 = new Square(3);
	ITetrisPiece square2 = new Square(3, 20);
}
