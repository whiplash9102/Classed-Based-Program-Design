package lab5;

public class ConsLoBook implements ILoBook {
	Book first;
	ILoBook rest;
	
	ConsLoBook(Book first, ILoBook rest){
		this.first = first;
		this.rest = rest;
	}
	
	public ILoBook sortByPrice() {
		//Sort the rest of the list
		ILoBook sortedRest = this.rest.sortByPrice();
		//Insert the first book into the sorted rest
		return sortedRest.insertByPrice(this.first);
	}
	
	 // Helper method to insert a book into a sorted list
  public ILoBook insertByPrice(Book book) {
      if (this.first.price <= book.price) {
          return new ConsLoBook(this.first, this.rest.insertByPrice(book));
      } else {
          return new ConsLoBook(book, this);
      }
  } 
  
  // Count the number of the book in the list
  public int count() {
  	return 1 + this.rest.count();
  } 
  
  //Print the list of the book that  publish before year
  public ILoBook allBefore(int year) {
  	if (this.first.year < year) {
  		return new ConsLoBook(this.first, this.rest.allBefore(year));
  	}
  	else {
  		return this.rest.allBefore(year);
  	}
  }
  
  public ILoBook sortByTitle() {
  	ILoBook sortedRest = this.rest.sortByTitle();
  	return sortedRest.insertByTitle(this.first);
  }
  
  public ILoBook insertByTitle(Book book) {
  	if (this.first.titleBefore(book)) {
  		return new ConsLoBook(this.first, this.rest.insertByTitle(book));
  	} else {
  		return new ConsLoBook(book, this);
  	}
  }
  
	@Override
	public double salePrice(int discount) {
		// TODO Auto-generated method stub
		return this.first.salePrice(discount) + this.rest.salePrice(discount);
	}
}