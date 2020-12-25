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
        softAssert.assertEquals(homePage.getUrl(), properties.getProperty("url"));
    }

    @Step("Проверка того, что открыта домашняя страница")
    public void assertThatBrowserTitleEqualsHomePage() {
        softAssert.assertEquals(homePage.getBrowserTitle(), properties.getProperty("browser.title"));
    }

    @Step("Проверка того, что пользователь вошел в систему")
    public void assertThatUserIsLogged() {
        softAssert.assertTrue(headerMenu.getLoggedUser().isDisplayed());
    }

    @Step("Проверка того, что отображаемое имя пользователя соответствует ожидаемому результату")
    public void assertThatUserNameEqualsToExpectedResult() {
        softAssert.assertEquals(headerMenu.getLoggedUser().getText(), properties.getProperty("userName"));
    }

    @Step("Проверка того, что количество разделов в header menu равняется 4")
    public void assertThatQuantityOfHeaderMenuItemsEqualsExpectedResult() {
        softAssert.assertEquals(homePage.quantityOfHeaderMenuItems(), 4);
    }

    @Step("Проверка того, что текст кнопок из header menu соответствует требуемому")
    public void assertThatTextOfTheHeaderButtonsEqualToExpectedResult() {
        List<String> text = new ArrayList<>();
        text.add(properties.getProperty("header.button1"));
        text.add(properties.getProperty("header.button2"));
        text.add(properties.getProperty("header.button3"));
        text.add(properties.getProperty("header.button4"));
        for (String string : text) {
            softAssert.assertTrue(homePage.checkHeaderButtonsText(text));
        }
    }

    @Step("Проверка того, что количество иконок равно 4")
    public void assertThatQuantityOfIconsEqualsToExpected() {
        softAssert.assertEquals(homePage.quantityOfIcons(), 4);
    }

    @Step("Проверка того, что все иконки отображены")
    public void assertThatEveryIconsAreDisplayed() {
        for (WebElement icon : homePage.getIcons()) {
            softAssert.assertTrue(icon.isDisplayed());
        }
    }

    @Step("Проверка того, что количество бенефитов равно 4")
    public void assertThatQuantityOfBenefitsEqualsToExpected() {
        softAssert.assertEquals(homePage.quantityOfBenefitsText(), 4);
    }

    @Step("Проверка того, что текст бенефитов соответствует требуемому")
    public void assertThatTextOfBenefitsEqualToExpected() {
        List<String> text = new ArrayList<>();
        text.add(properties.getProperty("text.image1"));
        text.add(properties.getProperty("text.image2"));
        text.add(properties.getProperty("text.image3"));
        text.add(properties.getProperty("text.image4"));
        for (String string : text) {
            softAssert.assertTrue(homePage.checkBenefitsText(text));
        }
    }

    @Step("Проверка того, что iframe отображена")
    public void assertThatIframeIsDisplayed() {
        softAssert.assertTrue(iframe.getIframe().isDisplayed());
    }

    @Step("Проверка того, что Frame Button отображена")
    public void assertThatFrameButtonIsDisplayed() {
        softAssert.assertTrue(iframe.getFrameButton().isDisplayed());
    }

    @Step("Проверка того, что количество разделов на левой секции равно 5")
    public void assertThatQuantityOfLeftSectionItemsEqualsToExpected() {
        softAssert.assertEquals(homePage.quantityOfLeftSideMenuItems(), 5);
    }

    @Step("Проверка того, что текст разделов из левой секции соотвествует требуемому")
    public void assertThatTextOfLeftSectionItemsEqualToExpected() {
        List<String> text = new ArrayList<>();
        text.add(properties.getProperty("leftSection.button1"));
        text.add(properties.getProperty("leftSection.button2"));
        text.add(properties.getProperty("leftSection.button3"));
        text.add(properties.getProperty("leftSection.button4"));
        text.add(properties.getProperty("leftSection.button5"));
        for (String string : text) {
            System.out.println(homePage.checkLeftSideItemsText(text));
            softAssert.assertTrue(homePage.checkLeftSideItemsText(text));

        }
    }

    @Step("Проверка того, что открыта страница Different Elements")
    public void assertThatBrowserTitleEqualsDifferentElements() {
        softAssert.assertEquals(homePage.getBrowserTitle(), properties.getProperty("differentElementsPage.browser.title"));
    }

    @Step("Проверка того, что чекбокс Water активирован")
    public void assertThatCheckboxWaterIsSelected() {
        softAssert.assertTrue(differentElements.getCheckbox(properties.getProperty("checkbox.water")).isSelected());
    }

    @Step("Проверка того, что чекбокс Wind активирован")
    public void assertThatCheckboxWindIsSelected() {
        softAssert.assertTrue(differentElements.getCheckbox(properties.getProperty("checkbox.wind")).isSelected());
    }

    @Step("Проверка того, что радиокнопка Selen активирована")
    public void assertThatRadioSelenIsSelected() {
        softAssert.assertTrue(differentElements.getRadio(properties.getProperty("radiobutton.selen")).isSelected());
    }

    @Step("Проверка того, что Yellow выбран")
    public void assertThatYellowIsSelected() {
        softAssert.assertTrue(differentElements.getColor(properties.getProperty("color.yellow")).isSelected());
    }

    @Step("Проверка того, что логи для активированных чекбоксов соответствуют статусу")
    public void assertThatLogsForCheckedCheckboxesCorrespondToTheStatus() {
        for (WebElement element : differentElements.getCheckboxes()) {
            softAssert.assertTrue(differentElements.compareLogs(element, properties.getProperty("log.text.checkboxChecked")));
        }
    }

    @Step("Проверка того, что логи для деактивированных чекбоксов соответствуют статусу")
    public void assertThatLogsForUncheckedCheckboxesCorrespondToTheStatus() {
        for (WebElement element : differentElements.getCheckboxes()) {
            softAssert.assertTrue(differentElements.compareLogs(element, properties.getProperty("log.text.checkboxUnchecked")));
        }
    }

    @Step("Проверка того, что логи для радиокнопок соответствуют статусу")
    public void assertThatLogsForRadioButtonsCorrespondToTheStatus() {
        for (WebElement element : differentElements.getRadioButtons()) {
            softAssert.assertTrue(differentElements.compareLogs(element, properties.getProperty("log.text.radio")));
        }
    }

    @Step("Проверка того, что логи для цветов соответствуют статусу")
    public void assertThatLogsForColorsCorrespondToTheStatus() {
        for (WebElement element : differentElements.getColor()) {
            softAssert.assertTrue(differentElements.compareLogs(element, properties.getProperty("log.text.color")));
        }
    }















}
