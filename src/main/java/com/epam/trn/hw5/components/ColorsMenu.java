package com.epam.trn.hw5.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ColorsMenu extends AbstractPageComposite{

public ColorsMenu(WebDriver webDriver) {
    super(webDriver);
}

    @FindBy(css = ".colors>select")
    private WebElement colorsMenu;

    public void clickColorsMenu() {
        colorsMenu.click();
    }

    @FindBy(css = ".uui-form-element>option")
    private List<WebElement> colors;

    public List<WebElement> getColors() {
        return colors;
    }
}
