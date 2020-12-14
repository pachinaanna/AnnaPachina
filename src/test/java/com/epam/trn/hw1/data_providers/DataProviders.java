package com.epam.trn.hw1.data_providers;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider (name = "divisionDataSet")
    public static Object[][] divisionDataSet() {
        return new Object[][] {
                {0, 2.0, 0},
                {4.6, 2.0, 2.3},
                {-10.0, 0.5, -20.0}
        };
    }

    @DataProvider (name = "multiplyDataSet")
    public Object[][] multiplyDataSet() {
        return new Object[][] {
                {1.5, 2.5, 3.75},
                {2.0, 3.0, 6.0},
                {1.5, 0, 0},
                {2.5, -1.0, -2.5}
        };
    }

    @DataProvider (name = "powerDataSet")
    public Object[][] powerDataSet() {
        return new Object[][] {
                {2.5, 3.0, 15.625},
                {-2.0, 0, 1.0},
                {2.0, -1, 0.5}
        };
    }

    @DataProvider (name = "sqrtDataSet")
    public Object[][] sqrtDataSet() {
        return new Object[][] {
                {16.0, 4.0},
                {3.0, 1.732},
                {0, 0}
        };
    }

    @DataProvider (name = "subtractionDataSet")
    public Object[][] subtractionDataSet() {
        return new Object[][] {
                {6.5, 3.0, 3.5},
                {0, 2.0, -2.0},
                {-3.5, -3.2, -0.3}
        };
    }

    @DataProvider (name = "sumDataSet")
    public Object[][] sumDataSet() {
        return new Object[][] {
                {2.0, 0, 2.0},
                {3.1, 3.5, 6.6},
                {-2.0, 4.0, 2.0},
                {-2.0, -3.0, -5.0}
        };
    }
}
