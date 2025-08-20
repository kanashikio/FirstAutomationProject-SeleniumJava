package hooks;

import base.baseUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.ByteArrayInputStream;

public class hooks extends baseUtil{
    private static final Logger logs = LogManager.getLogger(hooks.class);

    @Before
    public void startTest(io.cucumber.java.Scenario scenario) {
        try{
            logs.info("========== STARTING TEST: {} ==========", scenario.getName());
            logs.info("✅ Setting up WebDriver and initializing test");
            setUp();
            logs.info("✅ Setup Successful");
        } catch (Exception e) {
            Assert.fail("Failed to start test: " + e.getMessage());
            logs.error("❌ Test setup failed", e);
        }
    }

    @AfterStep
    public void stepScreenshot(Scenario scenario){
        try{ //takes screenshot of every step taken
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Step Screenshot - " + scenario.getName(), new ByteArrayInputStream(screenshot));
        } catch (Exception e) {
            Assert.fail("Error taking step screenshot: " + e.getMessage());
            logs.error("❌ Step screenshot failed", e);
        }
    }

    @After
    public void endTest(Scenario scenario) {
        try{ //
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot on test failure", new ByteArrayInputStream(screenshot));
            }
            logs.info("========== ENDING TEST: {} ==========", scenario.getName());
            quit();
        } catch (Exception e) {
            Assert.fail("Error taking screenshot for failed scenarios: " + e.getMessage());
            logs.error("❌ Error taking screenshot for failed tests", e);
        }
    }
}
