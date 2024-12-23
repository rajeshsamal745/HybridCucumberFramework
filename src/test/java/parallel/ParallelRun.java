package parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/parallel/LoginPage.feature" }, 
				glue = { "parallel" }, 
				plugin = { "pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/" ,
						"rerun:target/failedRun.txt"},
				//tags = "not @Skip",	
				publish = true, 
				monochrome = false, 
				dryRun = false)
public class ParallelRun extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
