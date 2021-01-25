package com.epam.trn.hw5.Steps;

import io.cucumber.java.en.Given;

import java.io.IOException;

public class GivenStepDef extends AbstractBaseStepDef {

    public GivenStepDef() throws IOException {
        super();
    }

    @Given ("I open JDI GitHub site")
    public void i_am_on_home_page() {
        homePage.open(properties.getProperty("url"));
    }
}
