package com.epam.trn.hw1.tests;

import com.epam.trn.hw1.data_providers.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivisionTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "divisionDataSet")
    public void divisionTest(double a, double b, double expexted) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expexted, 0.0001);

    }

}
