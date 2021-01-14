package com.epam.trn.hw5.Steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class WhenStepDef extends AbstractBaseStepDef {

    public WhenStepDef() throws IOException {
        super();
    }

    @When("I login as a user {string}")
    public void i_login_as_a_user(String user) {
        String[] words = properties.getProperty(user).split("/");
        String login = words[0].trim();
        String password = words[1].trim();
        homePage.login(login, password);
    }

    @When("I click on {string} button in header")
    public void i_click_on_button_in_header(String buttonName) {
        homePage.clickOnHeaderMenuButton(buttonName);
    }

    @When("I click on {string} in Service dropdown")
    public void i_click_on_in_service_dropdown(String service) {
        homePage.goToService(service);
    }

    @When("I check checkbox {string}")
    public void i_check_checkboxes_water_and_wind(String element) {
        differentElements.selectCheckbox(element);
    }

    @When("I activate radio button {string}")
    public void i_activate_radio_button(String radioButtonName) {
        differentElements.selectRadio(radioButtonName);
    }

    @When("I select {string} in dropdown")
    public void i_select_color_in_dropdown(String color) {
        differentElements.selectColor(color);
    }

    @When("I check all checkboxes")
    public void i_check_all_checkboxes() {
        for (WebElement element : differentElements.getCheckboxes()) {
            element.click();
        }
    }

    @When("I uncheck all checkboxes")
    public void i_uncheck_all_checkboxes() {
        for (WebElement element : differentElements.getCheckboxes()) {
            element.click();
        }
    }

    @When("I activate every radio button")
    public void i_activate_every_radio_button() {
        for (WebElement element : differentElements.getRadioButtons()) {
            element.click();
        }
    }

    @When("I select every color in dropdown")
    public void i_select_every_color_in_dropdown() {
        differentElements.selectColor(properties.getProperty("color.yellow"));
        for (WebElement element : differentElements.getColor()) {
            element.click();
        }
    }

    @When("I select {string} checkbox for {string}")
    public void i_select_checkbox_for(String checkbox, String userName) {
        userTable.selectCheckbox(checkbox, userName);
    }





}
