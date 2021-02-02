package com.epam.trn.hw8.utils;

import com.epam.trn.hw8.dto.RequestDto;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class JsonDataProvider {

    protected JsonDataReader reader = new JsonDataReader();

    public JsonDataProvider() throws IOException {
    }

    @DataProvider(name = "checkTextWithoutOptions")
    public Object[] checkTextData() throws IOException {
        List<RequestDto> list = reader.getCheckTextWithoutOptionsDataSet();
        return list.toArray();
    }

    @DataProvider(name = "ignoreDigitsOptionTestData")
    public Object[] ignoreDigitsOptionTestData() throws IOException {
        List<RequestDto> list = reader.getIgnoreDigitsTestDataSet();
        return list.toArray();
    }

    @DataProvider(name = "repeatWordTestData")
    public Object[] repeatWordTestData() throws IOException {
        List<RequestDto> list = reader.getRepeatWordTestDataSet();
        return list.toArray();
    }

    @DataProvider(name = "ignoreCapitalizationTestData")
    public Object[] ignoreCapitalizationTestsData() throws IOException {
        List<RequestDto> list = reader.getIgnoreCapitalizationTestData();
        return list.toArray();
    }
}
