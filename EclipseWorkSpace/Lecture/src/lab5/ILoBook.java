package lab5;



public interface ILoBook {
	// count the book in the list
	int count();
	
	// produce the list of all book published before the given date
	ILoBook allBefore(int year);
	
	// calculate the total sale price of all books in this list for a given discount
	double salePrice(int discount);
	
	// produce a list of all books in the list, sorted by the price
	ILoBook sortByPrice();
	
	// insert the given book into this list of books 
	// already sorted by price
	ILoBook insert(Book b);

	ILoBook sortByString();
	
	ILoBook insertString(Book b);
}
