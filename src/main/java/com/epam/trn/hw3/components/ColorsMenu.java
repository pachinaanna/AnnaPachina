package com.epam.trn.hw3.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ColorsMenu extends AbstractPageComposite{

public ColorsMenu(WebDriver webDriver) {
    super(webDriver);
}

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement colorsMenu;

    public void clickColorsMenu() {
        colorsMenu.click();
    }

    @FindBy(xpath = "//select[@class='uui-form-element']/option[text()='Yellow']")
    private WebElement yellow;

    @FindBy(xpath = "//select[@class='uui-form-element']/option")
    private List<WebElement> colors;

    public List<WebElement> getColors() {
        return colors;
    }
}
