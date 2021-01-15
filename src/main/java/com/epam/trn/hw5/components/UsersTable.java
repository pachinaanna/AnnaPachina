package com.epam.trn.hw5.components;

import org.openqa.selenium.By;
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
        for(WebElement el : usersCheckboxes) {
            System.out.println(el.getText());
        }
        return usersCheckboxes;
    }

//    @FindBy(id = "user-table")
//    private WebElement userTable;
//
//    public WebElement getUserTable() {
//        return userTable;
//    }

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

//    @FindBy(xpath = "//table[@id='user-table']//tr//td[4]")
//    private List<WebElement> descriptionCol;
//
//    public List<WebElement> getDescriptionCol() {
//        return descriptionCol;
//    }

//    @FindBy(xpath = "//td//select")
//    private List<WebElement> allDropdowns;
//
//    public List<WebElement> getAllDropdowns() {
//        return allDropdowns;
//    }

    @FindBy(xpath = "//tr[1]/td[2]/select[1]//option")
    private List<WebElement> romanDropdown;

    public List<WebElement> getRomanDropdown() {
        return romanDropdown;
    }
}

