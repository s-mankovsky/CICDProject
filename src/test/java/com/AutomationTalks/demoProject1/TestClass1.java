package com.AutomationTalks.demoProject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestClass1 {

    public static WebDriver driver;
    public static final String USERNAME = "stanislaumankous_BWzQbr";
    public static final String AUTOMATE_KEY = "mayruWDpJxScTF67zdh6";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod
    public void launchDriver() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/Caskroom/chromedriver/133.0.6943.141/chromedriver-mac-arm64/chromedriver");

//        //Setup for Jenkins
//        driver = new ChromeDriver();

//        //Setup for Selenium Grid
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        //Hub address
//        driver = new RemoteWebDriver(new URL("http://192.168.0.185:4444"), options);

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

        driver = new RemoteWebDriver(new URL(URL), dc);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test1() {
        driver.navigate().to("https://automationtalks.com/");
        System.out.println("Test 1 title is " + driver.getTitle());
    }

    @Test
    public void Test2() {
        driver.navigate().to("https://automationtalks.com/");
        System.out.println("Test 2 title is " + driver.getTitle());
    }

    @Test
    public void Test3() {
        driver.navigate().to("https://automationtalks.com/");
        System.out.println("Test 3 title is " + driver.getTitle());
    }

    @AfterMethod
    public void quit(ITestResult result) {
        driver.quit();
    }
}
