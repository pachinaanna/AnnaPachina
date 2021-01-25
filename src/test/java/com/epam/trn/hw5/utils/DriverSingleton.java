package com.epam.trn.hw5.utils;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverSingleton {

    private static WebDriver webDriver;

    private DriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            webDriver = DriverManager.createWebDriver();
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
