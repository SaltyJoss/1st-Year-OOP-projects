
public class Doctor extends Employee {
	private String specialise;
	
	Doctor(String name){
		this.name = name;
		
	}

	String setName() {
		name = "Denise Barton";
		
		return name;
	}

	String setSpecialise() {
		specialise = "Neuro-Surgery";
		
		return specialise;
	}
	
	public String toString() {
		return "Doctor " + setName() + " specialises in " + setSpecialise() + ".";
		
	}

}
