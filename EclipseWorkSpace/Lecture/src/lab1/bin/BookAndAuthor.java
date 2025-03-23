package lab1.bin;
class Author {
    String first;
    String last;
    int yob;
    IList<Book> Books;

    Author(String fst, String lst, int yob, IList<Book> Books) {
        this.first = fst;  
        this.last = lst;
        this.yob = yob;
        this.Books = new MtList<Book>(); // Initialize properly
    }

    void addBook(Book b) {
        if (!this.equals(b.author)) {  
            throw new RuntimeException("This book does not belong to this author");
        } else if (this.Books.contain(b)) { // Fixed method name
            throw new RuntimeException("This book already exists in the library");
        } else {
            this.Books = new ConsList<Book>(b, this.Books);
        }
    }
}


 
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
      this.author.addBook(this);
  }
}
