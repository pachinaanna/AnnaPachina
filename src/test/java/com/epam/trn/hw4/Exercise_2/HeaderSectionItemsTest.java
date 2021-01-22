package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class HeaderSectionItemsTest extends AbstractTest {

    @Feature(value = "Home Page")
    @Story(value = "Header Section")

    @Test(description = "Assert that there are 4 items in header section, they are displayed and have proper text")
    public void headerSectionItemsTest() {

        // Step 1: Open test site by URL
        // Step 2: Assert that there are 4 items on the header section are displayed and they have proper texts
        // Data: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        // Exp. results: Menu buttons are displayed and have proper texts

        step.openSite();
        assertionStep.assertThatQuantityOfHeaderMenuItemsEqualsExpectedResult(4);
        assertionStep.assertThatTextOfTheHeaderButtonsEqualToExpectedResult();
        assertionStep.assertAll();

    }
}
