package com.epam.trn.hw3.pages;

import com.epam.trn.hw3.components.AbstractPageComposite;
import com.epam.trn.hw3.components.HeaderMenu;
import com.epam.trn.hw3.components.LeftSideMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class AbstractPage extends AbstractPageComposite {

    protected HeaderMenu headerMenu;
    protected LeftSideMenu leftSideMenu;

    protected AbstractPage (WebDriver webDriver) {
        super(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        leftSideMenu = new LeftSideMenu(webDriver);
    }

    public void findAndClick(List<WebElement> elements, String elementName) {
        for(WebElement check : elements) {
            if(elementName.equals(check.getText())) {
                check.click();
            }
        }
    }


}
