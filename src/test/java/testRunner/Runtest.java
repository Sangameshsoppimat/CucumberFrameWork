package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="C:\\Users\\sande\\eclipse-workspace\\CucumberPracticeYTpavan\\src\\test\\java\\java\\Feature",
		glue="stepDefintions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/cucumber.html"}
		
		)
public class Runtest extends AbstractTestNGCucumberTests
{
	

}
