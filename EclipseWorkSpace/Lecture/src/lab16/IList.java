package lab16;
public interface IList<T> {
	
}

class MtList<T> implements IList<T> {
	
}

class ConsList<T> implements IList<T> {
	T first;
	IList<T> rest;
	
	ConsList(T first, IList<T> rest) {
		this.first = first;
		this.rest = rest;
	}
}