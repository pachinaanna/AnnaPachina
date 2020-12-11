package com.epam.trn.hw1.Tests;

import com.epam.trn.hw1.DataProviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sumDataSet")
    public void sumTest(double a, double b, double expexted) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expexted, 0.0001);
    }



}

