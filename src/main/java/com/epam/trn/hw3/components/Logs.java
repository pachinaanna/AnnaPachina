package com.epam.trn.hw3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Logs extends AbstractPageComposite {

    public Logs(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> logs;



}
