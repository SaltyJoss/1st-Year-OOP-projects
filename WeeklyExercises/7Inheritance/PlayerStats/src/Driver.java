
public class Driver {

	public static void main(String[] args) {
		PlayerStats sport1 = new PlayerStats("Football", "David Beckham", "England", 724);
		PlayerStats sport2 = new PlayerStats("Rugby", "Owen Farrel", "England", 247);
		PlayerStats sport3 = new PlayerStats("CSGO", "Oleksandr Kostyliev", "Ukraine", 917);
		PlayerStats sport4 = new PlayerStats("Powerlifting", "Russel Orhi", "American", 19);
		
		System.out.println(" _____________________________________________________________");
		System.out.println("|   SPORT NAME   |     INFO-ASK     |          STATS          |");
		System.out.println("|----------------|------------------|-------------------------|");
		System.out.println(sport1.setFtbll());
		System.out.println("|----------------|------------------|-------------------------|");
		System.out.println(sport2.setRgby());
		System.out.println("|----------------|------------------|-------------------------|");
		System.out.println(sport3.setCSGO());
		System.out.println("|----------------|------------------|-------------------------|");
		System.out.println(sport4.setPwrlfting());
		System.out.println("|________________|__________________|_________________________|");
		
	}
}
