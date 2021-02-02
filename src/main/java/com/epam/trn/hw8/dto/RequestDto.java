package com.epam.trn.hw8.dto;

import java.util.Objects;

public class RequestDto {
    private String text;
    private String lang;
    private String options;
    private String format;
    private String expected;

    public RequestDto(String text, String lang, String options, String format, String expected) {
        this.text = text;
        this.lang = lang;
        this.options = options;
        this.format = format;
        this.expected = expected;
    }

    public RequestDto() {
    }

    public String getExpected() { return expected; }

    public String getText() { return text; }

    public String getLang() { return lang; }

    public String getOptions() { return options; }

    public String getFormat() { return format; }

    public void setText(String text) { this.text = text; }

    public void setLang(String lang) { this.lang = lang; }

    public void setOptions(String options) { this.options = options; }

    public void setFormat(String format) { this.format = format; }

    public void setExpected(String expected) { this.expected = expected; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestDto that = (RequestDto) o;
        return Objects.equals(text, that.text) && Objects.equals(lang, that.lang) && Objects.equals(options, that.options) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, lang, options, format);
    }
}
