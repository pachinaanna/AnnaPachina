package com.epam.trn.hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Checkbox extends AbstractPageComposite {

    public Checkbox (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".label-checkbox:nth-child(1)")
    private WebElement water;

    @FindBy(css = ".label-checkbox:nth-child(3)")
    private WebElement wind;

    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkboxes;

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }
}
