//Project 1 cmp 168
//Youtube link: https://youtu.be/Hd_oEa1-9qQ
// in the video I forgot to test for invalid index in menu i and j
// my method in 932 and 957 for getFacCourseAtIndex() and getStudCourseAtIndex() actually handles invalid index

import java.util.*;
import java.io.*;
public class Driver_SchoolDB {
	//READ FILE AND DISPLAY METHODS

	private static int CourseCount = 0;
	private static int CourseNext = 0;
	private static int FacultyCount = 0;
	private static int StudentCount = 0;
	private static int GSCount = 0;
	private static String answer;
	private static String outputFileString = "";

	private static Course cour [] = new Course[50];
	private static Faculty facul [] = new Faculty[50];
	private static Student Stud [] = new Student[50];
	private static GeneralStaff gs [] = new GeneralStaff[50];
	//HELPER METHODS
	public static String readFile(String fileName) {
		String fileContent = "";
		Scanner inStream = null;

		try{
			File theFile = new File(fileName);
			inStream = new Scanner(theFile);
			while(inStream.hasNextLine()){
				fileContent += inStream.nextLine()+"\n"; //only read 1st line
			}
		}
		catch(FileNotFoundException e){
			System.out.println("The file "+fileName+" could not be found using readFile method");
		}
		finally{
			if(inStream !=null){
				inStream.close();
			}
		}


		return fileContent;
	}

