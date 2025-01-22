package Assignment_2;

public interface ILoMotifs {

	double countAll();

	double averageMotifs();

	String convertListString();

}

class MtList implements ILoMotifs {

	@Override
	public double countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double averageMotifs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String convertListString() {
		// TODO Auto-generated method stub
		return "";
	}
	
}

class ConsLoMotifs implements ILoMotifs {
	Motifs first;
	ILoMotifs rest;
	
	ConsLoMotifs(Motifs first, ILoMotifs rest){
		this.first = first;
		this.rest = rest;
	}

	@Override
	public double countAll() {
		// TODO Auto-generated method stub
		return this.first.countAll() + this.rest.countAll();
	}

	@Override
	public double averageMotifs() {
		// TODO Auto-generated method stub
		return this.first.averageMotifs() + this.rest.averageMotifs();
	}

	@Override
	public String convertListString() {
		// TODO Auto-generated method stub
		String firstInfo = this.first.convertString();
		String restInfo = this.rest.convertListString();
		
		if (restInfo.equals("")) {
			return firstInfo;
		} else {
			return firstInfo + ", " + restInfo;
		}
	}
}

