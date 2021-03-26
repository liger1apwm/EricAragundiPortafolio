
public class Faculty extends Employee implements Comparable<Person>{

	private Course coursesTaught [] ;
	private int numCoursesTaught;
	private boolean isTenured;




	public Faculty() {
		super();
		this.coursesTaught = new Course[100] ;
		this.numCoursesTaught = 0;
		this.isTenured = false;
	}

	public Faculty(boolean isTenured) {
		super();
		this.coursesTaught = new Course[100] ;
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}

	public Faculty(String deptName,boolean isTenured) {
		super(deptName);
		this.coursesTaught = new Course[100] ;
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}

	public Faculty(String name,int birthYear,String deptName,boolean isTenured) {
		super(name,birthYear,deptName);
		this.coursesTaught = new Course[100] ;
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}

	public boolean isTenured() {
		return this.isTenured;
	}

	public int getNumCoursesTaught() {
		return this.numCoursesTaught;
	}

	public void setisTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}

	public void addCourseTaught(Course c) {
		if (numCoursesTaught < coursesTaught.length) {
			coursesTaught[numCoursesTaught] = c;
			numCoursesTaught++;
		}
	}

	public void addCoursesTaught(Course [] c) {
		for (int i = 0 ; i < c.length;i++) {
			if (numCoursesTaught < coursesTaught.length) {
				coursesTaught[numCoursesTaught] = c[i];
				numCoursesTaught++;
			}}
	}


	public Course getCourseTaught(int index) {
		if(index >= 0 && index < numCoursesTaught) {
			return this.coursesTaught[index];
		}
		
		else {
		return null;
		
		}
		
	}
	public String getCourseTaughtAsString(int index) {
		String s = "";

		if(index >= 0 && index < numCoursesTaught) {
			s = String.format(

					"%3s-%3d", this.coursesTaught[index].getCourseDept(), this.coursesTaught[index].getCourseNum());
			return s;
		}
		else {
			return "";
		}
	}

	public String getAllCoursesTaughtAsString() {
		String s = "";
		for(int i =0; i < numCoursesTaught; i++) {
			s += getCourseTaughtAsString(i) + ",";
		}
		if(s.length() > 1) {
		s = s.substring(0, s.length()-1);
		}
		return s;
	}

	@Override
	public boolean equals(Object f) {
		if(super.equals(f)) {
			if (f instanceof Faculty) {

				Faculty fac = (Faculty) f;

				if(  this.numCoursesTaught == fac.getNumCoursesTaught() && this.isTenured == fac.isTenured()

						) {

					return true;
				}

			}}
		return false;

	}
	
	@Override
	public String toString() {
		String st = "";
		String st2 = "";
		if(this.isTenured == true) {
			st = "Is Tenured";
		}
		else {
			st = "Not Tenured";
		}
		
		if(this.numCoursesTaught == 0) {
			st2 = "";
		}
		else {
			st2 = getAllCoursesTaughtAsString();
		}
		
		String s = super.toString()  + String.format(


				" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s", st , this.numCoursesTaught,st2)  ;


		return s;

	}
	@Override
	public int compareTo(Person f){
		if(this.numCoursesTaught > ((Faculty) f).getNumCoursesTaught()){
			return 1;
		}
		else if(this.numCoursesTaught  < ((Faculty) f).getNumCoursesTaught()){
			return -1;
		}
		return 0;
	}


}
