package com.epam.trn.hw6.enums;

public enum HeaderMenuItems {

    HOME ("HOME"), CONTACT_FORM ("CONTACT FROM"), SERVICE ("SERVICE"),
    METALS_COLORS ("METALS & COLORS");

    String item;

    HeaderMenuItems(String item) {
        this.item = item;
    }
}
