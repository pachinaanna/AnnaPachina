package com.epam.trn.hw6.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.trn.hw6.entities.User;

public class LoginForm extends Form<User> {

    @FindBy(id = "password") public TextField password;
    @FindBy(id = "name") public TextField name;

}
