import java.util.Scanner;

public class SqurCal {

	public static void main(String[] args) {
		int val1, peri, area;
		Scanner scan = new Scanner(System.in);
		System.out.println("We will now find the Perimeter and Area of a sqaure:");
		
		System.out.print("Enter the length of a squares' side: ");
		val1 = scan.nextInt();
		
		peri = val1 * 4;
		area = (int) Math.pow(val1, 2);
		
		System.out.print("The Squares' Perimeter is: " + peri + "cm\n" +
				"The Squares' Area is: " + area + "cm^2");

	}

}
