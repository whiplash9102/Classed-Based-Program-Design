package lab19;
interface IFunc<T, A> {
	A update(T t);
}

class PhoneUpdate implements IFunc<Person, Void> {
	int phone; 
	
	PhoneUpdate(int phone){
		this.phone = phone;
	}
	@Override
	public Void update(Person t) {
		t.phone = this.phone;
		return null;
	}
	
}

interface IPred<T> {
	boolean apply(T t);
}


class findPhone implements IPred<Person> {
	String name;
	
	findPhone(String name){
		this.name = name; 
	}
	public boolean apply(Person p) {
		return p.name.equals(this.name);
	}
}

public interface IList<T> {

	T find(IPred<T> whichOne);
	Void findUpdate(IPred<T> whichOne, IFunc<T, Void> whatToDo);
}

class MtList<T> implements IList<T> {

	@Override
	public T find(IPred<T> whichOne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void findUpdate(IPred<T> whichOne, IFunc<T, Void> whatToDo) {
		return null;
		// TODO Auto-generated method stub
		
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
	public T find(IPred<T> whichOne) {
		// TODO Auto-generated method stub
		if (whichOne.apply(this.first)) {
			return this.first;
		} else { 
			return this.rest.find(whichOne);
		}
	}

	@Override
	public Void findUpdate(IPred<T> whichOne, IFunc<T, Void> whatToDo) {
		// TODO Auto-generated method stub
		if(whichOne.apply(this.first)) {
			whatToDo.update(this.first);
		} else {
			this.rest.findUpdate(whichOne, whatToDo);
		}
		return null;
	}
	
}