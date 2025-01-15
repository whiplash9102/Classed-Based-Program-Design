package lab5;


public class Book {
	String title;
	String author;
	double price;
	int year;
	
	Book(String title, String author, int year, double price){
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
	}
	
	double salePrice(int discount) {
		return this.price * (1 - discount/100.0);
	}
	
	boolean titleBefore(Book that) {
		return this.title.compareTo(that.title) < 0;
	}
	
	boolean publishedBefore(int year) {
		return this.year < year;
	}

	public boolean cheaperThan(Book b) {
		return this.price < b.price;
	}

}
