package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class IconsAreDisplayedTest extends AbstractTest {

    @Feature(value = "Home Page")
    @Story(value = "Icons")

    @Test(description = "Assert that there are 4 images and they are displayed")
    public void iconsAreDisplayedTest() {

        // Step 1: Open test site by URL
        // Step 2: Assert that there are 4 images on the Index Page and they are displayed
        // Data: 4 images
        // Exp. result: Images are displayed

        step.openSite();
        assertionStep.assertThatEveryIconsAreDisplayed();
        assertionStep.assertThatQuantityOfIconsEqualsToExpected();
        assertionStep.assertAll();

    }
}
