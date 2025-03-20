package lab1;
import tester.*;

interface IEntertainment {
    //compute the total price of this Entertainment
    double totalPrice();
    //computes the minutes of entertainment of this IEntertainment
    int duration();
    //produce a String that shows the name and price of this IEntertainment
    String format();
    //is this IEntertainment the same as that one?
    boolean sameEntertainment(IEntertainment that);
}

class Magazine implements IEntertainment {
    String name;
    double price; //represents price per issue
    String genre;
    int pages;
    int installments; //number of issues per year
    
    Magazine(String name, double price, String genre, int pages, int installments) {
        this.name = name;
        this.price = price;
        this.genre = genre;
        this.pages = pages;
        this.installments = installments;
    }
    
    //computes the price of a yearly subscription to this Magazine
    public double totalPrice() {
        return this.price * this.installments;
    }
    
    //computes the minutes of entertainment of this Magazine, (includes all installments)
    public int duration() {
        return 5;
    }
    
    //is this Magazine the same as that IEntertainment?
    public boolean sameEntertainment(IEntertainment that) {
    	if (that instanceof Magazine) {
    		Magazine m = (Magazine) that;
    		return this.name.equals(m.name)
    				&& this.price == m.price
    				&& this.genre == m.genre
    				&& this.pages == m.pages
    				&& this.installments == m.installments;
    	} else {
    		return false;
    	}
    }
    
    //produce a String that shows the name and price of this Magazine
    public String format() {
        return this.name + " " + this.price;
    }
}

class TVSeries implements IEntertainment {
    String name;
    double price; //represents price per episode
    int installments; //number of episodes of this series
    String corporation;
    
    TVSeries(String name, double price, int installments, String corporation) {
        this.name = name;
        this.price = price;
        this.installments = installments;
        this.corporation = corporation;
    }
    
    //computes the price of a yearly subscription to this TVSeries
    public double totalPrice() {
        return this.price * this.installments;
    }
    
    //computes the minutes of entertainment of this TVSeries
    public int duration() {
        return 50;
    }
    
    //is this TVSeries the same as that IEntertainment?
    public boolean sameEntertainment(IEntertainment that) {
      if (that instanceof TVSeries) {
      	TVSeries t = (TVSeries) that;
      	return this.name.equals(t.name) &&
      			this.price == t.price &&
      			this.installments == t.installments &&
      			this.corporation == t.corporation;
      } else {
      	return false;
      }
    }
    
    //produce a String that shows the name and price of this TVSeries
    public String format() {
        return this.name + " " + this.price;
    }
}

class Podcast implements IEntertainment {
    String name;
    double price; //represents price per issue
    int installments; //number of episodes in this Podcast
    
    Podcast(String name, double price, int installments) {
        this.name = name;
        this.price = price;
        this.installments = installments;
    }
    
    //computes the price of a yearly subscription to this Pod cast
    public double totalPrice() {
        return this.price * this.installments;
    }
    
    //computes the minutes of entertainment of this Pod cast 
    public int duration() {
        return 50;
    }
    
    //is this Podcast the same as that IEntertainment?
    public boolean sameEntertainment(IEntertainment that) {
        if (that instanceof Podcast) {
        	Podcast p = (Podcast) that;
        	return p.name.equals(this.name) &&
        			p.price == this.price &&
        			p.installments == this.installments;
        } else {
        	return false;
        }
    }
    
    //produce a String that shows the name and price of this Podcast
    public String format() {
        return this.name + " " + this.price;
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
    	return t.checkExpect(yCombinator.sameEntertainment(bigBangTheory), false) &&
    			t.checkExpect(bigBangTheory.sameEntertainment(bigBangTheory), true);
    }
}