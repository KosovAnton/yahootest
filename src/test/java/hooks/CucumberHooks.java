package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static utils.GlobalValues.DRIVER;

public class CucumberHooks {
    @Before
    public void setUp(Scenario scenario) {
        try {
            Driver.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DRIVER)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        DRIVER.quit();
    }
}
