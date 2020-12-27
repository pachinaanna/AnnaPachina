package com.epam.trn.hw3.Steps;

import com.epam.trn.hw3.components.HeaderMenu;
import com.epam.trn.hw3.components.Iframe;
import com.epam.trn.hw3.pages.DifferentElementsPage;
import com.epam.trn.hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractStep {

    HomePage homePage;
    DifferentElementsPage differentElements;
    HeaderMenu headerMenu;
    Iframe iframe;

    protected AbstractStep(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
        differentElements = new DifferentElementsPage(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        iframe = new Iframe(webDriver);
    }

    public Properties getProperties(String fileName) throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream(fileName));
        return p;
    }

}
