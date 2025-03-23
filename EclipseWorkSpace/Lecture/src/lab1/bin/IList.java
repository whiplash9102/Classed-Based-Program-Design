package lab1.bin;

public interface IList<T> {
	IList<T> append(T t);
	boolean contain(T t);
}

class MtList<T> implements IList<T> {

	@Override
	public IList<T> append(T t) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean contain(T t) {
		// TODO Auto-generated method stub
		return false;
	} 
	
}

class ConsList<T> implements IList<T> {
	T first;
	IList<T> rest;
	
	ConsList(T first, IList<T> rest) {
		this.first = first;
		this.rest = rest;
	}

	@Override
	public IList<T> append(T t) {
		// TODO Auto-generated method stub
		return new ConsList<>(t, this);
	}

	@Override
	public boolean contain(T t) {
		// TODO Auto-generated method stub
		return this.first.equals(t) || this.rest.contain(t);
	}
}
