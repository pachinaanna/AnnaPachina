package com.epam.trn.hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.trn.hw6.sections.MetalsAndColorsForm;
import com.epam.trn.hw6.entities.MetalsAndColorsFormData;
import com.epam.trn.hw6.utils.JsonDataReader;
import org.openqa.selenium.WebElement;

import static com.epam.trn.hw6.sections.MetalsAndColorsForm.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    protected JsonDataReader jreader;
    {
        try {
            jreader = new JsonDataReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FindBy(css = ".form")
    public static MetalsAndColorsForm metalsAndColorsForm;

    public static void selectSummary(ArrayList<String> summary) {
            summaryFirstLine.select(summary.get(0));
            summarySecondLine.select(summary.get(1));
    }

    public static void selectElements(ArrayList<String> element) {
        for (String el : element)
        {elementCheckboxes.select(el);}
    }

    public static void selectColor(String color) {
        colors.select(color);
    }

    public static void selectMetal(String metal) {
        metals.select(metal);
    }

    @FindBy(xpath = "//div[@id='salad-dropdown']//span")
    public static Button vegetablesButton;

    @FindBy(id = "g7")
    public static Checkbox vegetableCheckbox;

    public static void uncheckVegetables() {
        vegetablesButton.click();
        vegetableCheckbox.click();
    }

    public static void selectVegetables(ArrayList<String> veget) {
        uncheckVegetables();
        for(String v : veget) {
            vegetables.select(v);
        }
    }

    @FindBy(id = "submit-button")
    public static Button submitButton;

    public static void clickSubmitButton() {
        submitButton.click();
    }

    @FindBy(css = ".results > li")
    public List<WebElement> resultSection;

    public boolean resultSectionContainsData(MetalsAndColorsFormData set, int i) {
        List<String> list = set.setToList();
        return list.get(i).contains(resultSection.get(i).getText());
    }

}
