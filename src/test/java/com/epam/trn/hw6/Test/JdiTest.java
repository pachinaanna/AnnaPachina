package com.epam.trn.hw6.Test;

import com.epam.trn.hw6.utils.DataSet;
import com.epam.trn.hw6.dataProvider.JdiDataProvider;
import com.epam.trn.hw6.TestInit;
import com.epam.trn.hw6.enums.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.epam.trn.hw6.JdiSite.*;
import static com.epam.trn.hw6.dataProvider.UserTestData.*;
import static org.testng.Assert.assertTrue;

public class JdiTest implements TestInit {

    @AfterMethod
        public void logout() {
        homePage.userIcon.click();
        homePage.logoutButton.click();
    }

    @Test(dataProvider = "data", dataProviderClass = JdiDataProvider.class)
    public void jdiTest(DataSet set) {
        openHomePage();
        homePage.loginAsUser(ROMAN);
        homePage.selectFromHeaderMenu(HeaderMenuItems.METALS_COLORS);
        checkThatMetalsAndColorsIsOpened();
        metalsAndColors.selectSummary(set.getSummary());
        metalsAndColors.selectElements(set.getElements());
        metalsAndColors.selectColor(set.getColor());
        metalsAndColors.selectMetal(set.getMetals());
        metalsAndColors.selectVegetables(set.getVegetables());
        metalsAndColors.clickSubmitButton();
        for (int i=0; i<metalsAndColors.resultSection.size(); i++) {
            assertTrue(metalsAndColors.resultSectionContainsData(set, i));
        }
    }

}
