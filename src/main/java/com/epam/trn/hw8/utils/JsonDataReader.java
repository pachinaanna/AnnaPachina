package com.epam.trn.hw8.utils;

import com.epam.trn.hw8.dto.RequestDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonDataReader {

    protected ObjectMapper objectMapper = new ObjectMapper();
    public Map<String, RequestDto> checkTextWithoutOptionsData = objectMapper.readValue(new File("src/main/resources/checkTextWithoutOptionsData.json"), new TypeReference<Map<String, RequestDto>>() {
    });
    public Map<String, RequestDto> ignoreDigitsTestData = objectMapper.readValue(new File("src/main/resources/ignoreDigitsTestData.json"), new TypeReference<Map<String, RequestDto>>() {
    });
    public Map<String, RequestDto> repeatWordTestData = objectMapper.readValue(new File("src/main/resources/repeatWordTestData.json"), new TypeReference<Map<String, RequestDto>>() {
    });
    public Map<String, RequestDto> ignoreCapitalizationTestData = objectMapper.readValue(new File("src/main/resources/IgnoreCapitalizationTestData.json"), new TypeReference<Map<String, RequestDto>>() {
    });


    public JsonDataReader() throws IOException {
    }

    public List<RequestDto> getDataSet(Map<String, RequestDto> dataSet) {
        List<RequestDto> list = new ArrayList<>();
        for (Map.Entry entry : dataSet.entrySet()) {
            list.add((RequestDto) entry.getValue());
        }
        return list;
    }

    public List<RequestDto> getCheckTextWithoutOptionsDataSet() {
        return getDataSet(checkTextWithoutOptionsData);
    }

    public List<RequestDto> getIgnoreDigitsTestDataSet() {
        return getDataSet(ignoreDigitsTestData);
    }

    public List<RequestDto> getRepeatWordTestDataSet() {
        return getDataSet(repeatWordTestData);
    }

    public List<RequestDto> getIgnoreCapitalizationTestData() {
        return getDataSet(ignoreCapitalizationTestData);
    }

}
