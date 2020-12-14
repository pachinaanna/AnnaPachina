package com.epam.trn.hw1.tests;

import com.epam.trn.hw1.data_providers.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sumDataSet")
    public void sumTest(double a, double b, double expexted) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expexted, 0.0001);
    }



}

