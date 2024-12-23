package AppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	private WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By SubjectHeading = By.id("id_contact");
	private By EmailAddress = By.id("email");
	private By OrderReference = By.name("id_order");
	private By MessageTxt = By.id("message");
	private By SendButton = By.id("submitMessage");
	private By successMsg = By.cssSelector("div#center_column p");
	
	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	public void fillContactUsForm(String heading , String emailId ,String orderRef ,String message) {
		Select headingDrp = new Select(driver.findElement(SubjectHeading));
		headingDrp.selectByVisibleText(heading);
		driver.findElement(EmailAddress).sendKeys(emailId);
		driver.findElement(OrderReference).sendKeys(orderRef);
		driver.findElement(MessageTxt).sendKeys(message);
	}
	public void clickSend() {
		driver.findElement(SendButton).click();
	}
	public String getSuccessMessage() {
		return driver.findElement(successMsg).getText();
	}
}
