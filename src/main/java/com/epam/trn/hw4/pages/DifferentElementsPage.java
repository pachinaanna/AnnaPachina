package com.epam.trn.hw4.pages;

import com.epam.trn.hw4.components.Checkbox;
import com.epam.trn.hw4.components.ColorsMenu;
import com.epam.trn.hw4.components.LogsPanel;
import com.epam.trn.hw4.components.Radio;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    protected Checkbox checkbox = new Checkbox(webDriver);
    protected Radio radio = new Radio(webDriver);
    protected ColorsMenu colorsMenu = new ColorsMenu(webDriver);
    protected LogsPanel logsPanel = new LogsPanel(webDriver);

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectCheckbox(String checkboxName) {
        findAndClick(checkbox.getCheckboxes(), checkboxName);
    }

    public void selectRadio(String radioName) { findAndClick(radio.getRadioButtons(), radioName); }

    public void selectColor(String colorName) {
        colorsMenu.clickColorsMenu();
        findAndClick(colorsMenu.getColors(), colorName);
    }

    public List<WebElement> getColor() {
        return colorsMenu.getColors();
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

    public List<WebElement> getRadioButtons() {
        return radio.getRadioButtons(); }

    public WebElement getRadio(String checkboxName) {
        for(WebElement item : radio.getRadioButtons()) {
            if(checkboxName.equals(item.getText())) {
                return item;
            }
        }
        return null;
    }

    public List<WebElement> getCheckboxes() {
        return checkbox.getCheckboxes(); }

    public WebElement getCheckbox(String checkboxName) {
        for(WebElement item : checkbox.getCheckboxes()) {
            if(checkboxName.equals(item.getText())) {
                return item;
            }
        }
        return null;
    }

    public String expectedLog(String logText, WebElement element) {
        if(element.getText().equals("Water") || element.getText().equals("Wind")
                || element.getText().equals("Earth") || element.getText().equals("Fire")) {
            return element.getText() + logText;
        }
        else {
            return logText + element.getText();
        }
    }

    public List<String> actualLog(WebElement element) {
        doubleClickElements(element);
        List<String> list = new ArrayList<>();
        for (WebElement item : logsPanel.getLogs()) {
            list.add(item.getText());
        }
        return list;
    }

    public boolean compareLogs(WebElement element, String logText) {
        String expected = expectedLog(logText, element);
        List<String> actual = actualLog(element);
        if(expected.contains("false")) {
            return expected.contains(actual.get(1));
        }
        return expected.contains(actual.get(0));
    }


}

