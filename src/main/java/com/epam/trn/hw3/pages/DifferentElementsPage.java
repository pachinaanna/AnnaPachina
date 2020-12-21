package com.epam.trn.hw3.pages;

import com.epam.trn.hw3.components.Checkbox;
import com.epam.trn.hw3.components.ColorsMenu;
import com.epam.trn.hw3.components.Radio;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    protected Checkbox checkbox = new Checkbox(webDriver);
    protected Radio radio = new Radio(webDriver);
    protected ColorsMenu colorsMenu = new ColorsMenu(webDriver);

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectCheckbox(String checkboxName) {
        findAndClick(checkbox.getCheckboxes(), checkboxName);
    }

    public void selectRadio(String radioName) {
        findAndClick(radio.getRadioButtons(), radioName);
    }

    public void selectColor(String colorName) {
        colorsMenu.clickColorsMenu();
        findAndClick(colorsMenu.getColors(), colorName);
    }

    public WebElement getColor(String colorName) {
        List<WebElement> colors = colorsMenu.getColors();
        for(WebElement item : colors) {
            if(colorName.equals(item.getText())) {
                return item;
            }
        }
        return null;
    }

}

