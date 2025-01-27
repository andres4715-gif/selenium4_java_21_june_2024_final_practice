package com.nopCommerce.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.nopCommerce.steps", "com.nopCommerce.utils"},
        tags = "@Regression",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);

    @Override
    @DataProvider(parallel = false) // Change to true for parallel execution.
    public Object[][] scenarios() {
        logger.info("Loading Cucumber scenarios");
        return super.scenarios();
    }
}
