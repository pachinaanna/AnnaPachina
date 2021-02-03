package com.epam.trn.hw8.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RequestDto {

    private String text;
    private String lang;
    private String options;
    private String format;
    private String expected;

}
