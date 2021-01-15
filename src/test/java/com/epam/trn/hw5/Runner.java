package com.epam.trn.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},

features = {"classpath:hw5"})
public class Runner extends AbstractTestNGCucumberTests {
}
