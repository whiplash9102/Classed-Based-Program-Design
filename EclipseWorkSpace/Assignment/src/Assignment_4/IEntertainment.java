

import tester.Tester;

public interface IEntertainment {
	double totalPrice();
	String format();
	int duration();
	boolean sameEntertainment(IEntertainment that);
	boolean sameMagazine(Magazine that);
	boolean sameTVSeries(TVSeries that);
	boolean samePodcast(Podcast that);
}

abstract class AEntertainment implements IEntertainment {
	String name;
	double price;
	int installments;
	AEntertainment(String name, double price, int installments){
		this.name = name;
		this.installments = installments;
		this.price = price;
	}
	
	public double totalPrice() {
		return this.price * this.installments;
	}
	
	public String format() {
		return this.name + ", " + this.price + ".";
	}
	public int duration() {
		return this.installments * 50;
	}
	
	// default case
	public boolean sameMagazine(Magazine that) {
		return false;
	}
	public boolean sameTVSeries(TVSeries that) {
		return false;
	}
	public boolean samePodcast(Podcast that) {
		return false;
	}
}

// Magazine class constructor
class Magazine extends AEntertainment {
	String genre;
	int pages;
	
	Magazine(String name, double price, String genre, int pages, int installments){
		super(name, price, installments);
		this.genre = genre;
		this.pages = pages;
	}
	
	public int duration() {
		return this.pages * 5 * this.installments;
	}

	@Override
	public boolean sameEntertainment(IEntertainment that) {
		// TODO Auto-generated method stub
		return that.sameMagazine(this);
	}
	//helper method
	public boolean sameMagazine(Magazine that) {
		return this.name.equals(that.name) &&
				this.price == that.price &&
				this.genre.equals(that.genre) &&
				this.pages == that.pages &&
				this.installments == that.installments;
	}
}

// TV Series Class Constructor
class TVSeries extends AEntertainment {
	String coporation;
	
	TVSeries(String name, double price, int installments, String coporation){
		super(name, price, installments);
		this.coporation = coporation;
	}

	@Override
	public boolean sameEntertainment(IEntertainment that) {
		// TODO Auto-generated method stub
		return that.sameTVSeries(this);
	}
	//helper method
	public boolean sameTVSeries(TVSeries tv) {
		return this.name.equals(tv.name)
				&& this.price == tv.price
				&& this.installments == tv.installments
				&& this.coporation.equals(tv.coporation);
	}
}

// Podcast class constructor
class Podcast extends AEntertainment {
	Podcast(String name, double price, int installments){
		super(name, price, installments);
	}
	@Override
	public boolean sameEntertainment(IEntertainment that) {
		// TODO Auto-generated method stub
		return that.samePodcast(this);
	}	
	//helper method
	public boolean samePodcast(Podcast p) {
		return this.name.equals(p.name)
				&& this.price == p.price
				&& this.installments == p.installments;
	}

}
class ExamplesEntertainment {
  IEntertainment rollingStone = new Magazine("Rolling Stone", 2.55, "Music", 60, 12);
  IEntertainment houseOfCards = new TVSeries("House of Cards", 5.25, 13, "Netflix");
  IEntertainment serial = new Podcast("Serial", 0.0, 8);
  
  // my own examples
  IEntertainment tuoiTre = new Magazine("Bao tuoi tre", 2.02, "Student", 30, 20);
  IEntertainment bigBangTheory = new TVSeries("BigBang Theory", 3.00, 12, "Netflix");
  IEntertainment yCombinator = new Podcast("YCombinator",0, 9);
  
  //testing total price method
  boolean testTotalPrice(Tester t) {
      return t.checkInexact(this.rollingStone.totalPrice(), 2.55*12, .0001) 
      && t.checkInexact(this.houseOfCards.totalPrice(), 5.25*13, .0001)
      && t.checkInexact(this.serial.totalPrice(), 0.0, .0001)
      && t.checkInexact(this.tuoiTre.totalPrice(), 2.02 * 20, .0001)
      && t.checkInexact(this.bigBangTheory.totalPrice(), 3.00 * 12, .0001);
  }
  
  boolean testSameEntertainment(Tester t) {
  	return t.checkExpect(this.rollingStone.sameEntertainment(bigBangTheory), false)
  			&& t.checkExpect(this.rollingStone.sameEntertainment(rollingStone), true);
  }
}
