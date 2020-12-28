package com.epam.trn.hw4.Exercise_2;

import com.epam.trn.hw4.AbstractTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class BenefitsTextTest extends AbstractTest {

    @Feature(value = "Home Page")
    @Story(value = "Benefits")

    @Test(description = "Assert that there are 4 texts under icons and they have proper text")
    public void benefitsTextTest() {

        // Step 1: Open test site by URL
        // Step 2: Assert that there are 4 texts on the Index Page under icons and they have proper text
        // Data: textImage1, textImage2, textImage3, textImage4
        // Exp. result: Texts are displayed and equal to expected

        step.openSite();
        assertionStep.assertThatQuantityOfBenefitsEqualsToExpected();
        assertionStep.assertThatTextOfBenefitsEqualToExpected();
        assertionStep.assertAll();

    }
}
