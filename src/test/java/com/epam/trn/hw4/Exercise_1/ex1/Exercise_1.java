package com.epam.trn.hw4.Exercise_1.ex1;

import com.epam.trn.hw4.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.trn.hw4.AbstractTest;

@Listeners({AllureListener.class})
public class Exercise_1 extends AbstractTest {

    @Test(description = "Exercise 1 test")
    public void exercise1() {

        // Step 1: Open test site by URL
        // Data: "https://jdi-testing.github.io/jdi-light/index.html"
        // Exp. result: Test site is opened

        step.openSite();
        assertionStep.assertThatSiteIsOpened();

        // Step 2: Assert browser title
        // Data: "Home page"
        // Exp. result: Browser title equals "Home Page"

        assertionStep.assertThatBrowserTitleEqualsHomePage();

        // Step 3: Perform login
        // Data: username: Roman, pass: Jdi1234
        // Exp. result: User is logged

        step.login();
        assertionStep.assertThatUserIsLogged();

        // Step 4: Assert username is logged
        // Data: ROMAN IOVLEV
        // Exp. result: Name is displayed and equals to expected result

        assertionStep.assertThatUserNameEqualsToExpectedResult();

        // Step 5: Assert that there are 4 items on the header section are displayed and they have proper texts
        // Data: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        // Exp. results: Menu buttons are displayed and have proper texts

        assertionStep.assertThatQuantityOfHeaderMenuItemsEqualsExpectedResult();
        assertionStep.assertThatTextOfTheHeaderButtonsEqualToExpectedResult();

        // Step 6: Assert that there are 4 images on the Index Page and they are displayed
        // Data: 4 images
        // Exp. result: Images are displayed

        assertionStep.assertThatEveryIconsAreDisplayed();
        assertionStep.assertThatQuantityOfIconsEqualsToExpected();

        // Step 7: Assert that there are 4 texts on the Index Page under icons and they have proper text
        // Data: textImage1, textImage2, textImage3, textImage4
        // Exp. result: Texts are displayed and equal to expected

        assertionStep.assertThatQuantityOfBenefitsEqualsToExpected();
        assertionStep.assertThatTextOfBenefitsEqualToExpected();

        // Step 8: Assert that there is the iframe with “Frame Button” exist
        // Data: -
        // Exp. result: The iframe exists

        assertionStep.assertThatIframeIsDisplayed();

        // Step 9: Switch to the iframe and check that there is “Frame Button” in the iframe
        // Data: -
        // Exp. result: The “Frame Button” exists

        step.switchToIframe();
        assertionStep.assertThatFrameButtonIsDisplayed();

        // Step 10: Switch to original window back
        // Data: -
        // Exp. result: Driver has focus on the original window

        step.switchBackFromIframe();
        assertionStep.assertThatUserIsLogged();

        // Step 11: Assert that there are 5 items in the Left Section are displayed and they have proper text
        // Data:  “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        // Exp. result: Left section menu items are displayed and have proper text

        assertionStep.assertThatQuantityOfLeftSectionItemsEqualsToExpected();
        assertionStep.assertThatTextOfLeftSectionItemsEqualToExpected();

        assertionStep.assertAll();
    }

}

