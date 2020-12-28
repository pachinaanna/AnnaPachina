package com.epam.trn.hw3.pages;

import com.epam.trn.hw3.components.AbstractPageComposite;
import com.epam.trn.hw3.components.HeaderMenu;
import com.epam.trn.hw3.components.LeftSideMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AbstractPage extends AbstractPageComposite {

    protected HeaderMenu headerMenu;
    protected LeftSideMenu leftSideMenu;

    protected AbstractPage (WebDriver webDriver) {
        super(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        leftSideMenu = new LeftSideMenu(webDriver);
    }

    public void findAndClick(List<WebElement> elements, String elementName) {
        for(WebElement element : elements) {
            if(elementName.equals(element.getText())) {
                element.click();
            }
        }
    }

    public boolean findAndCompare(List<WebElement> elements, String elementName) {
        for(WebElement element : elements)
            if(elementName.equals(element.getText())) {
                return true;
            }
        return false;
    }

    public void doubleClickElements(WebElement element) {
            element.click();
            element.click();
    }
}
