import java.util.Random;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DiceRoll {

	public static void main(String[] args) {
		int side1, side2, total1, total2; // integers for user inputted sides
		float avg1, avg2; // floats for the total and avg
		int roll1, roll2, roll3, roll4, roll5, roll6; // integers for the 
		Random gen = new Random();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many sides does die 1 have? "); // side one question
		side1 = scan.nextInt(); // logs as an integer
		System.out.print("How many sides does die 2 have? "); // side two question
		side2 = scan.nextInt(); // logs as an integer
		
		scan.close();
		
		roll1 = gen.nextInt(side1) + 1; // six different rndm generators, all with + 1 to keep the dice > 0.
		roll2 = gen.nextInt(side2) + 1;
		roll3 = gen.nextInt(side1) + 1;
		roll4 = gen.nextInt(side2) + 1;
		roll5 = gen.nextInt(side1) + 1;
		roll6 = gen.nextInt(side2) + 1;
		
		total1 = roll1 + roll3 + roll5;
		avg1 = (float) total1 / 3; // avg1 sum, declared as float so format displays correct output
		total2 = roll2 + roll4 + roll6;
		avg2 = (float) total2 / 3; // avg2 sum, declared as float so format displays correct output
		
		DecimalFormat formatAvg1 = new DecimalFormat("###.##");
		DecimalFormat formatAvg2 = new DecimalFormat("###.##");
		
		System.out.println("Die 1 first roll = " + roll1 + ".");
		System.out.println("Die 2 first roll = " + roll2 + ".");
		System.out.println("Die 1 second roll = " + roll3 + ".");
		System.out.println("Die 2 second roll = " + roll4 + ".");
		System.out.println("Die 1 third roll = " + roll5 + ".");
		System.out.println("Die 2 third roll = " + roll6 + ".");
		System.out.println("Die 1 rolled a total of " + total1 + " amd rolled " + formatAvg1.format(avg1) + " on average");
		System.out.println("Die 2 rolled a total of " + total2 + " and rolled " + formatAvg2.format(avg2) + " on average.");
		
	}

}
