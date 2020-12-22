package com.epam.trn.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Properties;


public class AbstractTest {

    public WebDriver webDriver;
    public SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver(options);
        softAssert = new SoftAssert();

    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }

    public Properties getProperties(String fileName) throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream(fileName));
        return p;
    }

}

