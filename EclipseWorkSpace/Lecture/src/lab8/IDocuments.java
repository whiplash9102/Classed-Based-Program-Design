package lab8;

import tester.*;
public interface IDocuments {
	IDocuments sortBiblography();
	IDocuments removeDuplicates();
}


class Book implements IDocuments {
	String author;
	String title;
	String publisher;
	ILoList bibliography;
	
	Book(String author, String title, String publisher, ILoList bibliography){
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.bibliography = bibliography;
	}

	@Override
	public IDocuments sortBiblography() {
		// TODO Implementing the sortBiblography in here
		this.bibliography = this.bibliography.sort();
		return this;
	}
	
	public IDocuments removeDuplicates() {
		// ILoList -> ILoList
		// check the duplicated in the bibliography to remove
		this.bibliography = this.bibliography.removeDuplicates();
		return this;
	}
}

class Wiki implements IDocuments {
	String author;
	String title;
	String URL;
	ILoList bibliography;
	
	Wiki(String author, String title, String URL, ILoList bibliography){
		this.author = author;
		this.title = title;
		this.URL = URL;
		this.bibliography = bibliography;
	}

	@Override
	public IDocuments sortBiblography() {
		// TODO Auto-generated method stub
		this.bibliography = this.bibliography.sort();
		return this;
	}
	
	public IDocuments removeDuplicates() {
		this.bibliography = this.bibliography.removeDuplicates();
		return this;
	}
}

class ExamplesDocuments{
	
	IDocuments book1 = new Book("Smith, John", "Understanding Java","Tech Press", new MtList());
	IDocuments book3 = new Book(
       "Brown, Alice",
       "Data Structures",
       "LearnMore",
       new ConsLoList("Smith, John. Understanding Java", new MtList()));
	
	IDocuments wiki1 = new Wiki("Anonymous", "Java, How to make it", "https://java.example.com",
			new ConsLoList("Smith, John. Understanding Java", 
					new ConsLoList("Brown, Alice. Data Structures",
							new MtList())));
	
	IDocuments wiki2 = new Wiki("Anonymous", "Java, How to make it", "https://java.example.com",
			new ConsLoList("Smith, John. Understanding Java", 
					new ConsLoList("Brown, Alice. Data Structures",
							new ConsLoList("Smith, John. Understanding Java", 
									new MtList()))));
	
	ILoList biblography1 = new ConsLoList("Smith, John. Understanding Java", 
			new ConsLoList("Brown, Alice. Data Structures",
					new ConsLoList("Andrea, Aybar. Please remember",
							new MtList())));
	
	boolean testSortBiblography(Tester t) {
		return t.checkExpect(wiki1.sortBiblography(), new Wiki("Anonymous", "Java, How to make it", "https://java.example.com",
				new ConsLoList("Brown, Alice. Data Structures",
						new ConsLoList("Smith, John. Understanding Java", new MtList()))));
	}
	// check the sort function for the bibliography
	boolean testerSort(Tester t) {
		return t.checkExpect(biblography1.sort(),
				new ConsLoList("Andrea, Aybar. Please remember",
						new ConsLoList("Brown, Alice. Data Structures",
								new ConsLoList("Smith, John. Understanding Java",
										new MtList()))));
	}
	
	boolean testerRemoveDuplicates(Tester t) {
		return t.checkExpect(wiki2.removeDuplicates(), new Wiki("Anonymous", "Java, How to make it", "https://java.example.com",
				new ConsLoList("Smith, John. Understanding Java", 
						new ConsLoList("Brown, Alice. Data Structures",
								new MtList()))));
	}
}

