package com.epam.trn.hw5.pages;

import com.epam.trn.hw5.components.Checkbox;
import com.epam.trn.hw5.components.UsersTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.attribute.UserPrincipalNotFoundException;
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

    public List<WebElement> getTableRows() {
        return usersTable.getTableRows();
    }

    public String getNumbers(int index) {
        return getTableRows().get(index).findElement(By.xpath("//td[1]")).getText();
    }

    public List<WebElement> getUsersCheckboxes() {
        return usersTable.getUsersCheckboxes();
    }

    public WebElement getCheckboxForUser(String userName) {
        for (WebElement item : usersTable.getUsersCheckboxes()) {
            if (userName.equals(item.getText())) {
                return item;
            }
        }
        return null;
    }

    public void selectCheckbox(String checkbox, String userName) {
        if(checkbox.equals(getCheckboxForUser(userName).getText()));
        getCheckboxForUser(userName).click();
    }
}