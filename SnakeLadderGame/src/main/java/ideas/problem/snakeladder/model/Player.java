/**
 * 
 */
package ideas.problem.snakeladder.model;


/**
 * The Class Player.
 *
 * @author Avinash Pandey
 */
public class Player{
	
	/** The name. */
	private String name;
	
	/** The current pointer. */
	private int currentPointer;
	
	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 */
	public Player(String name) {
		this.name=name;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the current pointer.
	 *
	 * @return the currentPointer
	 */
	public int getCurrentPointer() {
		return currentPointer;
	}
	
	/**
	 * Sets the current pointer.
	 *
	 * @param currentPointer the currentPointer to set
	 */
	public void setCurrentPointer(int currentPointer) {
		this.currentPointer = currentPointer;
	}
}
