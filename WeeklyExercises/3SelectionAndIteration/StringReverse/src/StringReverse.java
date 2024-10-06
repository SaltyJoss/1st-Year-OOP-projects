import java.util.Scanner;

public class StringReverse { // took me some trial and error, using what we learned in this lesson applied with some outside knowledge grabbed from our python syntax.

	public static void main(String[] args) {
		String sentence; // string allocation for the variable sentence
		String sentenceRev = ""; // string variable for the reversed sentence
		String Reversed = ""; // assigning the String "Reversed" to nothing
		Scanner scan = new Scanner(System.in); // scanner function being set
		
		System.out.print("Tell me a sentence: ");
		sentence = scan.nextLine(); // initial scan for user input
		scan.close();
		
		for (int i = 0; i < sentence.length(); i++) { // for loop uses i as 0, saying as long as i is less than the length of the string then add amount to i
			sentenceRev = sentence.charAt(i) + sentenceRev; // for loop is active, adds each character, from 0 onwards, to the new variable (creates that reversed look) | i think i could've done "senctenceRev += sentence.charAt(i);"
		}
		
		String[] strArray = sentenceRev.split(" "); // splits the contents just added to array based on whitespace
		for (int i = strArray.length - 1; i >= 0; i--) { // for loop that allocated i to an integer that is equal to the length of strArray - 1, STOPS once i is less than 0 
			  Reversed += (strArray[i] + " "); // strArray with whatever index value of i, added with whitespace, is allocated to string variable "Reversed"
			}
		
		System.out.print("Your sentence reversed: " + Reversed.trim()); // prints the final product with .trim() to remove any extra whitespace at each end of the string
	}

}
