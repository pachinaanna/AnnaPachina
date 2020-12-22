package com.epam.trn.hw3.ex2;


import com.epam.trn.hw3.components.Checkbox;
import com.epam.trn.hw3.components.ColorsMenu;
import com.epam.trn.hw3.components.HeaderMenu;
import com.epam.trn.hw3.components.Radio;
import com.epam.trn.hw3.pages.DifferentElementsPage;
import com.epam.trn.hw3.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.epam.trn.hw3.AbstractTest;

import java.io.IOException;
import java.util.Properties;

public class Exercise_2 extends AbstractTest {

    @Test
    public void exercise2() throws IOException {

        HomePage homePage = new HomePage(webDriver);
        DifferentElementsPage differentElements = new DifferentElementsPage(webDriver);
        HeaderMenu headerMenu = new HeaderMenu(webDriver);
        Checkbox check = new Checkbox(webDriver);
        Radio radio = new Radio(webDriver);
        ColorsMenu colorsMenu = new ColorsMenu(webDriver);

        Properties p = getProperties("homePage.properties");

        // Step 1: Open test site by URL
        // Data: https://jdi-testing.github.io/jdi-light/index.html
        // Exp. result: Test site is opened

        webDriver.get(p.getProperty("url"));
        softAssert.assertEquals(webDriver.getCurrentUrl(), p.getProperty("url"));

        // Step 2: Assert browser title
        // Data: "Home Page"
        // Exp. result: Browser title equals "Home Page"

        softAssert.assertEquals(webDriver.getTitle(), p.getProperty("browser.title"));

        // Step 3: Perform login
        // Data: username: Roman, pass: Jdi1234
        // Exp. result: User is logged

        homePage.login(p.getProperty("login"), p.getProperty("password"));
        softAssert.assertTrue(headerMenu.getLoggedUser().isDisplayed());

        // Step4: Assert User name in the left-top side of screen that user is logged
        // Data: ROMAN IOVLEV
        // Exp. result: Name is displayed and equals to expected result

        softAssert.assertTrue(headerMenu.getLoggedUser().isDisplayed());
        softAssert.assertEquals(headerMenu.getLoggedUser().getText(), p.getProperty("userName"));

        // Step 5: Open through the header menu Service -> Different Elements Page
        // Data: -
        // Exp. result: Page is opened

        homePage.goToDifferentElements();
        softAssert.assertEquals(webDriver.getTitle(), p.getProperty("differentElementsPage.browser.title"));

        // Step 6: Select checkboxes
        // Data: Water, Wind
        // Exp. result: Elements are checked

        differentElements.selectCheckbox(p.getProperty("checkbox.water"));
        softAssert.assertTrue(differentElements.getCheckbox(p.getProperty("checkbox.water")).isSelected());

        differentElements.selectCheckbox(p.getProperty("checkbox.wind"));
        softAssert.assertTrue(differentElements.getCheckbox(p.getProperty("checkbox.wind")).isSelected());

        // Step 7: Select radio
        // Data: Selen
        // Exp. result: Element is checked

        differentElements.selectRadio(p.getProperty("radiobutton.selen"));
        softAssert.assertTrue(differentElements.getRadio(p.getProperty("radiobutton.selen")).isSelected());

//        // Step 8: Select in dropdown
        // Data: Yellow
        // Exp. result: Element is selected

        differentElements.selectColor(p.getProperty("color.yellow"));
        softAssert.assertTrue(differentElements.getColor(p.getProperty("color.yellow")).isSelected());

        // Step 9: Assert that
        // •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // •	for radio button there is a log row and value is corresponded to the status of radio button
        // •	for dropdown there is a log row and value is corresponded to the selected value.
        // Data: -
        // Exp. result: Log rows are displayed and
        // •	checkbox name and its status are corresponding to selected
        // •	radio button name and it status is corresponding to selected
        // •	dropdown name and selected value is corresponding to selected

        webDriver.navigate().refresh();

        for (WebElement element : check.getCheckboxes()) {
            softAssert.assertTrue(differentElements.compareLogs(element, p.getProperty("log.text.checkboxChecked")));
        }

        for (WebElement element : check.getCheckboxes()) {
            softAssert.assertTrue(differentElements.compareLogs(element, p.getProperty("log.text.checkboxUnchecked")));
        }

        for (WebElement element : radio.getRadioButtons()) {
            softAssert.assertTrue(differentElements.compareLogs(element, p.getProperty("log.text.radio")));
        }

        differentElements.selectColor(p.getProperty("color.yellow"));
        for (WebElement element : colorsMenu.getColors()) {
            softAssert.assertTrue(differentElements.compareLogs(element, p.getProperty("log.text.color")));
        }


    }

}