/**
 * 
 */
package ideas.problem.snakeladder.model;

/**
 * The Class GameDefinition.
 *
 * @author Avinash Pandey
 */
public abstract class GameDefinition {

	/**
	 * Define rules.
	 */
	public abstract void defineRules();

	/**
	 * Play game.
	 */
	public abstract void playGame();

	/**
	 * End game.
	 */
	public abstract void endGame();

	/**
	 * Start.
	 */
	public final void start() {
		defineRules();
		playGame();
		endGame();
	}
}
