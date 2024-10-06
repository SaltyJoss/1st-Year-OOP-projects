import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		int diameter;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("What is your diameter: ");
		diameter = scan.nextInt();
		
		Sphere obj = new Sphere(diameter);
		
		System.out.print(obj);
		
	}

}
