package com.epam.trn.hw4.Steps;

import com.epam.trn.hw4.components.HeaderMenu;
import com.epam.trn.hw4.components.Iframe;
import com.epam.trn.hw4.pages.DifferentElementsPage;
import com.epam.trn.hw4.pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractStep {

    HomePage homePage;
    DifferentElementsPage differentElements;
    HeaderMenu headerMenu;
    Iframe iframe;
    Properties properties;

    protected AbstractStep(WebDriver webDriver) throws IOException {
        homePage = new HomePage(webDriver);
        differentElements = new DifferentElementsPage(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        iframe = new Iframe(webDriver);
        properties = getProperties("expectedResults.properties");

    }

    public Properties getProperties(String fileName) throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream(fileName));
        return p;
    }

}
