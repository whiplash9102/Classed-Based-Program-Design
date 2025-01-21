package lab7;

import tester.Tester;

public interface IListAcc {
  IListAcc appendListAcc(IListAcc other, IListAcc acc);
}

class MtListAcc implements IListAcc {
  @Override
  public IListAcc appendListAcc(IListAcc other, IListAcc acc) {
      return acc; // Return the accumulated result.
  }
}

class ConsListAcc implements IListAcc {
  String first;
  IListAcc rest;

  ConsListAcc(String first, IListAcc rest) {
      this.first = first;
      this.rest = rest;
  }

  @Override
  public IListAcc appendListAcc(IListAcc other, IListAcc acc) {
      // Add the current element to the accumulator and recurse
      return this.rest.appendListAcc(other, new ConsListAcc(this.first, acc));
  }
}


class ExamplesListAcc{
	IListAcc newlist1 = new ConsListAcc("a", new ConsListAcc("b", new MtListAcc()));
	IListAcc newlist2 = new ConsListAcc("c", new ConsListAcc("d", new MtListAcc()));
	
	boolean testAppendList(Tester t) {
		return t.checkExpect(newlist1.appendListAcc(newlist2, new MtListAcc()), new ConsListAcc("a", new ConsListAcc("b", new ConsListAcc("c", new ConsListAcc("d", new MtListAcc()))))); 
}
}