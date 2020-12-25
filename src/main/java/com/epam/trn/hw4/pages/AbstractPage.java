package com.epam.trn.hw4.pages;

import com.epam.trn.hw4.components.AbstractPageComposite;
import com.epam.trn.hw4.components.HeaderMenu;
import com.epam.trn.hw4.components.LeftSideMenu;
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

    public boolean findAndCompareFromLists(List<WebElement> elements, List<String> elementName) {
        for(int i = 0; i<elements.size()-1; i++) {
            if(elementName.get(i).equals(elements.get(i).getText())) {
                return true;
            }
        }
        return false;
    }

    public void doubleClickElements(WebElement element) {
            element.click();
            element.click();
    }

    public void open(String url) { webDriver.get(url); }

    public String getUrl() { return webDriver.getCurrentUrl(); }

    public String getBrowserTitle() { return webDriver.getTitle(); }

    public void refreshPage() {
        webDriver.navigate().refresh();
    }

}
