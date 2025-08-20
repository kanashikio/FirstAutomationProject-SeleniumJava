package stepDefinitions;

import actions.incorrectLoginActions;
import actions.signupActions;
import base.baseUtil;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class commonSteps extends baseUtil {
    signupActions action;

    //navigate to url
    @Given("User navigates to application")
    public void user_navigates_to_app(){
        navigateTo();
        verifyHomePageVisibility();
    }

    //clicking login/signup link
    @Given("User navigates to login")
    public void user_navigates_to_login_signup(){
        action = new signupActions(driver);
        action.loginSignUpLink();
    }

}
