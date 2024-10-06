
public class PowerliftingStats extends PlayerStats {
	private String weightclass;
	
	PowerliftingStats(String sportName, String playerName, String nationPlayer, int gamesPlayed){
		super(sportName, playerName, nationPlayer, gamesPlayed);
	}
	
	String getSportName() {
		return sportName;
	}
	
	String getPlayerName() {
		return playerName;
		
	}
	
	String getNationPlayer() {
		return nationPlayer;
		
	}
	
	int getGamesPlayed() {
		return gamesPlayed;
	}
	
	String getWeight() {
		weightclass = "u93kg";
		return weightclass;
		
	}
	
	public String toString() {
		return "|  " + getSportName() + "  |   " + "ATHLETE NAME" + "   |       " + getPlayerName() + "       |\n"
				+ "|                |    " + "COMPS DONE" + "    |           " + getGamesPlayed() + "            |\n"
				+ "|                |   " + "NATIONALITY" + "    |        " + getNationPlayer() + "         |\n"
				+ "|                |   " + "WEIGHT CLASS" + "   |          " + getWeight() + "          |";
	}
}
