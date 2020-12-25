package com.epam.trn.hw4.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenu extends AbstractPageComposite {

    public HeaderMenu (WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    public void clickUserIcon() {
        userIcon.click();
    }

    @FindBy(xpath = "//input[@id='name']")
    private WebElement userNameTextField;

    public void sendKeysToUserNameSendField(String username) {
        userNameTextField.sendKeys(username);
    }

    @FindBy(id = "password")
    private WebElement passwordTextField;

    public void sendKeysToPasswordField(String password) {
        passwordTextField.sendKeys(password);
    }

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    @FindBy(id = "user-name")
    private WebElement loggedUser;

    public WebElement getLoggedUser() {
        return loggedUser;
    }

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerButtons;

    public List<WebElement> getHeaderButtons() {
        return headerButtons;
    }

    @FindBy(css = ".m-l8 > li:nth-child(3) > a")
    private WebElement service;

    public WebElement getService() {
        return service;
    }

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[8]")
    public WebElement differentElementsService;

    public WebElement getDifferentElementsService() {
        return differentElementsService;
    }

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    public List<WebElement> listOfServices;

    public List<WebElement> getServices() {
        return listOfServices;
    }

}




