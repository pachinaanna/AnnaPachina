package com.epam.trn.hw4.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LogsPanel extends AbstractPageComposite {

    public LogsPanel(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> logs;

    public List<WebElement> getLogs() {
        return logs;
    }
}
