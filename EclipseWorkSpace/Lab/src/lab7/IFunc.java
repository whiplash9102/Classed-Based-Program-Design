package lab7;
interface BiFunction<T, U, R> {
	R apply(T x, U y);
}

interface Function<T, R> {
	R apply(T t);
}

interface IArithVisitor<R> {
	R visitConst(Const c);
	R visitUnary(UnaryFormula u);
	R visitBinary(BinaryFormula c);
	
	// method apply to all like default
	R apply(IArith arith);
}

class EvalFunction implements IArithVisitor<Double> {

	@Override
	public Double visitConst(Const c) {
		// TODO Auto-generated method stub
		return c.num;
	}

	@Override
	public Double visitUnary(UnaryFormula u) {
		double value = u.child.accept(this);
		if (u.name.equals("sqrt")) {
			return value * value;
		} else if (u.name.equals("nega")) {
			return -value;
		} else {
			throw new IllegalArgumentException("Unknow unary operation " + u.name);
		}
	}

	@Override
	public Double visitBinary(BinaryFormula c) {
	// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double apply(IArith arith) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
