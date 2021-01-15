package com.epam.trn.hw5.pages;

import com.epam.trn.hw5.components.UsersTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<String> getDescriptionText() {
        return usersTable.getDescriptionText();
    }

    public List<WebElement> getDescriptionsCol() {
        return usersTable.getDescriptionCol();
    }

    public List<WebElement> getUsersCheckboxes() {
        return usersTable.getUsersCheckboxes();
    }

    public WebElement selectCheckboxForUser(String checkbox, String userName) {
        Map<String, Integer> users = new HashMap<>();
        for (int i=0; i<usersTable.getUserCol().size(); i++) {
            users.put(usersTable.getUserCol().get(i).getText(), i);
        }
           Integer index = users.get(userName);
        if (checkbox.equals(usersTable.getCheckboxesLabels().get(index).getText())) {
            return getUsersCheckboxes().get(index);
        }
        return null;
    }

    public List<WebElement> selectDropdownForUser(String userName) {
        Map<String, Integer> users = new HashMap<>();
        for (int i=0; i<usersTable.getUserCol().size(); i++) {
            users.put(usersTable.getUserCol().get(i).getText(), i);
        }
        Integer index = users.get(userName);
        return usersTable.getAllDropdowns().get(index).findElements(By.xpath("//option"));
    }

    public List<WebElement> getNumberCol() {
        return usersTable.getNumberCol();
    }

    public List<WebElement> getUserCol() {
        return usersTable.getUserCol();
    }

    public List<String> getLogText() {
        List<String> logText = new ArrayList<>();
        for (WebElement log : usersTable.getLogs()) {
            logText.add(log.getText().substring(9));
        }
        return logText;
    }
}