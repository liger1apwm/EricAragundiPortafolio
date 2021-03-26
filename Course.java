
public class Course implements Comparable<Course> {
	private boolean isGraduateCourse; 
	private int courseNum;
	private String courseDept; 
	private int numCredits; 
	

	public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
		this.isGraduateCourse = isGraduateCourse ; 
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
	}
	public boolean isGraduateCourse() {
		return this.isGraduateCourse;
	}
	public int getCourseNum() {
		return courseNum;
	}
	
	public String getCourseDept() {
		return courseDept;
	}
	
	public int getNumCredits() {
		return numCredits;
	}
	
	public String getCourseName() {		
		String s1 = "";
		if(this.isGraduateCourse) {
			s1 = "G";
		}
		else {
			s1 = "U";
		}
		
		return s1 + this.courseDept + this.courseNum ;
	}
	
	 @Override
	   public boolean equals(Object c) {

	       if (c instanceof Course) {

	           Course cour = (Course) c;

	          if( this.isGraduateCourse == cour.isGraduateCourse()&& this.courseDept.equalsIgnoreCase(cour.getCourseDept())

	                   && this.courseNum == cour.getCourseNum() && this.numCredits == cour.getNumCredits() ) {
	       
	           return true;
	          }
	        
	       }
		return false;

	   }
	   
	 @Override

	   public String toString() {
		 String g ="";
		 	if (this.isGraduateCourse) {
		 		g = "Graduate";
		 	}
		 	else {
		 		g = "Undergraduate";
		 	}

	       String s = String.format(

	    		   "Course: %3s-%3d | Number of Credits: %02d | ", this.courseDept, this.courseNum, this.numCredits) + g ;


	       return s;

	   }
	 @Override
	 public int compareTo(Course c){
			if(this.courseNum > c.courseNum){
				return 1;
			}
			else if(this.courseNum < c.courseNum){
				return -1;
			}
			return 0;
		}
		
}
