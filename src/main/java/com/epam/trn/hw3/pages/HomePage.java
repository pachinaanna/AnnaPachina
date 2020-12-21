package com.epam.trn.hw3.pages;

import com.epam.trn.hw3.components.Iframe;
import com.epam.trn.hw3.components.RowBenefits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends AbstractPage {

    public HomePage (WebDriver webDriver) {
        super(webDriver);
    }

    protected Iframe iframe = new Iframe(webDriver);
    protected RowBenefits rowBenefits = new RowBenefits(webDriver);

    public void login(String username, String password) {
        headerMenu.clickUserIcon();
        headerMenu.sendKeysToUserNameSendField(username);
        headerMenu.sendKeysToPasswordField(password);
        headerMenu.clickLoginButton();
    }

    public boolean checkHeaderButtonsText(String buttonText) {
       List<WebElement> headerButtons = headerMenu.getHeaderButtons();
        for (WebElement button : headerButtons) {
            if (buttonText.equals(button.getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkItemsText(String itemText) {
        List<WebElement> items = leftSideMenu.getLeftSideItems();
        for(WebElement item : items) {
            if(itemText.equals(item.getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkImagesText(String text) {
        List<WebElement> images = rowBenefits.getImages();
        for(WebElement image : images) {
            if(text.equals(image.getText())) {
                return true;
            }
        }
        return false;
    }

    public void goToServices(String serviceName) {
        headerMenu.getService().click();
        List<WebElement> services = headerMenu.getServices();
        for(WebElement service : services) {
            if(serviceName.equals(service.getText())) {
                service.click();
            }
        }



    }
}
