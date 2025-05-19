package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.Locale;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        features = "src/test/resources/features",
        glue = "com.cydeo.step_definitions",
        tags = "@LoginTest",
        dryRun = false
)
public class RunnerTest {
}
