import java.util.Random;

public class Card {
	int type, value;
	String strValue, strType;
	
	public Card(int type, int value){
		this.type = type;
		this.value = value;
		
	}
	
	String getCard() {
		Random gen = new Random();
		value = gen.nextInt(14);
		
		switch (value){
			case 0:
				strValue = "1";
				break;
			case 1:
				strValue = "2";
				break;
			case 2:
				strValue = "3";
				break;
			case 3:
				strValue = "4";
				break;
			case 4:
				strValue = "5";
				break;
			case 5:
				strValue = "6";
				break;
			case 6:
				strValue = "7";
				break;
			case 7:
				strValue = "8";
				break;
			case 8:
				strValue = "9";
				break;
			case 9:
				strValue = "10";
				break;
			case 10:
				strValue = "Jest";
				break;
			case 11:
				strValue = "Queen";
				break;
			case 12:
				strValue = "King";
				break;
			case 13:
				strValue = "Ace";
				break;
				
		}
		return strValue;
		
	}
	
	String getSuite() {
		Random gen = new Random();
		type = gen.nextInt(4);
		
		switch(type) {
			case 0:
				strType = "Spades";
				break;
			case 1:
				strType = "Hearts";
				break;
			case 2:
				strType = "Diamonds";
				break;
			case 3:
				strType = "Clubs";
				break;
		}
		return strType;
		
	}
	
	String setCard() {
		return getCard() + " of " + getSuite();
	}
	
	
	
	public String toString() {
		return "Card One: " + setCard() + "\n" +
				"Card Two: " + setCard() + "\n" +
				"Card Three: " + setCard() + "\n" +
				"Card Four: " + setCard() + "\n" +
				"Card Five: " + setCard() + "\n";
	}
	
}
