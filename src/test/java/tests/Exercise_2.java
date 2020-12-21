package tests;


import com.epam.trn.hw3.pages.DifferentElementsPage;
import com.epam.trn.hw3.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.zip.DeflaterInputStream;

public class Exercise_2 extends AbstractTest {

    @Test
    public void exercise2() {

        HomePage homePage = new HomePage(webDriver);
        DifferentElementsPage differentElements = new DifferentElementsPage(webDriver);

        // Step 1: Open test site by URL
        // Data: https://jdi-testing.github.io/jdi-light/index.html
        // Exp. result: Test site is opened

        String URL = "https://jdi-testing.github.io/jdi-light/index.html";

        webDriver.get(URL);
        softAssert.assertEquals(webDriver.getCurrentUrl(), URL);

        // Step 2: Assert browser title
        // Data: "Home Page"
        // Exp. result: Browser title equals "Home Page"

        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        // Step 3: Perform login
        // Data: username: Roman, pass: Jdi1234
        // Exp. result: User is logged

        String login = "Roman";
        String pass = "Jdi1234";

        homePage.login(login, pass);
        softAssert.assertTrue(webDriver.findElement(By.className("logout")).isDisplayed());

        // Step4: Assert User name in the left-top side of screen that user is logged
        // Data: ROMAN IOVLEV
        // Exp. result: Name is displayed and equals to expected result

        String name = "ROMAN IOVLEV";

        WebElement loggedUser = webDriver.findElement(By.id("user-name"));
        softAssert.assertTrue(loggedUser.isDisplayed());
        softAssert.assertEquals(loggedUser, name);

        // Step 5: Open through the header menu Service -> Different Elements Page
        // Data: -
        // Exp. result: Page is opened

        homePage.goToServices("DIFFERENT ELEMENTS");
        softAssert.assertEquals(webDriver.getTitle(), "Different Elements");

        // Step 6: Select checkboxes
        // Data: Water, Wind
        // Exp. result: Elements are checked

        differentElements.selectCheckbox("Water");
        softAssert.assertTrue(checkWater.isSelected());
        differentElements.selectCheckbox("Wind");
        softAssert.assertTrue(checkWind.isSelected());

        // Step 7: Select radio
        // Data: Selen
        // Exp. result: Element is checked

        differentElements.selectRadio("Selen");
        softAssert.assertTrue(radioSelen.isSelected());

        // Step 8: Select in dropdown
        // Data: Yellow
        // Exp. result: Element is selected

        differentElements.selectColor("Yellow");
        softAssert.assertTrue(differentElements.getColor("Yellow").isSelected());

        // Step 9: Assert that
        // •	for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        // •	for radio button there is a log row and value is corresponded to the status of radio button
        // •	for dropdown there is a log row and value is corresponded to the selected value.
        // Data: -
        // Exp. result: Log rows are displayed and
        // •	checkbox name and its status are corresponding to selected
        // •	radio button name and it status is corresponding to selected
        // •	dropdown name and selected value is corresponding to selected

        webDriver.navigate().refresh();

        List <WebElement> activeCheckbox = webDriver.findElements(By.xpath("//label[@class='label-checkbox']"));
        for(WebElement checkbox : activeCheckbox) {
            String logTextTrue = checkbox.getText() + ": condition changed to true";
            String logTextFalse = checkbox.getText() + ": condition changed to false";
            checkbox.click();
            checkbox.click();
            List <WebElement> logs = webDriver.findElements(By.cssSelector(".panel-body-list.logs > li"));
            softAssert.assertTrue(logTextTrue.contains(logs.get(0).getText()));
            softAssert.assertTrue(logTextFalse.contains(logs.get(1).getText()));

        }

        List <WebElement> activeRadio = webDriver.findElements(By.xpath("//label[@class='label-radio']"));
        for(WebElement radio : activeRadio) {
            String logText = "metal: value changed to " + radio.getText();
            radio.click();
            List <WebElement> logs = webDriver.findElements(By.cssSelector(".panel-body-list.logs > li"));
            softAssert.assertTrue(logText.contains(logs.get(0).getText()));

        }

        List <WebElement> colors = webDriver.findElements(By.xpath("//select[@class='uui-form-element']/option"));
        colors.get(1).click();
        for(WebElement color : colors) {
            String logText = "Colors: value changed to " + color.getText();
            color.click();
            List <WebElement> logs = webDriver.findElements(By.cssSelector(".panel-body-list.logs > li"));
            softAssert.assertTrue(logText.contains(logs.get(0).getText()));

        }

        // Step 10: Close browser
        // Data: -
        // Exp. result: Browser is closed

        webDriver.close();

    }

}