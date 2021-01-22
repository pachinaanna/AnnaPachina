package com.epam.trn.hw4.Exercise_1.ex2;

import com.epam.trn.hw4.utils.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.trn.hw4.AbstractTest;

@Listeners({AllureListener.class})
public class Exercise_2 extends AbstractTest {

    @Test(description = "Exercise 2 test")
    public void exercise2() {

        // Step 1: Open test site by URL
        // Data: https://jdi-testing.github.io/jdi-light/index.html
        // Exp. result: Test site is opened

        step.openSite();
        assertionStep.assertThatSiteIsOpened();

        // Step 2: Assert browser title
        // Data: "Home Page"
        // Exp. result: Browser title equals "Home Page"

        assertionStep.assertThatBrowserTitleEqualsHomePage();

        // Step 3: Perform login
        // Data: username: Roman, pass: Jdi1234
        // Exp. result: User is logged

        step.login();
        assertionStep.assertThatUserIsLogged();

        // Step4: Assert User name in the left-top side of screen that user is logged
        // Data: ROMAN IOVLEV
        // Exp. result: Name is displayed and equals to expected result

        assertionStep.assertThatUserNameEqualsToExpectedResult();

        // Step 5: Open through the header menu Service -> Different Elements Page
        // Data: -
        // Exp. result: Page is opened

        step.goToDifferentElementsPage();
        assertionStep.assertThatBrowserTitleEqualsDifferentElements();

        // Step 6: Select checkboxes
        // Data: Water, Wind
        // Exp. result: Elements are checked

        step.selectCheckboxWater();
        assertionStep.assertThatCheckboxWaterIsSelected();

        step.selectCheckboxWind();
        assertionStep.assertThatCheckboxWindIsSelected();

        // Step 7: Select radio
        // Data: Selen
        // Exp. result: Element is checked

        step.selectRadioSelen();
        assertionStep.assertThatRadioSelenIsSelected();

        // Step 8: Select in dropdown
        // Data: Yellow
        // Exp. result: Element is selected

        step.selectYellowInDropdown();
        assertionStep.assertThatYellowIsSelected();

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
        assertionStep.assertThatLogsForCheckedCheckboxesCorrespondToTheStatus();

        assertionStep.assertThatLogsForUncheckedCheckboxesCorrespondToTheStatus();

        assertionStep.assertThatLogsForRadioButtonsCorrespondToTheStatus();

        step.selectYellowInDropdown();
        assertionStep.assertThatLogsForColorsCorrespondToTheStatus();

        assertionStep.assertAll();
    }
}