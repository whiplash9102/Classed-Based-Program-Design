package lab7;
import tester.*;
public interface IList {
	IList appendList(IList list);
}

class MtList implements IList {
	public IList appendList(IList other) {
		return other;
	}
}

class ConsList implements IList {
	String first;
	IList rest;
	
	ConsList(String first, IList rest){
		this.first = first;
		this.rest = rest;
	}

	@Override
	public IList appendList(IList other) {
		// TODO Auto-generated method stub
		return new ConsList(this.first, this.rest.appendList(other)); 
	}
}

class ExamplesLists {
	IList newlist1 = new ConsList("a", new ConsList("b", new MtList()));
	IList newlist2 = new ConsList("c", new ConsList("d", new MtList()));
	
	boolean testAppendList(Tester t) {
		return t.checkExpect(newlist1.appendList(newlist2), new ConsList("a", new ConsList("b", new ConsList("c", new ConsList("d", new MtList()))))); 
	}
}