interface BiFunction<T, U, R> {
	R apply(T x, U y);
}

interface Function<T, R> {
	R apply(T t);
}

interface IArithVisitor<R> {
	R visit(Const c);
	R visit(UnaryFormula u);
	R visit(BinaryFormula c);
	
	// Method to use visitor as a function 
	R apply(IArith arith);
}

class add implements BiFunction<Double, Double, Double> {

	@Override
	public Double apply(Double x, Double y) {
		return x + y;
	}
	
}