package ideas.problem.snakeladder.service.test;

import java.util.Properties;

import org.junit.*;

import ideas.problem.snakeladder.model.test.SnakeLadderTest;
import ideas.problem.snakeladder.service.GameUtility;
import static org.junit.Assert.*;

/**
 *
 * @author Avinash Pandey
 */
public class GameUtilityTest {
	/**
	 * Run the Properties loadGameElements(String) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testLoadGameElements_1() throws Exception {
		String propertyFile = "snakeladder.properties";

		Properties result = GameUtility.loadGameElements(propertyFile);

		// add additional test code here
		assertNotNull(result);
		assertEquals(16, result.size());
	}

	/**
	 * Run the Properties loadGameElements(String) method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testLoadGameElements_2() throws Exception {
		String propertyFile = "dummy";
		GameUtility.loadGameElements(propertyFile);
	}

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 *
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SnakeLadderTest.class);
	}
}