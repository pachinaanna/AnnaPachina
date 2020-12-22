package com.epam.trn.hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftSideMenu extends AbstractPageComposite {

    public LeftSideMenu (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSideItems;

    public List<WebElement> getLeftSideItems() {
        return leftSideItems;
    }

}
