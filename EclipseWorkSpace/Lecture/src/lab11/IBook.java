package lab11;

public interface IBook {

}

class Book implements IBook {
	String title;
	String author;
	Book(String title, String author){
		this.title = title;
		this.author = author;
	}
	boolean sameBook(Book other) {
		if (this.title.equals(other.title) && this.author.equals(other.author)) {
			return true;
		} else {
			return false;
		}
	}
}