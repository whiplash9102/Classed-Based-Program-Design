package lab16;
import tester.Tester;
// Represents authors of books
class Author {
  String first;
  String last;
  int yob;
  Book book;
  Author(String fst, String lst, int yob, Book bk) {
    this.first = fst;
    this.last = lst;
    this.yob = yob;
    this.book = bk;
  }
}
 
// Represent books
class Book {
  String title;
  int price;
  int quantity;
  Author author;
  Book(String title, int price, int quantity, Author ath) {
    this.title = title;
    this.price = price;
    this.quantity = quantity;
    this.author = ath;
  }
}
  

// Presenting the data set above Donald E. Knuth.  The Art of Computer Programming (volume 1). Addison Wesley, Reading, Massachusetts.  1968.
class ExampleBookAuthor {
	boolean testMutation(Tester t) {
		Book b1 = new Book("the cheap shape", 20, 1, null);
		Author a1 = new Author("Haruki", "Murakami", 1968, b1);
		b1.author = a1;
		
		return t.checkExpect(b1.author, a1);
	}
}

