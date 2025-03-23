package lab14;

public interface ICompareRunner {
	int compare(Runner r1, Runner r2);
}

class compareTime implements ICompareRunner {
	public int compare(Runner r1, Runner r2) {
		return r1.time - r2.time;
	}
}

class ReverseComparator implements ICompareRunner {
	ICompareRunner originalComparator;
	
	ReverseComparator(ICompareRunner originalComparator){
		this.originalComparator = originalComparator;
	}
	
	public int compare(Runner r1, Runner r2) {
		return -originalComparator.compare(r1, r2);
	}
}

class compareByName implements ICompareRunner{
	public int compare(Runner r1, Runner r2) {
		return r1.name.compareTo(r2.name);
	}
}