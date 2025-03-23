
interface IList<T> {
	IList<T> add(T t);
	boolean contains(T t);
	boolean sameHelper(IList<T> T);
	boolean sameHelperTwice(IList<T> courses);
	int countHelper(IList<T> t );
}

class MtList<T> implements IList<T>{

	@Override
	public IList<T> add(T t) {
		// TODO Auto-generated method stub
		return new ConsList<T>(t, new MtList<T>());
	}

	@Override
	public boolean contains(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sameHelper(IList<T> T) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sameHelperTwice(IList<T> t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countHelper(IList<T> t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class ConsList<T> implements IList<T> {
	T first;
	IList<T> rest; 
	
	ConsList(T first, IList<T> rest){ 
		this.first = first;
		this.rest = rest;
	}

	@Override
	public IList<T> add(T t) {
		// TODO Auto-generated method stub
		return new ConsList<T>(t,this);
	}

	@Override
	public boolean contains(T t) {
		// TODO Auto-generated method stub
		return this.first.equals(t) || this.rest.contains(t);
	}

	@Override
	public boolean sameHelper(IList<T> T) {
		// TODO Auto-generated method stub
		if (T.contains(first)) {
			return T.sameHelper(rest);
		} else {
			return false;
		}
	}

	@Override
	public boolean sameHelperTwice(IList<T> t) {
		if (this.countHelper(t) >= 2) {
			return true;
		} else { 
			return false;
		}
	}


	@Override
	public int countHelper(IList<T> t) {
		// TODO Auto-generated method stub
		if (t.contains(this.first)) {
			return 1 + t.countHelper(this.rest);
		} else {
			return t.countHelper(this.rest);
		}
	}
}