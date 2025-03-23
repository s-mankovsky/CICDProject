package com.AutomationTalks.demoProject1;

import net.rcarz.jiraclient.JiraException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

    @BeforeMethod
    public void launchDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/Caskroom/chromedriver/133.0.6943.141/chromedriver-mac-arm64/chromedriver");

//        //Setup for Jenkins
//        driver = new ChromeDriver();

        //Setup for Selenium Grid
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        //Hub address
        driver = new RemoteWebDriver(new URL("http://192.168.0.185:4444"), options);

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
    public void quit(ITestResult result) throws JiraException {
        driver.quit();
    }
}
