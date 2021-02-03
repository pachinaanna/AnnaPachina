package com.epam.trn.hw8;

import com.epam.trn.hw8.dto.RequestDto;
import com.epam.trn.hw8.dto.ResultDto;
import com.epam.trn.hw8.service.CheckTextAssertions;
import com.epam.trn.hw8.service.CheckTextService;
import com.epam.trn.hw8.utils.JsonDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.trn.hw8.constans.ErrorCodes.*;

public class CheckText {

    CheckTextService checkTextService;

    @BeforeMethod
    public void setUp() {
        checkTextService = new CheckTextService();
    }

    @Test(description = "CheckText method with IGNORE_DIGITS option",
            dataProvider = "ignoreDigitsOptionTestData", dataProviderClass = JsonDataProvider.class)
    public void checkTextWithIgnoreDigitsOption(RequestDto request) {
        ResultDto[] actual = checkTextService.checkTextWithParams(request);
        new CheckTextAssertions(actual).verifyThatThereIsNoError();
    }

    @Test(description = "CheckText method without any options",
            dataProvider = "checkTextWithoutOptions", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithoutOptions(RequestDto request) {
        ResultDto[] actual = checkTextService.checkTextWithParams(request);
        new CheckTextAssertions(actual).verifyErrorCode(ERROR_UNKNOWN_WORD.getCode())
                .verifyIncorrectWords(request.getExpected());
    }

    @Test(description = "CheckText method with FIND_REPEAT_WORD option",
            dataProvider = "repeatWordTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithFindRepeatWordsOption(RequestDto request) {
        ResultDto[] actual = checkTextService.checkTextWithParams(request);
        new CheckTextAssertions(actual).verifyErrorCode(ERROR_REPEAT_WORD.getCode())
                .verifyIncorrectWords(request.getExpected());
        request.setOptions("0");
        actual = checkTextService.checkTextWithParams(request);
        new CheckTextAssertions(actual).verifyThatThereIsNoError()
                .verifyThatThereIsNoThatErrorCode(ERROR_REPEAT_WORD.getCode());
    }

    @Test(description = "CheckText method with IGNORE_CAPITALIZATION option",
            dataProvider = "ignoreCapitalizationTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextsWithIgnoreCapitalizationOption(RequestDto request) {
        ResultDto[] actual = checkTextService.checkTextWithParams(request);
        new CheckTextAssertions(actual)
                .verifyThatThereIsNoThatErrorCode(ERROR_CAPITALIZATION.getCode());
        request.setOptions("0");
        actual = checkTextService.checkTextWithParams(request);
        new CheckTextAssertions(actual)
                .verifyErrorCode(ERROR_CAPITALIZATION.getCode())
                .verifyIncorrectWords(request.getExpected());
    }

}
