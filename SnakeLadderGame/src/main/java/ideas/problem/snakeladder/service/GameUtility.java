/**
 * 
 */
package ideas.problem.snakeladder.service;

import java.util.Properties;

/**
 * The Class GameUtility.
 *
 * @author Avinash Pandey
 */
public class GameUtility {

	/**
	 * Load game elements.
	 *
	 * @param propertyFile the property file
	 * @return the properties
	 */
	public static Properties loadGameElements(String propertyFile){
		Properties properties=new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyFile));
		} catch (Exception e) {
			throw new RuntimeException("Unable to load properties file",e);
		}
		return properties;
	}
}
