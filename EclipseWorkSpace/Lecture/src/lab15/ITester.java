package lab15;
import tester.Tester;

public interface ITester {
	Integer sumList(IFunction3 fun);
}

class MtList implements ITester {

	@Override
	public Integer sumList(IFunction3 fun) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class ConsList implements ITester {
	Book first;
	ITester rest;
	
	ConsList(Book first, ITester rest){
		this.first = first;
		this.rest = rest; 
	}

	@Override
	public Integer sumList(IFunction3 fun) {
		// TODO Auto-generated method stub
		return fun.sum(first) + rest.sumList(fun);
	}
}


class Book {
	String title;
	String author;
	int yob;
	
	Book(String author, String title, int yob) {
		this.title = title; 
		this.author = author;
		this.yob = yob;
	}
}

interface IFunction3 {
	int sum(Book b);
}

class sumTheList implements IFunction3 {
	public int sum(Book b) {
		return b.yob;
	}
}

class IListExample{
	Book john = new Book("Thanh", "La", 1);
	Book lee = new Book("Pham", "ke", 2);
	
	ITester list1 = new ConsList(john, 
									new ConsList(lee, new MtList()));
	
	boolean testerBook(Tester t) {
		return t.checkExpect(list1.sumList(new sumTheList()), 3);
	}
}