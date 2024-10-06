
public class FootballStats extends PlayerStats {
	private int goals;
	
	FootballStats(String sportName, String playerName, String nationPlayer, int gamesPlayed){
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
	
	int getGoals() {
		goals = 127;
		return goals;
	}
	
	public String toString() {
		return "|    " + getSportName() + "    |   " + "ATHLETE NAME" + "   |      " + getPlayerName() + "      |\n"
				+ "|                |   " + "GAMES PLAYED" + "   |           " + getGamesPlayed() + "           |\n"
				+ "|                |   " + "NATIONALITY" + "    |         " + getNationPlayer() + "         |\n"
				+ "|                |   " + "GOALS SCORED" + "   |           " + getGoals() + "           |";
	}
}
