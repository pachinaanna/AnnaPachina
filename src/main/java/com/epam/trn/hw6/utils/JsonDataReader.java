package com.epam.trn.hw6.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonDataReader {

    public JsonDataReader() throws IOException {
    }

    protected ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, DataSet> testData = objectMapper.readValue(new File("src/test/resources/hw6/metalsColorsDataSet.json"), new TypeReference<Map<String, DataSet>>(){});

    public DataSet getDataSet(String setName) {
        return testData.get(setName);
    }
}