package AppPages;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	private By accountSections = By.xpath("//ul[@class='myaccount-link-list']//li//span");

	AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	public int getAccountSectionsCount() {
		return driver.findElements(accountSections).size();
	}

	public List<String> getAccontHeadersList() {
		List<WebElement> accountHeaders = driver.findElements(accountSections);
		List<String> accountHeaderLists = new ArrayList();
		for (WebElement headers : accountHeaders) {
			String headerText = headers.getText();
			accountHeaderLists.add(headerText);
		}
		return accountHeaderLists;
	}
}
