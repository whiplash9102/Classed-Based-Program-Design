package lab10;
import tester.*;

public interface IInteger {
    // Check if the list satisfies the stricter property
    boolean satisfiesStrictly();

		boolean satisfiesStrictlyHelper(boolean b, boolean c, boolean d);
}

class MtList implements IInteger {
  @Override
  public boolean satisfiesStrictly() {
      return false; // An empty list cannot satisfy all criteria
  }

	@Override
	public boolean satisfiesStrictlyHelper(boolean b, boolean c, boolean d) {
		// TODO Auto-generated method stub
		return false;
	}
}

class ListOfIntegers implements IInteger {
  int first;
  IInteger rest;

  ListOfIntegers(int first, IInteger rest) {
      this.first = first;
      this.rest = rest;
  }

  @Override
  public boolean satisfiesStrictly() {
      return satisfiesStrictlyHelper(false, false, false);
  }

  public boolean satisfiesStrictlyHelper(boolean hasEven, boolean hasOdd, boolean hasInRange) {
      // Base case: if all conditions are satisfied
      if (hasEven && hasOdd && hasInRange) {
          return true;
      }

      // Check the current number for each condition
      boolean currentEven = first % 2 == 0;
      boolean currentOdd = first > 0 && first % 2 != 0;
      boolean currentInRange = first >= 5 && first <= 10;

      // Pass updated flags to the rest of the list
      return rest.satisfiesStrictlyHelper(
          hasEven || currentEven,
          hasOdd || currentOdd,
          hasInRange || currentInRange
      );
  }
}
class ExamplesIInteger {
  IInteger validList1 = new ListOfIntegers(6, new ListOfIntegers(5, new ListOfIntegers(6, new MtList()))); // Valid
  IInteger validList2 = new ListOfIntegers(10, new ListOfIntegers(9, new ListOfIntegers(8, new MtList()))); // Valid
  IInteger invalidList1 = new ListOfIntegers(6, new ListOfIntegers(5, new MtList())); // Invalid
  IInteger invalidList2 = new MtList(); // Invalid (empty list)

  boolean testSatisfiesStrictly(Tester t) {
      return t.checkExpect(validList1.satisfiesStrictly(), true) &&
             t.checkExpect(validList2.satisfiesStrictly(), true) &&
             t.checkExpect(invalidList1.satisfiesStrictly(), false) &&
             t.checkExpect(invalidList2.satisfiesStrictly(), false);
  }
}
