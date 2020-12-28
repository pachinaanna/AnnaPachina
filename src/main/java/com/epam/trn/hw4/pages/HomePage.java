package com.epam.trn.hw4.pages;

import com.epam.trn.hw4.components.Iframe;
import com.epam.trn.hw4.components.RowBenefits;
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

    public void goToIframe() {
            webDriver.switchTo().frame(iframe.getIframe());
    }

    public void returnToHomePage() {
        webDriver.switchTo().defaultContent();
    }

    public boolean checkHeaderButtonsText(String buttonText) {
       return findAndCompare(headerMenu.getHeaderButtons(), buttonText);
    }

    public boolean checkLeftSideItemsText(String itemText) {
        return findAndCompare(leftSideMenu.getLeftSideItems(), itemText);
    }

    public boolean findAndCompareBenefits(List<String> elements, String elementName) {
        for(String element : elements)
            if(elementName.equals(element)) {
                return true;
            }
        return false;
    }

    public boolean checkBenefitsText(String benefitText) {
        return findAndCompareBenefits(rowBenefits.getBenefitsText(), benefitText);
    }

    public void goToDifferentElements() {
        headerMenu.getService().click();
        headerMenu.getDifferentElementsService().click();
    }

    public int quantityOfHeaderMenuItems() {
            return headerMenu.getHeaderButtons().size();
        }

    public int quantityOfLeftSideMenuItems() {
            return leftSideMenu.getLeftSideItems().size();
        }

    public int quantityOfIcons() {
            return rowBenefits.getIcons().size();
        }

    public int quantityOfBenefitsText() {
        return rowBenefits.getBenefitsText().size();
    }

    public List<WebElement> getIcons() {
            return rowBenefits.getIcons();
        }

}
