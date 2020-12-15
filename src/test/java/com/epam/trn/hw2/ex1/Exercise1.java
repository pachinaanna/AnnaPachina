package com.epam.trn.hw2.ex1;

import com.epam.trn.hw2.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise1 extends AbstractTest {

    @Test
    public void exercise1() {
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

        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.xpath("//input[@id='name']")).sendKeys(login);
        webDriver.findElement(By.id("password")).sendKeys(pass);
        webDriver.findElement(By.id("login-button")).click();
        softAssert.assertTrue(webDriver.findElement(By.className("logout")).isDisplayed());

        // Step 4: Assert username is logged
        // Data: ROMAN IOVLEV
        // Exp. result: Name is displayed and equals to expected result

        String name = "ROMAN IOVLEV";

        WebElement loggedUser = webDriver.findElement(By.id("user-name"));
        softAssert.assertTrue(loggedUser.isDisplayed());
        softAssert.assertEquals(loggedUser, name);

        // Step 5: Assert that there are 4 items on the header section are displayed and they have proper texts
        // Data: "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        // Exp. results: Menu buttons are displayed and have proper texts

        List<WebElement> buttons = webDriver.findElements(By.xpath("//ul[contains(@class, 'm-l8')]/li"));
        softAssert.assertEquals(buttons.size(), 4);
        for (WebElement button : buttons) {
            softAssert.assertTrue(button.isDisplayed());
        }

        WebElement buttonHome = webDriver.findElement(By.xpath("//ul[contains(@class, 'm-l8')]/li[1]"));
        softAssert.assertEquals(buttonHome.getText(), "HOME");

        WebElement buttonContactForm = webDriver.findElement(By.xpath("//ul[contains(@class, 'm-l8')]/li[2]"));
        softAssert.assertEquals(buttonContactForm.getText(), "CONTACT FORM");

        WebElement buttonService = webDriver.findElement(By.xpath("//ul[contains(@class, 'm-l8')]/li[3]"));
        softAssert.assertEquals(buttonService, "SERVICE");

        WebElement buttonMetals = webDriver.findElement(By.xpath("//ul[contains(@class, 'm-l8')]/li[4]"));
        softAssert.assertEquals(buttonMetals, "METALS & COLORS");

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

        List<WebElement> textBoxes = webDriver.findElements(By.cssSelector(".benefit-txt"));
        softAssert.assertEquals(textBoxes.get(0).getText(), textImage1);
        softAssert.assertEquals(textBoxes.get(1).getText(), textImage2);
        softAssert.assertEquals(textBoxes.get(2).getText(), textImage3);
        softAssert.assertEquals(textBoxes.get(3).getText(), textImage4);

        // Step 8: Assert that there is the iframe with “Frame Button” exist
        // Data: -
        // Exp. result: The iframe exists

        softAssert.assertTrue(webDriver.findElement(By.id("frame")).isDisplayed());

        // Step 9: Switch to the iframe and check that there is “Frame Button” in the iframe
        // Data: -
        // Exp. result: The “Frame Button” exists

        webDriver.switchTo().frame("frame");
        softAssert.assertTrue(webDriver.findElement(By.id("frame-button")).isDisplayed());

        // Step 10: Switch to original window back
        // Data: -
        // Exp. result: Driver has focus on the original window

        webDriver.switchTo().defaultContent();
        softAssert.assertTrue(loggedUser.isDisplayed());

        // Step 11: Assert that there are 5 items in the Left Section are displayed and they have proper text
        // Data:  “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        // Exp. result: Left section menu items are displayed and have proper text

        List<WebElement> leftSection = webDriver.findElements(By.className("sidebar-menu"));
        softAssert.assertEquals(leftSection.size(), 5);

        softAssert.assertEquals(webDriver.findElement(By.xpath("//ul[@class='sidebar-menu']/li[1]")).getText(), "Home");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//ul[@class='sidebar-menu']/li[2]")).getText(), "Contact form");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//ul[@class='sidebar-menu']/li[3]")).getText(), "Service");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//ul[@class='sidebar-menu']/li[4]")).getText(), "Metals & Colors");
        softAssert.assertEquals(webDriver.findElement(By.xpath("//ul[@class='sidebar-menu']/li[5]")).getText(), "Elements packs");

        // Step 11: Close browser
        // Data: -
        // Exp. result: browser is closed

        webDriver.close();
        softAssert.assertEquals(isBrowserClose(webDriver),false);

    }

}






