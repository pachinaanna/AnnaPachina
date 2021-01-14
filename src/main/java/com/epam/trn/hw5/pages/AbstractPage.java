package com.epam.trn.hw5.pages;

import com.epam.trn.hw5.components.AbstractPageComposite;
import com.epam.trn.hw5.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AbstractPage extends AbstractPageComposite {

    protected HeaderMenu headerMenu;

    protected AbstractPage (WebDriver webDriver) {
        super(webDriver);
        headerMenu = new HeaderMenu(webDriver);
    }

    public void findAndClick(List<WebElement> elements, String elementName) {
        for(WebElement element : elements) {
            if(elementName.equals(element.getText())) {
                element.click();
                break;
            }
        }
    }

    public void open(String url) { webDriver.get(url); }

    public String getUrl() { return webDriver.getCurrentUrl(); }

    public String getBrowserTitle() { return webDriver.getTitle(); }

}
