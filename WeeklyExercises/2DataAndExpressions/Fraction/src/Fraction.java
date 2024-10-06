import java.util.Scanner;

public class Fraction {

	public static void main(String[] args) {
		int val1, val2;
		double output;
		Scanner scan = new Scanner(System.in);
		System.out.println("We will now find the decimal equivalent of a fraction:");
		
		System.out.print("Enter the Numerator's value: ");
		val1 = scan.nextInt();
		
		System.out.print("Enter the Denominator's value: ");
		val2 = scan.nextInt();
		
		scan.close();
		
		output = (double)val1 / val2;
		
		System.out.print("Decimal Equivalent: " + output);
		
	}

}
