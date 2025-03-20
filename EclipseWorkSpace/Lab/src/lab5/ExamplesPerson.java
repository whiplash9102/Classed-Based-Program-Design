package lab1;
import java.util.ArrayList;
import java.util.List;

public class ExamplesPerson {
	
	//Address instances
	Address boston = new Address("Boston", "MA");
	Address warwick = new Address("Warwick", "RI");
	Address nashua = new Address("Nashua", "NH");
	
	Person tim = new Person("Tim", 23, "Male", boston);
	Person kata = new Person("Kate", 22, "Female", warwick);
	Person rebeca = new Person("Rebecca", 31, "Non-binary", nashua);
	
	
	//Method to return all person details
	public List<String> getAllPersonDetails(){
		List<String> details = new ArrayList<>();
		details.add(tim.toString());
		details.add(kata.toString());
		details.add(rebeca.toString());
		return details;
	}
	
	//Test output
	public static void main(String[] args ) {
		ExamplesPerson examples = new ExamplesPerson();
		
		//Get all person details
		List<String> details = examples.getAllPersonDetails();
		for (String detail : details) {
			System.out.println(detail);
		}
	}
}
