package com.epam.trn.hw5.context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static TestContext instance = new TestContext();

    private Map<String, Object> map = new HashMap<>();

    private TestContext() {
    }

    public void setTestObject(String key, Object value) {
        map.put(key, value);
    }

    public <T> T getTestObject(String key) {
        return (T) map.get(key);
    }

    public static TestContext getInstance() {
        if(instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

}
