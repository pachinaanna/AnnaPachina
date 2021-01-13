package com.epam.trn.hw5.Steps;

import com.epam.trn.hw5.DriverSingleton;
import com.epam.trn.hw5.components.HeaderMenu;
import com.epam.trn.hw5.pages.DifferentElementsPage;
import com.epam.trn.hw5.pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractBaseStepDef {

    HomePage homePage;
    DifferentElementsPage differentElements;
    HeaderMenu headerMenu;
    Properties properties;

    protected AbstractBaseStepDef() throws IOException {
        WebDriver webDriver = DriverSingleton.getWebDriver();
        homePage = new HomePage(webDriver);
        differentElements = new DifferentElementsPage(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        properties = getProperties("expectedResults.properties");

    }

    public Properties getProperties(String fileName) throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream(fileName));
        return p;
    }
}
