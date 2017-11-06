/**
 * Stores the player's name and Roshambo value selected by the player.
 * 
 * @author Yasmin
 *
 */
public abstract class Player {
	private String name;
	private Roshambo roshambo;

	public abstract Roshambo generateRoshambo();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Roshambo getRoshambo() {
		return roshambo;
	}

	public void setRoshambo(Roshambo roshambo) {
		this.roshambo = roshambo;
	}

}
