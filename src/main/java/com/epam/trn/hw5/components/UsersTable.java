package com.epam.trn.hw5.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UsersTable extends AbstractPageComposite {

    public UsersTable(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//tr//td[1]")
    private List<WebElement> numberTypes;

    public List<WebElement> getNumberTypes() {
        return numberTypes;
    }

    @FindBy(xpath = "//table[@id='user-table']//td//a")
    private List<WebElement> userNames;

    public List<WebElement> getUserNames() {
        return userNames;
    }

    @FindBy(css = ".user-descr > span")
    private List<WebElement> descriptionCol;

    public List<WebElement> getDescriptionCol() {
        return descriptionCol;
    }

    public List<String> getDescriptionText() {
        List<String> descriptText = new ArrayList<>();
        for(WebElement element : descriptionCol) {
            descriptText.add(element.getText().replace("\n", " "));
    }
        return descriptText;
    }

    @FindBy(xpath = "//div[@class='user-descr']//input")
    private List<WebElement> usersCheckboxes;

    public List<WebElement> getUsersCheckboxes() {
        return usersCheckboxes;
    }

    @FindBy(xpath = "//div[@class='user-descr']//label")
    private List<WebElement> checkboxesLabels;

    public List<WebElement> getCheckboxesLabels() {
        return checkboxesLabels;
    }

    @FindBy(xpath = "//table[@id='user-table']//tr//td[1]")
    private List<WebElement> numberCol;

    public List<WebElement> getNumberCol() {
        return numberCol;
    }

    @FindBy(xpath = "//table[@id='user-table']//tr//td[3]")
    private List<WebElement> userCol;

    public List<WebElement> getUserCol() {
        return userCol;
    }

    @FindBy(xpath = "//td//select")
    private List<WebElement> allDropdowns;

    public List<WebElement> getAllDropdowns() {
        return allDropdowns;
    }

    @FindBy(css = ".panel-body-list > li")
    private List<WebElement> logs;

    public List<WebElement> getLogs() {
        return logs;
    }
}

