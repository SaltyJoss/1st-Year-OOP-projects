import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

public class SphereCal {

	public static void main(String[] args) {
		double radius, volume, surfaceArea;
		
		Scanner scan = new Scanner(System.in);
		DecimalFormat decimalFormat = new DecimalFormat("##0.0000");
		
		System.out.print("Radius of a Sphere (cm): ");
		radius = scan.nextDouble();
		
		volume = (double) (4 * Math.PI * Math.pow(radius, 3)) / 3;
		surfaceArea = (double) 4 * Math.PI * Math.pow(radius, 2);
		
		System.out.println("The Radius of the sphere is: " + radius + "cm");
		System.out.println("The Volume of the sphere is: " + decimalFormat.format(volume) + "cm^3");
		System.out.println("The Surface Area of the sphere is: " + decimalFormat.format(surfaceArea) + "cm^2");
	}

}
