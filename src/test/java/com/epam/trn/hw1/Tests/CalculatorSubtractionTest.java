package com.epam.trn.hw1.Tests;

import com.epam.trn.hw1.DataProviders.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractionTest extends AbstractCalculatorTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "subtractionDataSet")
    public void subtractionTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.0001);
    }

}
