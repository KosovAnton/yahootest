package driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

import static utils.GlobalValues.DRIVER;

public class Driver {
    public static void init() {
        System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getAbsolutePath());
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", chromePrefs);
        DRIVER = new ChromeDriver(options);
        DRIVER.manage().window().maximize();
    }
}
