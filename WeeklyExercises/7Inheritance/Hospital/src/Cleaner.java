
public class Cleaner extends Employee {
	private String department;
	
	Cleaner(String name){
		this.name = name;
		
	}
	
	String setName() {
		name = "Ted Baker";
		
		return name;
	}
	
	String setDepartment() {
		department = "Light-Duty Specialist";
		
		return department;
	}
	
	public String toString() {
		return "Cleaner " + setName() + " is a " + setDepartment() + " for the 4th floor.";
	}
}
