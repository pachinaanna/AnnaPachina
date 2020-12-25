package com.epam.trn.hw3.ex2;


import com.epam.trn.hw3.Steps.TestSteps;
import com.epam.trn.hw4.components.Checkbox;
import com.epam.trn.hw4.components.ColorsMenu;
import com.epam.trn.hw4.components.Radio;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.epam.trn.hw3.AbstractTest;

import java.io.IOException;

public class Exercise_2 extends AbstractTest {

    @Test
    public void exercise2() throws IOException {

        Checkbox check = new Checkbox(webDriver);
        Radio radio = new Radio(webDriver);
        ColorsMenu colorsMenu = new ColorsMenu(webDriver);

        TestSteps step = new TestSteps(webDriver);

        // Step 1: Open test site by URL
        // Data: https://jdi-testing.github.io/jdi-light/index.html
        // Exp. result: Test site is opened

        step.openSite();
        softAssert.assertEquals(webDriver.getCurrentUrl(), step.getExpectedUrl());

        // Step 2: Assert browser title
        // Data: "Home Page"
        // Exp. result: Browser title equals "Home Page"

        softAssert.assertEquals(webDriver.getTitle(), step.homePageBrowserTitle());

        // Step 3: Perform login
        // Data: username: Roman, pass: Jdi1234
        // Exp. result: User is logged

        step.login();
        softAssert.assertTrue(step.loggedUserIsDisplayed());

        // Step4: Assert User name in the left-top side of screen that user is logged
        // Data: ROMAN IOVLEV
        // Exp. result: Name is displayed and equals to expected result

        softAssert.assertTrue(step.loggedUserIsDisplayed());
        softAssert.assertEquals(step.getLoggedUserText(), step.getUserName());

        // Step 5: Open through the header menu Service -> Different Elements Page
        // Data: -
        // Exp. result: Page is opened

        step.goToDifferentElementsPage();
        softAssert.assertEquals(webDriver.getTitle(), step.differentElementsPageBrowserTitle());

        // Step 6: Select checkboxes
        // Data: Water, Wind
        // Exp. result: Elements are checked

        step.selectCheckboxWater();
        softAssert.assertTrue(step.checkboxWaterIsSelected());

        step.selectCheckboxWind();
        softAssert.assertTrue(step.checkboxWindIsSelected());

        // Step 7: Select radio
        // Data: Selen
        // Exp. result: Element is checked

        step.selectRadioSelen();
        softAssert.assertTrue(step.radioSelenIsSelected());

//        // Step 8: Select in dropdown
        // Data: Yellow
        // Exp. result: Element is selected

        step.selectYellowInDropdown();
        softAssert.assertTrue(step.yellowIsSelected());

        // Step 9: Assert that
        // •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // •	for radio button there is a log row and value is corresponded to the status of radio button
        // •	for dropdown there is a log row and value is corresponded to the selected value.
        // Data: -
        // Exp. result: Log rows are displayed and
        // •	checkbox name and its status are corresponding to selected
        // •	radio button name and it status is corresponding to selected
        // •	dropdown name and selected value is corresponding to selected

        step.refreshPage();

        for (WebElement element : check.getCheckboxes()) {
            softAssert.assertTrue(step.checkCheckboxCheckedLogs(element));
        }

        for (WebElement element : check.getCheckboxes()) {
            softAssert.assertTrue(step.checkCheckboxUncheckedLogs(element));
        }

        for (WebElement element : radio.getRadioButtons()) {
            softAssert.assertTrue(step.checkRadioCheckedLogs(element));
        }

        step.selectYellowInDropdown();
        for (WebElement element : colorsMenu.getColors()) {
            softAssert.assertTrue(step.checkColorCheckedLogs(element));
        }

    }

}