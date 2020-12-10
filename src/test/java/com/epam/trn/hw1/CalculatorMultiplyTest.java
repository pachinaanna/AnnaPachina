package com.epam.trn.hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] multiplyDataSet() {
        return new Object[][] {
                {1.5, 2.5, 3.75},
                {2.0, 3.0, 6.0},
                {1.5, 0, 0},
                {2.5, -1.0, -2.5}
        };
    }

    @Test(dataProvider = "multiplyDataSet")
    public void multiplyTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected,0.0001);
    }
}
