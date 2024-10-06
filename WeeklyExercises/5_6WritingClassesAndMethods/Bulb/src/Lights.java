import java.util.Scanner;

public class Lights {

	public static void main(String[] args) {
		String lightState;
		int count = 0;
		boolean bulbState = false;
		
		Scanner scan = new Scanner(System.in);
		
		while (count <= 0) {
			System.out.print("Would you like to turn the light ON / OFF? ");
			lightState = scan.next().toUpperCase();
			
			Bulb obj = new Bulb(bulbState, lightState);
			
			System.out.println(obj);
			System.out.println("");
		}
	}

}
