package Tools;
/**
 * Description: Class that holds properties for a standard Card.
 * I.e. Value of the card as well as type .
 **/
public class Card {

	private final int value;
	private final String suit;
	private final String cardName;

	// Description:Creates a new Card [Default]
	public Card() {
		value = 0;
		suit = "";
		cardName = "";
	}


	// Description:Creates a new card with supplied parameters
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
		this.cardName = setCardName();
	}


	// Description:Gets the value of the card
	public int getValue() {
		return this.value;
	}


	// Description:Gets the type of the card
	public String getSuit() {
		return this.suit;
	}


	// Description:Gets the name of the card based on value and type
	public String setCardName() {
		if (this.value == 11) {
			return "Jack of " + suit;
		} else if (this.value == 12) {
			return "Queen of " + suit;
		} else if (this.value == 13) {
			return "King of " + suit;
		} else if (this.value == 14) {
			return "Ace of " + suit;
		} else
			return value + " of " + suit;
	}

	public String getCardName() {
		return cardName;
	}
}