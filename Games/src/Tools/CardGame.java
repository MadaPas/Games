package Tools;
import java.util.ArrayList;


/**
 * @TODO:Convert this to an interface
 */
public class CardGame extends Game {

	public CardGame() {
		// should set up default things for card games, instead of it being merely a library
	}


	// Description: prints remaining cards for a single player
	public void printRemainingCards(Player player) {
		System.out.print(player.getName() + "'s Remaining Cards: " + player.handSize());
	}


	// Description: prints amount remaining cards for all players
	public void printAllPlayersRemainingCards(ArrayList < Player > players) {
		int onPlayer = 0;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).hasCards()) {
				printRemainingCards(players.get(i));
				if (onPlayer != getNumOfPlayersWithCards(players) - 1)
					System.out.print("  |  ");
				onPlayer++;
			}
		}
		System.out.println();
	}


	// Description: returns number of players with cards
	public int getNumOfPlayersWithCards(ArrayList < Player > players) {
		int playersWithCards = 0;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).hasCards())
				playersWithCards++;
		}
		return playersWithCards;
	}
}