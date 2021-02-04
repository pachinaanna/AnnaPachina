package com.epam.trn.hw8;

import com.epam.trn.hw8.constants.ErrorCodes;
import com.epam.trn.hw8.dto.RequestDto;
import com.epam.trn.hw8.dto.ResultDto;
import com.epam.trn.hw8.service.CheckTextAssertions;
import com.epam.trn.hw8.service.CheckTextService;
import com.epam.trn.hw8.utils.JsonDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.trn.hw8.constants.ErrorCodes.*;

public class CheckText {

    CheckTextService checkTextService;

    @BeforeMethod
    public void setUp() {
        checkTextService = new CheckTextService();
    }

    private void checkByErrorCode(RequestDto requestDto, ErrorCodes errorRepeatWord) {
        ResultDto[] actual = checkTextService.checkTextWithParams(requestDto);

        new CheckTextAssertions(actual).verifyErrorCode(errorRepeatWord.getCode())
                .verifyIncorrectWords(requestDto.getExpected());
    }

    @Test(description = "CheckText method with IGNORE_DIGITS option",
            dataProvider = "ignoreDigitsOptionTestData", dataProviderClass = JsonDataProvider.class)
    public void checkTextWithIgnoreDigitsOption(RequestDto requestDto) {
        ResultDto[] actual = checkTextService.checkTextWithParams(requestDto);

        new CheckTextAssertions(actual).verifyThatThereIsNoError();
    }

    @Test(description = "Check text without any options",
            dataProvider = "checkTextWithoutOptions", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithoutOptions(RequestDto requestDto) {
        checkByErrorCode(requestDto, ERROR_UNKNOWN_WORD);
    }

    @Test(description = "CheckText method with FIND_REPEAT_WORD option",
            dataProvider = "repeatWordTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithFindRepeatWordsOption(RequestDto requestDto) {
        checkByErrorCode(requestDto, ERROR_REPEAT_WORD);
    }

    @Test(description = "Check text with repeated words without FIND_REPEAT_WORD option",
            dataProvider = "repeatWordTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithoutFindRepeatWordsOption(RequestDto requestDto) {
        requestDto.setOptions("0");
        ResultDto[] actual = checkTextService.checkTextWithParams(requestDto);

        new CheckTextAssertions(actual).verifyThatThereIsNoError().
                verifyThatThereIsNoThatErrorCode(ERROR_REPEAT_WORD.getCode());
    }

    @Test(description = "CheckTexts with IGNORE_CAPITALIZATION option",
            dataProvider = "ignoreCapitalizationTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextsWithIgnoreCapitalizationOption(RequestDto requestDto) {
        ResultDto[] actual = checkTextService.checkTextWithParams(requestDto);

        new CheckTextAssertions(actual)
                .verifyThatThereIsNoThatErrorCode(ERROR_CAPITALIZATION.getCode());
    }

    @Test(description = "Check incorrect text without IGNORE_CAPITALIZATION option",
            dataProvider = "ignoreCapitalizationTestData", dataProviderClass = JsonDataProvider.class)
    public void CheckTextWithoutIgnoreCapitalizationOption(RequestDto requestDto) {
        requestDto.setOptions("0");
        checkByErrorCode(requestDto, ERROR_CAPITALIZATION);
    }

}
