package lab14;
import tester.*;

public interface ILoRunner {
	ILoRunner sortBy(ICompareRunner compare);
	ILoRunner insertBy(ICompareRunner compare, Runner r);
	Runner findMinHelper(ICompareRunner comp, Runner acc);
	Runner findMin(ICompareRunner compareTime);
	Runner findMax(ICompareRunner compareTime);
}

class MtLoRunner implements ILoRunner {

	@Override
	public ILoRunner sortBy(ICompareRunner compare) {
		return this;
	}

	@Override
	public ILoRunner insertBy(ICompareRunner compare, Runner r) {
		return new ConsLoRunner(r, this);
	}

	@Override
	public Runner findMinHelper(ICompareRunner comp, Runner r) {
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public Runner findMin(ICompareRunner compare) {
		// TODO Auto-generated method stub
		return this.findMinHelper(compare, null);
	}

	@Override
	public Runner findMax(ICompareRunner compareTime) {
		// TODO Auto-generated method stub
		return null;
	}

}

class ConsLoRunner implements ILoRunner {
	Runner first;
	ILoRunner rest;

	ConsLoRunner(Runner first, ILoRunner rest) {
		this.first = first;
		this.rest = rest;
	}

	@Override
	public ILoRunner sortBy(ICompareRunner compare) {
		return this.rest.sortBy(compare).insertBy(compare, this.first);
	}

	@Override
	public ILoRunner insertBy(ICompareRunner compare, Runner r) {
		if (compare.compare(this.first, r) < 0) {
			return new ConsLoRunner(this.first, this.rest.insertBy(compare, r));
		}
		else {
			return new ConsLoRunner(r, this);
		}
	}
	
	public Runner findMinHelper(ICompareRunner compare, Runner acc) {
		if (compare.compare(acc, this.first) < 0) {
			return this.rest.findMinHelper(compare, acc);
		} else {
			return this.rest.findMinHelper(compare, this.first);
		}
	}
	
	public Runner findMin(ICompareRunner compare) {
		return this.rest.findMinHelper(compare, first);
	}

	@Override
	public Runner findMax(ICompareRunner compareTime) {
		// TODO Auto-generated method stub
		ICompareRunner reverse = new ReverseComparator(compareTime);
		return this.findMin(reverse);
	}

}

class ExamplesRunner {
//In Examples class
	Runner johnny = new Runner("Kelly", 97, 999, true, 30, 360);
	Runner frank = new Runner("Shorter", 32, 888, true, 245, 130);
	Runner bill = new Runner("Rogers", 36, 777, true, 119, 129);
	Runner joan = new Runner("Benoit", 29, 444, false, 18, 155);
	

	ILoRunner unsortedListed = new ConsLoRunner(joan, new ConsLoRunner(bill,
			(new ConsLoRunner(johnny, new ConsLoRunner(frank, new MtLoRunner())))));

	ILoRunner sortedListed = new ConsLoRunner(bill,
			new ConsLoRunner(frank, new ConsLoRunner(joan, 
					new ConsLoRunner(johnny, new MtLoRunner()))));
	

	
	boolean testSortTime(Tester t) {
		return t.checkExpect(unsortedListed.sortBy(new compareTime()), sortedListed);
	}
	
	boolean testFindMin(Tester t) {
		return t.checkExpect(sortedListed.findMin(new compareTime()), bill);
	}
	boolean testFindMax(Tester t) {
		return t.checkExpect(sortedListed.findMax(new compareTime()), johnny);
	}

}