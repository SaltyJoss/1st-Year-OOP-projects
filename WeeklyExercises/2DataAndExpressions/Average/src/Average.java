import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		int val1, val2, val3;
		double average;
	    Scanner scan = new Scanner(System.in) ;

	    // get three values from user
	    System.out.println("Please enter three integers and " +
	                       "I will compute their average");
	       
	    System.out.print("Enter the first value: ");
	    val1 = scan.nextInt();
	       
	    System.out.print("Enter the second value: ");
	    val2 = scan.nextInt();
	       
	    System.out.print("Enter the third value: ");
	    val3 = scan.nextInt();
	    
	    // closes scan
	    scan.close();
	       
	    //compute the average
	    average = (double)(val1 + val2 + val3) / 3;
	       
	    //print the average
	    System.out.print("The average is " + average);

	}

}
