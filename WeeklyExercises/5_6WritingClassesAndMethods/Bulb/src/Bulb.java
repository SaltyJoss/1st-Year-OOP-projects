
public class Bulb {
	boolean bulbState;
	String lightState;
	
	// constructor
	Bulb(boolean bulbState, String lightState){
		this.bulbState = bulbState;
		this.lightState = lightState;
		
	}

	// getting the bulbs state
	boolean getBulb() {
		if (lightState.equals("ON")) {
			bulbState = true;
			return bulbState;
			
		}
		else if (lightState.equals("OFF")) {
			bulbState = false;
			return bulbState;
			
		}
		else {
			return bulbState;
		}
	}
	
	public String toString() {
		return "Light is on: " + getBulb();
		
	}
	
}
