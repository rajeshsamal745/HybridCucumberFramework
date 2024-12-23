package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"src/test/java/parallel/LoginPage.feature"},
		glue = {"parallel"},
		plugin = {"pretty"}
		)
public class MySerenityTestRun {

}
