package com.epam.trn.hw8.dto;

import java.util.ArrayList;
import java.util.Objects;

public class ResultDto {

    private String code;
    private String pos;
    private String row;
    private String col;
    private String len;
    private String word;
    private ArrayList<String> s;

    public ResultDto(String code, String pos, String row, String col, String len, String word, ArrayList<String> s) {
        this.code = code;
        this.pos = pos;
        this.row = row;
        this.col = col;
        this.len = len;
        this.word = word;
        this.s = s;
    }

    public String getCode() { return code; }

    public String getPos() { return pos; }

    public String getRow() { return row; }

    public String getCol() { return col; }

    public String getLen() { return len; }

    public String getWord() { return word; }

    public ArrayList<String> getS() { return s; }

    public void setCode(String code) { this.code = code; }

    public void setPos(String pos) { this.pos = pos; }

    public void setRow(String row) { this.row = row; }

    public void setCol(String col) { this.col = col; }

    public void setLen(String len) { this.len = len; }

    public void setWord(String word) { this.word = word; }

    public void setS(ArrayList<String> s) { this.s = s; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDto that = (ResultDto) o;
        return Objects.equals(code, that.code) && Objects.equals(pos, that.pos) && Objects.equals(row, that.row) && Objects.equals(col, that.col) && Objects.equals(len, that.len) && Objects.equals(word, that.word) && Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, pos, row, col, len, word, s);
    }
}
