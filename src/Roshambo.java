/**
 * Stores 3 values: rock, paper, and scissors.
 * 
 * @author Yasmin
 *
 */
public enum Roshambo {

	ROCK, PAPER, SCISSORS;

	// implement toString method
	public String toString() {
		if (this == ROCK) {
			return "rock";
		} else if (this == PAPER) {
			return "paper";
		} else {
			return "scissors";
		}
	}
}
