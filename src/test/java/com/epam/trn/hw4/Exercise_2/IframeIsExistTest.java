package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class IframeIsExistTest extends AbstractTest {

    @Feature(value = "Home Page")
    @Story(value = "Iframe")

    @Test(description = "Assert that there is the iframe with “Frame Button” exist")
    public void iframeIsExistTest() {

        // Step 1: Open test site by URL
        // Step 2: Assert that there is the iframe with “Frame Button” exist
        // Data: -
        // Exp. result: The iframe exists

        step.openSite();
        assertionStep.assertThatIframeIsDisplayed();

    }
}
