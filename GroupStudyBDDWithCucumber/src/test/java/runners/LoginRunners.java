package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/java/features/login.feature", 
		glue = {"steps" }, //glue means the path of the step definition file
		dryRun = false,    //to check the mapping is proper between feature file and step definition
		monochrome = true, //Monochrome displays the console output in proper readable format
		plugin = { "pretty", "html:test-output" }) //plugin or Format to generate different types of reporting formats
public class LoginRunners {

}
//Strict = true or false to check if any teststep is undefined