package pl.luxoft.qaupskilling.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "pl.luxoft.qaupskilling.cucumber.stepdefs",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class FeatureRunner {
}
