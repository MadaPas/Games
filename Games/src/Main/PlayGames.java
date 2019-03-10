package Main;
import java.util.Scanner;

import games.Hangman;
import games.TicTacToe;
import games.War;
import Tools.Game;

/**
 * Description: Class that handles the executing
 * of games based on the user input.
 **/
public class PlayGames {

	//Possibility to load player profiles and then merely count how many people are playing. (dropdown menu?)


	// Description: Constructor for PlayGame, lets the user play the game they wish to play.
	public PlayGames(String args[]) {
		String[] availableGames = {
				"Tic Tac Toe",
				"Hangman",
				"War (The Card Game)"
		};
		Scanner input = new Scanner(System.in);
		String game, answer;
		System.out.println("Hi there! Welcome to my Game Suite! Do you want to play a game?");
		answer = input.next();
		input.nextLine();
		while (answer.equals("yes") || answer.equals("Yes")) {
			System.out.print("Our available games are: ");

			for (int i = 0; i < availableGames.length; i++) {
				System.out.print(availableGames[i]);
				if (i == availableGames.length - 2)
					System.out.print(" and ");
				else if (i < availableGames.length - 1 && availableGames.length != 2)
					System.out.print(", ");
				else
					System.out.print(".");
			}
			System.out.print("\nWhich of these games would you like to play? ");
			game = input.next();
			input.nextLine();
			System.out.println();

			if (game.toLowerCase().equals("tic")) {
				TicTacToe t = new TicTacToe();
				t.play();
			} else if (game.toLowerCase().equals("hangman")) {
				Hangman h = new Hangman();
				h.play();
			} else if (game.toLowerCase().equals("war")) {
				War w = new War(getNumOfPlayersPlaying(new War()));
				w.play();
			}

			System.out.print("Would you like to play another game?: ");
			answer = input.next();
			input.nextLine();
		} // end of while loop
		System.exit(0);
	} // Lets comment this method and add dates and etc. Definitely needs to be done
	public int getNumOfPlayersPlaying(Game game) {
		System.out.println(game.playerAmountMessage());
		System.out.println("And how many of you will be playing today?");
		Scanner input = new Scanner(System.in);
		int numOfRequestedPlayers = input.nextInt();
		input.nextLine();
		if (!isValidNumOfPlayers(numOfRequestedPlayers, game)) {
			if (numOfRequestedPlayers < game.getMinPlayers()) {
				System.out.println("You have too few players to play this game! \n" +
						"Please gather more players and re-run the program with the correct number of players.");
			} else
				System.out.println("You have too many players to play this game! \n" +
						"Please choose who is playing and re-run the program with the correct number of players.");
			System.exit(0);
		}

		return numOfRequestedPlayers;

	}

	public boolean isValidNumOfPlayers(int n, Game g) {
		return n >= g.getMinPlayers() && n <= g.getMaxPlayers();
	}
}