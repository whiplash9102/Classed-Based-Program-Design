package lab5;

import tester.*;

public class ExampleBooks {
	Book htdp = new Book("HtDP", "MF", 2001, 60);
	Book lpp = new Book("LPP", "STX", 1942, 25);
	Book ll = new Book("LL", "FF", 1968, 10);

	ILoBook mtlist = new MtLoBook();
	ILoBook lista = new ConsLoBook(this.ll, this.mtlist);
	ILoBook listb = new ConsLoBook(this.lpp, new ConsLoBook(this.ll, this.mtlist));
	ILoBook listc = new ConsLoBook(this.lpp, new ConsLoBook(this.ll, this.mtlist));
	ILoBook listd = new ConsLoBook(this.ll, new ConsLoBook(this.lpp, this.mtlist));
	ILoBook listdUnsorted = new ConsLoBook(this.lpp,
			new ConsLoBook(this.htdp, new ConsLoBook(this.ll, this.mtlist)));

	// tests for the method count
	boolean testCount(Tester t) {
		return t.checkExpect(this.mtlist.count(), 0) && t.checkExpect(this.lista.count(), 1)
				&& t.checkExpect(this.listd.count(), 2);
	}

	// tests for the method salePrice
	boolean testSalePrice(Tester t) {
		return t.checkInexact(this.mtlist.salePrice(0), 0.0, 0.001)
				&& t.checkInexact(this.lista.salePrice(0), 10.0, 0.001)
				&& t.checkInexact(this.listc.salePrice(0), 35.0, 0.001)
				&& t.checkInexact(this.listd.salePrice(0), 35.0, 0.001)
				&& t.checkInexact(this.mtlist.salePrice(50), 0.0, 0.001)
				&& t.checkInexact(this.lista.salePrice(50), 5.0, 0.001)
				&& t.checkInexact(this.listc.salePrice(50), 17.5, 0.001)
				&& t.checkInexact(this.listd.salePrice(50), 17.5, 0.001);
	}

	// tests for the method allBefore
	boolean testAllBefore(Tester t) {
		return t.checkExpect(this.mtlist.allBefore(2001), this.mtlist)
				&& t.checkExpect(this.lista.allBefore(2001), this.lista)
				&& t.checkExpect(this.listb.allBefore(2001), this.mtlist)
				&& t.checkExpect(this.listc.allBefore(2001),
						new ConsLoBook(this.lpp, new ConsLoBook(this.ll, this.mtlist)))
				&& t.checkExpect(this.listd.allBefore(2001),
						new ConsLoBook(this.ll, new ConsLoBook(this.lpp, this.mtlist)));
	}

//test the method sort for the lists of books
	boolean testSort(Tester t) {
		return t.checkExpect(this.listc.sortByPrice(), this.listd)
				&& t.checkExpect(this.listdUnsorted.sortByPrice(), this.listd);
	}

	public static void main(String[] args) {
		Tester.runReport(new ExampleBooks(), false, false);
	}
}