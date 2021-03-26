import java.util.Random;

public class Employee extends Person implements Comparable<Person>{
	private static int numEmployees = 0;
	private String deptName;
	private int employeeID ;	

	public Employee() {
		super();
		this.numEmployees = numEmployees + 1;
		this.employeeID = numEmployees;
		this.deptName = "";
	}

	public Employee(String deptName) {
		super();
		this.numEmployees = numEmployees + 1;
		this.employeeID = numEmployees;
		this.deptName = deptName;

	}

	public Employee(String name, int birthYear, String deptName) {
		super(name,birthYear);
		this.numEmployees = numEmployees + 1;
		this.employeeID = numEmployees;
		this.deptName = deptName;


	}

	public String getDeptName() {
		return this.deptName;
	}

	public static int getNumEmployees() {
		return numEmployees;
	}

	public int getEmployeeID() {
		return this.employeeID;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	@Override
	public boolean equals(Object e) {
		if(super.equals(e)) {
			if (e instanceof Employee) {

				Employee emp = (Employee) e;

				if(  this.deptName.equalsIgnoreCase(emp.getDeptName())

						) {

					return true;
				}

			}}
		return false;

	}

	@Override

	public String toString() {

		String s = super.toString()  + String.format(

				" Employee: Department: %20s | Employee Number: %3d", this.deptName, this.employeeID) ;


		return s;

	}
	@Override
	public int compareTo(Person e){
		if(this.employeeID > ((Employee) e).getEmployeeID()){
			return 1;
		}
		else if(this.employeeID < ((Employee) e).getEmployeeID()){
			return -1;
		}
		return 0;
	}


}
