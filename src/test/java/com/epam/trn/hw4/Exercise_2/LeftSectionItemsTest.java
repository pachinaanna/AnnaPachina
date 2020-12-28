package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class LeftSectionItemsTest extends AbstractTest {

    @Feature(value = "Home Page")
    @Story(value = "Left Section")

    @Test(description = "Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void leftSectionItemsTest() {

        // Step 1: Open test site by URL
        // Step 2: Assert that there are 5 items in the Left Section are displayed and they have proper text
        // Data:  “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        // Exp. result: Left section menu items are displayed and have proper text

        step.openSite();
        assertionStep.assertThatQuantityOfLeftSectionItemsEqualsToExpected();
        assertionStep.assertThatTextOfLeftSectionItemsEqualToExpected();
        assertionStep.assertAll();

    }
}
