
public class GeneralStaff extends Employee{
		private String duty;
		
		public GeneralStaff() {
			super();
			this.duty = "";
		}
		
		public GeneralStaff(String duty) {
			super();
			this.duty = duty;
		}
		
		public GeneralStaff(String deptName, String duty) {
			super(deptName);
			this.duty = duty;
		}
		
		public GeneralStaff(String name, int birthYear, String deptName, String duty) {
			super(name,birthYear,deptName);
			this.duty = duty;
		}
		
		public String getDuty() {
			return this.duty;
		}
		
		@Override
		public boolean equals(Object gs) {
			if(super.equals(gs)) {
				if (gs instanceof GeneralStaff) {

					GeneralStaff gst = (GeneralStaff) gs;

					if(  this.duty.equalsIgnoreCase(gst.getDuty())) {

						return true;
					}

				}}
			return false;

		}
		//
		@Override

		public String toString() {
			
			String s = super.toString()  + String.format(


					" GeneralStaff: Duty: %10s", this.duty)  ;


			return s;

		}
		
		
}
