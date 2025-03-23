package lab6;

public interface IFunc1<A1, A2, R> {
	R apply(A1 a1, A2 a2);

}

class SumOfTheList implements IFunc1<Integer, Integer, Integer> { 
	public Integer apply(Integer a1, Integer a2) {
		return a1 + a2;
	}
}

interface IPred<T> extends IFunc<T, Boolean> {
}

class ListNumberBiggerThan3 implements IPred<Integer> {

	@Override
	public Boolean apply(Integer input) {
		// TODO Auto-generated method stub
		return input >= 4;
	}
	
}
class ExtractJSONValue implements IFunc<Pair<String, JSON>, JSON> {
  @Override
  public JSON apply(Pair<String, JSON> input) {
      return input.y; // Ignore the key, return the JSON value
  }

}
class SumJSON implements IFunc1<JSON,Integer, Integer>{
	public Integer apply(JSON input, Integer acc) {
		return input.accept(new JSONToNumber()) + acc;
	}
}

class SumPairJSON implements IFunc1<Pair<String, JSON>, Integer, Integer> {
	public Integer apply(Pair<String, JSON> pair, Integer acc) {
		return pair.y.accept(new JSONToNumber()) + acc;
	}
}

class FindInList implements IFunc1<Pair<String, JSON>, JSON, JSON> {
	String ref;
	FindInList(String ref){
		this.ref = ref;
	}
	@Override
	public JSON apply(Pair<String, JSON> a1, JSON a2) {
		// TODO Auto-generated method stub
		if (a1.x.equals(ref)) {
			return a1.y;
		} else {
			return a2;
		}
	}
}


