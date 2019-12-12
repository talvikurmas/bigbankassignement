package com.bigbank;

import java.io.File;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features"
        ,glue= "com/bigbank",
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true

)

public class RunCucumberTest {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("src/config/report"));

    }
}