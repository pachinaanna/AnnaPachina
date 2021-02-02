package com.epam.trn.hw8.service;

import com.epam.trn.hw8.dto.ResultDto;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CheckTextAssertions {

    private ResultDto[] results;

    public CheckTextAssertions(ResultDto[] response) {
        this.results = response;
    }

    public CheckTextAssertions verifyIncorrectWords(String expected) {
        assertEquals(results.length, 1);
        assertEquals(results[0].getWord(), expected);
        return this;
    }

    public CheckTextAssertions verifyErrorCode(String code) {
        assertEquals(results[0].getCode(), code);
        return this;
    }

    public CheckTextAssertions verifyThatThereIsNoError() {
        assertEquals(results.length, 0);
        return this;
    }

    public CheckTextAssertions verifyThatThereIsNoThatErrorCode(String code) {
        for (int i = 0; i < results.length; i++) {
            assertNotEquals(results[i].getCode(), code);
        }
        return this;
    }

}
