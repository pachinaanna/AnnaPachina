package com.epam.trn.hw5.Hooks;

import com.epam.trn.hw5.utils.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        DriverSingleton.getWebDriver();
    }

    @After
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
