import java.util.HashMap;
import java.util.Scanner;

/**
 * Allows the user to play rock, paper, scissors against one of two players. At
 * the end, it returns total score for both players.
 * 
 * @author Yasmin
 *
 */
public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;

		System.out.println("Welcome to Rock Paper Scissors!");

		// Get the user's name and ask which of the two players they want to play
		// against
		String playerName = Validator.getString(scan, "Enter your name: ");
		System.out.println();
		int opponent = Validator.getInt(scan,
				"Would you like to play against (1/2):\n 1.The Lions or\n 2.The Eagles (1/2)? ", 1, 2);
		System.out.println();

		// Instantiate the user's player
		HumanPlayer user = new HumanPlayer();
		user.setName(playerName);

		// Instantiate an opponent player based on the user selection
		Player computer;
		if (opponent == 1) {
			computer = new RandomPlayer();
			computer.setName("The Lions");
		} else {
			computer = new RockPlayer();
			computer.setName("The Eagles");
		}

		while (keepGoing) {

			// Generate and store a Roshambo for both players
			user.setRoshambo(user.generateRoshambo());
			computer.setRoshambo(computer.generateRoshambo());

			System.out.println();
			System.out.println(user.getName() + ": " + user.getRoshambo());
			System.out.println(computer.getName() + ": " + computer.getRoshambo());

			// Get the winner and display the results
			Player winner = determineWinner(user, computer);
			if (winner == null) {
				System.out.println("Draw!");
			} else {
				System.out.println(winner.getName() + " wins!");
			}
			System.out.println();

			// Ask the user if they want to keep playing
			keepGoing = Validator.getYOrN(scan, "Play again? (y/n): ");
			System.out.println();
		}
		scan.close();

		System.out.println("Total Score: ");
		System.out.println(user.getName() + " " + user.getScore());
		System.out.println(computer.getName() + " " + computer.getScore());

		System.out.println();
		System.out.println("Goodbye!");

	}

	/**
	 * Gets the Roshambo for each player and determines who won.
	 * 
	 * @param player1
	 *            a player
	 * @param player2
	 *            a player
	 * @return player who won or null when it's a draw
	 */
	public static Player determineWinner(Player player1, Player player2) {
		Player winner = null;

		if (player1.getRoshambo() == player2.getRoshambo()) {
			return null; // This is a draw, no points are scored in this case
		} else {
			// Adds both player's choice to a hash map so they can be examined more easily
			HashMap<Player, Roshambo> results = new HashMap<>();
			results.put(player1, player1.getRoshambo());
			results.put(player2, player2.getRoshambo());

			if (results.containsValue(Roshambo.ROCK) && results.containsValue(Roshambo.PAPER)) {
				winner = player1.getRoshambo() == Roshambo.PAPER ? player1 : player2;

			} else if (results.containsValue(Roshambo.PAPER) && results.containsValue(Roshambo.SCISSORS)) {
				winner = player1.getRoshambo() == Roshambo.SCISSORS ? player1 : player2;

			} else { // ROCK & SCISSORS
				winner = player1.getRoshambo() == Roshambo.ROCK ? player1 : player2;
			}
		}
		// increase the winner's score
		winner.setScore(winner.getScore() + 1);

		return winner;
	}
}
