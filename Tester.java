import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		//	// TESTING COURSE CLASS
		Course c1 = new Course(true, 2034 , "MAT", 4);
		Course c2 = new Course(true, 2034 , "MAT", 4);
		Course c3 = new Course(false, 2534 , "SCI", 3);
		//		
		//			
		//		System.out.println(c1.getCourseName());
		//		System.out.println(c2.getCourseName());
		//		System.out.println(c3.getCourseName());
		//		
				System.out.println(c1.equals(c2));
				System.out.println(c2.equals(c3));
				System.out.println(c3.equals(c1));
		//		
		//		System.out.println(c1.toString());
		//		System.out.println(c2.toString());
		//		System.out.println(c3.toString());
		//		
		//		System.out.println(c1.compareTo(c2));
		//		System.out.println(c1.compareTo(c3));
		//		System.out.println(c3.compareTo(c1));

		//		// TESTING Person CLASS
		Person p1 = new Person("eric", 1991);
		Person p2 = new Person("eric", 1991);
		Person p3 = new Person("Pedro", 1997);
		//		
		//		System.out.println(p1.equals(p2));
		//		System.out.println(p2.equals(p1));
		//		System.out.println(p3.equals(p1));
		//		
		//		System.out.println(p1.toString());
		//		System.out.println(p2.toString());
		//		System.out.println(p3.toString());
		//		
		//		System.out.println(p1.compareTo(p2));
		//		System.out.println(p1.compareTo(p3));
		//		System.out.println(p3.compareTo(p1));

		Employee e1 = new Employee("pedro", 1993,"security");
		Employee e2 = new Employee("pedro", 1993,"security");
		Employee e3 = new Employee("elviro", 1990,"janitor");
		//		
		//		System.out.println(e1.toString());
		//		System.out.println(e2.toString());
		//		System.out.println(e3.toString());
		//		
		//		System.out.println(e1.equals(e2));
		//		System.out.println(e2.equals(e1));
		//		System.out.println(e1.equals(e3));
		//		
		//		System.out.println(e1.compareTo(e2));
		//		System.out.println(e1.compareTo(e3));
		//		System.out.println(e3.compareTo(e1));
		//		
		//		System.out.println(e1.getEmployeeID());
		//		System.out.println(e2.getEmployeeID());
		//		System.out.println(e3.getEmployeeID());


		// TESTING FACULTY CLASS
		Faculty f1 = new Faculty("matt",1993,"MAT",true);
		Faculty f2 = new Faculty("matt",1993,"MAT",true);
		Faculty f3 = new Faculty("pitt",1989,"CMP",false);
		Faculty f4 = new Faculty("pedro",1989,"SCI",false);
		//						
		Course cou[] = {c1,c2};
		Course co[] = {c1,c2,c3};
		f1.addCoursesTaught(cou);
		f2.addCoursesTaught(cou);
		f3.addCoursesTaught(co);
//				System.out.println(f1.getCourseTaught(1));
//				System.out.println(f1.equals(f2));
//				System.out.println(f2.equals(f1));
//				System.out.println(f1.equals(f3));
//				
				System.out.println(f1.toString());
				System.out.println(f2.toString());
				System.out.println(f3.toString());
//				
//				System.out.println(f1.compareTo(f2));
//				System.out.println(f2.compareTo(f3));
//				System.out.println(f3.compareTo(f1));

//TESTING GENERAL STAFF CLASS

		GeneralStaff g1 = new GeneralStaff("matt",1993,"MAT","Professor");
		GeneralStaff g2 = new GeneralStaff("matt",1993,"MAT","Professor");
		GeneralStaff g3 = new GeneralStaff("pitt",1989,"CMP","janitor");
//
//		System.out.println(g1.equals(g2));
//		System.out.println(g2.equals(g1));
//		System.out.println(g1.equals(g3));
//
//		System.out.println(g1.toString());
//		System.out.println(g2.toString());
//		System.out.println(g3.toString());
//
//		System.out.println(g1.compareTo(g1));
//		System.out.println(g2.compareTo(g3));
//		System.out.println(g3.compareTo(g1));
//

//TESTING STUDENT CLASS
//		
		Student s1 = new Student("peter",1993,"MATH",true);
		Student s2 = new Student("peter",1993,"MATh",true);
		Student s3 = new Student("eric",1989,"CMP",false);
//		//						
		Course cou2[] = {c1,c2};
		Course co2[] = {c1,c2,c3};
		s1.addCoursesTaken(cou2);
		s2.addCoursesTaken(cou2);
		s3.addCoursesTaken(co2);
//		System.out.println(s1.getCourseTakenAsString(1));
//		System.out.println(s1.equals(s2));
//		System.out.println(s2.equals(s1));
//		System.out.println(s1.equals(s3));
//
//		System.out.println(s1.toString());
//		System.out.println(s2.toString());
//		System.out.println(s3.toString());
//
//		System.out.println(s1.compareTo(s2));
//		System.out.println(s2.compareTo(s3));
//		System.out.println(s3.compareTo(s1));

		// MENU PORTION
		
//		(3 pts) Create 3 new Course objects based on input
//		(3 pts) Create 3 new Faculty objects based on input
//		(3 pts) Create 3 new GeneralStaff objects based on input
//		(3 pts) Create 3 new Student objects based on input
//		(2 pts) Add 2 new Courses to a Faculty object
//		(2 pts) Add 2 new Courses to a Student object
//		(1 pts) Add an array of 2 Courses to a Faculty object
//		(1 pts) Add an array of 2 Courses to a Student object
//		(1 pts) Get the Course at index (valid and invalid indexes) from a Faculty object
//		(1 pts) Get the Course at index (valid and invalid indexes) from a Student object
//		(1 pts) Allow the user to select a Faculty object and a Course object from menus and query the Faculty object for the Course to determine whether the Faculty object teaches it or not.
//		(1 pts) Determine which Faculty object teaches the most and the least courses.
//		(1 pts) Determine which Course is the minimum of all Course objects in the catalog.
//		(1 pts) Determine which Course is the maximum of all Course objects in the catalog.
//		(1 pts) Determine which Student has the most and least credits.

		//TESTING AMOUNT OF COURSES TEACHED BY FACULTY
//		Faculty [] facul = {f1,f2,f3,f4};;
//		
//		Faculty [] facul2 = new Faculty[50];
//		facul2 = facul;
//		Arrays.sort(facul2);
//		System.out.println("The Faculty that teaches the least courses is: " + facul2[0].getName());
//		System.out.println("The Faculty that teaches the most courses is: " + facul2[facul2.length -1].getName());







	}}