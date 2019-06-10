import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @RunWith Class with this annotation will run a Cucumber Feature. The class should be empty without any fields or methods.
 * @CucumberOptions This annotation provides the same options as the cucumber command line.
 * @params format What formatter(s) to use.
 * @params features The paths to the feature(s).
 * @params glue Where to look for glue code (stepdefs and hooks).
 * @params tags Identify scenarios or features to run.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/cucumber-report.json", "junit:target/cucumber-junit-report/cuc.xml"},
        glue = {"stepdefinitions", "hooks"},
        features = {"src/test/resources"},
        tags = {"@Historical_data_scenarios"}
)
public class CucumberRunner {
}
