package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class UsernameIsLoggedTest extends AbstractTest {

    @Feature(value = "Home Page")
    @Story(value = "Performing login")

    @Test(description = "Assert username is logged")
    public void usernameIsLoggedTest() {

        // Step 1: Open test site by URL
        // Step 2: Perform login with username: Roman, pass: Jdi1234
        // Step 3: Assert username is logged
        // Data: ROMAN IOVLEV
        // Exp. result: User is logged

        step.openSite();
        step.login();
        assertionStep.assertThatUserNameEqualsToExpectedResult();

    }
}
