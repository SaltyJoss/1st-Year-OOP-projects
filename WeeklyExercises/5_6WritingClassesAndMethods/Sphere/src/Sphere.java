import java.text.DecimalFormat;

public class Sphere {
	int diameter;
	
	Sphere(int diameter){	
		this.diameter = diameter;
		
	}
	int getDiameter() {
		return diameter;
		
	}
	// sets volume
	double calVolume() {
		double radius, volume;
		radius = (double) diameter / 2;
		return volume = (double) ((4 / 3) * Math.PI * Math.pow(radius, 3));
		
	}
	// sets surfaceArea
	double calSurfArea() {
		double radius, surfaceArea;
		radius = (double) diameter / 2;
		return surfaceArea = (double) (4 * Math.PI * Math.pow(radius, 2));
		
	}
	// toString compile
	public String toString() {
		double radius;
		
		DecimalFormat fmt = new DecimalFormat("###.###");
		radius = (double) diameter / 2;
		return "The sphere has a diameter of " + diameter + "cm.\n It has a radius of " + fmt.format(radius) + "cm.\n"
				+ "It also has a volume of " + fmt.format(calVolume()) + "cm^3, and, a surface area of " + fmt.format(calSurfArea()) + "cm^2.";
		
	}
}
