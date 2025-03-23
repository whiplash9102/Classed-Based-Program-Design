package lab1.bin;
import tester.*;

public class ExampleBooks {
	Author knuth;
	Book taocp1, taocp2;
	Author shakespeare;
	Book comedyOfError;

	void iniTestConditions() {
		this.knuth = new Author("Donald", "Knuth", 1938, null); // no books yet
		this.taocp1 = new Book("The Art of Computer Programming (volume 1)", 100, 2, knuth);
		this.taocp2 = new Book("The Art of Computer Programming (volume 2)", 100, 2, knuth);
		this.shakespeare = new Author("William", "Shakepeare", 1564, null);
		this.comedyOfError = new Book("The Comedy of Errors", 42, 1, shakespeare);

	}

	void testAddBook(Tester t) {
		this.iniTestConditions();
		t.checkExpect(this.knuth.Books, new ConsList<>(taocp2, new ConsList<>(taocp1, new MtList<>())));
	}

	void testErrorRun(Tester t) {
		this.iniTestConditions();
		knuth.addBook(taocp1); // First addition - should work fine
		t.checkException(new RuntimeException("This book already exist in the library"), knuth,
				"addBook", this.taocp1 // Second addition - should throw an exception
		);
	}

}

//	// In ExampleBooks
//	boolean testTaocp1(Tester t) {
//		// 1. Check that the initial conditions are as expected
//		this.iniTestConditions();
//		// 2. Modify them
//		this.knuth.updateBook(this.taocp1);
//		// 3. Check that the expected changes have occurred
//		return t.checkExpect(this.knuth.book, this.taocp1);
//	}
//
//	boolean testTaocp2(Tester t) {
//		this.iniTestConditions();
//		this.knuth.addBook(taocp2);
//		return t.checkExpect(this.knuth.book, this.taocp2);
//	}
//
//	// In ExampleBooks
//	void testTwoBooks(Tester t) {
//		this.iniTestConditions();
//		// Test 1: check that knuth hasn't written any books yet
//		t.checkExpect(this.knuth.book, null);
//		// Modify knuth to know about volume 1
//		this.knuth.updateBook(this.taocp1);
//		// Test 2: check that knuth's book was written by knuth
//		t.checkExpect(this.knuth.book.author, this.knuth);
//		// Modify knuth to know about volume 2
//		 t.checkException(
//			    new RuntimeException("Trying to add second book to an author"),
//			    this.knuth, "updateBook", this.taocp2);
//		t.checkExpect(this.taocp1.author.book, this.taocp1);
//		 t.checkException(
//			    new RuntimeException("This book does not belong to this author"),
//			    shakespeare, "updateBook", this.taocp1);
//		}
//	
//	void testBookAuthors(Tester t) {
//		this.iniTestConditions();
//		this.knuth.updateBook(taocp2);
//		t.checkExpect(this.knuth.book.author, this.knuth);
