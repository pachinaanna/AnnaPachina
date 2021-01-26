package com.epam.trn.hw6.utils;

import com.epam.trn.hw6.entities.MetalsAndColorsFormData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonDataReader {

    public JsonDataReader() throws IOException {
    }

    protected ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, MetalsAndColorsFormData> testData = objectMapper.readValue(new File("src/test/resources/hw6/metalsColorsDataSet.json"), new TypeReference<Map<String, MetalsAndColorsFormData>>(){});

    public List<MetalsAndColorsFormData> getJsonDataSet() {
        List<MetalsAndColorsFormData> list = new ArrayList<>();
        for(Map.Entry entry : testData.entrySet()){
            list.add((MetalsAndColorsFormData) entry.getValue());
        }
        return list;
    }

}