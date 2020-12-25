package com.epam.trn.hw4.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RowBenefits extends AbstractPageComposite {

    public RowBenefits (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitText;

    public List<WebElement> getBenefitsText() {
        return benefitText;
    }

    @FindBy(css = ".icons-benefit")
    private List<WebElement> icons;

    public List<WebElement> getIcons() {
        return icons;
    }


}
