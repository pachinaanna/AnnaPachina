package com.epam.trn.hw6.dataProvider;

import com.epam.trn.hw6.entities.User;

public class UserTestData {

    public static User ROMAN = new User().set(c -> {c.name = "Roman";
        c.password = "Jdi1234";});
}
