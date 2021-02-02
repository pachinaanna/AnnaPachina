package com.epam.trn.hw8.utils;

import lombok.SneakyThrows;

import java.util.Properties;

public class SelectProperties {

    @SneakyThrows
        public static Properties getProp(String fileName) {
            Properties p = new Properties();
            p.load(ClassLoader.getSystemResourceAsStream(fileName));
            return p;
    }

    public static Properties getTestProperties() {
        String testProperties = "test.properties";
        return getProp(testProperties);
    }
}
