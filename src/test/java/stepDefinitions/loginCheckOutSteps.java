package stepDefinitions;

import actions.loginCheckOutActions;
import actions.signupActions;
import actions.incorrectLoginActions;
import base.baseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class loginCheckOutSteps extends baseUtil {
    loginCheckOutActions loginCheckOut;
    signupActions action;
    incorrectLoginActions loginAction;

  /*  @Given("User navigates to login page")
    public void user_navigates_to_login(){
        loginCheckOut = new loginCheckOutActions(driver);
        action = new signupActions(driver);
        loginAction = new incorrectLoginActions(driver);
        navigateTo();
        verifyHomePageVisibility();
        action.loginSignUpLink();
    }*/

  /* @When("User signs up using data")
    public void user_signs_up(){
       //<editor-fold desc="drivers">



     //</editor-fold>
        action.loadDataFromExcel();
        action.signUpInput();
        action.clickSignUpBtn();
        action.selectTitle();
        action.accInformationInput();
        action.personalInformationInput();
        action.addressInformationInput();
        action.enterMobileNumber();
        action.clickCreateAccBtn();
        action.clickContinueBtn();
        loginCheckOut.clickLogout();
    } */

    @Then("User logs out and logs in again")
    public void user_logs_in(){
        //<editor-fold desc="drivers">
        loginCheckOut = new loginCheckOutActions(driver);
        loginAction = new incorrectLoginActions(driver);
        action = new signupActions(driver);
        //</editor-fold>
        loginCheckOut.clickLogout();
        loginCheckOut.loginToDashboard();
        loginAction.clickLoginBtn();
        Assert.assertTrue(action.isLoggedInASUNDisplayed(), "Login failed");
    }

    @And("User adds products to cart")
    public void user_add_to_cart(){
        loginCheckOut.addProducts();
    }

    @Then("User proceeds to checkout")
    public void user_checks_out(){
        loginCheckOut.checkOut();
        Assert.assertTrue(loginCheckOut.verifyCartPage(), "Cart Page Not Found");
        loginCheckOut.verifyProducts();
    }

    @And("User places order and leaves a comment")
    public void user_sends_msg_and_places_order(){
        loginCheckOut.verifyAddress();
        loginCheckOut.placeOrder();
        Assert.assertTrue(loginCheckOut.verifyClickedPlaceOrderBtn(), "Place order did not go through");
    }

    @Then("User proceeds to payment")
    public void user_proceeds_to_payment(){
        loginCheckOut.paymentDetails();
        //<editor-fold desc="payment assertions">
        Assert.assertTrue(loginCheckOut.isInputEntered(loginCheckOut.loginCheckOut.cardNameInput), "Card name not entered");
        Assert.assertTrue(loginCheckOut.isInputEntered(loginCheckOut.loginCheckOut.cardNumberInput), "Card number not entered");
        Assert.assertTrue(loginCheckOut.isInputEntered(loginCheckOut.loginCheckOut.cvcInput), "CVC not entered");
        Assert.assertTrue(loginCheckOut.isInputEntered(loginCheckOut.loginCheckOut.expiryMonthInput), "Expiry month not entered");
        Assert.assertTrue(loginCheckOut.isInputEntered(loginCheckOut.loginCheckOut.expiryYearInput), "Expiry year not entered");
        //</editor-fold>
        loginCheckOut.confirmPayment();
        Assert.assertEquals(loginCheckOut.loginCheckOut.congratsText.getText(), "Congratulations! Your order has been confirmed!", "❌ Congratulatory text not found");
    }

   /*@And("User proceeds to delete account")
    public void user_deletes_acc(){
        action.clickDeleteAccBtn();
        Assert.assertTrue(action.isAccountDeletedDisplayed(), "Account Deletion Failed");
        action.clickDeletedAccContinueBtn();
    }*/
}
