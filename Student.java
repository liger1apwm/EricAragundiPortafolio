
public class Student extends Person{
	
	private static int numStudents = 0;
	private int studentID ;
	private Course coursesTaken [] ;
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major;
	
	public Student() {
		super();
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = false;
		this.major = "undeclared";
		numStudents ++;
		this.studentID = numStudents;
	}
	
	public Student(boolean isGraduate) {
		super();
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = "undeclared";
		numStudents ++;
		this.studentID = numStudents;
	}
	
	public Student(String major, boolean isGraduate) {
		super();
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		numStudents ++;
		this.studentID = numStudents;
		
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		super(name,birthYear);
		this.coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		numStudents ++;
		this.studentID = numStudents;
		
	}
	
	public boolean isGraduate() {
		return this.isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return this.numCoursesTaken;
	}
	
	public static int getNumStudents(){
		return numStudents;
	}
	
	public int getStudentID() {
		return this.studentID;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public void setIsGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void addCourseTaken(Course c) {
		if (numCoursesTaken < coursesTaken.length) {
			coursesTaken[numCoursesTaken] = c;
			numCoursesTaken++;
		}
	}

	public void addCoursesTaken(Course [] c) {
		for (int i = 0 ; i < c.length ;i++) {
			if (numCoursesTaken < coursesTaken.length ) {
				coursesTaken[numCoursesTaken] = c[i];
				numCoursesTaken++;
			}}
	}

	public Course getCourseTaken(int index)
	{
		if (index <0 || index>this.numCoursesTaken-1)
			return null;
		else
			return this.coursesTaken[index];
	}

	public String getCoursesTakenAsString(int index) {
		String s = "";

		if(index >= 0 && index < numCoursesTaken) {
			s = String.format(

					"%3s-%3d", this.coursesTaken[index].getCourseDept(), this.coursesTaken[index].getCourseNum());
			return s;
		}
		else {
			return "";
		}
	}

	public String getAllCoursesTakenAsString() {
		String s = "";
		for(int i =0; i < numCoursesTaken; i++) {
			s += getCoursesTakenAsString(i) + ",";
		}
		if(s.length() > 0) {
		s = s.substring(0, s.length()-1);
		}
		return s;
	}

	@Override
	public boolean equals(Object s) {
		if(super.equals(s)) {
			if (s instanceof Student) {

				Student stu = (Student) s;

				if(  this.numCoursesTaken == stu.getNumCoursesTaken() && this.isGraduate == stu.isGraduate() &&
						this.major.equalsIgnoreCase(((Student) s).getMajor())

						) {

					return true;
				}

			}}
		return false;

	}
	//
	@Override

	public String toString() {
		String g = "";
		String g2 = "";
		if (this.isGraduate) {
	 		g = "Graduate";
	 	}
	 	else {
	 		g = "Undergraduate";
	 	}
		
		if(this.numCoursesTaken == 0) {
			g2 = "";
		}
		else {
			g2 = getAllCoursesTakenAsString();
		}
		
		String s = super.toString()  + String.format(


				" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s", this.studentID, this.major, g, this.numCoursesTaken, g2)  ;


		return s;

	}
	@Override
	public int compareTo(Person s){
		if(this.numCoursesTaken > ((Student) s).getNumCoursesTaken()){
			return 1;
		}
		else if(this.numCoursesTaken < ((Student) s).getNumCoursesTaken()){
			return -1;
		}
		return 0;
	}

	
	
	
	
}
