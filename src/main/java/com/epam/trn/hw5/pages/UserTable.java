package com.epam.trn.hw5.pages;

import com.epam.trn.hw5.components.Checkbox;
import com.epam.trn.hw5.components.UsersTable;
import org.openqa.selenium.WebDriver;

public class UserTable extends AbstractPage {

    public UserTable(WebDriver webDriver) {
        super(webDriver);
    }

    protected UsersTable usersTable = new UsersTable(webDriver);



}
