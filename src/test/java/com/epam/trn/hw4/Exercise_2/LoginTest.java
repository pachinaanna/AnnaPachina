package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    @Feature(value = "Home Page")
    @Story(value = "Performing login")

    @Test(description = "Login test")
    public void loginTest() {

        // Step 1: Open test site by URL
        // Step 2: Perform login
        // Data: "https://jdi-testing.github.io/jdi-light/index.html", username: Roman, pass: Jdi1234
        // Exp. result: User is logged

        step.openSite();
        step.login();
        assertionStep.assertThatUserIsLogged();
        assertionStep.assertAll();

    }
}
