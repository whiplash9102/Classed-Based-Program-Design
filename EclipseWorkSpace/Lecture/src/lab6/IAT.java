package lab6;

import tester.Tester;

public interface IAT {
	int count();
	int countHelper();
	int countFemaleAnCOver40();
	int countFemaleHelper();
	boolean wellFormed();
	boolean wellFormeHelper(int childYob);
	IAT youngestAncAtGen(int gen);
	IAT youngerIATHelper(IAT other, int otherYob);
	IAT youngerIAT(IAT person);
	IAT youngestParent();	
	IAT youngestGrandparent();
}

class Unknown implements IAT {
	Unknown() {
	}

	public int count() {
		return 0;
	}

	public int countHelper() {
		return 0;
	}

	public int countFemaleAnCOver40() {
		return 0;
	}

	public int countFemaleHelper() {
		return 0;
	}

	public int numTotalGens() {
		return 0;
	}

	public boolean wellFormed() {
		return true;
	}

	public boolean wellFormeHelper(int childYob) {
		return true;
	}

	@Override
	public IAT youngestAncAtGen(int gen) {
		if (gen == 0) {
			return this;
		} else {
			return new Unknown();
		}
	}

	public IAT youngerIAT(IAT other) {
		return other;
	}
	
	public IAT youngestParent() {
		return new Unknown();
	}

	@Override
	public IAT youngerIATHelper(IAT other, int otherYob) {
		// TODO Auto-generated method stub
		return other;
	}

	@Override
	public IAT youngestGrandparent() {
		// TODO Auto-generated method stub
		return new Unknown();
	}
}

class Person implements IAT {
	String name;
	int yob;
	boolean isMale;
	IAT mom;
	IAT dad;

	Person(String name, int yob, boolean isMale, IAT mom, IAT dad) {
		this.name = name;
		this.yob = yob;
		this.isMale = isMale;
		this.mom = mom;
		this.dad = dad;
	}

	public int count() {
		return mom.countHelper() + dad.countHelper();
	}

	public int countHelper() {
		return 1 + mom.countHelper() + dad.countHelper();
	}

	public int countFemaleAnCOver40() {
		if (!this.isMale && 2015 - this.yob > 40) {
			return 1 + countFemaleHelper();
		}
		else {
			return countFemaleHelper();
		}
	}

	public int countFemaleHelper() {
		return mom.countFemaleAnCOver40() + dad.countFemaleAnCOver40();
	}

	public boolean wellFormed() {
		return this.mom.wellFormeHelper(this.yob) && this.dad.wellFormeHelper(this.yob)
				&& this.mom.wellFormed() && this.dad.wellFormed();
	}

	public boolean wellFormeHelper(int childYob) {
		return this.yob < childYob;
	}

	@Override
	public IAT youngestAncAtGen(int gen) {
		// TODO Auto-generated method stub
		if (gen == 0) {
			return this;
		} else if (gen == 1){
			return this.youngestParent();
		} else if (gen == 2) {
			return this.youngestGrandparent();
		} else {
			return this.mom.youngestAncAtGen(gen - 1).youngerIAT(this.dad.youngestAncAtGen(gen - 1));
		}
	}

	public IAT youngerIAT(IAT other) {
		return other.youngerIATHelper(this, this.yob);
	}

	@Override
	public IAT youngerIATHelper(IAT other, int otherYob) {
		// TODO Auto-generated method stub
		if (this.yob > otherYob) {
			return this;
		}
		else {
			return other;
		}
	}

	@Override
	public IAT youngestParent() {
		// TODO Auto-generated method stub
		return this.mom.youngerIAT(this.dad);
	}

	@Override
	public IAT youngestGrandparent() {
		// TODO Auto-generated method stub
		return this.mom.youngestParent().youngerIAT(this.dad.youngestParent());
	}

}

class ExamplesIAT {
	IAT enid = new Person("Enid", 1904, false, new Unknown(), new Unknown());
	IAT edward = new Person("Edward", 1902, true, new Unknown(), new Unknown());
	IAT emma = new Person("Emma", 1906, false, new Unknown(), new Unknown());
	IAT eustace = new Person("Eustace", 1907, true, new Unknown(), new Unknown());

	IAT david = new Person("David", 1925, true, new Unknown(), this.edward);
	IAT daisy = new Person("Daisy", 1927, false, new Unknown(), new Unknown());
	IAT dana = new Person("Dana", 1933, false, new Unknown(), new Unknown());
	IAT darcy = new Person("Darcy", 1930, false, this.emma, this.eustace);
	IAT darren = new Person("Darren", 1935, true, this.enid, new Unknown());
	IAT dixon = new Person("Dixon", 1936, true, new Unknown(), new Unknown());

	IAT clyde = new Person("Clyde", 1955, true, this.daisy, this.david);
	IAT candace = new Person("Candace", 1960, false, this.dana, this.darren);
	IAT cameron = new Person("Cameron", 1959, true, new Unknown(), this.dixon);
	IAT claire = new Person("Claire", 1956, false, this.darcy, new Unknown());

	IAT bill = new Person("Bill", 1980, true, this.candace, this.clyde);
	IAT bree = new Person("Bree", 1981, false, this.claire, this.cameron);

	IAT andrew = new Person("Andrew", 2001, true, this.bree, this.bill);

	boolean testCount(Tester t) {
		return t.checkExpect(this.andrew.count(), 16) && t.checkExpect(this.david.count(), 1)
				&& t.checkExpect(this.enid.count(), 0) && t.checkExpect(new Unknown().count(), 0);
	}

	boolean testIATcountFemaleAnCOver40(Tester t) {
		return t.checkExpect(andrew.countFemaleAnCOver40(), 7)
				&& t.checkExpect(bree.countFemaleAnCOver40(), 3)
				&& t.checkExpect(david.countFemaleAnCOver40(), 0);
	}

	boolean testIATwellFormed(Tester t) {
		return t.checkExpect(andrew.wellFormed(), true);
	}

	
	  boolean testIATYoungestAncAtGen(Tester t) { return
	  t.checkExpect(andrew.youngestAncAtGen(0), andrew) &&
	  t.checkExpect(andrew.youngestAncAtGen(1), bree) &&
	  t.checkExpect(andrew.youngestAncAtGen(3), dixon) &&
	  t.checkExpect(andrew.youngestAncAtGen(4), eustace); }
	 

	boolean testIATYoungerIAT(Tester t) {
		return t.checkExpect(bree.youngerIAT(bill), bree)
				&& t.checkExpect(cameron.youngerIAT(candace), candace);
	}
	boolean testIATYoungestParent(Tester t) {
		return t.checkExpect(andrew.youngestParent(), bree);
	}
	boolean testIATYoungestGrandparent(Tester t) {
		return t.checkExpect(andrew.youngestGrandparent(), candace);
	}
}