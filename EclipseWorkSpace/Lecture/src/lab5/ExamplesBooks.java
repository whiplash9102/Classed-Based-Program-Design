package lab5;


import tester.*;

public class ExamplesBooks {
//Books
	Book htdp = new Book("HtDP", "MF", 2001, 60);
	Book lpp = new Book("LPP", "STX", 1942, 25);
	Book ll = new Book("LL", "FF", 1986, 10);
	Book oop = new Book("OOP", "AuthorX", 2022, 40);

// lists of Books
	ILoBook mtlist = new MtList();
	ILoBook lista = new ConsLoBook(this.lpp, this.mtlist);
	ILoBook listb = new ConsLoBook(this.htdp, this.mtlist);
	ILoBook listc = new ConsLoBook(this.lpp, new ConsLoBook(this.ll, this.listb));
	ILoBook listd = new ConsLoBook(this.ll,
			new ConsLoBook(this.lpp, new ConsLoBook(this.htdp, this.mtlist)));
	
	ILoBook unsortedBooks = new ConsLoBook(ll,
			new ConsLoBook(htdp, new ConsLoBook(oop, new ConsLoBook(lpp, new MtList()))));
	
	ILoBook expectedSortedBooks = new ConsLoBook(htdp,
			new ConsLoBook(ll, new ConsLoBook(lpp, new ConsLoBook(oop, new MtList()))));

	boolean testCount(Tester t) {
		return t.checkExpect(this.mtlist.count(), 0) && t.checkExpect(this.lista.count(), 1);
	}

	boolean testSalePrice(Tester t) {
		return t.checkInexact(this.mtlist.salePrice(50), 0.0, 0.001)
				&& t.checkInexact(this.mtlist.salePrice(50), 0.0, 0.001)
				&& t.checkInexact(this.listc.salePrice(50), 47.5, 0.001)
				&& t.checkInexact(this.listd.salePrice(50), 47.5, 0.001);
	}

	boolean testSortByString(Tester t) {
		// Expected sorted list by title: [HtDP, LL, LPP, OOP]
		ILoBook expectedSortedBooks = new ConsLoBook(htdp,
				new ConsLoBook(ll, new ConsLoBook(lpp, new ConsLoBook(oop, new MtList()))));

		// Sort the unsortedBooks list
		ILoBook sortedBooks = unsortedBooks.sortByString();

		// Test if the sorted list matches the expected list
		return t.checkExpect(sortedBooks, expectedSortedBooks);
	}

}
