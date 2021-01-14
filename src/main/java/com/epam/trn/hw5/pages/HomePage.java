package com.epam.trn.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends AbstractPage {

    public HomePage (WebDriver webDriver) {
        super(webDriver);
    }

    public void open(String url) {
        webDriver.get(url);
    }

    public void login(String username, String password) {
        headerMenu.clickUserIcon();
        headerMenu.sendKeysToUserNameSendField(username);
        headerMenu.sendKeysToPasswordField(password);
        headerMenu.clickLoginButton();
    }

    public void goToService(String serviceName) {
        List<WebElement> elements = headerMenu.getServices();
        findAndClick(elements, serviceName);
    }

}
