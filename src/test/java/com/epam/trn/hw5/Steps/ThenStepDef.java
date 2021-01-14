package com.epam.trn.hw5.Steps;

import com.epam.trn.hw5.DriverSingleton;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenStepDef extends AbstractBaseStepDef {

    public ThenStepDef() throws IOException {
        super();
    }

    @Then("site should be opened")
    public void site_should_be_opened() {
        assertEquals(homePage.getUrl(), properties.getProperty("url"));
    }

    @Then("{string} page should be opened")
    public void page_should_be_opened(String browserTitle) {
        System.out.println(DriverSingleton.getWebDriver().getTitle());
        System.out.println(browserTitle);
        assertEquals(DriverSingleton.getWebDriver().getTitle(), browserTitle);
    }

    @Then("user should be logged")
    public void user_should_be_logged() {
        assertTrue(headerMenu.getLoggedUser().isDisplayed());
    }

    @Then("user name should be equal to {string}")
    public void user_name_should_be_equal_to_expected_result(String user) {
        assertEquals(headerMenu.getLoggedUser().getText(), user);
    }

    @Then("element {string} should be checked")
    public void elements_should_be_checked(String element) {
        assertTrue(differentElements.getCheckbox(element).isEnabled());
    }

    @Then("radio button {string} should be checked")
    public void radio_button_should_be_checked(String radioButtonName) {
        assertTrue(differentElements.getRadio(radioButtonName).isEnabled());
    }

    @Then("color {string} should be selected")
    public void color_should_be_selected(String color) {
        assertTrue(differentElements.getColor(color).isSelected());
    }

    @Then("log row for checked checkboxes should match the status")
    public void log_row_for_checked_checkboxes_should_match_the_status() {
        for (WebElement element : differentElements.getCheckboxes()) {
            assertTrue(differentElements.compareCheckboxLogs(element, properties.getProperty("log.text.checkboxChecked")));
        }
    }

    @Then("log row for unchecked checkboxes should match the status")
    public void log_row_for_unchecked_checkboxes_should_match_the_status() {
        for (WebElement element : differentElements.getCheckboxes()) {
            assertTrue(differentElements.compareCheckboxLogs(element, properties.getProperty("log.text.checkboxUnchecked")));
        }
    }

    @Then ("log row for each radio button should match the status")
    public void log_row_for_each_radio_button_should_match_the_status() {
        for (WebElement element : differentElements.getRadioButtons()) {
            assertTrue(differentElements.compareRadioButtonsAndColorsLogs(element, properties.getProperty("log.text.radio")));
        }
    }

    @Then ("log row for each color should match the status")
    public void log_row_for_each_color_should_match_the_status() {
        for (WebElement element : differentElements.getColor()) {
            assertTrue(differentElements.compareRadioButtonsAndColorsLogs(element, properties.getProperty("log.text.color")));
        }
    }

//    @Then ("(\\d+) Number Type Dropdown should be displayed on Users Table on User Table Page$")
//    public void number_type_dropdown_should_be_displayed_on_users_table_on_user_table_page(int number) {
////        for (WebElement element : userTable.getNumberTypes()) {
//            assertEquals(userTable.getNumberTypes().size(), number);
////            assertTrue(element.isDisplayed());
////        }
//    }

//    @Then ("(\\d+) Usernames should be displayed on Users Table on User Table Page$")
//    public void usernames_should_be_displayed_on_users_table_on_user_table_page(int number) {
////        for (WebElement element : userTable.getNumberTypes()) {
//        assertEquals(userTable.getUserNames().size(), number);
////            assertTrue(element.isDisplayed());
////        }
//    }

    @Then ("(\\d+) Description texts under images should be displayed on Users Table on User Table Page$")
    public void description_texts_under_images_should_be_displayed_on_users_table_on_user_table_page(int number) {
//        for (WebElement element : userTable.getNumberTypes()) {
        assertEquals(userTable.getDescriptions().size(), number);
//            assertTrue(element.isDisplayed());
//        }
    }

//    @Then ("(\\d+) checkboxes should be displayed on Users Table on User Table Page$")
//    public void checkboxes_should_be_displayed_on_users_table_on_user_table_page(int number) {
////        for (WebElement element : userTable.getNumberTypes()) {
//        assertEquals(userTable.getUsersCheckboxes().size(), number);
////            assertTrue(element.isDisplayed());
////        }
//    }







}
