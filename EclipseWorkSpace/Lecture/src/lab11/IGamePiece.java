package lab11;
import tester.*;
// NOTE: Templates and purpose statements left out: You should fill them in yourself!
interface IGamePiece {
  int getValue();
}
class BaseTile implements IGamePiece {
  int value;
  BaseTile(int value) { this.value = value; }
  public int getValue() { return this.value; }
}
class MergeTile implements IGamePiece {
  IGamePiece piece1, piece2;
  MergeTile(IGamePiece piece1, IGamePiece piece2) {
    this.piece1 = piece1;
    this.piece2 = piece2;
  }
  public int getValue() {
    return this.piece1.getValue() + this.piece2.getValue() + this.getValue();
  }
}
 
class ExamplesGamePiece {
  IGamePiece four = new MergeTile(new BaseTile(2), new BaseTile(2));
  boolean testGetValue(Tester t) {
    return t.checkExpect(four.getValue(), 4);
  }
}