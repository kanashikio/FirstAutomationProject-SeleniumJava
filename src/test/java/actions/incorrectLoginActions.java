package actions;

import base.excelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.incorrectLoginPage;
import stepDefinitions.incorrectLoginSteps;

import java.util.Map;

public class incorrectLoginActions extends commonActions{
    private static final Logger logs = LogManager.getLogger(incorrectLoginActions.class);
    public incorrectLoginPage incorrectLogin;

    public incorrectLoginActions(WebDriver driver) {
        super(driver);
        incorrectLogin = new incorrectLoginPage(driver);
    }

    public void login(){
        logs.info("✦•┈๑⋅⋯ User Enters Invalid Credentials ⋯⋅๑┈•✦ ");
        try{ //loading spreadsheet
            String excelPath = System.getProperty("user.dir") + "/src/test/java/testData/try-data.xlsx";
            Map<String, String> data = excelReader.getRowData(excelPath, "invalidData", 1);

            //enters login credentials
            incorrectLogin.loginEmailInputField.sendKeys(data.get("email"));
            incorrectLogin.loginPasswordInput.sendKeys(data.get("password"));

            logs.info("✅ Invalid credentials input successful");
        } catch (Exception e) {
            Assert.fail("Error entering credentials: " + e.getMessage());
            logs.error("❌ Failed to enter credentials", e);
        }
    }

    public void clickLoginBtn(){
        logs.info("✦•┈๑⋅⋯ Initiates login ⋯⋅๑┈•✦ ");
        try{ //clicks login button
            incorrectLogin.loginButton.click();
            logs.info("✅ Login button clicked");
        } catch (Exception e) {
            Assert.fail("Error logging in: " + e.getMessage());
            logs.error("❌ Login Failed", e);
        }
    }

    //Verify
    public boolean verifyLoginText(){
        return incorrectLogin.loginTextDisplay.isDisplayed();
    }

    public boolean verifyLoginErrorText(){
        return incorrectLogin.loginErrorText.isDisplayed();
    }
}
