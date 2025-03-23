package lab19;
import tester.Tester;

public class Counter {
	int val;
	Counter() {
		this(0);
	}
	
	Counter (int initialVal) {
		this.val = initialVal;
	}
	
	int get() {
		int ans = this.val;
		this.val = this.val + 1;
		return ans;
	}
}

class ExamplesCounter {
	void testCounter(Tester t) { 
		Counter c1 = new Counter(); // c1's  val == 0
		Counter c2 = new Counter(5); //c2's val == 5;
		Counter c3 = c1;
		
		//What shoud these test be?
		t.checkExpect(c1.get(), 0);
		t.checkExpect(c2.get(), 5);
		t.checkExpect(c3.get(), 1);
		
		t.checkExpect(c1.get() == c3.get(), false);
		t.checkExpect(c1.get() == c1.get(), false);
		t.checkExpect(c2.get() == c1.get(), true);
		
	}
}
