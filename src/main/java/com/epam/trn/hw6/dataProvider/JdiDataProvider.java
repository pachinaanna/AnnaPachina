package com.epam.trn.hw6.dataProvider;

import com.epam.trn.hw6.utils.JsonDataReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class JdiDataProvider {

    protected JsonDataReader reader = new JsonDataReader();

    public JdiDataProvider() throws IOException {
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                {reader.getDataSet("data_1")},
                {reader.getDataSet("data_2")},
                {reader.getDataSet("data_3")},
                {reader.getDataSet("data_4")},
                {reader.getDataSet("data_5")},
        };
    }
}
