

public interface IArith {
	<R> R accept(IArithVisitor<R> visitor);
}

class Const implements IArith { 
	double num;
	
	Const(double num) {
		this.num = num;
	}

	@Override
	public <R> R accept(IArithVisitor<R> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
}

class UnaryFormula implements IArith {
	Function<Double, Double> func;
	String name;
	IArith child;
	
	UnaryFormula(Function<Double, Double> func, String name, IArith child){
		this.func = func;
		this.name = name;
		this.child = child;
	}

	@Override
	public <R> R accept(IArithVisitor<R> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
}

class BinaryFormula implements IArith {
	BiFunction<Double, Double, Double> func;
	String name;
	IArith left;
	IArith right;
	
	BinaryFormula(BiFunction<Double, Double, Double> func, String name, IArith left, IArith right){
		this.func = func; 
		this.name = name;
		this.left = left;
		this.right = right;
	}

	@Override
	public <R> R accept(IArithVisitor<R> visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
}