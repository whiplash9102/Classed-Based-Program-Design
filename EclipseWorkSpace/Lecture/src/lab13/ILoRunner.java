package lab13;
import tester.*;
public interface ILoRunner {
	ILoRunner find(IRunnerPredicate predicate);
}

class MtLoRunner implements ILoRunner {
	public ILoRunner find(IRunnerPredicate predicate) {
		return new MtLoRunner(); 
	}
}

class ConsLoRunner implements ILoRunner {
	Runner first;
	ILoRunner rest;
	
	ConsLoRunner(Runner first, ILoRunner rest){
		this.first = first;
		this.rest = rest;
	}

	@Override
	public ILoRunner find(IRunnerPredicate predicate) {
		if (predicate.apply(first)) {
			return new ConsLoRunner(first, this.rest.find(predicate));
		} else {
			return rest.find(predicate);
		}
	}
	
}
	
class ExamplesRunner{
//In Examples class
Runner johnny = new Runner("Kelly", 97, 999, true, 30, 360);
Runner frank  = new Runner("Shorter", 32, 888, true, 245, 130);
Runner bill = new Runner("Rogers", 36, 777, true, 119, 129);
Runner joan = new Runner("Benoit", 29, 444, false, 18, 155);

ILoRunner mtlist = new MtLoRunner();
ILoRunner list1 = new ConsLoRunner(johnny, new ConsLoRunner(joan, mtlist));
ILoRunner list2 = new ConsLoRunner(frank, new ConsLoRunner(bill, list1));

//In Examples class
boolean testFind(Tester t) {
	return t.checkExpect(list1.find(new RunnerIsMale()),
			new ConsLoRunner(johnny, new MtLoRunner()));
}

boolean testAndPredicate(Tester t) {
	return t.checkExpect(list1.find(new combinePredicate(
			new UnderPos50Runner(), new RunnerIsMale())), new ConsLoRunner(johnny, new MtLoRunner()));
			}
}


