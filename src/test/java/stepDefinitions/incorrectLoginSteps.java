package stepDefinitions;

import actions.incorrectLoginActions;
import actions.signupActions;
import base.baseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class incorrectLoginSteps extends baseUtil {
    private static final Logger logs = LogManager.getLogger(incorrectLoginSteps.class);
    incorrectLoginActions incorrectLogin;

   /* @Given("User goes to login page")
    public void user_goes_to_login_page(){
        incorrectLogin = new incorrectLoginActions(driver);
        loginSignUpLink = new signupActions(driver);
        navigateTo();
        verifyHomePageVisibility();
        loginSignUpLink.loginSignUpLink();
    }*/

    @When("User enters invalid credentials")
    public void user_enters_invalid_credentials(){
        incorrectLogin = new incorrectLoginActions(driver);
        Assert.assertTrue(incorrectLogin.verifyLoginText(), "Login Text Missing");

        incorrectLogin.login();
        Assert.assertTrue(incorrectLogin.isInputEntered(incorrectLogin.incorrectLogin.loginEmailInputField), "Email not entered");
        Assert.assertTrue(incorrectLogin.isInputEntered(incorrectLogin.incorrectLogin.loginPasswordInput), "Password not entered");
    }

    @Then("User gets error message")
    public void user_gets_error_message(){
        incorrectLogin.clickLoginBtn();
        Assert.assertTrue(incorrectLogin.verifyLoginErrorText(), "Error Text Missing");
        logs.info("✅ Failed login due to invalid credentials");
    }
}
