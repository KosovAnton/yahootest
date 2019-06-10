package utils;



import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class GlobalValues {
    public static RemoteWebDriver DRIVER;
    public static int DEFAULT_WAITING_TIMEOUT = 10;
    public static String BASE_URL = "https://finance.yahoo.com";
    public static Map<String, Object> valuesToBePassedBetweenSteps = new HashMap<>();
}
