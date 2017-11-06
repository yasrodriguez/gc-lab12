import java.util.Random;

/**
 * This player randomly selects and returns rock, paper or scissors.
 * 
 * @author Yasmin
 *
 */
public class RandomPlayer extends Player {

	@Override
	public Roshambo generateRoshambo() {
		Random randomNumber = new Random();
		int result = randomNumber.nextInt(3);

		switch (result) {
		case 0:
			return Roshambo.ROCK;
		case 1:
			return Roshambo.PAPER;
		case 2:
			return Roshambo.SCISSORS;
		default:
			return null;
		}
	}
}
