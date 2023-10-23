package com.nishaFramework.LearnCucumberFramework;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/RefreshToken.feature", glue = { "stepDefinition" }, tags = "@RefreshTokenAPI")
public class TestRunner {

}
