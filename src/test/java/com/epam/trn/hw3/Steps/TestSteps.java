package com.epam.trn.hw3;

import com.epam.trn.hw3.components.HeaderMenu;
import com.epam.trn.hw3.components.Iframe;
import com.epam.trn.hw3.pages.DifferentElementsPage;
import com.epam.trn.hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;

public class TestSteps{

    public WebDriver webDriver;

    HeaderMenu headerMenu = new HeaderMenu(webDriver);
    HomePage homePage = new HomePage(webDriver);
    Iframe iframe = new Iframe(webDriver);
    DifferentElementsPage differentElements = new DifferentElementsPage(webDriver);

    Properties properties = getProperties("expectedResults.properties");

    public TestSteps() throws IOException { }

    public Properties getProperties(String fileName) throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream(fileName));
        return p;
    }

    public void openSite() {
        webDriver.get(properties.getProperty("url"));
    }

    public String getExpectedUrl() {
        return properties.getProperty("url");
    }

    public String homePageBrowserTitle() {
        return properties.getProperty("browser.title");
    }

    public void login() {
        homePage.login(properties.getProperty("login"), properties.getProperty("password"));
    }

    public boolean loggedUserIsDisplayed() {
        return headerMenu.getLoggedUser().isDisplayed();
    }

    public String getLoggedUserText() {
        return headerMenu.getLoggedUser().getText();
    }

    public String getUserName() {
        return properties.getProperty("userName");
    }

    public int getQuantityOfHeaderMenuItems() {
        return homePage.quantityOfHeaderMenuItems();
    }

    public boolean checkTextOfThe1HeaderButton() {
        return homePage.checkHeaderButtonsText(properties.getProperty("header.button1"));
    }

    public boolean checkTextOfThe2HeaderButton() {
        return homePage.checkHeaderButtonsText(properties.getProperty("header.button2"));
    }

    public boolean checkTextOfThe3HeaderButton() {
        return homePage.checkHeaderButtonsText(properties.getProperty("header.button3"));
    }

    public boolean checkTextOfThe4HeaderButton() {
        return homePage.checkHeaderButtonsText(properties.getProperty("header.button4"));
    }

    public int getQuantityOfIcons() {
        return homePage.quantityOfIcons();
    }

    public int getQuantityOfBenefits() {
        return homePage.quantityOfBenefitsText();
    }

    public boolean checkTextOfThe1Benefit() {
        return homePage.checkBenefitsText(properties.getProperty("text.image1"));
    }

    public boolean checkTextOfThe2Benefit() {
        return homePage.checkBenefitsText(properties.getProperty("text.image2"));
    }

    public boolean checkTextOfThe3Benefit() {
        return homePage.checkBenefitsText(properties.getProperty("text.image3"));
    }

    public boolean checkTextOfThe4Benefit() {
        return homePage.checkBenefitsText(properties.getProperty("text.image4"));
    }

    public boolean iframeIsDisplayed() {
        return iframe.getIframe().isDisplayed();
    }

    public void switchToIframe() {
        webDriver.switchTo().frame(iframe.getIframe());
    }

    public boolean frameButtonIsDisplayed() {
        return iframe.getFrameButton().isDisplayed();
    }

    public void switchBackFromIframe() {
        webDriver.switchTo().defaultContent();
    }

    public int getQuantityOfSideMenuItems() {
        return homePage.quantityOfLeftSideMenuItems();
    }

    public boolean checkTextOfThe1LeftSideItem() {
        return homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button1"));
    }

    public boolean checkTextOfThe2LeftSideItem() {
        return homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button2"));
    }

    public boolean checkTextOfThe3LeftSideItem() {
        return homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button3"));
    }

    public boolean checkTextOfThe4LeftSideItem() {
        return homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button4"));
    }

    public boolean checkTextOfThe5LeftSideItem() {
        return homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button5"));
    }

    public void goToDifferentElementsPage() {
        homePage.goToDifferentElements();
    }

    public String differentElementsPageBrowserTitle() {
        return properties.getProperty("differentElementsPage.browser.title");
    }

    public void selectCheckboxWater() {
        differentElements.selectCheckbox(properties.getProperty("checkbox.water"));
    }

    public boolean checkboxWaterIsSelected() {
        return differentElements.getCheckbox(properties.getProperty("checkbox.water")).isSelected();
    }

    public void selectCheckboxWind() {
        differentElements.selectCheckbox(properties.getProperty("checkbox.wind"));
    }

    public boolean checkboxWindIsSelected() {
        return differentElements.getCheckbox(properties.getProperty("checkbox.wind")).isSelected();
    }

    public void selectRadioSelen() {
        differentElements.selectRadio(properties.getProperty("radiobutton.selen"));
    }

    public boolean radioSelenIsSelected() {
        return differentElements.getRadio(properties.getProperty("radiobutton.selen")).isSelected();
    }

    public void selectYellowInDropdown() {
        differentElements.selectColor(properties.getProperty("color.yellow"));
    }

    public boolean yellowIsSelected() {
        return differentElements.getColor(properties.getProperty("color.yellow")).isSelected();
    }

    public void refreshPage() {
        webDriver.navigate().refresh();
    }

    public boolean checkCheckboxCheckedLogs(WebElement element) {
        return differentElements.compareLogs(element, properties.getProperty("log.text.checkboxChecked"));
    }

    public boolean checkCheckboxUncheckedLogs(WebElement element) {
        return differentElements.compareLogs(element, properties.getProperty("log.text.checkboxUnchecked"));
    }

    public boolean checkRadioCheckedLogs(WebElement element) {
        return differentElements.compareLogs(element, properties.getProperty("log.text.radio"));
    }

    public boolean checkColorCheckedLogs(WebElement element) {
        return differentElements.compareLogs(element, properties.getProperty("log.text.color"));
    }


}

