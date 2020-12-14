package com.epam.trn.hw1.tests;

import com.epam.trn.hw1.data_providers.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowerTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "powerDataSet")
    public void powerTest(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        assertEquals(actual, expected, 0.0001);
    }


}

