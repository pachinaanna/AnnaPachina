package com.epam.trn.hw8.service;

import com.epam.trn.hw8.constans.URI;
import com.epam.trn.hw8.dto.RequestDto;
import com.epam.trn.hw8.dto.ResultDto;
import com.google.gson.Gson;

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

}
