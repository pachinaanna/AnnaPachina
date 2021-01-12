package com.epam.trn.hw4.Steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssertionSteps extends AbstractStep {

    public AssertionSteps(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    public SoftAssert softAssert = new SoftAssert();

    @Step("Проверка того, что сайт открыт")
    public void assertThatSiteIsOpened() {
        softAssert.assertEquals(homePage.getUrl(), properties.getProperty("url"), "сайт не открыт");
    }

    @Step("Проверка того, что открыта домашняя страница")
    public void assertThatBrowserTitleEqualsHomePage() {
        softAssert.assertEquals(homePage.getBrowserTitle(), properties.getProperty("browser.title"), "домашняя страница не открыта");
    }

    @Step("Проверка того, что пользователь вошел в систему")
    public void assertThatUserIsLogged() {
        softAssert.assertTrue(headerMenu.getLoggedUser().isDisplayed(), "пользователь не вошел в систему");
    }

    @Step("Проверка того, что отображаемое имя пользователя соответствует ожидаемому результату")
    public void assertThatUserNameEqualsToExpectedResult() {
        softAssert.assertEquals(headerMenu.getLoggedUser().getText(), properties.getProperty("userName"), "имя пользователя не соответствует ожидаемому");
    }

    @Step("Проверка того, что количество разделов в header menu равняется 4")
    public void assertThatQuantityOfHeaderMenuItemsEqualsExpectedResult(int expected) {
        softAssert.assertEquals(homePage.quantityOfHeaderMenuItems(), expected, "количество разделов header menu не равно 4");
    }

    @Step("Проверка того, что текст кнопок из header menu соответствует требуемому")
    public void assertThatTextOfTheHeaderButtonsEqualToExpectedResult() {
        List<String> text = new ArrayList<>();
        text.add(properties.getProperty("header.button1"));
        text.add(properties.getProperty("header.button2"));
        text.add(properties.getProperty("header.button3"));
        text.add(properties.getProperty("header.button4"));
        for (String line : text) {
            softAssert.assertTrue(homePage.checkHeaderButtonsText(line), "текст кнопки из header menu не соответствует требуемому");
        }
    }

    @Step("Проверка того, что количество иконок равно 4")
    public void assertThatQuantityOfIconsEqualsToExpected(int expected) {
        softAssert.assertEquals(homePage.quantityOfIcons(), expected, "количество иконок не равно 4");
    }

    @Step("Проверка того, что все иконки отображены")
    public void assertThatEveryIconsAreDisplayed() {
        for (WebElement icon : homePage.getIcons()) {
            softAssert.assertTrue(icon.isDisplayed(), "иконка не отображена");
        }
    }

    @Step("Проверка того, что количество бенефитов равно 4")
    public void assertThatQuantityOfBenefitsEqualsToExpected(int expected) {
        softAssert.assertEquals(homePage.quantityOfBenefitsText(), expected, "количество бенефитов не равно 4");
    }

    @Step("Проверка того, что текст бенефитов соответствует требуемому")
    public void assertThatTextOfBenefitsEqualToExpected() {
        List<String> text = new ArrayList<>();
        text.add(properties.getProperty("text.image1"));
        text.add(properties.getProperty("text.image2"));
        text.add(properties.getProperty("text.image3"));
        text.add(properties.getProperty("text.image4"));
        for (String line : text) {
            softAssert.assertTrue(homePage.checkBenefitsText(line), "текст бенефита не соответствует требуемому");
        }
    }

    @Step("Проверка того, что iframe отображена")
    public void assertThatIframeIsDisplayed() {
        softAssert.assertTrue(iframe.getIframe().isDisplayed(), "iframe не отображена");
    }

    @Step("Проверка того, что Frame Button отображена")
    public void assertThatFrameButtonIsDisplayed() {
        softAssert.assertTrue(iframe.getFrameButton().isDisplayed(), "Frame button не отображена");
    }

    @Step("Проверка того, что количество разделов на левой секции равно 5")
    public void assertThatQuantityOfLeftSectionItemsEqualsToExpected(int expected) {
        softAssert.assertEquals(homePage.quantityOfLeftSideMenuItems(), expected, "количество разделов левой секции не равно 5");
    }

    @Step("Проверка того, что текст разделов из левой секции соотвествует требуемому")
    public void assertThatTextOfLeftSectionItemsEqualToExpected() {
        List<String> text = new ArrayList<>();
        text.add(properties.getProperty("leftSection.button1"));
        text.add(properties.getProperty("leftSection.button2"));
        text.add(properties.getProperty("leftSection.button3"));
        text.add(properties.getProperty("leftSection.button4"));
        text.add(properties.getProperty("leftSection.button5"));
        for (String line : text) {
            softAssert.assertTrue(homePage.checkLeftSideItemsText(line), "текст разделов левой секции не соответствует требуемому");
        }
    }

    @Step("Проверка того, что открыта страница Different Elements")
    public void assertThatBrowserTitleEqualsDifferentElements() {
        softAssert.assertEquals(homePage.getBrowserTitle(), properties.getProperty("differentElementsPage.browser.title"), "страница Different Elements не открыта");
    }

    @Step("Проверка того, что чекбокс Water активирован")
    public void assertThatCheckboxWaterIsSelected() {
        softAssert.assertTrue(differentElements.getCheckbox(properties.getProperty("checkbox.water")).isEnabled(), "чекбокс Water не активирован");
    }

    @Step("Проверка того, что чекбокс Wind активирован")
    public void assertThatCheckboxWindIsSelected() {
        softAssert.assertTrue(differentElements.getCheckbox(properties.getProperty("checkbox.wind")).isEnabled(), "чекбокс Wind не активирован");
    }

    @Step("Проверка того, что радиокнопка Selen активирована")
    public void assertThatRadioSelenIsSelected() {
        softAssert.assertTrue(differentElements.getRadio(properties.getProperty("radiobutton.selen")).isEnabled(), "радиокнопка не Selen активирована");
    }

    @Step("Проверка того, что Yellow выбран")
    public void assertThatYellowIsSelected() {
        softAssert.assertTrue(differentElements.getColor(properties.getProperty("color.yellow")).isSelected(), "Yellow не выбран");
    }

    @Step("Проверка того, что логи для активированных чекбоксов соответствуют статусу")
    public void assertThatLogsForCheckedCheckboxesCorrespondToTheStatus() {
        for (WebElement element : differentElements.getCheckboxes()) {
            softAssert.assertTrue(differentElements.compareCheckboxLogs(element, properties.getProperty("log.text.checkboxChecked")), "лог активированного чекбокса не соответсвтуют статусу");
        }
    }

    @Step("Проверка того, что логи для деактивированных чекбоксов соответствуют статусу")
    public void assertThatLogsForUncheckedCheckboxesCorrespondToTheStatus() {
        for (WebElement element : differentElements.getCheckboxes()) {
            softAssert.assertTrue(differentElements.compareCheckboxLogs(element, properties.getProperty("log.text.checkboxUnchecked")), "лог деактивированного чекбокса не соответсвуют статусу");
        }
    }

    @Step("Проверка того, что логи для радиокнопок соответствуют статусу")
    public void assertThatLogsForRadioButtonsCorrespondToTheStatus() {
        for (WebElement element : differentElements.getRadioButtons()) {
            softAssert.assertTrue(differentElements.compareRadioButtonsAndColorsLogs(element, properties.getProperty("log.text.radio")), "лог радиокнопки не соответствуют статусу");
        }
    }

    @Step("Проверка того, что логи для цветов соответствуют статусу")
    public void assertThatLogsForColorsCorrespondToTheStatus() {
        for (WebElement element : differentElements.getColor()) {
            softAssert.assertTrue(differentElements.compareRadioButtonsAndColorsLogs(element, properties.getProperty("log.text.color")), "лог цвета не соответствуют статусу");
        }
    }

        public void assertAll() {
            softAssert.assertAll();
    }
}
