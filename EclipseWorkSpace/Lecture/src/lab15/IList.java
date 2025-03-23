package lab15;


import tester.Tester;
public interface IList<T> {

	IList<T> find(IPred<T> pred);
	IList<T> sort(IComPare<T> comp);
	IList<T> insert(IComPare<T> comp, T t);
	<R> IList<R> map(IFunction<T, R> function); 
	<R> R        foldr( IFunc<T, R, R> function, R initialValue);
}

class MtLo<T> implements IList<T> {

	@Override
	public IList<T> find(IPred<T> pred) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IList<T> sort(IComPare<T> comp) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IList<T> insert(IComPare<T> comp, T t) {
		// TODO Auto-generated method stub
		return new ConsLo<T> (t, this);
	}

	@Override
	public <R> IList<R> map(IFunction<T, R> function) {
		// TODO Auto-generated method stub
		return new MtLo<R>();
	}

	@Override
	public <R> R foldr(IFunc<T, R, R> function, R initialValue) {
		// TODO Auto-generated method stub
		return initialValue;
	}
}

class ConsLo<T> implements IList<T>{
	T first;
	IList<T> rest;
	
	ConsLo(T first, IList<T> rest){
		this.first = first;
		this.rest = rest;
	}

	@Override
	public IList<T> find(IPred<T> pred) {
		// TODO Auto-generated method stub
		if (pred.apply(this.first)) {
			return new ConsLo<T>(this.first, this.rest.find(pred));
		} else {
			return this.rest.find(pred);
		}
	}

	@Override
	public IList<T> sort(IComPare<T> comp) {
		// TODO Auto-generated method stub
		return this.rest.insert(comp, first);
	}
	

	@Override
	public IList<T> insert(IComPare<T> pred, T t) {
		// TODO Auto-generated method stub
		if (pred.compare(this.first, t) < 0) {
			return new ConsLo<T>(this.first, this.rest.insert(pred, t));
		} else {
			return this.rest.insert(pred, first);
		}
	}

	@Override
	public <R> IList<R> map(IFunction<T, R> function) {
		return new ConsLo<R>(function.apply(first), this.rest.map(function)); 
	}

	@Override
	public <R> R foldr(IFunc<T, R, R> function, R initialValue) {
		// TODO Auto-generated method stub 
		return function.apply(first, this.rest.foldr(function, initialValue));
	}
}

class IListExamples {
	IListExamples(){}
	
	Runner frank = new Runner("Shorte", 32, 888, true, 234, 130);
	Runner joan = new Runner("Benord", 29, 444, false, 18, 155);
	
	IList<Runner> list1 = new ConsLo<Runner>(this.frank,
									new MtLo<Runner>());
	
	
	
	IPred<Book> byAuthor = new BookByAuthor();
	IPred<Runner> posUnder50 = new IsPosUnder50();
	IList<Runner> expectedRunnerList = new ConsLo<Runner>(joan, new MtLo<Runner>());
	
	IList<Runner> runnerList = new ConsLo<Runner>( this.frank,
														 new ConsLo<Runner>( this.joan,
														 new MtLo<Runner>()));
	
	boolean testIListExamples(Tester t) {
		return t.checkExpect( runnerList.find(posUnder50), new ConsLo<Runner>(joan, new MtLo<Runner>()));
	}
	
	boolean testIFuntion(Tester t) {
		return t.checkExpect(list1.map(new RunnerToAge()), new ConsLo<Integer>(32, new MtLo<Integer>()));
	}
	boolean testIListFoldR(Tester t) {
		return t.checkExpect(runnerList.find(this.posUnder50), 
												 this.expectedRunnerList);
	}
}