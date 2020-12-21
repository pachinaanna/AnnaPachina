package com.epam.trn.hw3.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DataStorage {

    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResourceAsStream("differentElementsPage.properties"));
        System.out.println(p.entrySet());
    }

//    private Map<String, Properties> propertiesMap;
//
//    private DataStorage() {
//        this.propertiesMap = new HashMap <String, Properties>();
//    }
//    public static DataStorage getInstance() {
//        return new DataStorage();
//    }
//
//    private static Map<String,String> loadProperties() throws Exception {
//        Map<String,String> propertyMap = new HashMap();
//
//        FileReader reader = new FileReader("propertyFileName");
//        Properties p = new Properties();
//        p.load(reader);
//        Enumeration keys = p.propertyNames();
//        while (keys.hasMoreElements()) {
//            String key = (String) keys.nextElement();
//            propertyMap.put(key, p.getProperty(key));
//        }
//
//        reader.close();
//        return propertyMap;
//    }
}



