package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps","cucumber"},
        tags = "@wedding",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/wedding.html",
                "json:target/cucumber-reports/wedding.json"
        }
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}