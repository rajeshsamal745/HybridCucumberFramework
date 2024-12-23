package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import AppPages.AccountsPage;
import AppPages.LoginPage;
import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage; 
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String , String>> loginCred = dataTable.asMaps();
		String userName = loginCred.get(0).get("username");
		String password = loginCred.get(0).get("password");
		DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogIn(userName, password);
	}

	@Given("user is on the Accounts page")
	public void user_is_on_the_accounts_page() {
		String accountPageTitle = accountsPage.getAccountPageTitle();
		System.out.println("Title of the Account page is :"+accountPageTitle);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List<String> expectedAccountSectionList = sectionsTable.asList();
		for(String e : expectedAccountSectionList) {
			System.out.println("Expected Account Section Lists are :"+e);
		}
		List<String> actualAccountSectionList = accountsPage.getAccontHeadersList();
		for(String e : actualAccountSectionList) {
			System.out.println("Actual Account Section Lists are :"+e);
		}
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		int sectionCount = accountsPage.getAccountSectionsCount();
		System.out.println("Total no of sections in account page are :"+sectionCount);
		Assert.assertTrue(accountsPage.getAccountSectionsCount() == expectedSectionCount);
	}
}
