/**
 * Stores the player's name, Roshambo value selected by the player, and their
 * score.
 * 
 * @author Yasmin
 *
 */
public abstract class Player {
	private String name;
	private Roshambo roshambo;
	private int score;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
