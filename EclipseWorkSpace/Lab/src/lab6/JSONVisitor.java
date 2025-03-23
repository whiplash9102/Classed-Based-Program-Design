package lab6;

public interface JSONVisitor<T> {
	T visitBlank(JSONBlank blank);

	T visitNumber(JSONNumber number);

	T visitStringLength(JSONString stringLength);

	T visitBoolean(JSONBool boolCheck);

	T visitList(JSONList jsonList);
	
	T visitPair(JSONObject jsonPair);
}

class JSONToNumber
		implements JSONVisitor<Integer>, IFunc<JSON, Integer>{

	@Override
	public Integer visitBlank(JSONBlank blank) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer visitNumber(JSONNumber number) {
		// TODO Auto-generated method stub
		return number.number;
	}

	@Override
	public Integer visitStringLength(JSONString stringLength) {
		// TODO Auto-generated method stub
		return stringLength.str.length();
	}

	@Override
	public Integer visitBoolean(JSONBool boolCheck) {
		// TODO Auto-generated method stub
		boolean bool = boolCheck.bool;
		if (bool) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public Integer apply(JSON input) {
		// TODO Auto-generated method stub
		return input.accept(this);
	}


	@Override
	public Integer visitList(JSONList jsonList) {
	    return jsonList.values.foldr(new SumJSON(), 0);
	}

	@Override
	public Integer visitPair(JSONObject jsonPair) {
		// TODO Auto-generated method stub
	return jsonPair.pairs.foldr(new SumPairJSON(), 0);
	}
	
}

class JSONFind implements JSONVisitor<JSON> {
	String ref;
	
	JSONFind(String ref) {
		this.ref = ref; 
	}

	@Override
	public JSON visitBlank(JSONBlank blank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSON visitNumber(JSONNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSON visitStringLength(JSONString stringLength) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSON visitBoolean(JSONBool boolCheck) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSON visitList(JSONList jsonList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSON visitPair(JSONObject jsonPair) {
		// TODO Auto-generated method stub
		return jsonPair.pairs.foldr(new FindInList(ref), new JSONBlank());
	}
}