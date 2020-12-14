package com.epam.trn.hw1.tests;

import com.epam.trn.hw1.data_providers.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSqrtTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sqrtDataSet")
    public void sqrtTest(double a, double expected) {
        double actual = calculator.sqrt(a);
        assertEquals(actual, expected, 0.0001);
    }
}
