package parallel;

import org.junit.Assert;
import AppPages.LoginPage;
import Factory.DriverFactory;
import io.cucumber.java.en.*;

public class LoginSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is :"+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExists());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterEmail(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);  
	}

	@When("user clicks on SignIn Button")
	public void user_clicks_on_sign_in_button() {
		loginPage.clickSignIn();
	}

	@Then("user gets title of the home page")
	public void user_gets_title_of_the_home_page() {
	   
	}
}
