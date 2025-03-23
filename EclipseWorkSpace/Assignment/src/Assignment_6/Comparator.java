package Assignment_6;

interface Comparator<T> { 
	int compare(T t1, T t2);
}

class BooksByTitle implements Comparator<Book> {

	@Override
	public int compare(Book t1, Book t2) {
		// TODO Auto-generated method stub
		return t1.title.compareTo(t2.title);
	}
}

class BooksByAuthor implements Comparator<Book> {

	@Override
	public int compare(Book t1, Book t2) {
		// TODO Auto-generated method stub
		return t1.author.compareTo(t2.author);
	}
}

class BooksByPrice implements Comparator<Book> {

	@Override
	public int compare(Book t1, Book t2) {
		// TODO Auto-generated method stub
		return t1.price - t2.price;
	}
}

