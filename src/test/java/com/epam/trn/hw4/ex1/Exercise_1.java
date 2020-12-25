package com.epam.trn.hw4.ex1;

import com.epam.trn.hw4.Steps.TestSteps;
import com.epam.trn.hw4.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.epam.trn.hw4.AbstractTest;

import java.io.IOException;

public class Exercise_1 extends AbstractTest {

    @Test
    public void exercise1() throws IOException {
        TestSteps step = new TestSteps(webDriver);

        HomePage homePage = new HomePage(webDriver);

        // Step 1: Open test site by URL
        // Data: "https://jdi-testing.github.io/jdi-light/index.html"
        // Exp. result: Test site is opened

        step.openSite();
        softAssert.assertEquals(webDriver.getCurrentUrl(), step.getExpectedUrl());

        // Step 2: Assert browser title
        // Data: "Home page"
        // Exp. result: Browser title equals "Home Page"

        softAssert.assertEquals(webDriver.getTitle(), step.homePageBrowserTitle());

        // Step 3: Perform login
        // Data: username: Roman, pass: Jdi1234
        // Exp. result: User is logged

        step.login();
        softAssert.assertTrue(step.loggedUserIsDisplayed());

        // Step 4: Assert username is logged
        // Data: ROMAN IOVLEV
        // Exp. result: Name is displayed and equals to expected result

        softAssert.assertTrue(step.loggedUserIsDisplayed());
        softAssert.assertEquals(step.getLoggedUserText(), step.getUserName());

        // Step 5: Assert that there are 4 items on the header section are displayed and they have proper texts
        // Data: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        // Exp. results: Menu buttons are displayed and have proper texts

        softAssert.assertEquals(step.getQuantityOfHeaderMenuItems(), 4);

        softAssert.assertTrue(step.checkTextOfThe1HeaderButton());
        softAssert.assertTrue(step.checkTextOfThe2HeaderButton());
        softAssert.assertTrue(step.checkTextOfThe3HeaderButton());
        softAssert.assertTrue(step.checkTextOfThe4HeaderButton());

        // Step 6: Assert that there are 4 images on the Index Page and they are displayed
        // Data: 4 images
        // Exp. result: Images are displayed

        softAssert.assertEquals(step.getQuantityOfIcons(), 4);
        for (WebElement icon : homePage.getIcons()) {
            softAssert.assertTrue(icon.isDisplayed());
        }

        // Step 7: Assert that there are 4 texts on the Index Page under icons and they have proper text
        // Data: textImage1, textImage2, textImage3, textImage4
        // Exp. result: Texts are displayed and equal to expected

        softAssert.assertEquals(step.getQuantityOfBenefits(), 4);
        softAssert.assertTrue(step.checkTextOfThe1Benefit());
        softAssert.assertTrue(step.checkTextOfThe2Benefit());
        softAssert.assertTrue(step.checkTextOfThe3Benefit());
        softAssert.assertTrue(step.checkTextOfThe4Benefit());

        // Step 8: Assert that there is the iframe with “Frame Button” exist
        // Data: -
        // Exp. result: The iframe exists

        softAssert.assertTrue(step.iframeIsDisplayed());

        // Step 9: Switch to the iframe and check that there is “Frame Button” in the iframe
        // Data: -
        // Exp. result: The “Frame Button” exists

        step.switchToIframe();
        softAssert.assertTrue(step.frameButtonIsDisplayed());

        // Step 10: Switch to original window back
        // Data: -
        // Exp. result: Driver has focus on the original window

        step.switchBackFromIframe();
        softAssert.assertTrue(step.loggedUserIsDisplayed());

        // Step 11: Assert that there are 5 items in the Left Section are displayed and they have proper text
        // Data:  “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        // Exp. result: Left section menu items are displayed and have proper text

        softAssert.assertEquals(step.getQuantityOfSideMenuItems(), 5);

        softAssert.assertTrue(step.checkTextOfThe1LeftSideItem());
        softAssert.assertTrue(step.checkTextOfThe2LeftSideItem());
        softAssert.assertTrue(step.checkTextOfThe3LeftSideItem());
        softAssert.assertTrue(step.checkTextOfThe4LeftSideItem());
        softAssert.assertTrue(step.checkTextOfThe5LeftSideItem());

    }

}

