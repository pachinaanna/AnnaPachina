package com.epam.trn.hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSqrtTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] sqrtDataSet() {
        return new Object[][] {
                {16.0, 4.0},
                {3.0, 1.732},
                {0, 0}

        };
    }

    @Test(dataProvider = "sqrtDataSet")
    public void sqrtTest(double a, double expected) {
        double actual = calculator.sqrt(a);
        assertEquals(actual, expected, 0.0001);
    }
}
