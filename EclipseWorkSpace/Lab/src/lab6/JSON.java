package lab6;

public interface JSON {
	<R> R accept(JSONVisitor<R> json);
}
 
// no value
class JSONBlank implements JSON {

	@Override
	public <R> R accept(JSONVisitor<R> json) {
		// TODO Auto-generated method stub
		return json.visitBlank(this);
	}
}

 
// a number
class JSONNumber implements JSON {
  int number;
 
  JSONNumber(int number) {
    this.number = number;
  }

	@Override
	public <R> R accept(JSONVisitor<R> json) {
		// TODO Auto-generated method stub
		return json.visitNumber(this);
	}
}
 
// a boolean
class JSONBool implements JSON {
  boolean bool;
 
  JSONBool(boolean bool) {
    this.bool = bool;
  }

	@Override
	public <R> R accept(JSONVisitor<R> json) {
		// TODO Auto-generated method stub
		return json.visitBoolean(this);
	}
}
 
// a string
class JSONString implements JSON {
  String str;
 
  JSONString(String str) {
    this.str = str;
  }

	@Override
	public <R> R accept(JSONVisitor<R> json) {
		// TODO Auto-generated method stub
		return json.visitStringLength(this);
	}
}//a list of JSON values

class JSONList implements JSON {
	IList<JSON> values;
	
	JSONList(IList<JSON> values){
		this.values = values;
	}

	@Override
	public <R> R accept(JSONVisitor<R> json) {
		// TODO Auto-generated method stub
		return json.visitList(this);
	}
}
class JSONObject implements JSON {
  IList<Pair<String, JSON>> pairs;
  
  JSONObject(IList<Pair<String, JSON>> pairs) {
    this.pairs = pairs;
  }
	@Override
	public <R> R accept(JSONVisitor<R> json) {
		// TODO Auto-generated method stub
		return json.visitPair(this);
	}
}

class Pair<X, Y> {
  X x;
  Y y;
 
  Pair(X x, Y y) {
    this.x = x;
    this.y = y;
  }
}
