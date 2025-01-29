// CS 2510, Assignment 3

import tester.*;

// to represent a list of Strings
interface ILoString {
	// combine all Strings in this list into one
	String combine();

	ILoString sort();

	ILoString insert(String other);

	ILoString interLeave(ILoString other);

	ILoString reverse();

	ILoString insertOrder(String first);
	
	boolean isDoubleList();
	
	boolean isDoubleList1();
	
	boolean isSimmilar(String other);
	
	boolean isPalindromeList();
	
	boolean isEqual(ILoString list);
	
}

// to represent an empty list of Strings
class MtLoString implements ILoString {
	MtLoString() {
	}

	// combine all Strings in this list into one
	public String combine() {
		return "";
	}

	// sort all the string in the list
	public ILoString sort() {
		return this;
	}

	// insert and compare string into the list
	public ILoString insert(String other) {
		return new ConsLoString(other, new MtLoString());
	}

	// combine two list of string into one string
	public ILoString interLeave(ILoString other) {
		// TODO Auto-generated method stub
		return this;
	}

	// reverse the current list but keep the same order
	public ILoString reverse() {
		return this;
	}

	// insert the reverse order of list
	public ILoString insertOrder(String first) {
		return new ConsLoString(first, this);
	}
	
	public boolean isDoubleList() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDoubleList1() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSimmilar(String other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPalindromeList() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqual(ILoString list) {
		return list instanceof MtLoString;
	}

}

// to represent a nonempty list of Strings
class ConsLoString implements ILoString {
	String first;
	ILoString rest;

	ConsLoString(String first, ILoString rest) {
		this.first = first;
		this.rest = rest;
	}

	// combine all Strings in this list into one
	public String combine() {
		return this.first.concat(this.rest.combine());
	}

	@Override
	public ILoString sort() {
		// TODO Auto-generated method stub
		return this.rest.insert(first);
	}

	// insert string into the list
	public ILoString insert(String other) {
		if (first.toLowerCase().compareTo(other.toLowerCase()) <= 0) {
			return new ConsLoString(this.first, this.rest.insert(other));
		}
		else {
			return new ConsLoString(other, this);
		}
	}

	// Combine two list together
	public ILoString interLeave(ILoString other) {
		if (other instanceof MtLoString) {
			return this;
		}
		else if (other instanceof ConsLoString) {
			return new ConsLoString(this.first, other.interLeave(this.rest));
		}
		throw new IllegalStateException("Unexpected list type");
	}

	// Reverse the current list order
	public ILoString reverse() {
		return this.rest.reverse().insertOrder(this.first);
	}

	// Insert the list in the backward order
	public ILoString insertOrder(String other) {
		return new ConsLoString(this.first, this.rest.insertOrder(other));
	}

	
	public boolean isDoubleList() {
		// TODO Auto-generated method stub
		if (this.rest instanceof ConsLoString) {
			ConsLoString second = (ConsLoString) this.rest;
			if (this.first.equals(second.first)) {
				return true ;
			} else {
				return this.rest.isDoubleList();
			}
	} else {
		return false;
	}
}

	@Override
	public boolean isDoubleList1() {
		return this.rest.isSimmilar(this.first);
	}
	
	public boolean isSimmilar(String other) {
		if(other.equals(this.first)){
			return true;
		} else {
			return this.rest.isSimmilar(this.first);
		}
	}

	@Override
	public boolean isPalindromeList() {
		// TODO Auto-generated method stub
		return this.isEqual(this.reverse());
	}

	@Override
	public boolean isEqual(ILoString list) {
		if (list instanceof MtLoString) {
			return false;
		}
		if (list instanceof ConsLoString) {
				ConsLoString otherCons = (ConsLoString) list;
				return this.first.equals(otherCons.first) &&
						this.rest.isEqual(otherCons.rest);
		} else {
			return false;
		}
	}
}

// to represent examples for lists of strings
class ExamplesStrings{

	ILoString mary = new ConsLoString("Mary ", new ConsLoString("had ", new ConsLoString("a ",
			new ConsLoString("little ", new ConsLoString("lamb.", new MtLoString())))));

	ILoString unsorted = new ConsLoString("Banana",
			new ConsLoString("apple", new ConsLoString("Cherry", new MtLoString())));

	ILoString list1 = new ConsLoString("x",
			new ConsLoString("y", new ConsLoString("z", new MtLoString())));
	ILoString list2 = new ConsLoString("a",
			new ConsLoString("b", new ConsLoString("c", new MtLoString())));
	ILoString list3 = new MtLoString();
	
	ILoString identicalList1 = new ConsLoString("x",
			new ConsLoString("x",
					new ConsLoString("y", 
							new ConsLoString("z", new MtLoString()))));

	ILoString panlidromels = new ConsLoString("a",
			new ConsLoString("b", 
					new ConsLoString("b", 
							new ConsLoString("a", new MtLoString()))));

	// test the method combine for the lists of Strings
	boolean testCombine(Tester t) {
		return t.checkExpect(this.mary.combine(), "Mary had a little lamb.");
	}

	boolean testSort(Tester t) {
		return t.checkExpect(unsorted.sort(), new ConsLoString("apple",
				new ConsLoString("Banana", new ConsLoString("Cherry", new MtLoString()))));
	}

	boolean testInterLeve(Tester t) {
		return t.checkExpect(list1.interLeave(list2),
				new ConsLoString("x",
						new ConsLoString("a",
								new ConsLoString("y",
										new ConsLoString("b",
												new ConsLoString("z", new ConsLoString("c", new MtLoString())))))))
				&& t.checkExpect(list1.interLeave(list3),
						new ConsLoString("x", new ConsLoString("y", new ConsLoString("z", new MtLoString()))));
	}

	boolean testReverse(Tester t) { return t.checkExpect(list1.reverse(), 
			new ConsLoString("z", new ConsLoString("y", new ConsLoString("x", new MtLoString()))));
	}
	
	boolean testIsDouble(Tester t) {
		return t.checkExpect(identicalList1.isDoubleList(), true);
	}
	boolean testIsDouble1(Tester t) {
		return t.checkExpect(identicalList1.isDoubleList1(), true);
	}
	boolean testPanlidromeList(Tester t) {
		return t.checkExpect(panlidromels.isPalindromeList(), true) &&
				t.checkExpect(list3.isPalindromeList(), false);
	}
}
