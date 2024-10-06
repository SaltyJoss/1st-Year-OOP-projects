
public class Punctuation { // code as a whole feel like this would get very long very quick

	public static void main(String[] args) {
		String PuncMarks = "Mary had a little lamb, her fleece was as white as snow, and everywhere Mary went, the lamb was sure to go. -that was a nice poem- the end."; // sentence string
		char comma = ','; // singling out ',' for later use
		int commaCount = 0; // count for said character
		char hyphen = '-'; // singling out '-' for later use
		int hyphenCount = 0;
		char period = '.'; // singling out '.' for later use
		int periodCount = 0;		
		
		for (int i = 0; i < PuncMarks.length(); i++) { // for loop that runs through the length of PuncMarks string, and adds it too i along as it's less than the length of the string
			if (PuncMarks.charAt(i) == comma) { // if statement checking that any of comma are within the string, using .charAt() to find the specific place(s)
				commaCount++;
			}
			if (PuncMarks.charAt(i) == hyphen) { // if statement checking that any of dash are within the string, using .charAt() to find the specific place(s)
				hyphenCount++;
			}
			if (PuncMarks.charAt(i) == period) { // if statement checking that any of period are within the string, using .charAt() to find the specific place(s)
				periodCount++;
			}
		}
		System.out.println("The sentence:\n\"Mary had a little lamb, her fleece was as white as snow,\n and everywhere Mary went, the lamb was sure to go.\n -that was a nice poem-\n the end.\"");
		System.out.println();
		System.out.println("    Type of Punctuation     |  Amount of times appeared");
		System.out.println("----------------------------|----------------------------");
		System.out.println("                            |");
		System.out.println("            Comma,          |           " + commaCount + " times");
		System.out.println("                            |");
		System.out.println("----------------------------|----------------------------");
		System.out.println("                            |");
		System.out.println("           Hypehen-         |           " + hyphenCount + " times");
		System.out.println("                            |");
		System.out.println("----------------------------|----------------------------");
		System.out.println("                            |");
		System.out.println("            Period.         |           " + periodCount + " times");
		System.out.println("                            |");
	}

}

// (PuncMarks.charAt(i) == comma)
// (PuncMarks.charAt(i) == hyphen)
// (PuncMarks.charAt(i) == period)