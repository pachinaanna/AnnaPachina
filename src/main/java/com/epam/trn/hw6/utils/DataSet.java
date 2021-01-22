package com.epam.trn.hw6.utils;

import com.epam.jdi.tools.DataClass;
import java.util.ArrayList;
import java.util.List;

public class DataSet extends DataClass<JsonDataReader> {

    public DataSet() {
    }

    public DataSet(ArrayList<String> summary, ArrayList<String> elements, String color, String metals, ArrayList<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    private ArrayList<String> summary;
    private ArrayList<String> elements;
    private String color;
    private String metals;
    private ArrayList<String> vegetables;

    public String dataSetToString() {
        return summary.toString() + "/" +
                elements.toString() + "/" +
                color + "/" +
                metals + "/" +
                vegetables.toString();
    }

    public ArrayList<String> getSummary() {
        return summary;
    }
    public void setSummary(ArrayList<String> summary) {
        this.summary = summary;
    }

    public ArrayList<String> getElements() {
        return elements;
    }

    public void setElements(ArrayList<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public ArrayList<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(ArrayList<String> vegetables) {
        this.vegetables = vegetables;
    }

    public String sumNumbersFromSummary() {
        int int1 = Integer.parseInt(summary.get(0)) + Integer.parseInt(summary.get(1));
        return int1 + "";
    }

    public List<String> setToList() {
        List<String> list = new ArrayList<>();
        list.add("Summary: " + sumNumbersFromSummary());
        String el = elements.toString();
        list.add("Elements: " + el.substring(1, el.length()-1));
        list.add("Color: " + color);
        list.add("Metal: " + metals);
        String veg = vegetables.toString();
        list.add("Vegetables: " + veg.substring(1, veg.length()-1));
        return list;
    }
}
