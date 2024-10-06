
public class csgoStats extends PlayerStats {
	private String position;
	
	csgoStats(String sportName, String playerName, String nationPlayer, int gamesPlayed){
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
	
	String getPos() {
		position = "AWPer";
		return position;
		
	}
	
	public String toString() {
		return "|      " + getSportName() + "      |   " + "ATHLETE NAME" + "   |   " + getPlayerName() + "   |\n"
				+ "|                |    " + "COMPS DONE" + "    |           " + getGamesPlayed() + "           |\n"
				+ "|                |   " + "NATIONALITY" + "    |         " + getNationPlayer() + "         |\n"
				+ "|                |     " + "POSITION" + "     |          " + getPos() + "          |";
	}
}
