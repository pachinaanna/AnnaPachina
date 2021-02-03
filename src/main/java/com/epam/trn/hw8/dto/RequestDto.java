package com.epam.trn.hw8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    private String text;
    private String lang;
    private String options;
    private String format;
    private String expected;

}
