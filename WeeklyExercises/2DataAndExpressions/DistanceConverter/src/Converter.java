import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		double val1, output;
		Scanner scan = new Scanner(System.in) ;
		System.out.println("We will now convert miles to kilometers:");
		
		System.out.print("Please enter a distance in Miles: ");
		val1 = scan.nextDouble();
		
		scan.close();
		
		output = (double)(val1 * 1.60935);
		
		System.out.println("In miles: " + val1 + " m\n" +
				"In Kilometers: " + output +" km");
	}

}
