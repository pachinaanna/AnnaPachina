package com.epam.trn.hw6.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.ui.html.elements.common.*;
import com.epam.trn.hw6.entities.User;
import com.epam.trn.hw6.enums.HeaderMenuItems;
import com.epam.trn.hw6.sections.LoginForm;


@Title("Home Page")
public class HomePage extends WebPage {

    @FindBy(css = "form")
    public LoginForm loginForm;

    @FindBy(css = "img#user-icon")
    public Link userIcon;

    @FindBy(css = ".fa-sign-out")
    public  Button logoutButton;

    @FindBy(id = "user-name")
    public Text userName;

    @FindBy(css = ".m-l8")
    public Menu headerMenu;

    public void loginAsUser(User user) {
        userIcon.click();
        loginForm.loginAs(user);
    }

    public void selectFromHeaderMenu(HeaderMenuItems item) {
        headerMenu.select(item);
    }

}
