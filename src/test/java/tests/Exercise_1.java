package tests;


import com.epam.trn.hw3.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Exercise_1 extends AbstractTest {

    @Test
    public void exercise1() throws IOException {

        HomePage homePage = new HomePage(webDriver);
        Properties properties = getProperties("homePage.properties");

        // Step 1: Open test site by URL
        // Data: "https://jdi-testing.github.io/jdi-light/index.html"
        // Exp. result: Test site is opened

        String URL = "https://jdi-testing.github.io/jdi-light/index.html";

        webDriver.get(URL);
        softAssert.assertEquals(webDriver.getCurrentUrl(), URL);

        // Step 2: Assert browser title
        // Data: "Home page"
        // Exp. result: Browser title equals "Home Page"

        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        // Step 3: Perform login
        // Data: username: Roman, pass: Jdi1234
        // Exp. result: User is logged

        String login = "Roman";
        String pass = "Jdi1234";

        homePage.login(login, pass);
        softAssert.assertTrue(homePage.getLogoutButton().isDisplayed());

        // Step 4: Assert username is logged
        // Data: ROMAN IOVLEV
        // Exp. result: Name is displayed and equals to expected result

        String name = "ROMAN IOVLEV";

        softAssert.assertTrue(headerMenu.getUserName().isDisplayed());
        softAssert.assertEquals(headerMenu.getUserName().getText(), name);

        // Step 5: Assert that there are 4 items on the header section are displayed and they have proper texts
        // Data: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        // Exp. results: Menu buttons are displayed and have proper texts

        softAssert.assertEquals(headerMenu.getHeaderButtons().size, 4);

        softAssert.assertTrue(homePage.checkHeaderButtonsText("HOME"));
        softAssert.assertTrue(homePage.checkHeaderButtonsText("CONTACT FORM"));
        softAssert.assertTrue(homePage.checkHeaderButtonsText("SERVICE"));
        softAssert.assertTrue(homePage.checkHeaderButtonsText("METALS & COLORS"));

        // Step 6: Assert that there are 4 images on the Index Page and they are displayed
        // Data: 4 images
        // Exp. result: Images are displayed

        List<WebElement> images = webDriver.findElements(By.cssSelector(".icons-benefit"));
        softAssert.assertEquals(images.size(), 4);
        for (WebElement image : images) {
            softAssert.assertTrue(image.isDisplayed());
        }

        // Step 7: Assert that there are 4 texts on the Index Page under icons and they have proper text
        // Data: textImage1, textImage2, textImage3, textImage4
        // Exp. result: Texts are displayed and equal to expected

        String textImage1 = "To include good practices and ideas from successful EPAM project";
        String textImage2 = "To be flexible and customizable";
        String textImage3 = "To be multiplatform";
        String textImage4 = "Already have good base (about 20 internal and some external projects), wish to get more...";

        softAssert.assertTrue(homePage.checkImagesText(textImage1));
        softAssert.assertTrue(homePage.checkImagesText(textImage2));
        softAssert.assertTrue(homePage.checkImagesText(textImage3));
        softAssert.assertTrue(homePage.checkImagesText(textImage4));

        // Step 8: Assert that there is the iframe with “Frame Button” exist
        // Data: -
        // Exp. result: The iframe exists

        softAssert.assertTrue(homePage.getIframe().isDisplayed());

        // Step 9: Switch to the iframe and check that there is “Frame Button” in the iframe
        // Data: -
        // Exp. result: The “Frame Button” exists

        webDriver.switchTo().frame(iframe.getIframe());
        softAssert.assertTrue(iframe.getFrameButton().isDisplayed());

        // Step 10: Switch to original window back
        // Data: -
        // Exp. result: Driver has focus on the original window

        webDriver.switchTo().defaultContent();
        softAssert.assertTrue(headerMenu.getUserName().isDisplayed());

        // Step 11: Assert that there are 5 items in the Left Section are displayed and they have proper text
        // Data:  “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        // Exp. result: Left section menu items are displayed and have proper text

        softAssert.assertEquals(leftSideMenu.getLEftSideItems(), 5);

        softAssert.assertTrue(homePage.checkItemsText("Home"));
        softAssert.assertTrue(homePage.checkItemsText("Contact form"));
        softAssert.assertTrue(homePage.checkItemsText("Service"));
        softAssert.assertTrue(homePage.checkItemsText("Metals & Colors"));
        softAssert.assertTrue(homePage.checkItemsText("Elements packs"));

        // Step 11: Close browser
        // Data: -
        // Exp. result: browser is closed

        webDriver.close();

    }

}

