package com.epam.trn.hw8.utils;

import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Properties;

public class SelectProperties {

    @SneakyThrows
    public static Properties getProp(String fileName) throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream(fileName));
        return p;
    }

    @SneakyThrows
    public static Properties getTestProperties() {
        String testProperties = "test.properties";
        return getProp(testProperties);
    }

}
