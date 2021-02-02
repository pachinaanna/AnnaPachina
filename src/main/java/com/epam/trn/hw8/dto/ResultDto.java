package com.epam.trn.hw8.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ResultDto {

    private String code;
    private String pos;
    private String row;
    private String col;
    private String len;
    private String word;
    private ArrayList<String> s;

}
