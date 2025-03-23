package lab7;
import tester.*;


// runs tests for the buddies problem
public class ExamplesBuddies{
   Person fay;
   Person gabi; 
   Person clyde;
   Person anna;
   Person bob;
   
   ILoBuddy buddies;
   void initData() {
  	 anna = new Person("Anna");
  	 bob = new Person("Bob");
  	 clyde = new Person("Clyde");
  	 gabi = new Person("Gabi");
  	 fay = new Person("Fay");
  	 
  	 // Test direct buddies
  	 anna.addBuddy(bob);
  	 anna.addBuddy(gabi);
  	 
  	 //Test fay
  	 fay.addBuddy(bob);
  	 fay.addBuddy(clyde);
  	 fay.addBuddy(gabi);
   }
   
   void testAddBuddies(Tester t) {
  	 initData();
  	 t.checkExpect(anna.contain(bob), true);
   }
   
   void testDirectFriend(Tester t) {
  	 initData();
  	 t.checkExpect(anna.hasDirectBuddy(bob), true);
  	 t.checkExpect(anna.hasDirectBuddy(fay), false);
   }
   
   void testCountCommon(Tester t) {
  	 initData();
  	 t.checkExpect(anna.countCommonBuddies(fay), 2);
   }
}