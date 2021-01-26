package com.epam.trn.hw6.dataProvider;

import com.epam.trn.hw6.utils.JsonDataReader;
import com.epam.trn.hw6.entities.MetalsAndColorsFormData;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class JdiDataProvider {

    protected JsonDataReader reader = new JsonDataReader();

    public JdiDataProvider() throws IOException {
    }

    @DataProvider
    public Object[] data() throws IOException {
        List<MetalsAndColorsFormData> list = reader.getJsonDataSet();
        return list.toArray();
    }

}
