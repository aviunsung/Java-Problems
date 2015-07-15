package ideas.problem.snakeladder.model.test;

import java.util.HashMap;
import java.util.Map;

import ideas.problem.snakeladder.model.Player;

import java.util.Properties;

import org.junit.*;

import ideas.problem.snakeladder.model.SnakeLadder;
import static org.junit.Assert.*;

/**
 * @author Avinash Pandey
 */
public class SnakeLadderTest {
	/**
	 * Run the SnakeLadder() constructor test.
	 *
	 */
	@Test
	public void testSnakeLadder_1()
		throws Exception {
		SnakeLadder result = new SnakeLadder();
		assertNotNull(result);
	}

	/**
	 * Run the void addGameElements(Properties,String,Map<String,Integer>) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testAddGameElements_1()
		throws Exception {
		SnakeLadder fixture = new SnakeLadder();
		Properties properties = new Properties();
		String propKey = "snakeladder.properties";
		Map<String, Integer> gameElements = new HashMap<String, Integer>();
		fixture.addGameElements(properties, propKey, gameElements);
	}

	/**
	 * Run the void defineRules() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testDefineRules_1()
		throws Exception {
		SnakeLadder fixture = new SnakeLadder();

		fixture.defineRules();

	}

	/**
	 * Run the void endGame() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testEndGame_1()
		throws Exception {
		SnakeLadder fixture = new SnakeLadder();

		fixture.endGame();

	}

	/**
	 * Run the void playGame() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = NullPointerException.class)
	public void testPlayGame_1()
		throws Exception {
		SnakeLadder fixture = new SnakeLadder();

		fixture.playGame();
	}


	/**
	 * Run the boolean rollsDice(Player) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = NullPointerException.class)
	public void testRollsDice_1()
		throws Exception {
		SnakeLadder fixture = new SnakeLadder();
		Player player = new Player("Player-1");
		player.setCurrentPointer(1);

		boolean result = fixture.rollsDice(player);
		assertTrue(result);
	}

	/**
	 * Run the void snakeLadderCheck(Player) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = NullPointerException.class)
	public void testSnakeLadderCheck_1()
		throws Exception {
		SnakeLadder fixture = new SnakeLadder();
		Player player = new Player("");
		player.setCurrentPointer(1);

		fixture.snakeLadderCheck(player);
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SnakeLadderTest.class);
	}
}