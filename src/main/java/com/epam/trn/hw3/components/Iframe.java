package com.epam.trn.hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Iframe extends AbstractPageComposite {

    public Iframe (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "frame")
    private WebElement iframe;

    public WebElement getIframe() {
        return iframe;
    }

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public WebElement getFrameButton() {
        return frameButton;
    }
}
