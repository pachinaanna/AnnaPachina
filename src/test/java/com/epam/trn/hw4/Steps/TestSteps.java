package com.epam.trn.hw4.Steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestSteps extends AbstractStep {

    public TestSteps(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    @Step("Открыть домашнюю страницу")
    public void openSite() {
        homePage.open(properties.getProperty("url"));
    }

    @Step("Ввести логин, пароль и войти в систему")
    public void login() {
        homePage.login(properties.getProperty("login"), properties.getProperty("password"));
    }

    @Step("Переключиться на iframe")
    public void switchToIframe() {
        homePage.goToIframe();
    }

    @Step("Вернуться на домашнюю страницу")
    public void switchBackFromIframe() {
        homePage.returnToHomePage();
    }

    @Step("Перейти на страницу Different Elements")
    public void goToDifferentElementsPage() {
        homePage.goToDifferentElements();
    }

    @Step("Активировать чекбокс Water")
    public void selectCheckboxWater() { differentElements.selectCheckbox(properties.getProperty("checkbox.water")); }

    @Step("Активировать чекбокс Wind")
    public void selectCheckboxWind() {
        differentElements.selectCheckbox(properties.getProperty("checkbox.wind"));
    }

    @Step("Активировать радиокнопку Selen")
    public void selectRadioSelen() {
        differentElements.selectRadio(properties.getProperty("radiobutton.selen"));
    }

    @Step("Выбрать из выпадающего списка Yellow")
    public void selectYellowInDropdown() {
        differentElements.selectColor(properties.getProperty("color.yellow"));
    }

    @Step("Обновить страницу")
    public void refreshPage() {
        differentElements.refreshPage();
    }

}

