
import java.util.Scanner;
import java.util.Random;

public class Rock
{
	public static void main(String[] args)
	{
		String personPlay;    //User's play -- "R", "P", or "S"
		String computerPlay = "";  //Computer's play -- "R", "P", or "S"
		int computerInt;      //Randomly generated number used to determine
		
		Scanner scan = new Scanner(System.in);
		Random generator = new Random(); // random gen for computer play
		computerInt = generator.nextInt(3); // randomly generates a number between 0-2
      
		System.out.print("R, P, OR S? ");
		personPlay = scan.next().toUpperCase(); // changes the users input to an uppercase value
		
        
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
			System.out.println("It's a tie!");
		}
		else if (personPlay.equals("R")) {
			System.out.println("Computer chose: " + computerPlay + ".");
			if (computerPlay.equals("S")) {
                System.out.println("Rock crushes scissors.  You win!!");
			}
			else if (computerPlay.equals("P")) {
            	System.out.println("Paper covers rock. You lose!!");
			}
		}
		else if (personPlay.equals("P")) {
			System.out.println("Computer chose: " + computerPlay + ".");
			if (computerPlay.equals("S")) {
                System.out.println("Scissors cut paper.  You lose!!");
			} 
			else if (computerPlay.equals("R")) { 
            	System.out.println("Paper covers rock. You win!!");
			}
		} 
		else if (personPlay.equals("S")){
			System.out.println("Computer chose: " + computerPlay + ".");
			if (computerPlay.equals("R")) {
                System.out.println("Rock crushes scissors.  You lose!!");
			} 
			else if (computerPlay.equals("P")) {
            	System.out.println("Scissors cut paper. You win!!");
			}
		}
		else {
        	System.out.print("Incorrect go! Try again later!");
		}

	}
}