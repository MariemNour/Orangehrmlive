package api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/api/CreateCandidateApi.feature", glue = {"api.stepsDefinitions"},
        monochrome = true,
        plugin = {"pretty", "junit:target/JUnitReports/report.xml",
                "json:target/JSONReports/report.json",
                "html:target/HtmlReports"}
)
public class CreateCandidateTestRunner {

}
