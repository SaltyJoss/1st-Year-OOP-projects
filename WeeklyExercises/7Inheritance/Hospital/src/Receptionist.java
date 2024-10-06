
public class Receptionist extends Employee {
	private String sector;
	
	Receptionist(String name){
		this.name = name;

	}
	
	String setName() {
		name = "Jenny Matthews";
		
		return name;
	}
	
	String setSector() {
		sector = "Neuro Science";
		
		return sector;
	}
	
	public String toString() {
		return "Receptionist " + setName() + " deals with the " + setSector() + " sector.";
	}
}
