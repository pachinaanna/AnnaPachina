package com.epam.trn.hw5.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Radio extends AbstractPageComposite{

    public Radio(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//label[@class='label-radio']")
    private List<WebElement> radioButtons;

    public List<WebElement> getRadioButtons() {
        return radioButtons;
    }

}

