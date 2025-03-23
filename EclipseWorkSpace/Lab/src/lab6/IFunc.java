package lab6;
import tester.Tester;
public interface IFunc<A, R> {
  R apply(A input);

}

// generic list
interface IList<T> {
  // map over a list, and produce a new list with a (possibly different)
  // element type
  <U> IList<U> map(IFunc<T, U> f);
  <R> R foldr(IFunc1<T, R, R> f, R initial);
  <U> U findSolutionOrElse(IFunc<T, U> covert, IPred<U> pred, U backup);
}
 
// empty generic list
class MtList<T> implements IList<T> {
  public <U> IList<U> map(IFunc<T, U> f) {
    return new MtList<U>();
  }

	@Override
	public <R> R foldr(IFunc1<T, R, R> f, R initial) {
		// TODO Auto-generated method stub
		return initial;
	}

	@Override
	public <U> U findSolutionOrElse(IFunc<T, U> covert, IPred<U> pred, U backup) {
		// TODO Auto-generated method stub
		return backup;
	}
}
 
// non-empty generic list
class ConsList<T> implements IList<T> {
  T first;
  IList<T> rest;
 
  ConsList(T first, IList<T> rest) {
    this.first = first;
    this.rest = rest;
  }
 
  public <U> IList<U> map(IFunc<T, U> f) {
    return new ConsList<U>(f.apply(this.first), this.rest.map(f));
  }

	@Override
	public <R> R foldr(IFunc1<T, R, R> f, R initial) {
		// TODO Auto-generated method stub
		return f.apply(first, this.rest.foldr(f, initial));
	}

	@Override
	public <U> U findSolutionOrElse(IFunc<T, U> covert, IPred<U> pred, U backup) {
		// TODO Auto-generated method stub
		U convertedValue = covert.apply(this.first);
		
		if(pred.apply(convertedValue)) {
			return convertedValue; 
		} else {
			return this.rest.findSolutionOrElse(covert, pred, backup);
		}
	}
}

class ExampleLists {
	IList<Integer> list1 = new ConsList<Integer>(1, 
												 new ConsList<Integer>(2,
												 new ConsList<Integer>(3,
												 new MtList<Integer>())));
	
	IList<JSON> json1 = new ConsList<JSON>(new JSONNumber(3),
											new ConsList<JSON>(new JSONBool(true),
											new ConsList<JSON>(new JSONString("hello"),
											new MtList<JSON>())));
	
	JSON jsonObject1 = new JSONObject(new ConsList<>(
																			new Pair<>("thanh", new JSONString("thanh")),
																			new MtList<>()));
			
	
	IPred<Integer> listNumberBiggerThan3 = new ListNumberBiggerThan3();
	
	IList<Integer> convertedList = json1.map(new JSONToNumber());
	
	boolean testSum(Tester t) { 
		return t.checkExpect(convertedList.foldr(new SumOfTheList(), 0), 9);
		}
	
	boolean testConvert(Tester t) {
		return t.checkExpect(json1.findSolutionOrElse(new JSONToNumber(),new ListNumberBiggerThan3(), 0), 5);
	}
	
	boolean testVisitPair(Tester t) {
		return t.checkExpect(jsonObject1.accept(new JSONFind("thanh")), new JSONString("thanh")) &&
					 t.checkExpect(jsonObject1.accept(new JSONFind("zzz")), new JSONBlank());
	}
}