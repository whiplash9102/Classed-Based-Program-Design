package lab19;

import tester.*;
class Person {
	String name;
	int phone;
	Person(String name, int phone) {
		this.name = name;
		this.phone = phone;	
		}
	
	boolean samePerson(Person that) {
		return this.name.equals(that.name) && this.phone == that.phone;
	}
	
	void changeNum(int newNum) {
		this.phone = newNum;
	}
	
}

class ExamplePerson {
	Person anne ;
  Person bob ;
  Person clyde;
  Person dana; 
  Person eric ;
  Person frank ;
  Person henry;
  Person gail;
  Person irene ;
  Person jenny ;
  IList<Person> listName;
 
  ILoPerson friends, family, work;
  void initData() {
  	 anne = new Person("Anne", 1234);
    bob = new Person("Bob", 3456);
    clyde = new Person("Clyde", 6789);
    dana = new Person("Dana", 1357);
    eric = new Person("Eric", 12469);
    frank = new Person("Frank", 7294);
    gail = new Person("Gail", 9345);
    henry = new Person("Henry", 8602);
    irene = new Person("Irene", 91302);
    jenny = new Person("Jenny", 8675309);
    
    listName = new ConsList<>(anne, new ConsList<>(bob,
    													new ConsList<>(dana, new MtList<>())));
    
    this.friends =
      new ConsLoPerson(this.anne, new ConsLoPerson(this.clyde,
        new ConsLoPerson(this.gail, new ConsLoPerson(this.frank,
          new ConsLoPerson(this.jenny, new MtLoPerson())))));
    this.family =
      new ConsLoPerson(this.anne, new ConsLoPerson(this.dana,
        new ConsLoPerson(this.frank, new MtLoPerson())));
    this.work =
      new ConsLoPerson(this.bob, new ConsLoPerson(this.clyde,
        new ConsLoPerson(this.dana, new ConsLoPerson(this.eric,
          new ConsLoPerson(this.henry, new ConsLoPerson(this.irene,
            new MtLoPerson()))))));
  }
  
  void testFindPhoneNum(Tester t) {
  	this.initData();
  	t.checkExpect(this.friends.contains("Frank"), true);
  	t.checkExpect(this.friends.contains("T"), false);
  }
  
  void testFindPhone(Tester t) {
  	this.initData();
  	t.checkExpect(this.friends.findPhoneNum("Anne"), 1234);
  	t.checkExpect(this.friends.findPhoneNum("Anne"), this.family.findPhoneNum("Anne"));
  }
  
  void testFindPhoneNum1(Tester t) {
  	this.initData();
  	this.friends.changePhone("Anne", 4567);
  	t.checkExpect(this.friends.findPhoneNum("Anne"), 4567);
  	t.checkExpect(this.work.findPhoneNum("Anne"), -1);
  	t.checkExpect(this.friends.findPhoneNum("Anne"), this.family.findPhoneNum("Anne"));
  }
  void testFind(Tester t) {
  	this.initData();
  	t.checkExpect(listName.find(new findPhone("Anne")), anne);
  }
  
  void testPhoneUpdate(Tester t) {
  	this.initData();
  	t.checkExpect(listName.findUpdate(new findPhone("Anne"), new PhoneUpdate(4567)), null);
  	t.checkExpect(this.anne.phone, 4567);
  }
}