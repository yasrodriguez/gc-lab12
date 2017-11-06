import java.util.ArrayList;
import java.util.Scanner;

/**
 * This player gets input from the user and returns their selection of rock,
 * paper, or scissors.
 * 
 * @author Yasmin
 *
 */
public class HumanPlayer extends Player {

	@Override
	public Roshambo generateRoshambo() {
		Scanner scan = new Scanner(System.in);

		ArrayList<String> validOptions = new ArrayList<>();
		validOptions.add("R");
		validOptions.add("P");
		validOptions.add("S");
		validOptions.add("r");
		validOptions.add("p");
		validOptions.add("s");

		String userSelection = Validator.getValidString(scan, "Rock, paper, or scissors? (R/P/S)", validOptions);
		if (userSelection.equalsIgnoreCase("R")) {
			return Roshambo.ROCK;
		} else if (userSelection.equalsIgnoreCase("P")) {
			return Roshambo.PAPER;
		} else {
			return Roshambo.SCISSORS;
		}
	}
}
