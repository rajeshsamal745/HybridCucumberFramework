package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import AppPages.ContactUsPage;
import Factory.DriverFactory;
import Utilities.ExcelReader;
import io.cucumber.java.en.*;

public class ContactUsSteps {
	
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());
	ExcelReader reader = new ExcelReader();
	
	@Given("user navigate to contact us page")
	public void user_navigate_to_contact_us_page() {
	   DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=contact");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, 
			Integer rowNum) throws InvalidFormatException, IOException{
		List<Map<String,String>> testData = 
		reader.getData("D:/MyLearing/MyProjects_2025/CucumberHybridFramework/automation.xlsx", 
				sheetName);
		String HeadingSubject= testData.get(rowNum).get("SubjectHeading");//Here SubjectHeading is the heading in excelsheet
		String email= testData.get(rowNum).get("EmailAddress");//Here EmailAddress is the heading in excelsheet
		String orderRef= testData.get(rowNum).get("OrderReference");//Here OrderReference is the heading in excelsheet
		String msg= testData.get(rowNum).get("Message");//Here Message is the heading in excelsheet
		contactUsPage.fillContactUsForm(HeadingSubject, email, orderRef, msg);
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickSend();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMsg) {
		String actSuccessMsg =contactUsPage.getSuccessMessage();
		System.out.println(actSuccessMsg);
	}
}
