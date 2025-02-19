package lab5;


public class ConsLoBook implements ILoBook {
	Book first;
	ILoBook rest;

	// Constructor
	ConsLoBook(Book first, ILoBook rest) {
		this.first = first;
		this.rest = rest;
	}

	@Override
	public int count() {
		// Count the number of books in the list
		return 1 + this.rest.count();
	}

	@Override
	public ILoBook allBefore(int year) {
		// TODO Auto-generated method stub
		if (this.first.publishedBefore(year)) {
			return new ConsLoBook(this.first, this.rest.allBefore(year));
		}
		else {
			return this.rest.allBefore(year);
		}
	}

	@Override
	public double salePrice(int discount) {
		// TODO Auto-generated method stub
		return this.first.salePrice(discount) + this.rest.salePrice(discount);
	}

	@Override
	public ILoBook sortByPrice() {
		return this.rest.sortByPrice().insert(this.first);
	}
// 25, 10, 60, 50
	// (10, 60, 50) 25 (
	// ((60, 50) 10
	// ((50) 60 insert 50,60
	// () 50
	
	
	public ILoBook insert(Book b) {
		if (this.first.cheaperThan(b)) {
			return new ConsLoBook(this.first, this.rest.insert(b));
		}
		else {
			return new ConsLoBook(b, this);
		}
	}

	public ILoBook sortByString() {
		return this.rest.sortByString().insertString(this.first);
	}

	public ILoBook insertString(Book b) {
		if (this.first.titleBefore(b)) {
			return new ConsLoBook(this.first, this.rest.sortByString());
		}
		else {
			return new ConsLoBook(b, this);
		}
	}
}
