package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static final String USERNAME = "stanislaumankous_BWzQbr";
    private static final String AUTOMATE_KEY = "mayruWDpJxScTF67zdh6";
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createDriver(ResourceType resourceType) throws MalformedURLException {
        switch (resourceType) {
            case JENKINS:
                //Setup for Jenkins
                System.setProperty("webdriver.chrome.driver", "/opt/homebrew/Caskroom/chromedriver/133.0.6943.141/chromedriver-mac-arm64/chromedriver");
                return new ChromeDriver();

            case SELENIUM_GRID:
                //Setup for Selenium Grid
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                //Hub address
                return new RemoteWebDriver(new URL("http://192.168.0.185:4444"), options);

            case BROWSER_STACK:
                //Setup for Browserstack
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability("browser", "Firefox");
                dc.setCapability("browser_version", "latest");
                dc.setCapability("os", "Windows");
                dc.setCapability("os_version", "11");
                dc.setCapability("resolution", "1024x768");
                dc.setCapability("project", "CICDProject");
                dc.setCapability("build", "Build");
                dc.setCapability("name", "Test case name");
                return new RemoteWebDriver(new URL(URL), dc);

            default:
                throw new IllegalArgumentException("Unknown driver type: " + resourceType);
        }
    }
}