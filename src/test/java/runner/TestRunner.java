package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"stepDefinitions", "hooks"},
        tags = "@incorrectLogin",
        monochrome = true,
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

/*
@signup
@incorrectLogin
@contactUs
@loginCheckOut
@downloadInvoice
 */
