package com.epam.trn.hw8.utils;

import com.epam.trn.hw8.dto.RequestDto;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class JsonDataProvider {

    protected JsonDataReader reader;
    {
        try {
            reader = new JsonDataReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @DataProvider(name = "checkTextWithoutOptions")
//    public Object[] checkTextData() {
//        return reader.getCheckTextWithoutOptionsDataSet().toArray();
//    }


    @DataProvider(name = "checkTextWithoutOptions")
    public Object[][] checkTextData() {
        return new Object[][] { {new RequestDto("I dont know what to write", "", "", "", "dont")},
        };
    }

    @DataProvider(name = "ignoreDigitsOptionTestData")
    public Object[] ignoreDigitsOptionTestData() {
        return reader.getIgnoreDigitsTestDataSet().toArray();
    }

    @DataProvider(name = "repeatWordTestData")
    public Object[] repeatWordTestData() {
        return reader.getRepeatWordTestDataSet().toArray();
    }

    @DataProvider(name = "ignoreCapitalizationTestData")
    public Object[] ignoreCapitalizationTestsData() {
        return reader.getIgnoreCapitalizationTestData().toArray();
    }
}
