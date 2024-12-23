package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/*
	 * This method is used to initialize the thread local driver on the basis of given browser
	 * this will return tlDriver
	 */
	public WebDriver init_driver(String browserName) {
		System.out.println("Browser Name is :" + browserName);
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} 
		else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} 
		else {
			System.out.println("Please enter the correct browser value :" + browserName);
		}	
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	/*
	 * This is used to get the driver with ThreadLocal
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
