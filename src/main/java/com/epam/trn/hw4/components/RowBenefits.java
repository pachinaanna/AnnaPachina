package com.epam.trn.hw4.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RowBenefits extends AbstractPageComposite {

    public RowBenefits (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefits;

    public List<String> getBenefitsText() {
        List<String> benefitText = new ArrayList<>();
        for(WebElement element : benefits) {
            benefitText.add(element.getText().replace("\n", " ").replace("…", "..."));
        }
        return benefitText;
    }

    @FindBy(css = ".icons-benefit")
    private List<WebElement> icons;

    public List<WebElement> getIcons() {
        return icons;
    }


}
