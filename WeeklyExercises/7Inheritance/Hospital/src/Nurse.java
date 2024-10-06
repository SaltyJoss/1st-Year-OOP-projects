
public class Nurse extends Employee {
	private int patient;
	
	Nurse(String name){
		this.name = name;

	}
	
	String setName() {
		name = "Steven Emberton";
		
		return name;
	}
	
	int setPatient() {
		patient = 11;
		
		return patient;
		
	}
	
	public String toString() {
		return "Nurse " + setName() + " has " + setPatient() + " patients.";
		
	}
	
}