package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"steps", "hooks"},
	    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
	)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {}
