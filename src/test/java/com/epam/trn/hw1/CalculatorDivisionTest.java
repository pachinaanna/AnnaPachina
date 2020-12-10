package com.epam.trn.hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivisionTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] divisionDataSet() {
        return new Object[][] {
                {0, 2.0, 0},
                {4.6, 2.0, 2.3},
                {-10.0, 0.5, -20.0}

        };
    }

    @Test(dataProvider = "divisionDataSet")
    public void divisionTest(double a, double b, double expexted) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expexted, 0.0001);

    }

}
