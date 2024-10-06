import java.util.Scanner;

public class cardDealer {

	public static void main(String[] args) {
		int type = 0, value = 0, count = 0;
		String answer;
		Scanner scan = new Scanner(System.in);
		
		while (count == 0) {
			System.out.print("Would you like to see 5 random cards (Y/N) ? ");
			answer = scan.next().toUpperCase();
			
			if (answer.equals("Y")) {
				Card obj = new Card(type, value);
				System.out.println(obj);
				System.out.print("");
			}
			else {
				System.out.println("");
				System.out.println("OKAY, GOODBYE!");
				count ++;
			}
			
		}

	}

}
