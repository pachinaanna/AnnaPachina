package com.epam.trn.hw4;

import com.epam.trn.hw4.Steps.AssertionSteps;
import com.epam.trn.hw4.Steps.TestSteps;
import com.epam.trn.hw4.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public abstract class AbstractTest {

    public WebDriver webDriver;
    public TestSteps step;
    public AssertionSteps assertionStep;

    @BeforeMethod
    public void setUp(ITestContext testContext) throws IOException {
        webDriver = DriverManager.getDriver();
        step = new TestSteps(webDriver);
        assertionStep = new AssertionSteps(webDriver);
        testContext.setAttribute("webDriver", webDriver);
    }

    @AfterMethod
    public void clear() {
        webDriver.quit();
    }
}

