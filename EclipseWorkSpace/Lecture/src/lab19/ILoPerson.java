package lab19;

public interface ILoPerson {
	boolean contains(String name);
	int findPhoneNum(String name);
	void changePhone(String name, int newNum);
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
}

class ConsLoPerson implements ILoPerson {
	Person first;
	ILoPerson rest;
	
	ConsLoPerson(Person first, ILoPerson rest){
		this.first = first;
		this.rest = rest;
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
}