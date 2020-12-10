package com.epam.trn.hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractionTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] subtractionDataSet () {
        return new Object[][] {
                {6.5, 3.0, 3.5},
                {0, 2.0, -2.0},
                {-3.5, -3.2, -0.3},
        };
    }

    @Test(dataProvider = "subtractionDataSet")
    public void subtractionTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.0001);
    }

}
