
public class Employee {
	protected String name;
	
	Doctor setDoctor() {
		Doctor doct = new Doctor(name);
		
		return doct;
	}
	
	Nurse setNurse() {
		Nurse nurs = new Nurse(name);
		
		return nurs;
	}
	
	Cleaner setCleaner() {
		Cleaner clean = new Cleaner(name);
		
		return clean;
	}
	
	Receptionist setReception() {
		Receptionist reception= new Receptionist(name);
		
		return reception;
	}
	
	public String toString() {
		return setDoctor() + "\n"
				+ setNurse() + "\n"
				+ setCleaner() + "\n"
				+ setReception() + "\n";
		
	}
}