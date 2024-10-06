
public class PlayerStats {

	protected String sportName, playerName, nationPlayer;
	protected int gamesPlayed;
	
	PlayerStats(String sportName, String playerName, String nationPlayer, int gamesPlayed){
		this.sportName = sportName;
		this.playerName = playerName;
		this.nationPlayer = nationPlayer;
		this.gamesPlayed = gamesPlayed;
	}
	
	public PowerliftingStats setPwrlfting(){
		PowerliftingStats go = new PowerliftingStats(sportName, playerName, nationPlayer, gamesPlayed);
		return go;
	}
	
	public FootballStats setFtbll() {
		FootballStats go = new FootballStats(sportName, playerName, nationPlayer, gamesPlayed);
		return go;
	}
	
	public RugbyStats setRgby() {
		RugbyStats go = new RugbyStats(sportName, playerName, nationPlayer, gamesPlayed);
		return go;
	}
	
	public csgoStats setCSGO() {
		csgoStats go = new csgoStats(sportName, playerName, nationPlayer, gamesPlayed);
		return go;
	}
	
}
