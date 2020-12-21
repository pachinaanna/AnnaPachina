package com.epam.trn.hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RowBenefits extends AbstractPageComposite {

    public RowBenefits (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".benefit-txt")
    private List<WebElement> images;

    public List<WebElement> getImages() {
        return images;
    }

}
