package com.epam.trn.hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.trn.hw6.sections.MetalsAndColorsForm;
import com.epam.trn.hw6.entities.MetalsAndColorsFormData;
import org.openqa.selenium.WebElement;

import java.util.List;

@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @FindBy(css = ".form")
    public static MetalsAndColorsForm metalsAndColorsForm;

    @FindBy(css = ".results > li")
    public List<WebElement> resultSection;

    public boolean resultSectionContainsData(MetalsAndColorsFormData set, int i) {
        List<String> list = set.setToList();
        return list.get(i).contains(resultSection.get(i).getText());
    }

}
