package lab13;

public interface IRunnerPredicate {
	boolean apply(Runner r);
}

class RunnerIsMale implements IRunnerPredicate{
	RunnerIsMale(){
	}
	
	public boolean apply(Runner r) {
		return r.isMale;
	}
}

class RunnerIsFemale implements IRunnerPredicate {
	RunnerIsFemale(){}
	
	public boolean apply(Runner r) {
		return !r.isMale;
	}
}

class UnderPos50Runner implements IRunnerPredicate {
	UnderPos50Runner(){}
	
	public boolean apply(Runner r) {
		return r.pos <= 50;
	}
}

class combinePredicate implements IRunnerPredicate {
	IRunnerPredicate left;
	IRunnerPredicate right;
	
	combinePredicate(IRunnerPredicate left, IRunnerPredicate right){
		this.left = left; 
		this.right = right;
	}
	
	public boolean apply(Runner r) {
		return this.left.apply(r) && this.right.apply(r);
	}
}
