package com.AutomationTalks.demoProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.EnvironmentConfig;
import utils.WebDriverManager;

import java.net.MalformedURLException;

public class TestClass1 {

    private static WebDriver driver;
    protected static EnvironmentConfig config;

    @BeforeClass
    @Parameters({"env", "resourceType"})
    public static void setUp(String env, String resourceType) throws MalformedURLException {
        config = new EnvironmentConfig(env);
        WebDriverManager.initializeDriver(resourceType);
        driver = WebDriverManager.getDriver();
    }

    @Test
    public void Test1() {
        driver.navigate().to(config.getEnvironmentUrl());
        driver.findElement(By.xpath("//a[text()='Courses']")).click();
        System.out.println("Test 1 title is " + driver.getTitle());
    }

    @Test
    public void Test2() {
        driver.navigate().to(config.getEnvironmentUrl());
        System.out.println("Test 2 title is " + driver.getTitle());
    }

    @AfterClass
    public void quit() {
        WebDriverManager.quitDriver();
    }
}
