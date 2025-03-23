package lab15;


public interface IPred<T> {
	boolean apply(T t);
}

interface IFunc<A1, A2, R> {
	R apply (A1 a1, A2 a2);
}

class IsPosUnder50 implements IPred<Runner> {
	public boolean apply(Runner r) {
		return r.pos <= 50;
	}
}

class BookByAuthor implements IPred<Book> {
	public boolean apply(Book b) {
		return b.title.equals("ABC");
	}
}

interface IComPare<T> {
	int compare(T t1, T t2);
}

class sortByTime implements IComPare<Runner> {
	public int compare(Runner r1, Runner r2) {
		return r1.time -r2.time;
	}
}

interface IFunction<A, R> {
	R apply (A a);
}

class RunnerToAge implements IFunction<Runner, Integer> {
	public Integer apply(Runner r) {
		return r.age;
	}
	
class TotalRunnerAge implements IFunc<Runner, Integer, Integer> {
	
	public Integer apply(Runner r, Integer sum) {
		return r.age + sum;
	}
}
}
