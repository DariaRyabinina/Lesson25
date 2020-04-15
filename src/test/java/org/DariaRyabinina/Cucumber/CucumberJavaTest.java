package org.DariaRyabinina.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature",
        glue = "org.DariaRyabinina.Cucumber.Steps")
public class CucumberJavaTest extends AbstractTestNGCucumberTests {

}
