package com.epam.trn.hw8.service;

import com.epam.trn.hw8.dto.ResultDto;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class CheckTextAssertions {

    private ResultDto[] results;

    public CheckTextAssertions(ResultDto[] response) {
        this.results = response;
    }

    public CheckTextAssertions verifyIncorrectWords(String expected) {
        assertEquals(results.length, 1, "");
        assertEquals(results[0].getWord(), expected, "Incorrect word is not equal to expected word");
        return this;
    }

    public CheckTextAssertions verifyErrorCode(String code) {
        assertEquals(results[0].getCode(), code, "Incorrect error code");
        return this;
    }

    public CheckTextAssertions verifyThatThereIsNoError() {
        assertEquals(results.length, 0, "Not expected error");
        return this;
    }

    public CheckTextAssertions verifyThatThereIsNoThatErrorCode(String code) {
        IntStream.range(0, results.length)
                .forEach(i -> assertNotEquals(results[i]
                        .getCode(), code, "Not expected error code"));
        return this;
    }

}
