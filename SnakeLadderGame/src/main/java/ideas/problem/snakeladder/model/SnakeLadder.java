/**
 * 
 */
package ideas.problem.snakeladder.model;

import ideas.problem.snakeladder.service.GameUtility;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * The Class SnakeLadder.
 *
 * @author Avinash Pandey
 */
public class SnakeLadder extends GameDefinition {

	/** The snakes. */
	private Map<String, Integer> snakes;

	/** The ladders. */
	private Map<String, Integer> ladders;

	/** The Constant GAME_PROPERTY_FILE. */
	private static final String GAME_PROPERTY_FILE = "snakeladder.properties";

	/** The winning score. */
	private final int WINNING_SCORE = 10 * 10;

	/** The random generator. */
	private Random randomGenerator;

	/** The moves count. */
	private int movesCount = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ideas.problem.snakeladder.model.GameDefinition#defineRules()
	 */
	@Override
	public void defineRules() {
		// Add the snakes and ladder
		Properties properties = GameUtility
				.loadGameElements(GAME_PROPERTY_FILE);
		if (properties.keySet() != null & !properties.keySet().isEmpty()) {
			snakes = new HashMap<String, Integer>();
			ladders = new HashMap<String, Integer>();
			for (Object key : properties.keySet()) {
				String propKey = (String) key;
				if (propKey.contains("Snake")) {
					addGameElements(properties, propKey, snakes);
				} else if (propKey.contains("Ladder")) {
					addGameElements(properties, propKey, ladders);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ideas.problem.snakeladder.model.GameDefinition#playGame()
	 */
	@Override
	public void playGame() {
		// Start the two player game
		Player player1 = new Player("Player-1");
		Player player2 = new Player("Player-2");
		while (true) {
			if (rollsDice(player1))
				break;

			if (rollsDice(player2))
				break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ideas.problem.snakeladder.model.GameDefinition#endGame()
	 */
	@Override
	public void endGame() {
		System.out.println("\nThe game ended after " + movesCount + " moves.");
	}

	/**
	 * Adds the game elements.
	 *
	 * @param properties
	 *            the properties
	 * @param propKey
	 *            the prop key
	 * @param gameElements
	 *            the game elements
	 */
	public void addGameElements(Properties properties, String propKey,
			Map<String, Integer> gameElements) {
		String value = (String) properties.get(propKey);
		if (value != null) {
			String keyValue[] = value.split(",");
			gameElements.put(keyValue[0], Integer.valueOf(keyValue[1]));
		}
	}

	/**
	 * Rolls dice.
	 *
	 * @param player
	 *            the player
	 * @return true, if successful
	 */
	public boolean rollsDice(Player player) {
		if (randomGenerator == null)
			randomGenerator = new Random();

		int result = randomGenerator.nextInt(6) + 1;
		if ((player.getCurrentPointer() + result) <= 100) {
			movesCount++;
			System.out.println(player.getName() + " rolls dice and gets >> "
					+ result + " :: Current :: " + player.getCurrentPointer()
					+ " and now moves to :: "
					+ (player.getCurrentPointer() + result));
			player.setCurrentPointer(player.getCurrentPointer() + result);

			snakeLadderCheck(player);

			if (player.getCurrentPointer() == WINNING_SCORE) {
				System.out.println("\n" + player.getName()
						+ " has won the game.");
				return true;
			}
		}
		return false;
	}

	/**
	 * Snake ladder check.
	 *
	 * @param player
	 *            the player
	 */
	public void snakeLadderCheck(Player player) {
		// check in snakes and ladders
		if (snakes.containsKey(String.valueOf(player.getCurrentPointer()))) {
			System.out.println("\n" + player.getName()
					+ " is bitten by snake at :: " + player.getCurrentPointer()
					+ " and is moved down to :: "
					+ snakes.get(String.valueOf(player.getCurrentPointer()))
					+ "\n");
			player.setCurrentPointer(snakes.get(String.valueOf(player
					.getCurrentPointer())));
		} else if (ladders.containsKey(String.valueOf(player
				.getCurrentPointer()))) {
			System.out.println("\n" + player.getName()
					+ " found a ladder at :: " + player.getCurrentPointer()
					+ " and is moved up to :: "
					+ ladders.get(String.valueOf(player.getCurrentPointer()))
					+ "\n");
			player.setCurrentPointer(ladders.get(String.valueOf(player
					.getCurrentPointer())));
		}
	}
}
