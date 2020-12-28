package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class FrameButtonIsExistTest extends AbstractTest {

    @Feature(value = "Iframe")
    @Story(value = "Frame Button")

    @Test(description = "Assert that there is “Frame Button” in the iframe")
    public void frameButtonIsExistTest() {

        // Step 1: Open test site by URL
        // Step 2: Switch to the iframe and check that there is “Frame Button” in the iframe
        // Data: -
        // Exp. result: The “Frame Button” exists

        step.openSite();
        step.switchToIframe();
        assertionStep.assertThatFrameButtonIsDisplayed();

    }
}
