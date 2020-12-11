package com.epam.trn.hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] sumDataSet() {
        return new Object[][] {
                {2.0, 0, 2.0},
                {3.1, 3.5, 6.6},
                {-2.0, 4.0, 2.0},
                {-2.0, -3.0, -5.0}

        };
    }

    @Test(dataProvider = "sumDataSet")
    public void sumTest(double a, double b, double expexted) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expexted, 0.0001);
    }



}

