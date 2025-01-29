package lab3;

import tester.*;

public interface IGamePiece {

	int getValue();
	IGamePiece merge(IGamePiece other);
	boolean isValid();
}

class baseTile implements IGamePiece {
	int number;
	
	baseTile(int number){
		this.number = number;
	}
	public int getValue() {
		return this.number;
	}
	@Override
	public IGamePiece merge(IGamePiece other) {
		// DONE merge the two piece together 
		return new mergeTile(this, other);
	}
	@Override
	public boolean isValid() {
		// DONE check if the mergeTile is valid or not;
		return true;
	}
}

class mergeTile implements IGamePiece {
	IGamePiece piece1;
	IGamePiece piece2;
	
	mergeTile(IGamePiece piece1, IGamePiece piece2){
		this.piece1 = piece1;
		this.piece2 = piece2;
	}
	public int getValue() {
		return this.piece1.getValue() + this.piece2.getValue();
	}
	@Override
	public IGamePiece merge(IGamePiece other) {
		// TODO Auto-generated method stub
		return new mergeTile(this, other);
	}
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return piece1.getValue() == piece2.getValue() && piece1.isValid() && piece2.isValid();
	}
}

class ExamplesGames {
	IGamePiece game1 = new baseTile(2);
	IGamePiece game2 = new baseTile(4);
	
	IGamePiece mergeTile1 = new mergeTile(game1, game2);
	
	boolean testGetValue(Tester t) {
		return t.checkExpect(mergeTile1.getValue(), 6) && 
				t.checkExpect(game1.getValue(), 2);
	}
	
	boolean testMergeTile(Tester t) {
		return t.checkExpect(mergeTile1.merge(game1), 
				new mergeTile(new mergeTile (new baseTile(2), new baseTile(4)),new baseTile(2)));
	}
	
	boolean testValid(Tester t) {
		return t.checkExpect(mergeTile1.isValid(),false) &&
				t.checkExpect(new mergeTile(new baseTile(2), new baseTile(2)).isValid(), true);
	}
}

