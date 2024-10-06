
import java.util.Scanner;
import java.text.NumberFormat;


public class Salary
{
   public static void main (String[] args)
   {
       double currentSalary;  // employee's current  salary
       double raise = 0;          // amount of the raise
       double newSalary;      // new salary for the employee
       String rating;         // performance rating


       Scanner scan = new Scanner(System.in);


       System.out.print ("Enter the current salary: ");
       currentSalary = scan.nextDouble();
       System.out.print ("Enter the performance rating (Excellent, Good, or Poor): ");
       rating = scan.next();


       // Compute the raise using if ...
       if (rating.equals("Excellent")) { // string.equals(Object) method for all if / else if helps create a True / False
    	   raise = (double) currentSalary * .06;
       }
       else if (rating.equals("Good")) {
    	   raise = (double) currentSalary * .04;
       }
       else if (rating.equals("Poor")) {
    	   raise = (double) currentSalary * .015;
       }
       else {
    	   System.out.print("Error Raised with answer!");
       }
       
       newSalary = currentSalary + raise;


       // Print the results
       NumberFormat money = NumberFormat.getCurrencyInstance();
       System.out.println();
       System.out.println("Current Salary:       " + money.format(currentSalary));
       System.out.println("Amount of your raise: " + money.format(raise));
       System.out.println("Your new salary:      " + money.format(newSalary));
       System.out.println();
    }
}