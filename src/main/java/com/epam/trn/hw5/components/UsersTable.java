package com.epam.trn.hw5.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UsersTable extends AbstractPageComposite {

    public UsersTable(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//table[@id='user-table']//tr//td//select")
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
    private List<WebElement> descriptions;

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    @FindBy(xpath = "//div[@class='user-descr']//input")
    private List<WebElement> usersCheckboxes;

    public List<WebElement> getUsersCheckboxes() {
        return usersCheckboxes;
    }

    @FindBy(xpath = "//table[@id='user-table']//tr")
    private List<WebElement> tableRows;

    public List<WebElement> getTableRows() {
        return tableRows;
    }
}
