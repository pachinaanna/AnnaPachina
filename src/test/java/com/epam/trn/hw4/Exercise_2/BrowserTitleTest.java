package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class BrowserTitleTest extends AbstractTest{

    @Feature(value = "Home Page")
    @Story(value = "Browser title")

    @Test(description = "Assertion browser title")
    public void browserTitleTest() {

        // Step 1: Open test site by URL
        // Step 2: Assert browser title
        // Data: "Home page"
        // Exp. result: Browser title equals "Home Page"

        step.openSite();
        assertionStep.assertThatBrowserTitleEqualsHomePage();
        assertionStep.assertAll();

    }

}
