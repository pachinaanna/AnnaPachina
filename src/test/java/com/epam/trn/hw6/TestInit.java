package com.epam.trn.hw6;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;


public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    default void setUp() {
        initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    default void teardown() {
        killAllSeleniumDrivers();
    }
}
