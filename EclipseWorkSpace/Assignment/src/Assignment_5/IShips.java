package Assignment_5;

public interface IShips {

}

class MtLoShip implements IShips {
	
}

class ConsLoShip implements IShips {
	Ship first; 
	IShips rest;
	
	ConsLoShip(Ship first, IShips rest){
		this.first = first;
		this.rest = rest;
	}
}
