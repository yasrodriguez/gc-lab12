/**
 * This player always returns Rock.
 * 
 * @author Yasmin
 *
 */
public class RockPlayer extends Player {

	@Override
	public Roshambo generateRoshambo() {
		return Roshambo.ROCK;
	}

}
