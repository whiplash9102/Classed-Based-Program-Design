package lab20;
interface IMutablePerson { 
	void add(String name, int phone );
	void remove(String name);
	boolean contains(String name);
}

class MutableLoPerson implements IMutablePerson {
	ILoPerson sentinel;
	
	MutableLoPerson(){
		this.sentinel = new Sentinel( new MtLoPerson());
	}
	
	@Override
	public void add(String name, int phone) {
		// TODO Auto-generated method stub
		this.sentinel = this.sentinel.insert(name, phone);
	}

	@Override
	public void remove(String name) {
		// TODO Auto-generated method stub
	 this.sentinel.RemovePerson(name); 
	}

	@Override
	public boolean contains(String name) {
		// TODO Auto-generated method stub
		return this.sentinel.contains(name);
	}
}
public interface ILoPerson {
	boolean contains(String name);
	int findPhoneNum(String name);
	void changePhone(String name, int newNum);
	void removePersonHelper(String name, ANode consLoPerson);
	void RemovePerson(String name);
	ILoPerson insert(String name, int phone);
}

abstract class ANode implements ILoPerson {
	ILoPerson rest;
	ANode(ILoPerson rest){
		this.rest = rest;
	}
	public abstract boolean contains(String name);
	public abstract int findPhoneNum(String name);
	public abstract void changePhone(String name, int newNum);
	public abstract void removePersonHelper(String name, ANode consLoPerson);
	public abstract void RemovePerson(String name);
	public abstract ILoPerson insert(String name, int phone);
}

class Sentinel extends ANode {
	Sentinel(ILoPerson rest){
		super(rest);
	}
	@Override
	public boolean contains(String name) {
		// TODO Auto-generated method stub
		return this.rest.contains(name);
	}

	@Override
	public int findPhoneNum(String name) {
		// TODO Auto-generated method stub
		return this.rest.findPhoneNum(name);
	}

	@Override
	public void changePhone(String name, int newNum) {
		this.rest.changePhone(name, newNum);
		
	}

	@Override
	public void removePersonHelper(String name, ANode consLoPerson) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemovePerson(String name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		this.rest.removePersonHelper(name, this);	
	}
	@Override
	public ILoPerson insert(String name, int phone) {
		return this.rest.insert(name, phone);
	}
}
	
class MtLoPerson implements ILoPerson{
	MtLoPerson(){}
	public boolean contains(String name) { 
		return false;
	}
	@Override
	public int findPhoneNum(String name) {
		// find the phone number of the person in the list
		// if cannot find the person phone number return -1
		return -1;
	}
	@Override
	public void changePhone(String name, int newNum) {
		// change the phone number of the 
		
	}
	@Override
	public void removePersonHelper(String name, ANode consLoPerson) {
		// TODO Auto-generated method stub
		return;
	}
	@Override
	public void RemovePerson(String name) {
		return;
	}
	@Override
	public ILoPerson insert(String name, int phone) {
		return new ConsLoPerson(new Person(name, phone), this);
	}
}

class ConsLoPerson extends ANode {
	Person first;

	
	ConsLoPerson(Person first, ILoPerson rest){
		super(rest);
		this.first = first;
	}
	public boolean contains(String name) {
		return this.first.name.equals(name) || this.rest.contains(name);
	}
	@Override
	public int findPhoneNum(String name) {
		// TODO Auto-generated method stub
		if (this.first.name.equals(name)) {
			return this.first.phone;
		} else { 
			return this.rest.findPhoneNum(name);
		}
	}
	
	@Override
	public void changePhone(String name, int newNum) {
		if (this.first.name.equals(name)) {
			this.first.changeNum(newNum);
		} else {
			this.rest.changePhone(name, newNum);
		}
	}
	
	public void RemovePerson(String name) {
		this.rest.removePersonHelper(name, this);
	}
	
	public void removePersonHelper(String name, ANode prev) {
		if (this.first.sameName(name)) {
			prev.rest = this.rest; 
		} else {
			this.rest.removePersonHelper(name, this);
		}
		return;
		}
	@Override
	public ILoPerson insert(String name, int phone) {
		return new ConsLoPerson(this.first, this.rest.insert(name, phone));
	}
	
}