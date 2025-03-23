import tester.*;

class Course {
	String name;
	Instructor prof;
	IList<Student> students;

	Course(String name, Instructor prof) {
		this.name = name;
		this.prof = prof;
		this.students = new MtList<Student>();
		this.prof.courses = this.prof.courses.add(this);
	}
}

class Instructor {
	String name;
	IList<Course> courses;

	Instructor(String name) {
		this.name = name;
		this.courses = new MtList<Course>();
	}
	
	boolean dejavu(Student c) {
		return c.courses.sameHelperTwice(this.courses);
	}
}

class Student {
	String name;
	int id;
	IList<Course> courses;

	Student(String name, int id) {
		this.name = name;
		this.id = id;
		this.courses = new MtList<Course>();
	}

	void enroll(Course c) {
		if (this.courses.contains(c)) {
			throw new RuntimeException("This course already enrolled by student");
		}
		else {
			this.courses = this.courses.add(c);
		}
	}
	
	boolean classmate(Student c) {
		return this.courses.sameHelper(c.courses);
	}
}

class ExamplesClass {
	Student carla;
	Student john;
	Student thomas;

	Course javaCourse;
	Course pythonCourse;
	Course cCourse;
	Course MMusic;

	Instructor maya;
	Instructor jayg;
	Instructor defer;
	Instructor thanhp;

	void initData() {
		john = new Student("John", 234);
		carla = new Student("Carla", 123);
		thomas = new Student("Thomas", 345);
		
		jayg = new Instructor("P.Thanh");
		maya = new Instructor("R.Feller");
		defer = new Instructor("Defer");
		thanhp = new Instructor("ThanhP");
		
		cCourse = new Course("C++ Course", defer);
		MMusic = new Course("Music Course", thanhp);
		javaCourse = new Course("Java Programming", maya);
		pythonCourse = new Course("Python Programming", maya);
	}
	
	void testUpdate(Tester t) {
		initData();
		t.checkExpect(john.courses.contains(pythonCourse), false);
		john.enroll(javaCourse);
		t.checkExpect(john.courses.contains(javaCourse), true);
	}
	
	void testClassmate(Tester t) {
		initData();
		john.enroll(javaCourse);
		carla.enroll(javaCourse);
		t.checkExpect(john.classmate(carla), false);
		t.checkExpect(thomas.classmate(carla), false);
	}
	
	void testDejavu(Tester t) {
		initData();
	}
	
	void testCountHelepr(Tester t) {
		initData();
		t.checkExpect(maya.dejavu(carla), false);
		carla.enroll(javaCourse);
		carla.enroll(pythonCourse);
		t.checkExpect(maya.dejavu(carla), true);
	}
}