package lab10;
import tester.Tester;

public interface IBook {
	int daysOverdue(int today);
	boolean isOverdue(int currentDay);
	int computeFine(int dayNum);
}

abstract class ABook implements IBook {
	String title;
	int dayTaken;

	public ABook(String title, int dayTaken) {
		this.title = title;
		this.dayTaken = dayTaken;
	}

	// the number of days this book is overdue
	public int daysOverdue(int today, int loanPeriod) {
		return today - (dayTaken + loanPeriod);
	}

	public boolean isOverdue(int currentDay) {
		return this.daysOverdue(currentDay, getLoanPeriod()) > 0;
}
	
	public int computeFine(int currentDay) {
		int overdueDays = this.daysOverdue(currentDay, getLoanPeriod());
		if (overdueDays > 0) {
			return overdueDays * getOverdueFees();
	}
		return 0;
	}
	
	// Getter method 
	abstract int getLoanPeriod();
	// Getter method 
	abstract int getOverdueFees();
	
}

// Book class implementation
class Book extends ABook {
	String author;

	Book(String title, String author, int dayTaken) {
		super(title, dayTaken);
		this.author = author;
	}

	@Override
	public int daysOverdue(int today) {
		return super.daysOverdue(today, 14);
	}
	// check if the book is overdue or not

	@Override
	public boolean isOverdue(int currentDay) {
		return super.isOverdue(currentDay);
	}
	
	public int computeFine(int currentDay) {
		return super.computeFine(currentDay);
	}
	
	// Getter method
	protected int getLoanPeriod() {
		return 14;
	}
	protected int getOverdueFees() {
		return 10;
	}

	
}

// RefBook class implementation 
class RefBook extends ABook {
	RefBook(String title, int dayTaken) {
		super(title, dayTaken);
	}

	public int daysOverdue(int today) {
		return super.daysOverdue(today, 2);
	}

	@Override
	public boolean isOverdue(int currentDay) {
		// TODO Auto-generated method stub
		return super.isOverdue(currentDay);
	}
	public int computeFine(int currentDay) {
		return super.computeFine(currentDay);
	}
	
	protected int getLoanPeriod() {
		return 2;
	}
	protected int getOverdueFees() {
		return 10;
	}

}

// AudioBook class implementation
class AudioBook extends ABook {
	String author;

	AudioBook(String title, String author, int dayTaken) {
		super(title, dayTaken);
		this.author = author;
	}

	public int daysOverdue(int today) {
		return super.daysOverdue(today, 14);
	}
	public boolean isOverdue(int currentDay) {
		return super.isOverdue(currentDay);
	}
	
	protected int getLoanPeriod() {
		return 14;
	}

	protected int getOverdueFees() {
		return 20;
	}
	
	public int computeFine(int currentDay) {
		return super.computeFine(currentDay);
	}
}

class ExamplesBooks {
	Book myBook = new Book("Harry Potter", "J.K Rowling", 7783);
	IBook myAudio = new AudioBook("Sherlock Holmes", "Arthur Conan Doyle", 7778);
	IBook refBook = new RefBook("Encyclopedia", 7780);

	int currentDay = 7790;

	boolean testerDaysOverdue(Tester t) {
		return t.checkExpect(refBook.daysOverdue(currentDay), 8);
	}

	boolean testerIsOverdue(Tester t) {
			return t.checkExpect(refBook.isOverdue(currentDay), true);
	}
	
	boolean testComputeFine(Tester t) {
		return t.checkExpect(refBook.computeFine(currentDay), 80);
	}

}