	public static void appendToFile(String fileName, String text) {
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(new FileOutputStream(fileName, true)); //append to end of file if it exists, otherwise create a new empty file
			outStream.println(text);  //write to the file
		} catch (FileNotFoundException e) { 
			System.out.println("The file "+fileName+" could not be written to using appendToFile method");
			//			e.printStackTrace();
		}
		finally{
			if(outStream != null){
				outStream.close();
			}
		}
	}

	public static Course createCourse(boolean b, int num, String clas, int numCr) {



		Course c1 = new Course(b,num,clas,numCr);

		CourseCount++;

		return c1;
	}


	public static Faculty createFaculty(String name, int num, String clas, boolean b) {

		Faculty f1 = new Faculty(name,num,clas,b);

		FacultyCount++;

		return f1;
	}

	public static Faculty createFaculty() {

		Faculty f1 = new Faculty();

		FacultyCount++;

		return f1;
	}

	public static Faculty createFaculty(String clas, boolean b) {

		Faculty f1 = new Faculty(clas,b);

		FacultyCount++;

		return f1;
	}

	public static Faculty createFaculty(boolean b) {

		Faculty f1 = new Faculty(b);

		FacultyCount++;

		return f1;
	}


	public static Student createStudent(String name, int num, String clas, boolean b) {

		Student s1 = new Student(name,num,clas,b);

		StudentCount++;

		return s1;
	}

	public static Student createStudent() {

		Student s1 = new Student();

		StudentCount++;

		return s1;
	}

	public static Student createStudent(String clas, boolean b) {

		Student s1 = new Student(clas,b);

		StudentCount++;

		return s1;
	}

	public static Student createStudent(boolean b) {

		Student s1 = new Student(b);

		StudentCount++;

		return s1;
	}


	public static GeneralStaff createGeneralStaff(String name, int num, String dept, String d) {

		GeneralStaff g1 = new GeneralStaff(name,num,dept,d);

		GSCount++;

		return g1;
	}

	public static GeneralStaff createGeneralStaff() {

		GeneralStaff g1 = new GeneralStaff();

		GSCount++;

		return g1;
	}

	public static GeneralStaff createGeneralStaff( String dept, String d) {

		GeneralStaff g1 = new GeneralStaff(dept,d);

		GSCount++;

		return g1;
	}

	public static GeneralStaff createGeneralStaff(String d) {

		GeneralStaff g1 = new GeneralStaff(d);

		GSCount++;

		return g1;
	}

	// MENU PORTION METHODS

	public static void MainMenu() {


		System.out.println("Please select the letter corresponding to the option you would like to perform:");
		System.out.println("a. Create new Course object.");
		System.out.println("b. Create new Faculty object.");
		System.out.println("c. Create new General Staff object.");
		System.out.println("d. Create new Student.");
		System.out.println("e. Add 2 new Courses to a Faculty object.");
		System.out.println("f. Add 2 new Courses to a Student object.");
		System.out.println("g. Add an array of 2 Courses to a Faculty object.");
		System.out.println("h. Add an array of 2 Courses to a Student object.");
		System.out.println("i. Get the Course at index (valid and invalid indexes) from a Faculty object.");
		System.out.println("j. Get the Course at index (valid and invalid indexes) from a Student object.");
		System.out.println("k. Allow the user to select a Faculty object and a Course "
				+ "object from menus and query the Faculty object for the Course"
				+ " to determine whether the Faculty object teaches it or not.");
		System.out.println("l. Determine which Faculty object teaches the most and the least courses.");
		System.out.println("m. Determine which Course is the minimum and maximum of all Course objects in the catalog.");
		System.out.println("n. Determine which Student has the most and least courses.");
		System.out.println("z. Leave menu");


		Scanner scnr = new Scanner(System.in);
		String answer = scnr.next();

		try {
			if(answer.equalsIgnoreCase("z")) {
				scnr.close();
				return;
			}

			if(answer.equalsIgnoreCase("a")) {
				createCourseMenu();

				return;


			}
			if(answer.equalsIgnoreCase("b")) {
				createFacultyMenu();

			}
			if(answer.equalsIgnoreCase("c")) {
				createGSMenu();

			}
			if(answer.equalsIgnoreCase("d")) {
				createStudentMenu();

			}
			if(answer.equalsIgnoreCase("e")) {
				addCourseFacultyMenu();

			}
			if(answer.equalsIgnoreCase("f")) {
				addCourseStudentMenu();

			}
			if(answer.equalsIgnoreCase("g")) {
				addArrayCoursesFaculMenu();

			}
			if(answer.equalsIgnoreCase("h")) {
				addArrayCoursesStudMenu();

			}
			if(answer.equalsIgnoreCase("i")) {
				getFacCourseAtIndex();

			}
			if(answer.equalsIgnoreCase("j")) {
				getStudCourseAtIndex();

			}
			if(answer.equalsIgnoreCase("k")) {
				FacultyTeaches();

			}
			if(answer.equalsIgnoreCase("l")) {
				FacultyMaxMin();

			}

			if(answer.equalsIgnoreCase("m")) {
				CoursesMaxMin();
			}
			if(answer.equalsIgnoreCase("n")) {
				StudentMaxMin();

			}
		}
		catch (NoSuchElementException ne) {

		}

	}

	public static void createCourseMenu(){
		Scanner scnr = new Scanner(System.in);
		boolean graduate = false;
		String grad;
		int cNum = 0;
		String dept = "";
		int Cr = 0;
		System.out.println("Creating new course:");
		System.out.println("Please enter true if it is a graduate course or false if it a undergraduate course:");
		//asking if is graduate
		grad = 	scnr.next();
		while(!(grad.equalsIgnoreCase("true")||grad.equalsIgnoreCase("false"))) {
			System.out.println("Please enter true or false:");
			grad = 	scnr.next();
		}

		if(grad.equalsIgnoreCase("true")) {
			graduate = true;
		}
		//asking for course number
		System.out.println("Please enter the three digits numbers of the course:");
		//		boolean exit = true;
		//		int check = 0 ;		
		try {
			cNum = 	scnr.nextInt();	

		}
		//NOTE:  ASK PROFESSOR WHY IS NOT READING A NUMBER AGAIN
		catch(InputMismatchException e) {
			System.out.println("This is not a correct course number:");			
			try {
				//scnr.nextLine();				
				cNum = 	scnr.nextInt();	
				System.out.print("cNum have this: " + cNum);
			}
			catch(InputMismatchException d) {
				System.out.println("A course number should be between 000 and 999, try again from the beggining:");
				createCourseMenu();
				return;
			}
		}	
		// asking for course department
		System.out.println("Please enter the three letters name of the departement abreviation:");
		dept = 	scnr.next();
		while(dept.length() > 3 ) {
			System.out.println("Please enter the three letters name of the departement abreviation:");
			dept = 	scnr.next();
		}
		// asking for number of credits


		try {
			System.out.println("Please enter a digit from 1 to 9 for the number of credits:");
			Cr = scnr.nextInt();
			while(Cr < 0 || Cr > 9) {
				System.out.println("Please enter a digit from 1 to 9 for the number of credits:");
				Cr = scnr.nextInt();
			}	

		}
		//NOTE:  ASK PROFESSOR WHY IS NOT READING A NUMBER AGAIN
		catch(InputMismatchException e) {
			System.out.print("This is not correct number of credits:");			
			try {
				Cr = scnr.nextInt();	
				while(Cr < 0 || Cr > 9) {
					System.out.println("Please enter a digit from 1 to 9 for the number of credits:");
					Cr = scnr.nextInt();
				}		
			}
			catch(InputMismatchException d) {
				System.out.println("A correct number of credits should be between 0 and 9, try again from the beggining:");
				createCourseMenu();
				return;
			}
		}	

		cour[CourseCount] = createCourse(graduate,cNum,dept,Cr);

		System.out.println("Would you like to create another Course object?");
		String answer2 = scnr.next();
		if(answer2.equalsIgnoreCase("Yes")) {
			createCourseMenu();

		}
		else {
			MainMenu();
			return;
		}
		scnr.close();
	}

	public static void createCourseMenu2(){
		Scanner scnr = new Scanner(System.in);
		boolean graduate = false;
		String grad;
		int cNum = 0;
		String dept = "";
		int Cr = 0;
		System.out.println("Creating new course:");
		System.out.println("Please enter true if it is a graduate course or false if it a undergraduate course:");
		//asking if is graduate
		grad = 	scnr.next();
		while(!(grad.equalsIgnoreCase("true")||grad.equalsIgnoreCase("false"))) {
			System.out.println("Please enter true or false:");
			grad = 	scnr.next();
		}

		if(grad.equalsIgnoreCase("true")) {
			graduate = true;
		}
		//asking for course number
		System.out.println("Please enter the three digits numbers of the course:");
		//		boolean exit = true;
		//		int check = 0 ;		
		try {
			cNum = 	scnr.nextInt();	

		}
		//NOTE:  ASK PROFESSOR WHY IS NOT READING A NUMBER AGAIN
		catch(InputMismatchException e) {
			System.out.println("This is not a correct course number:");			
			try {
				cNum = 	scnr.nextInt();	

			}
			catch(InputMismatchException d) {
				System.out.println("A course number should be between 000 and 999, try again from the beggining:");
				createCourseMenu2();

			}
		}	
		// asking for course department
		System.out.println("Please enter the three letters name of the departement abreviation:");
		dept = 	scnr.next();
		while(dept.length() > 3 ) {
			System.out.println("Please enter the three letters name of the departement abreviation:");
			dept = 	scnr.next();
		}
		// asking for number of credits


		try {
			System.out.println("Please enter a digit from 1 to 9 for the number of credits:");
			Cr = scnr.nextInt();
			while(Cr < 0 || Cr > 9) {
				System.out.println("Please enter a digit from 1 to 9 for the number of credits:");
				Cr = scnr.nextInt();
			}	

		}
		//NOTE:  ASK PROFESSOR WHY IS NOT READING A NUMBER AGAIN
		catch(InputMismatchException e) {
			System.out.print("This is not correct number of credits:");			
			try {
				Cr = scnr.nextInt();	
				while(Cr < 0 || Cr > 9) {
					System.out.println("Please enter a digit from 1 to 9 for the number of credits:");
					Cr = scnr.nextInt();
				}		
			}
			catch(InputMismatchException d) {
				System.out.println("A correct number of credits should be between 0 and 9, try again from the beggining:");
				createCourseMenu2();

			}
		}	

		cour[CourseCount] = createCourse(graduate,cNum,dept,Cr);

		System.out.println("Would you like to create another Course object?");
		String answer2 = scnr.next();
		if(answer2.equalsIgnoreCase("Yes")) {
			CourseNext++;
			createCourseMenu2();

		}
		else {

			return;
		}

	}

	public static void createFacultyMenu() {

		Scanner scnr = new Scanner(System.in);
		boolean tenured = false;
		String tenu;
		int birthYear = 0;
		String dept = "";
		String name = "";
		System.out.println("Creating new Faculty:");

		//Asking for the name
		System.out.println("Please enter the name of the Faculty :");
		name = 	scnr.next();

		//asking for birthYear

		try {
			System.out.println("Please enter a four digit number for the date of Birth:");
			birthYear = scnr.nextInt();
			while(birthYear < 0 || birthYear > 2020) {
				System.out.println("Please enter a valid Date of Birth:");
				birthYear = scnr.nextInt();
			}	

		}
		//NOTE:  ASK PROFESSOR WHY IS NOT READING A NUMBER AGAIN
		catch(InputMismatchException e) {
			System.out.println("Not a valid Date of Birth:");			
			try {
				birthYear = scnr.nextInt();	
				while(birthYear < 0 || birthYear > 2020) {
					System.out.println("Please enter a valid Date of Birth:");
					birthYear = scnr.nextInt();
				}	
			}
			catch(InputMismatchException d) {
				System.out.println("A valid Date of Birth is a number between 0000 and the present year, try again from the beggining:");
				createFacultyMenu();
				return;
			}
		}	

		//Asking for dept
		System.out.println("Please enter the three letters name of the departement abreviation:");
		System.out.println("If there is not department assigned please input 0:");
		dept = 	scnr.next();
		if(dept.equalsIgnoreCase("0")) {
			dept = "";
		}
		while(dept.length() > 3 ) {
			System.out.println("Please enter the three letters name of the departement abreviation:");
			dept = 	scnr.next();
		}

		//asking if is tenured

		System.out.println("Please enter true if it is Tenured Faculty or false if it is not:");
		tenu = 	scnr.next();
		while(!(tenu.equalsIgnoreCase("true")||tenu.equalsIgnoreCase("false"))) {
			System.out.println("Please enter true or false:");
			tenu = 	scnr.next();
		}

		if(tenu.equalsIgnoreCase("true")) {
			tenured = true;
		}

		facul[FacultyCount] = createFaculty(name,birthYear,dept,tenured);

		System.out.println("Would you like to create another Faculty object?");
		String answer2 = scnr.next();
		if(answer2.equalsIgnoreCase("Yes")) {
			createFacultyMenu();
		}
		else {
			MainMenu();
		}
		scnr.close();

	}

	public static void createGSMenu() {

		Scanner scnr = new Scanner(System.in);
		String duty = "";
		int birthYear = 0;
		String dept = "";
		String name = "";
		System.out.println("Creating new General Staff:");

		//Asking for the name
		System.out.println("Please enter the name of the General Staff :");
		name = 	scnr.next();

		//asking for birthYear

		try {
			System.out.println("Please enter a four digit number for the date of Birth:");
			birthYear = scnr.nextInt();
			while(birthYear < 0 || birthYear > 2020) {
				System.out.println("Please enter a valid Date of Birth:");
				birthYear = scnr.nextInt();
			}	

		}
		//NOTE:  ASK PROFESSOR WHY IS NOT READING A NUMBER AGAIN
		catch(InputMismatchException e) {
			System.out.println("Not a valid Date of Birth:");			
			try {
				birthYear = scnr.nextInt();	
				while(birthYear < 0 || birthYear > 2020) {
					System.out.println("Please enter a valid Date of Birth:");
					birthYear = scnr.nextInt();
				}	
			}
			catch(InputMismatchException d) {
				System.out.println("A valid Date of Birth is a number between 0000 and the present year, try again from the beggining:");
				createGSMenu();
				return;
			}
		}	
		//Asking for dept
		System.out.println("Please enter the  name of the departement :");
		System.out.println("If there is not department assigned please input 0:");
		dept = 	scnr.next();
		if(dept.equalsIgnoreCase("0")) {
			dept = "";
		}

		//asking for duty

		System.out.println("Please enter the  duty assigned to the general staff:");
		System.out.println("If there is not duty assigned please input 0:");
		duty = 	scnr.next();
		if(duty.equalsIgnoreCase("0")) {
			duty = "";
		}

		gs[GSCount] = createGeneralStaff(name,birthYear,dept,duty);

		System.out.println("Would you like to create another General Staff object?");
		String answer2 = scnr.next();
		if(answer2.equalsIgnoreCase("Yes")) {
			createGSMenu();
		}
		else {
			MainMenu();
		}
		scnr.close();

	}

	public static void createStudentMenu() {

		Scanner scnr = new Scanner(System.in);
		boolean Graduated = false;
		String Gradu;
		int birthYear = 0;
		String dept = "";
		String name = "";
		System.out.println("Creating new Student:");

		//Asking for the name
		System.out.println("Please enter the name of the Student:");
		name = 	scnr.next();

		//asking for birthYear

		try {
			System.out.println("Please enter a four digit number for the date of Birth:");
			birthYear = scnr.nextInt();
			while(birthYear < 0 || birthYear > 2020) {
				System.out.println("Please enter a valid Date of Birth:");
				birthYear = scnr.nextInt();
			}	

		}
		//NOTE:  ASK PROFESSOR WHY IS NOT READING A NUMBER AGAIN
		catch(InputMismatchException e) {
			System.out.println("Please enter a valid Date of Birth:");			
			try {
				birthYear = scnr.nextInt();	
				while(birthYear < 0 || birthYear > 2020) {
					System.out.println("Please enter a valid Date of Birth:");
					birthYear = scnr.nextInt();
				}	
			}
			catch(InputMismatchException d) {
				System.out.println("Still not a valid Date of Birth, try again from the beggining:");
				createStudentMenu();
				return;
			}
		}	

		//Asking for dept
		System.out.println("Please enter the three letters name of the departement abreviation:");
		System.out.println("If there is not department assigned please input 0:");
		dept = 	scnr.next();
		if(dept.equalsIgnoreCase("0")) {
			dept = "";
		}
		while(dept.length() > 3 ) {
			System.out.println("Please enter the three letters name of the departement abreviation:");
			dept = 	scnr.next();
		}

		//asking if is graduated

		System.out.println("Please enter true if it is Graduated Studnet or false if it is not:");
		Gradu = 	scnr.next();
		while(!(Gradu.equalsIgnoreCase("true")||Gradu.equalsIgnoreCase("false"))) {
			System.out.println("Please enter true or false:");
			Gradu = 	scnr.next();
		}

		if(Gradu.equalsIgnoreCase("true")) {
			Graduated = true;
		}

		Stud[StudentCount] = createStudent(name,birthYear,dept,Graduated);

		System.out.println("Would you like to create another Student object?");
		String answer2 = scnr.next();
		if(answer2.equalsIgnoreCase("Yes")) {
			createStudentMenu();
		}
		else {
			MainMenu();
		}
		scnr.close();

	}

	public static void AddCoursesFaculty(Faculty f, Course c) {
		f.addCourseTaught(c);
	}
	public static void addCourseFacultyMenu() {
		Scanner scnr2 = new Scanner(System.in);
		int ans;
		System.out.println("Please create a new course to add to the faculty");
		CourseNext++;
		createCourseMenu2();
		System.out.println("Please select the faculty you would like to add the new course");

		for(int i = 0;i < FacultyCount; i++) {
			System.out.println( (i + 1) +": " + facul[i].getName());

		}
		//System.out.println(CourseNext);

		ans = scnr2.nextInt();

		if(CourseNext == 1) {
			AddCoursesFaculty(facul[ans-1],cour[CourseCount - 1]);
		}
		else if(CourseNext == 2) {
			AddCoursesFaculty(facul[ans-1],cour[CourseCount -1]);
			AddCoursesFaculty(facul[ans-1],cour[CourseCount - 2]);

		}
		else if(CourseNext == 3) {
			AddCoursesFaculty(facul[ans-1],cour[CourseCount -1]);
			AddCoursesFaculty(facul[ans-1],cour[CourseCount - 2]);
			AddCoursesFaculty(facul[ans-1],cour[CourseCount - 3]);
		}
		else {
			System.out.println("Only a max of 3 courses can be added to a Faculty at the time");
			addCourseFacultyMenu();
		}


		CourseNext = 0;
		MainMenu();

	}

	public static void AddCoursesStudent(Student s, Course c) {
		s.addCourseTaken(c);
	}
	public static void addCourseStudentMenu() {
		Scanner scnr2 = new Scanner(System.in);
		int ans;
		System.out.println("Please create a new course to add to the Student");
		CourseNext++;
		createCourseMenu2();
		System.out.println("Please select the Student you would like to add the new course");

		for(int i = 0;i < StudentCount; i++) {
			System.out.println( (i + 1) +": " + Stud[i].getName());

		}
		//System.out.println(CourseNext);

		ans = scnr2.nextInt();

		if(CourseNext == 1) {
			AddCoursesStudent(Stud[ans-1],cour[CourseCount - 1]);
		}
		else if(CourseNext == 2) {
			AddCoursesStudent(Stud[ans-1],cour[CourseCount -1]);
			AddCoursesStudent(Stud[ans-1],cour[CourseCount - 2]);

		}
		else if(CourseNext == 3) {
			AddCoursesStudent(Stud[ans-1],cour[CourseCount -1]);
			AddCoursesStudent(Stud[ans-1],cour[CourseCount - 2]);
			AddCoursesStudent(Stud[ans-1],cour[CourseCount - 3]);
		}
		else {
			System.out.println("Only a max of 3 courses can be added to a Student at the time");
			addCourseStudentMenu();
		}


		CourseNext = 0;
		MainMenu();

	}

	public static void addArrayCoursesFaculty(Faculty f ,Course [] c) {
		f.addCoursesTaught(c);
	}
	public static void addArrayCoursesFaculMenu() {
		Scanner scnr2 = new Scanner(System.in);		
		Course [] cour3 = new Course[10];
		int ans;
		int ans2;
		String ans3;
		boolean vad = true;



		System.out.println("Please select the faculty you would like to add a list of courses");

		for(int i = 0;i < FacultyCount; i++) {
			System.out.println( (i + 1) +": " + facul[i].getName());

		}
		ans = scnr2.nextInt();


		while(vad) {
			System.out.println("Choose the course you would like to add to the list:");
			for(int i = 0;i < CourseCount; i++) {
				System.out.println( (i + 1) +": " + cour[i].getCourseName());

			}
			try {
				ans2 = scnr2.nextInt();
				if(ans2 > 0 && ans2 <= CourseCount) {
					cour3[CourseNext] = cour[ans2 - 1];
				}
				else {
					System.out.println("Course selected is not valid");
				}
				CourseNext += 1;
				System.out.println("would you like to add another course:");		
				ans3 = scnr2.next();
				if(ans3.equalsIgnoreCase("yes")) {
					vad = true;
				}
				else if(ans3.equalsIgnoreCase("no")){
					System.out.println("Your list will be added now:!\n");
					vad = false;
				}
				else {
					System.out.println("Invalid answer we will add the courses selected so far:\n");
					vad = false;
				}
			}
			catch(InputMismatchException in) {
				System.out.println("Invalid entry");

				break;
			}

		}

		Course [] cour4 = new Course[CourseNext];
		for(int i = 0; i < CourseNext;i++) {
			cour4[i] = cour3[i];
		}

		addArrayCoursesFaculty(facul[ans -1],cour4);		
		CourseNext = 0;
		MainMenu();


	}


	public static void addArrayCoursesStudent(Student s ,Course [] c) {
		s.addCoursesTaken(c);
	}
	public static void addArrayCoursesStudMenu() {
		Scanner scnr2 = new Scanner(System.in);		
		Course [] cour3 = new Course[10];
		int ans;
		int ans2;
		String ans3;
		boolean vad = true;



		System.out.println("Please select the Student you would like to add a list of courses");

		for(int i = 0;i < StudentCount; i++) {
			System.out.println( (i + 1) +": " + Stud[i].getName());

		}
		ans = scnr2.nextInt();


		while(vad) {
			System.out.println("Choose the course you would like to add to the list:");
			for(int i = 0;i < CourseCount; i++) {
				System.out.println( (i + 1) +": " + cour[i].getCourseName());

			}
			try {
				ans2 = scnr2.nextInt();
				if(ans2 > 0 && ans2 <= CourseCount) {
					cour3[CourseNext] = cour[ans2 - 1];
				}
				else {
					System.out.println("Course selected is not valid");
				}
				CourseNext += 1;
				System.out.println("would you like to add another course:");		
				ans3 = scnr2.next();
				if(ans3.equalsIgnoreCase("yes")) {
					vad = true;
				}
				else if(ans3.equalsIgnoreCase("no")){
					System.out.println("Your list will be added now:!\n");
					vad = false;
				}
				else {
					System.out.println("Invalid answer we will add the courses selected so far:\n");
					vad = false;
				}
			}
			catch(InputMismatchException in) {
				System.out.println("Invalid entry");

				break;
			}

		}

		Course [] cour4 = new Course[CourseNext];
		for(int i = 0; i < CourseNext;i++) {
			cour4[i] = cour3[i];
		}

		addArrayCoursesStudent(Stud[ans -1],cour4);		
		CourseNext = 0;
		MainMenu();


	}


	public static void getFacCourseAtIndex() {
		Scanner scnr2 = new Scanner(System.in);
		int ans;
		int index;

		System.out.println("Please select the faculty you would like to get the course at the index");

		for(int i = 0;i < FacultyCount; i++) {
			System.out.println( (i + 1) +": " + facul[i].getName());

		}
		ans = scnr2.nextInt();
		System.out.println("What is the index of the course you will like to get");
		index = scnr2.nextInt();
		try {
			System.out.println("The course at index " + index + " is: " + 
					facul[ans-1].getCourseTaughtAsString(index));
		}
		catch(NullPointerException ne){
			System.out.println("The course at index" + index + "does not exist");
		}

		MainMenu();
	}

	public static void getStudCourseAtIndex() {
		Scanner scnr2 = new Scanner(System.in);
		int ans;
		int index;

		System.out.println("Please select the Student you would like to get the course at the index");

		for(int i = 0;i < StudentCount; i++) {
			System.out.println( (i + 1) +": " + Stud[i].getName());

		}
		ans = scnr2.nextInt();
		System.out.println("What is the index of the course you will like to get");
		index = scnr2.nextInt();		
		try {
			System.out.println("The course at index " + index + " is: " + 
					Stud[ans-1].getCoursesTakenAsString(index));
		}
		catch(NullPointerException ne){
			System.out.println("The course at index" + index + "does not exist");
		}
		MainMenu();
	}

	public static void FacultyTeaches() {
		Scanner scnr2 = new Scanner(System.in);
		int ans;
		int index;
		String Verify = "";
		String Verify2 = "";

		System.out.println("Please select the faculty you would like to inquire about:");

		for(int i = 0;i < FacultyCount; i++) {
			System.out.println( (i + 1) +": " + facul[i].getName());

		}
		ans = scnr2.nextInt();
		System.out.println("Please select the Course you would like to know if the faculty teach:");
		for(int i = 0;i < CourseCount; i++) {
			System.out.println( (i + 1) +": " + cour[i].getCourseName());

		}
		index = scnr2.nextInt();

		Verify = cour[index - 1].getCourseName();
		Verify = Verify.substring(1, 4)+"-"+Verify.substring(4, 7);
		for(int j = 0; j < facul[ans-1].getNumCoursesTaught();j++){
			Verify2 += facul[ans-1].getCourseTaughtAsString(j);
		}
		//		System.out.println(Verify);
		//		System.out.println(Verify2);
		if(Verify2.contains(Verify)) {
			System.out.println("The faculty teaches " + Verify);
			System.out.println("");
		}
		else {
			System.out.println("the faculty does not teach the curse");
		}

		MainMenu();


	}

	//Determine which Faculty object teaches the most and the least courses.
	public static void FacultyMaxMin() {
		Faculty [] facul2 = new Faculty[FacultyCount];
		for(int i =0; i < FacultyCount;i++) {
			facul2[i] = facul[i];
		}
		Arrays.sort(facul2);
		System.out.println("The Faculty that teaches the least courses is: " + facul2[0].getName());
		System.out.println("The Faculty that teaches the most courses is: " + facul2[facul2.length -1].getName()+ "\n\n");
		MainMenu();
	}

	public static void CoursesMaxMin() {
		Course [] cour2 = new Course[CourseCount];
		for(int i =0; i < CourseCount;i++) {
			cour2[i] = cour[i];
		}
		Arrays.sort(cour2);
		System.out.println("This is the minimun course : " + cour2[0].getCourseName());
		System.out.println("This is the maximun course : " + cour2[cour2.length -1].getCourseName()+ "\n\n");
		MainMenu();
	}

	public static void StudentMaxMin() {
		Student [] Stud2 = new Student[StudentCount];
		for(int i =0; i < StudentCount;i++) {
			Stud2[i] = Stud[i];
		}
		Arrays.sort(Stud2);
		System.out.println("This is the Student with the minimun amount of courses : " + Stud2[0].getName());
		System.out.println("This is the Student with the maximun amount of courses : " + Stud2[Stud2.length -1].getName()+ "\n\n");
		MainMenu();
	}



	public static void main(String[] args) throws NoSuchElementException{
		//READ FILE TO DISPLAY PORTION	

				String s = readFile("SchoolDB_Initial.txt");
				String str;
				String[] results = s.split("\n");
		
		
				for(int i = 0;i < results.length ;i++) {
					str = results[i];
					if(str.equalsIgnoreCase("")) {
					}
					else {
						// if code to create course objects
						if(str.charAt(0) == 'C') {
							boolean bo = false;
							int x;
							String str2;
							int y;
		
							String[] line = str.split(",");
		
							if(line[0].charAt(8) == 't') {
								bo = true;
							}
		
							if(line[1].charAt(0)== ' ') {
								x = Integer.parseInt(line[1].substring(1, 4));
							}
							else {
								x = Integer.parseInt(line[1].substring(0, 3));
							}
		
							if(line[2].charAt(0)== ' '){
								str2 = line[2].substring(1, 4);
							}
							else {
								str2 = line[2].substring(0, 3);
							}
		
							if(line[3].charAt(0)== ' '){
								y = Integer.parseInt(line[3].substring(1, 2));
							}
							else {
								y = Integer.parseInt(line[3].substring(0, 1));				
							}
		
							cour[CourseCount] = createCourse(bo, x, str2,y);
		
						}
						//If code to create faculty objects
						if(str.charAt(0) == 'F') {
							String nam;
							int x;
							String str2;
							boolean bo = false;
		
							String[] line = str.split(",");
		
							if(line.length == 1){
								if(line[0].length() < 9) {
									facul[FacultyCount] = createFaculty();
								}
								else if (line[0].charAt(9) == 't'){
									bo = true;
									facul[FacultyCount] = createFaculty(bo);
								}}
		
							if(line.length == 2){
								str2 = line[0].substring(9, 12);
								if(line[1].charAt(0) == 't') {
									bo = true;
								}
								facul[FacultyCount] = createFaculty(str2,bo);
		
							}	
							if(line.length == 4) {
								nam = line[0].substring(9, 17);
								x= Integer.parseInt(line[1].substring(0, 4));
								str2 = line[2];
								bo = true;
		
								facul[FacultyCount] = createFaculty(nam,x,str2,bo);
							}		
						}
		
						//If code to create Student objects
						if(str.charAt(0) == 'S') {
							String nam;
							int x;
							String str2;
							boolean bo = false;
		
							String[] line = str.split(",");
		
							if(line.length == 1){
								if(line[0].length() < 9) {
									Stud[StudentCount] = createStudent();
		
								}
								else if (line[0].charAt(9) == 'f'){
		
									bo = false;
									Stud[StudentCount] = createStudent(bo);
								}}
		
							if(line.length == 2){
								str2 = line[0].substring(9, 13);
								if(line[1].charAt(0) == 'f') {
									bo = false;
								}
								Stud[StudentCount] = createStudent(str2,bo);
		
							}	
							if(line.length == 4) {
								nam = line[0].substring(9, 20);
								x= Integer.parseInt(line[1].substring(0, 4));
								str2 = line[2];
								bo = true;				
								Stud[StudentCount] = createStudent(nam,x,str2,bo);
		
							}		
						}
		
						//If code to create General staff objects
						if(str.charAt(0) == 'G') {
							String nam = "" ;
							int x;
							String str2 = "";
							String duty = "";
		
							String[] line = str.split(",");
		
							if(line.length == 1){
								if(line[0].length() < 14) {
									gs[GSCount] = createGeneralStaff();
									//System.out.println(line[0]);
								}
								else if (line[0].charAt(14) == 'a'){
									//System.out.println(line[0]);
									duty = "advise students";
									gs[GSCount] = createGeneralStaff(duty);
								}}
		
							if(line.length == 2){
								str2 = line[0].substring(14, 24);
								if(line[1].charAt(0) == 'c') {
									duty = "clean";
								}
								gs[GSCount] = createGeneralStaff(str2,duty);
		
								//						System.out.println(str2);
								//						System.out.println(duty);
							}	
							if(line.length == 4) {
								nam = line[0].substring(14, 26);
								x= Integer.parseInt(line[1].substring(0, 4));
								str2 = line[2];
								duty = "safety";
		
								gs[GSCount] = createGeneralStaff(nam,x,str2,duty);
		
								//						System.out.println(nam);
								//						System.out.println(x);
								//						System.out.println(str2);
								//						System.out.println(bo);
							}		
						}
						
		
						//for empty and try
						else {
							//System.out.println("none at: " + str);
						}}
				}
		//		//TESTING OUTPUT
		//
//				System.out.println(s);
//		
//				System.out.println("******************************"
//						+ "********************************");
//				System.out.println("SCHOOL DATABASE INFO:\n");
//				System.out.println("**********************"
//						+ "**************************");
//		
//				System.out.println("COURSES:");
//				for(int l = 0; l < 6;l++) {
//					System.out.println(cour[l].toString());
//				}
//		
//				System.out.println("**********************"
//						+ "**************************");
//				System.out.println("**********************"
//						+ "**************************");
//		
//				System.out.println("PERSONS:");
//		
//				System.out.println("**********************"
//						+ "**************************");
//				System.out.println("**********************"
//						+ "**************************");
//		
//		
//				System.out.println("EMPLOYEES:");
//		
//				System.out.println("**********************"
//						+ "**************************");
//				System.out.println("**********************"
//						+ "**************************");
//		
//		
//				System.out.println("GENERAL STAFF:");
//				for(int t = 0; t < 4;t++) {
//					System.out.println(gs[t].toString());
//				}
//		
//				System.out.println("**********************"
//						+ "**************************");
//				System.out.println("**********************"
//						+ "**************************");
//		
//				System.out.println("FACULTY:");
//				for(int p = 0; p < 4;p++) {
//					System.out.println(facul[p].toString());
//				}
//		
//				System.out.println("**********************"
//						+ "**************************");
//				System.out.println("**********************"
//						+ "**************************");
//		
//				System.out.println("STUDENTS:");
//				for(int r = 0; r < 4;r++) {
//					System.out.println(Stud[r].toString());
//				}
//		
//				System.out.println("**********************"
//						+ "**************************");
//				System.out.println("******************************"
//						+ "********************************\n");


		//MENU PORTION

//
//
		System.out.println("Welcome to the School Database menu!");
		MainMenu();

		outputFileString += "******************************"
				+ "********************************\n";
		outputFileString += "SCHOOL DATABASE INFO:\n\n";
		outputFileString += "**********************"
				+ "**************************\n";

		outputFileString += "COURSES:\n";
		try {
			for(int l = 0; l < CourseCount;l++) {
				outputFileString += cour[l].toString() + "\n";
			}
		}
		catch(NullPointerException e) {

		}
		outputFileString += "**********************"
				+ "**************************\n";
		outputFileString += "**********************"
				+ "**************************\n";

		outputFileString += "PERSONS:\n";

		outputFileString += "**********************"
				+ "**************************\n";
		outputFileString += "**********************"
				+ "**************************\n";


		outputFileString += "EMPLOYEES:\n";

		outputFileString += "**********************"
				+ "**************************\n";
		outputFileString += "**********************"
				+ "**************************\n";


		outputFileString += "GENERAL STAFF:\n";
		try {
			for(int t = 0; t < GSCount;t++) {
				outputFileString += gs[t].toString() + "\n";
			}
		}
		catch(NullPointerException e) {

		}
		outputFileString += "**********************"
				+ "**************************\n";
		outputFileString += "**********************"
				+ "**************************\n";

		outputFileString += "FACULTY:\n";
		try {
			for(int p = 0; p < FacultyCount;p++) {
				outputFileString += facul[p].toString() + "\n";
			}
		}
		catch(NullPointerException e) {

		}
		outputFileString += "**********************"
				+ "**************************\n";
		outputFileString += "**********************"
				+ "**************************\n";

		outputFileString += "STUDENTS:\n";
		try {
			for(int r = 0; r < StudentCount;r++) {
				outputFileString += Stud[r].toString() + "\n";
			}
		}
		catch(NullPointerException e) {

		}
		outputFileString += "**********************"
				+ "**************************\n";
		outputFileString +="******************************"
				+ "********************************\n\n";

		System.out.println(outputFileString);
		String filename = "SchoolDB_Updated.txt";

		appendToFile(filename,outputFileString);
		System.out.println("\n\n This output has been saved into the file");




	}	

}
