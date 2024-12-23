package parallel;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(value="@Skip",order=0)
	public void skipScenario(Scenario scenario) {
		System.out.println("Skipped Scenario is: "+scenario.getName());
		Assume.assumeTrue(false);
	}
	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 2)
	public void launchBrowser() {
		String nameOfBrowser = prop.getProperty("browserName"); // Here browser is from config.properties file
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(nameOfBrowser);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take Screen shot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
