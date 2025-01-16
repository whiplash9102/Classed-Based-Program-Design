package Assignment_1;

import tester.*;

public class ExamplesDogs {
  Dog huffle = new Dog("Hufflepuff", "Wheaten Terrier", 2012, "TX", true);
  Dog pearl = new Dog("Pearl", "Labrador Retriever", 2016, "MA", false);
  Dog max = new Dog("Max", "Golden Retriever", 2018, "CA", false);
  
  boolean testDogAttributes(Tester t) {
    return t.checkExpect(huffle.name, "Hufflepuff")
        && t.checkExpect(huffle.breed, "Wheaten Terrier")
        && t.checkExpect(huffle.yob, 2012)
        && t.checkExpect(huffle.state, "TX")
        && t.checkExpect(huffle.hypoallergenic, true);

  }
}
