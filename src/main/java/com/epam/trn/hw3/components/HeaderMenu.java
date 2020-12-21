package com.epam.trn.hw3.components;

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

    @FindBy(className = "logout")
    private WebElement logoutButton;

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    @FindBy(id = "user-name")
    private WebElement userName;

    public WebElement getUserName() {
        return userName;
    }

    @FindBy(css = "ul.m-l8 > li")
    private List<WebElement> headerButtons;

    public List<WebElement> getHeaderButtons() {
        return headerButtons;
    }

    @FindBy(css = ".m-l8 > li:nth-child(3) > a")
    private WebElement service;

    public WebElement getService() {
        return service;
    }

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    public List<WebElement> services;

    public List<WebElement> getServices() {
        return services;
    }


}




