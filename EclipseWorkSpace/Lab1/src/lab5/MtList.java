package lab5;


public class MtList implements ILoBook{

	@Override
	public int count() {
		// count the number of books in the list
		return 0;
	}

	@Override
	public ILoBook allBefore(int year) {
		return this;
	}

	@Override
	public double salePrice(int discount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ILoBook sortByPrice() {
		// TODO Auto-generated method stub
		return this;
	}
	
	public ILoBook insert(Book b) {
		return new ConsLoBook(b, this);
	}

	@Override
	public ILoBook sortByString() {
		// TODO Auto-generated method stub
		return this; 
	}
	public ILoBook insertString(Book b) {
		return new ConsLoBook(b, this);
	}

}
