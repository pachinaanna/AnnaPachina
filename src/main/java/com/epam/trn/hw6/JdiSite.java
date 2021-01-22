package com.epam.trn.hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.trn.hw6.pages.HomePage;
import com.epam.trn.hw6.pages.MetalsAndColors;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/")
    public static HomePage homePage;

    @Url("/metals-colors")
    public static MetalsAndColors metalsAndColors;

    public static void openHomePage() {
        homePage.open();
    }

    public static void checkThatMetalsAndColorsIsOpened() {
        metalsAndColors.checkOpened();
    }
}