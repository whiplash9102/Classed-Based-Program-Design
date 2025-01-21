package lab8;
import tester.*;

public class EmbroideryPiece { 
	String name;
	Motifs motifs;
	
	// constructor function
	EmbroideryPiece(String name, Motifs motifs){
		this.name = name;
		this.motifs = motifs;
		}
	double mainAverageMotifs() {
		double totalMotifs = this.motifs.averageMotifs();
		double countMotifs = this.motifs.countAll();
		
		return Math.round(totalMotifs/countMotifs * 100.0)/100.0;
	}
	
	String embroideryInfo() {
		return this.name.concat(": " + this.motifs.convertString() +".");
	}
}

// Create the interface of the class

interface Motifs {
	double averageMotifs();
	double countAll();
	String convertString();
}

class CrossStichMotif implements Motifs {
	String description;
	double difficulty;
	
	// Constructor
	CrossStichMotif(String description, double difficulty){
		this.description = description;
		this.difficulty = difficulty;
	}

	@Override
	public double averageMotifs() {
		// TODO Auto-generated method stub
		return this.difficulty;
	}

	@Override
	public double countAll() {
		// TODO Auto-generated method stub
		return 1.0;
	}

	@Override
	public String convertString() {
		// TODO Auto-generated method stub
		return this.description + " ( cross stich )";
	}
}

class ChainStichMotif implements Motifs { 
	String description;
	double difficulty;
	
	ChainStichMotif(String description, double difficulty){
		this.description = description;
		this.difficulty = difficulty;
	}

	@Override
	public double averageMotifs() {
		// TODO Auto-generated method stub
		return this.difficulty;
	}

	@Override
	public double countAll() {
		// TODO Auto-generated method stub
		return 1.0;
	}

	@Override
	public String convertString() {
		// TODO Auto-generated method stub
		return this.description + " ( chain stich )";
	}
}

class GroupMotifs implements Motifs {
	String description;
	ILoMotifs list;
	
	// Constructor
	GroupMotifs(String description, ILoMotifs list){
		this.description = description;
		this.list = list;
	}

	@Override
	public double averageMotifs() {
		// TODO Auto-generated method stub
		return this.list.averageMotifs();
	}

	@Override
	public double countAll() {
		// TODO Auto-generated method stub
		return this.list.countAll();
	}

	@Override
	public String convertString() {
		// TODO Auto-generated method stub
		return list.convertListString();
	}
}

// Constructor for the example EmbroideryPiece
class ExamplesEmbroideryPiece {
	CrossStichMotif rose = new CrossStichMotif("Rose", 4.5);
	CrossStichMotif daisy = new CrossStichMotif("Daisy", 3.2);
	ChainStichMotif poppy = new ChainStichMotif("Poppy", 4.75);
	
	ILoMotifs listnature = new ConsLoMotifs(rose, new ConsLoMotifs(daisy, new ConsLoMotifs(poppy, new MtList())));
	Motifs nature = new GroupMotifs("nature", listnature);
	EmbroideryPiece pillowcover = new EmbroideryPiece("Pillow Cover", nature);
	
	boolean testCountAll(Tester t) {
		return t.checkExpect(nature.countAll(), 3.0);
	}
	
	boolean testAveragePrice(Tester t) {
		return t.checkExpect(pillowcover.mainAverageMotifs(),4.15);
	}
	boolean testEmbroideryInfo(Tester t) {
		return t.checkExpect(pillowcover.embroideryInfo(), "Pillow Cover: Rose ( cross stich ), Daisy ( cross stich ), Poppy ( chain stich ).");
	}
	boolean testConvertString(Tester t) {
		return t.checkExpect(rose.convertString(), "Rose ( cross stich )");
	}
}