
public class RugbyStats extends PlayerStats {
	private int tries;
	
	RugbyStats(String sportName, String playerName, String nationPlayer, int gamesPlayed){
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
	
	int getTries() {
		tries = 18; 
		return tries;
	}
	
	public String toString() {
		return "|     " + getSportName() + "      |   " + "ATHLETE NAME" + "   |        " + getPlayerName() + "      |\n"
				+ "|                |   " + "GAMES PLAYED" + "   |           " + getGamesPlayed() + "           |\n"
				+ "|                |   " + "NATIONALITY" + "    |         " + getNationPlayer() + "         |\n"
				+ "|                |   " + "TRIES SCORED" + "   |            " + getTries() + "           |";
	}
}
