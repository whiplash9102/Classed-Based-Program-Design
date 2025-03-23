package lab18;

class Course {
	String department;
	int ID;
	Instructor instructor;
	IList<Student> students;
	
	Course(String department, int ID, Instructor instructor ){
		this.department = department;
		this.ID = ID;
		this.instructor = instructor;
		this.students = new MtList<Student>();
		instructor.addCourse(this);
	}
	
	void addStudent(Student s) {
		if (this.students.contain(s)) {
			throw new RuntimeException("This student already exist in the course");
		}
		else {
			this.students.append(s);
		}
	}
	
}

class Student {
	String firstName;
	String lastName; 
	IList<Course> courses;
	
	Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = new MtList<Course>();
		
	}
	
	void enroll(Course course) {
		if (this.courses.contain(course)) {
			throw new RuntimeException("This course already enrolled by the student");
		} else {
			this.courses.append(course);
		}
	}
}

class Instructor {
	String firstName;
	String lastName;
	IList<Course> courses;
	
	Instructor(String firstName, String lastName, Course courses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = new MtList<Course>();

	}
	
	void addCourse(Course c) {
		if (this.courses.contain(c)) {
			throw new RuntimeException("This instructor already add in the course");
		} else {
			this.courses.append(c);
		}
	}
}

public class ExampleClasses {
	
}