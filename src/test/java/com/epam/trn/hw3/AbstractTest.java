package com.epam.trn.hw3;

import com.epam.trn.hw3.Steps.TestSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public abstract class AbstractTest {

    public WebDriver webDriver;
    public SoftAssert softAssert;

    TestSteps step;

    @BeforeMethod
    public void setUp() throws IOException {
        webDriver = DriverManager.getDriver();
        softAssert = new SoftAssert();
        step = new TestSteps(webDriver);
    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }

}

