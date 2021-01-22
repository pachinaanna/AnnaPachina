package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class OpeningSiteTest extends AbstractTest {

    @Feature(value = "Home Page")
    @Story(value = "Opening site")

    @Test(description = "Open test site by URL")
    public void openSiteByUrl() {

        // Step 1: Open test site by URL
        // Data: "https://jdi-testing.github.io/jdi-light/index.html"
        // Exp. result: Test site is opened

        step.openSite();
        assertionStep.assertThatSiteIsOpened();
        assertionStep.assertAll();

    }
}
