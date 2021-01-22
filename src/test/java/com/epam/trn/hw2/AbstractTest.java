package com.epam.trn.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class AbstractTest {

    public WebDriver webDriver;
    public SoftAssert softAssert;

    public boolean isBrowserClose(WebDriver driver) {
        try {
            driver.getTitle();
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

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

}



