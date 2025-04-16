package utils;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver;

    private WebDriverManager() {
    }

    public static void initializeDriver(String resourceType) throws MalformedURLException {
        if (driver == null) {
            ResourceType resourceTypeValue = ResourceType.valueOf(resourceType.toUpperCase());
            driver = DriverFactory.createDriver(resourceTypeValue);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}