package social_media_automation.sma;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/html-report", "json:target/json-report.json",
		"pretty:target/pretty-report.txt", "usage:target/usage-report.json",
		"junit:target/junit-report.xml" }, features = {
				"src/test/resources/features/instagram.feature" }, glue = { "stepDefinitions" }
// tags = ("@ignore")
)
public class Run_Instagram {
	public static WebDriver driver;

	public void tearDown() {
		driver.quit();
	}
}