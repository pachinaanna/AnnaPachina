package com.epam.trn.hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        System.setProperty("webdriver.chrome.driver", "c://Drivers//chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        webDriver.manage().timeouts().setScriptTimeout(30000, TimeUnit.MILLISECONDS);
        webDriver.manage().window().maximize();
        softAssert = new SoftAssert();

    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }

}



