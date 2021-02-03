package com.epam.trn.hw8.dto;

import lombok.*;

import java.util.ArrayList;

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
