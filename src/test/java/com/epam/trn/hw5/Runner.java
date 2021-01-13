package com.epam.trn.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"hw5"}
//        plugin = {"io.qameta.allure:allure-cucumber6-jvm:2.13.7"}
)
public class Runner extends AbstractTestNGCucumberTests {

}
