package lab8;


public interface ILoList {
	ILoList sort();

	ILoList insert(String first);

	ILoList removeDuplicates();

	ILoList stringFormat(String first);
}

class MtList implements ILoList {

	@Override
	public ILoList sort() {
		// TODO Sort the empty list
		return this;
	}

	@Override
	public ILoList insert(String other) {
		// TODO insert the empty list into the list
		return new ConsLoList(other, this);
	}

	@Override
	public ILoList removeDuplicates() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ILoList stringFormat(String first) {
		// TODO Auto-generated method stub
		return new ConsLoList(first, this);
	}
	
}

class ConsLoList implements ILoList {
	String first;
	ILoList rest;
	
	ConsLoList(String first, ILoList rest){
		this.first = first;
		this.rest = rest;
	}
	
	public ILoList sort() {
		return this.rest.sort().insert(this.first);
	}

	@Override
	public ILoList insert(String other) {
		// TODO Insert the String into the list with the alphabet respectively 
		if (other.compareTo(this.first) < 0){
			return new ConsLoList(other, this);
		} else {
			return new ConsLoList(this.first, this.rest.insert(other));
		}
	}

	@Override
	public ILoList removeDuplicates() {
		// TODO ILoList ->LoiList
		// Remove duplicated in the list
		return this.rest.removeDuplicates().stringFormat(this.first);
	}

	@Override
	public ILoList stringFormat(String other) {
		// TODO ILoList String -> ILoList
		if (other.equals(this.first)){
			return new ConsLoList(other, this.rest);
		} else {
		return new ConsLoList(this.first, this.rest.stringFormat(other));
		}
	}
}