package com.epam.trn.hw1.Tests;

import com.epam.trn.hw1.DataProviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowerTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "powerDataSet")
    public void powerTest(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        assertEquals(actual, expected, 0.0001);
    }


}

