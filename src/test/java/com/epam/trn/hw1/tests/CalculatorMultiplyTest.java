package com.epam.trn.hw1.tests;

import com.epam.trn.hw1.data_providers.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "multiplyDataSet")
    public void multiplyTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected,0.0001);
    }
}
