package lab9;
public interface IInteger {
	
	// LIstOfInteger -> boolean
	//Check if the list is even
	boolean isEven();
	
	// ListOfInteger -> boolean
	// check if the list is positive and odd
	boolean isPotiveOdd();
	
	// ListOfInteger -> boolean
	// check if the list have all the number between 5 and 10
	boolean isBetweenRange();
}

class MtList implements IInteger {

	@Override
	public boolean isEven() {
		// TODO Auto-generated method
		return true;
	}

	@Override
	public boolean isPotiveOdd() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isBetweenRange() {
		// TODO Auto-generated method stub
		return true;
	}
	
}

class ListOfIntegers implements IInteger{
	int first;
	IInteger rest;
	
	ListOfIntegers(int first, IInteger rest){
		this.first = first;
		this.rest = rest;
	}

	@Override
	public boolean isEven() {
		// TODO Auto-generated method stub
		return first  % 2 ==0 && rest.isEven();
	}

	@Override
	public boolean isPotiveOdd() {
		// TODO Auto-generated method stub
		return (this.first % 2 != 0 && this.first > 0) && this.rest.isPotiveOdd();
	}

	@Override
	public boolean isBetweenRange() {
		// TODO Auto-generated method stub
		return (5 <= this.first && this.first <= 10) && this.rest.isBetweenRange();
	}
}
