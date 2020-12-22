package com.epam.trn.hw3.ex1;

import com.epam.trn.hw3.components.HeaderMenu;
import com.epam.trn.hw3.components.Iframe;
import com.epam.trn.hw3.components.RowBenefits;
import com.epam.trn.hw3.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.epam.trn.hw3.AbstractTest;

import java.io.IOException;
import java.util.Properties;

public class Exercise_1 extends AbstractTest {

    @Test
    public void exercise1() throws IOException {

        HomePage homePage = new HomePage(webDriver);
        HeaderMenu headerMenu = new HeaderMenu(webDriver);
        Iframe iframe = new Iframe(webDriver);
        RowBenefits benefit = new RowBenefits(webDriver);

        Properties properties = getProperties("homePage.properties");

        // Step 1: Open test site by URL
        // Data: "https://jdi-testing.github.io/jdi-light/index.html"
        // Exp. result: Test site is opened

        webDriver.get(properties.getProperty("url"));
        softAssert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("url"));

        // Step 2: Assert browser title
        // Data: "Home page"
        // Exp. result: Browser title equals "Home Page"

        softAssert.assertEquals(webDriver.getTitle(), properties.getProperty("browser.title"));

        // Step 3: Perform login
        // Data: username: Roman, pass: Jdi1234
        // Exp. result: User is logged

        homePage.login(properties.getProperty("login"), properties.getProperty("password"));
        softAssert.assertTrue(headerMenu.getLoggedUser().isDisplayed());

        // Step 4: Assert username is logged
        // Data: ROMAN IOVLEV
        // Exp. result: Name is displayed and equals to expected result

        softAssert.assertTrue(headerMenu.getLoggedUser().isDisplayed());
        softAssert.assertEquals(headerMenu.getLoggedUser().getText(), properties.getProperty("userName"));

        // Step 5: Assert that there are 4 items on the header section are displayed and they have proper texts
        // Data: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        // Exp. results: Menu buttons are displayed and have proper texts

        softAssert.assertEquals(homePage.quantityOfHeaderMenuItems(), 4);

        softAssert.assertTrue(homePage.checkHeaderButtonsText(properties.getProperty("header.button1")));
        softAssert.assertTrue(homePage.checkHeaderButtonsText(properties.getProperty("header.button2")));
        softAssert.assertTrue(homePage.checkHeaderButtonsText(properties.getProperty("header.button3")));
        softAssert.assertTrue(homePage.checkHeaderButtonsText(properties.getProperty("header.button4")));

        // Step 6: Assert that there are 4 images on the Index Page and they are displayed
        // Data: 4 images
        // Exp. result: Images are displayed

        softAssert.assertEquals(homePage.quantityOfIcons(), 4);
        for (WebElement icon : homePage.getIcons()) {
            softAssert.assertTrue(icon.isDisplayed());
        }

        // Step 7: Assert that there are 4 texts on the Index Page under icons and they have proper text
        // Data: textImage1, textImage2, textImage3, textImage4
        // Exp. result: Texts are displayed and equal to expected

        softAssert.assertEquals(homePage.quantityOfBenefitsText(), 4);
        softAssert.assertTrue(homePage.checkBenefitsText(properties.getProperty("text.image1")));
        softAssert.assertTrue(homePage.checkBenefitsText(properties.getProperty("text.image2")));
        softAssert.assertTrue(homePage.checkBenefitsText(properties.getProperty("text.image3")));
        softAssert.assertTrue(homePage.checkBenefitsText(properties.getProperty("text.image4")));

        // Step 8: Assert that there is the iframe with “Frame Button” exist
        // Data: -
        // Exp. result: The iframe exists

        softAssert.assertTrue(iframe.getIframe().isDisplayed());

        // Step 9: Switch to the iframe and check that there is “Frame Button” in the iframe
        // Data: -
        // Exp. result: The “Frame Button” exists

        webDriver.switchTo().frame(iframe.getIframe());
        softAssert.assertTrue(iframe.getFrameButton().isDisplayed());

        // Step 10: Switch to original window back
        // Data: -
        // Exp. result: Driver has focus on the original window

        webDriver.switchTo().defaultContent();
        softAssert.assertTrue(headerMenu.getLoggedUser().isDisplayed());

        // Step 11: Assert that there are 5 items in the Left Section are displayed and they have proper text
        // Data:  “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        // Exp. result: Left section menu items are displayed and have proper text

        softAssert.assertEquals(homePage.quantityOfLeftSideMenuItems(), 5);

        softAssert.assertTrue(homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button1")));
        softAssert.assertTrue(homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button2")));
        softAssert.assertTrue(homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button3")));
        softAssert.assertTrue(homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button4")));
        softAssert.assertTrue(homePage.checkLeftSideItemsText(properties.getProperty("leftSection.button5")));

    }

}

