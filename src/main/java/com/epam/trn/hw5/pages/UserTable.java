package com.epam.trn.hw5.pages;

import com.epam.trn.hw5.components.Checkbox;
import com.epam.trn.hw5.components.UsersTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserTable extends AbstractPage {

    protected UsersTable usersTable = new UsersTable(webDriver);

    public UserTable(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getNumberTypes() {
        return usersTable.getNumberTypes();
    }

    public List<WebElement> getUserNames() {
        return usersTable.getUserNames();
    }

    public List<WebElement> getDescriptions() {
        return usersTable.getDescriptions();
    }

    public List<WebElement> getUsersCheckboxes() {
        return usersTable.getUsersCheckboxes();
    }
}
