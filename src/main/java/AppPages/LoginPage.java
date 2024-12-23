package AppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	private WebDriver driver;

	// Constructor of the LoginPage
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signIn = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	// Action Methods
	public void enterEmail(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickSignIn() {
		driver.findElement(signIn).click();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExists() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public AccountsPage doLogIn(String username, String pass) {
		System.out.println("Log in With " + username + " and " + pass);
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signIn).click();
		return new AccountsPage(driver);
	}
}
