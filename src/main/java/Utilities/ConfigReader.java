package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	/*
	 * This method is used to load properties from config.properties file it returns
	 * Properties prop object
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream inputFile = new FileInputStream("src/test/resources/Config/Config.properties");
			prop.load(inputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
