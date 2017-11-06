import java.util.HashMap;
import java.util.Scanner;

/**
 * Allows the user to play against either the Rock Player or the Random Player.
 * 
 * @author Yasmin
 *
 */
public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Rock Paper Scissors!");

		String playerName = Validator.getString(scan, "Enter your name: ");
		System.out.println();
		int opponent = Validator.getInt(scan,
				"Would you like to play against (1/2):\n 1.The Lions or\n 2.The Eagles (1/2)? ",
				1, 2);
		System.out.println();

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

		user.setRoshambo(user.generateRoshambo());
		computer.setRoshambo(computer.generateRoshambo());

		System.out.println();
		System.out.println(user.getName() + ": " + user.getRoshambo());
		System.out.println(computer.getName() + ": " + computer.getRoshambo());
		System.out.println();

		System.out.println(determineWinner(user, computer));
	}

	/**
	 * Gets the Roshambo for each player and determines who won.
	 * 
	 * @param player1
	 *            a player
	 * @param player2
	 *            a player
	 * @return name of the player who won, or the word Draw
	 */
	public static String determineWinner(Player player1, Player player2) {
		String result = "";

		if (player1.getRoshambo() == player2.getRoshambo()) {
			result = "Draw!";
		}
		else {
			HashMap<Player, Roshambo> results = new HashMap<>();
			results.put(player1, player1.getRoshambo());
			results.put(player2, player2.getRoshambo());

			if (results.containsValue(Roshambo.ROCK) && results.containsValue(Roshambo.PAPER)) {
				result = player1.getRoshambo() == Roshambo.PAPER ? player1.getName() : player2.getName();
			} else if (results.containsValue(Roshambo.PAPER) && results.containsValue(Roshambo.SCISSORS)) {
				result = player1.getRoshambo() == Roshambo.SCISSORS ? player1.getName() : player2.getName();
			} else { // ROCK & SCISSORS
				result = player1.getRoshambo() == Roshambo.ROCK ? player1.getName() : player2.getName();
			}

			result += " wins!";
		}

		return result;
	}

}
