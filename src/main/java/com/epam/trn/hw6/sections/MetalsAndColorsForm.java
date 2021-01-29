package com.epam.trn.hw6.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.trn.hw6.entities.MetalsAndColorsFormData;

import java.util.ArrayList;

public class MetalsAndColorsForm extends Form<MetalsAndColorsFormData> {

    @UI("[name = custom_radio_odd]")
    public RadioButtons summaryFirstLine;

    @UI("[name = custom_radio_even]")
    public RadioButtons summarySecondLine;

    public void selectSummary(ArrayList<String> summary) {
        summaryFirstLine.select(summary.get(0));
        summarySecondLine.select(summary.get(1));
    }

    @FindBy(css = "section[id=elements-checklist] input[type=checkbox]")
    public Checklist elementCheckboxes;

    public void selectElements(ArrayList<String> element) {
        for (String el : element)
        {elementCheckboxes.select(el);}
    }

    @JDropdown(root = "div[id=colors]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colors;

    public void selectColor(String color) {
        colors.select(color);
    }

    @JDropdown(root = "div[id=metals]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown metals;

    public void selectMetal(String metal) {
        metals.select(metal);
    }

    @JDropdown(root = "div[id=vegetables]",
            value = "button",
            list = "li",
            expand = ".caret")
    public Dropdown vegetables;

    @FindBy(xpath = "//div[@id='salad-dropdown']//span")
    public Button vegetablesButton;

    @FindBy(id = "g7")
    public Checkbox vegetableCheckbox;

    public void uncheckVegetables() {
        vegetablesButton.click();
        vegetableCheckbox.click();
    }

    public void selectVegetables(ArrayList<String> veget) {
        uncheckVegetables();
        for(String v : veget) {
            vegetables.select(v);
        }
    }

    @FindBy(id = "submit-button")
    public Button submitButton;

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void submitForm(MetalsAndColorsFormData set) {
        selectSummary(set.getSummary());
        selectElements(set.getElements());
        selectColor(set.getColor());
        selectMetal(set.getMetals());
        selectVegetables(set.getVegetables());
        clickSubmitButton();
    }

}
