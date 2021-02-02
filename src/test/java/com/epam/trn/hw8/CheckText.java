package com.epam.trn.hw8;

import com.epam.trn.hw8.dto.RequestDto;
import com.epam.trn.hw8.dto.ResultDto;
import com.epam.trn.hw8.service.CheckTextAssertions;
import com.epam.trn.hw8.service.CheckTextService;
import lombok.SneakyThrows;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.epam.trn.hw8.utils.JsonDataProvider;

import java.util.Properties;

public class CheckText {

    @SneakyThrows
    private Properties getProperties() {
        Properties props = new Properties();
        String propFileName = "error_codes.properties";
        props.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        return props;
    }

    @BeforeMethod
    public void setup() {
    }

    @AfterMethod
    public void teardown() {
    }

    @Test(description = "CheckText method with IGNORE_DIGITS option",
            dataProvider = "ignoreDigitsOptionTestData", dataProviderClass = JsonDataProvider.class)
    public void checkTextWithIgnoreDigitsOption(RequestDto request) {
        ResultDto[] actual = new CheckTextService().checkTextWithParams(request);

        new CheckTextAssertions(actual).verifyThatThereIsNoError();
    }

    @Test(description = "Check text without any options",
            dataProvider = "checkTextWithoutOptions", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithoutOptions(RequestDto request) {
        ResultDto[] actual = new CheckTextService().checkTextWithoutParams(request);

        new CheckTextAssertions(actual).verifyErrorCode(getProperties().getProperty("ERROR_UNKNOWN_WORD"))
                .verifyIncorrectWords(request.getExpected());
    }

    @Test(description = "CheckText method with FIND_REPEAT_WORD option",
            dataProvider = "repeatWordTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithFindRepeatWordsOption(RequestDto request) {
        ResultDto[] actual = new CheckTextService().checkTextWithParams(request);

        new CheckTextAssertions(actual).verifyErrorCode(getProperties().getProperty("ERROR_REPEAT_WORD"))
                .verifyIncorrectWords(request.getExpected());
    }

    @Test(description = "Check text with repeated words without FIND_REPEAT_WORD option",
            dataProvider = "repeatWordTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithoutFindRepeatWordsOption(RequestDto request) {
        request.setOptions("0");
        ResultDto[] actual = new CheckTextService().checkTextWithParams(request);

        new CheckTextAssertions(actual).verifyThatThereIsNoError().
                verifyThatThereIsNoThatErrorCode(getProperties().getProperty("ERROR_REPEAT_WORD"));
    }

    @Test(description = "CheckTexts with IGNORE_CAPITALIZATION option",
            dataProvider = "ignoreCapitalizationTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextsWithIgnoreCapitalizationOption(RequestDto request) {
        ResultDto[] actual = new CheckTextService().checkTextWithParams(request);

        new CheckTextAssertions(actual).verifyThatThereIsNoThatErrorCode(getProperties().getProperty("ERROR_CAPITALIZATION"));
    }


    @Test(description = "Check incorrect text without IGNORE_CAPITALIZATION option",
            dataProvider = "ignoreCapitalizationTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithoutIgnoreCapitalizationOption(RequestDto request) {
        request.setOptions("0");
        ResultDto[] actual = new CheckTextService().checkTextWithParams(request);

        new CheckTextAssertions(actual)
                .verifyErrorCode(getProperties().getProperty("ERROR_CAPITALIZATION"))
                .verifyIncorrectWords(request.getExpected());
    }

}
