package com.epam.trn.hw4.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Checkbox extends AbstractPageComposite {

    public Checkbox (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy (xpath = "//label[@class='label-checkbox']" )
    private List<WebElement> checkboxes;

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

}
