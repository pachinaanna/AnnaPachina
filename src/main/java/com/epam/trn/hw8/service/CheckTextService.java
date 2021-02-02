package com.epam.trn.hw8.service;

import com.epam.trn.hw8.dto.RequestDto;
import com.google.gson.Gson;
import com.epam.trn.hw8.dto.ResultDto;
import java.util.HashMap;
import java.util.Map;

public class CheckTextService {

    public ResultDto[] checkTextWithParams(RequestDto request) {
        Map<String, Object> params = new HashMap<>();
        params.put("lang", request.getLang());
        params.put("options", request.getOptions());
        params.put("format", request.getFormat());
        return
                new Gson().fromJson(
                        new CommonService()
                                .postTextWithParams(URI.CHECK_TEXT, request.getText(), params)
                                .getBody().asString(), ResultDto[].class);
    }

    public ResultDto[] checkTextWithoutParams(RequestDto request) {
        String json = new CommonService()
                .postTextNoParams(URI.CHECK_TEXT, request.getText())
                .getBody().asString();
        return
                new Gson().fromJson(
                        json, ResultDto[].class);
    }

}
