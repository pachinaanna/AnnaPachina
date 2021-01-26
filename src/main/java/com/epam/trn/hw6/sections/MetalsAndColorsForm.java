package com.epam.trn.hw6.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

import static com.epam.trn.hw6.pages.MetalsAndColorsPage.*;
import com.epam.trn.hw6.entities.MetalsAndColorsFormData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsFormData> {

    @UI("[name = custom_radio_odd]")
    public static RadioButtons summaryFirstLine;

    @UI("[name = custom_radio_even]")
    public static RadioButtons summarySecondLine;

    @FindBy(css = "section[id=elements-checklist] input[type=checkbox]")
    public static Checklist elementCheckboxes;

    @JDropdown(root = "div[id=colors]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colors;

    @JDropdown(root = "div[id=metals]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "div[id=vegetables]",
            value = "button",
            list = "li",
            expand = ".caret")
    public static Dropdown vegetables;

    public void submitForm(MetalsAndColorsFormData set) {
        selectSummary(set.getSummary());
        selectElements(set.getElements());
        selectColor(set.getColor());
        selectMetal(set.getMetals());
        selectVegetables(set.getVegetables());
        clickSubmitButton();
    }

}
