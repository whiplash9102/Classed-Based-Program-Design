package lab18;


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