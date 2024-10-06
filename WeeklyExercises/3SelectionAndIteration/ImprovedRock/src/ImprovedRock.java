
import java.util.Scanner;
import java.util.Random;

public class ImprovedRock
{
	public static void main(String[] args)
	{
		String personPlay;    //User's play -- "R", "P", or "S"
		String computerPlay = "";  //Computer's play -- "R", "P", or "S"
		int computerInt;      //Randomly generated number used to determine
		int player1 = 0;	// count for player
		int computer = 0;	// count for computer
		
		System.out.println("-------------------------------------");
		System.out.println("Welcome to ROCK, PAPER, OR, SCISSORS!\n\"R\" = ROCK\n\"P\" = PAPER\n\"S\" = SCISSORS\nFirst to 3 wins!\nHAVE FUN!");
		System.out.println("-------------------------------------");
		System.out.println("");
		
		Scanner scan = new Scanner(System.in);
		Random generator = new Random(); // random generator variable for computerPlay to utilise 
		
		while ((player1 < 3) && (computer < 3)) { // while loop that uses an OR operator to check if either have reached the alloted score of 3!
			System.out.print("R, P, OR S? ");
			personPlay = scan.next().toUpperCase(); // changes the users input to an uppercase value
			
			computerInt = generator.nextInt(3); // uses Random function to randomly generates a number between 0-2
	        
			switch (computerInt) { // switches computerInt to one of the values (0,1,2)
		        case 0:
		        	computerPlay = "R"; // allocates the integer 0 to "R"
		        	break;
		        case 1:
		        	computerPlay = "P"; // allocates the integer 1 to "P"
		        	break;
		        case 2:
		        	computerPlay = "S"; // allocates the integer 2 to "S"
		        	break;
			}
			
	        
			if (personPlay.equals(computerPlay)) {
				System.out.println("Computer chose: " + computerPlay + ".");
				System.out.println("It's a tie! No points given!");
			}
			else if (personPlay.equals("R")) {
				System.out.println("Computer chose: " + computerPlay + ".");
				if (computerPlay.equals("S")) {
	                System.out.println("Rock crushes scissors. Point to Player 1!");
	                player1 += 1;
				}
				else if (computerPlay.equals("P")) {
	            	System.out.println("Paper covers rock. Point to the computer!");
	            	computer += 1;
				}
			}
			else if (personPlay.equals("P")) {
				System.out.println("Computer chose: " + computerPlay + ".");
				if (computerPlay.equals("S")) {
	                System.out.println("Scissors cut paper. Point to the computer!");
	                computer += 1;
				} 
				else if (computerPlay.equals("R")) { 
	            	System.out.println("Paper covers rock. Point to Player 1!");
	            	player1 += 1;
				}
			} 
			else if (personPlay.equals("S")){
				System.out.println("Computer chose: " + computerPlay + ".");
				if (computerPlay.equals("R")) {
	                System.out.println("Rock crushes scissors. Point to the computer!");
	                computer += 1;
				} 
				else if (computerPlay.equals("P")) {
	            	System.out.println("Scissors cut paper. Point to Player 1!");
	            	player1 += 1;
				}
			}
			else {
	        	System.out.println("Incorrect go! Try again!");
			}
			
		}
		
		if (player1 == 3) {
			System.out.println("");
			System.out.println("-------------------------------------");
			System.out.println("PLAYER 1 BETA THE COMPUTER: " + player1 + " to " + computer + "!");
			System.out.println("-------------------------------------");
		}
		else {
			System.out.println("");
			System.out.println("-------------------------------------");
			System.out.println("THE COMPUTER BEAT PLAYER 1: " + computer + " to " + player1 + "!");
			System.out.println("-------------------------------------");
		}
	}
}