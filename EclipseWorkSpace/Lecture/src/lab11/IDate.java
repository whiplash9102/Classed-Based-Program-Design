package lab11;
import tester.*;

public interface IDate {
}

class Date implements IDate {
	int day;
	int month;
	int year;
	
	Date(int day, int month, int year){
		this.day = Utils(day, 31, 1, "Invalid day: " + day);
		this.month = Utils(month, 12, 1, "Invalid month: " + month);
		this.year = Utils(year, year + 1, 0, "Invalid year: " + year);
	}
	
	Date(int day,int month){
		this(day, month, 2022);
	}
	int Utils(int num, int max, int min, String msg) {
		if (num >= min && num <= max) {
			return num;
		} else {
			throw new IllegalArgumentException(msg);
		}
	}
}

class ExamplesDate{
	IDate date1 = new Date(3, 12, 2002);
	
	
	boolean testIDate(Tester t) {
		return t.checkConstructorException(
				new IllegalArgumentException("Invalid day: -5"),
				"Date",
				date1);
	}
}