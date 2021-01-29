package com.epam.trn.hw6.Test;

import com.epam.trn.hw6.entities.MetalsAndColorsFormData;
import com.epam.trn.hw6.dataProvider.JdiDataProvider;
import com.epam.trn.hw6.TestInit;
import com.epam.trn.hw6.enums.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.epam.trn.hw6.JdiSite.*;
import static com.epam.trn.hw6.dataProvider.UserTestData.*;
import static org.testng.Assert.assertTrue;
import static com.epam.trn.hw6.pages.MetalsAndColorsPage.*;

public class JdiTest implements TestInit {

    @AfterMethod
    public void logout() {
        homePage.userIcon.click();
        homePage.logoutButton.click();
    }

    @Test(dataProvider = "data", dataProviderClass = JdiDataProvider.class)
    public void jdiTest(MetalsAndColorsFormData set) {
        openHomePage();
        homePage.loginAsUser(ROMAN);
        homePage.selectFromHeaderMenu(HeaderMenuItems.METALS_COLORS);
        checkThatMetalsAndColorsIsOpened();
        metalsAndColorsForm.submitForm(set);
        for (int i = 0; i < metalsAndColorsPage.resultSection.size(); i++) {
            assertTrue(metalsAndColorsPage.resultSectionContainsData(set, i));
        }
    }

}
