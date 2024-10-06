
public class Grades {

	public static void main(String[] args) {
		System.out.println("///////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.println("==          Student Points          ==");
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////");
		System.out.println("");
		System.out.println("");
		
		final Object[][] table = new String[7][];
		table[0] = new String[] { "Name", "Lab", "Bonus", "Total" };
		table[1] = new String[] { "----", "---", "-----", "-----" };
		table[2] = new String[] { "William", "69", "11", "80" };
		table[3] = new String[] { "Joss", "54", "19", "73" };
		table[4] = new String[] { "Ollie", "67", "5", "72" };
		table[5] = new String[] { "Aflie", "89", "10", "99" };
		table[6] = new String[] { "Nathan", "56", "6", "62" };

		for (final Object[] row : table) {
		    System.out.format("%-15s%-9s%-9s%-9s%n", row);
		}
	}

}
