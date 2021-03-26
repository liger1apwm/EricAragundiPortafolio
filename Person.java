
public class Person implements Comparable<Person>{
	private String name;
	private int birthYear;
	
	public Person()	{		
		this.name = "";
		this.birthYear= 0;
		}
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear= birthYear;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	@Override
	   public boolean equals(Object p) {

	       if (p instanceof Person) {

	           Person per = (Person) p;

	          if(  this.name.equalsIgnoreCase(per.getName())

	                   && this.birthYear == per.getBirthYear() ) {
	       
	           return true;
	          }
	        
	       }
		return false;

	   }
	   
	 @Override

	   public String toString() {
		 
	       String s = String.format(

	    		   "Person: Name: %30s | Birth Year: %4d", this.name, this.birthYear) ;


	       return s;

	   }
	 @Override
	 public int compareTo(Person p){
			if(this.birthYear > p.birthYear){
				return 1;
			}
			else if(this.birthYear < p.birthYear){
				return -1;
			}
			return 0;
		}
		
	
}
