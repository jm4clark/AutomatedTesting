package com.bae.cucumber.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Admin\\eclipse-workspace\\Cucumber\\src\\test\\java\\Parametisation.feature" , glue = {"com.bae.cucumber.tests"}) //"C:\\Users\\Admin\\eclipse-workspace\\Cucumber\\src\\test\\java\\TeaTesting.feature"

public class Runner {

}
