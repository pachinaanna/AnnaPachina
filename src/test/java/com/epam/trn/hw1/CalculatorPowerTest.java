package com.epam.trn.hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowerTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] powerDataSet() {
        return new Object[][] {
                {2.5, 3.0, 15.625},
                {-2.0, 0, 1.0},
                {2.0, -1, 0.5}

        };
    }

    @Test(dataProvider = "powerDataSet")
    public void powerTest(double a, double b, double expected) {
        double actual = calculator.pow(a, b);
        assertEquals(actual, expected, 0.0001);
    }


}

