package stepDefinitions;

import actions.downloadInvoiceActions;
import actions.incorrectLoginActions;
import actions.loginCheckOutActions;
import actions.signupActions;
import base.baseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class downloadInvoiceSteps extends baseUtil {
    //<editor-fold desc="objects">
    signupActions actions;
    incorrectLoginActions actions1;
    loginCheckOutActions actions3;
    downloadInvoiceActions downloadInvoice;
  //</editor-fold>

    @When("User selects products and proceeds to checkout")
    public void user_selects_products(){
       //<editor-fold desc="drivers"
        actions = new signupActions(driver);
        actions1 = new incorrectLoginActions(driver);
        actions3 = new loginCheckOutActions(driver);
        downloadInvoice = new downloadInvoiceActions(driver);
      //</editor-fold>
        actions3.addProducts();
        actions3.checkOut();
        Assert.assertTrue(actions3.verifyCartPage(), "Cart Page Not Found");
    }

    @Then("User is redirected to register or login page")
    public void user_redirected_to_register_page(){
        downloadInvoice.registerLogin();
        Assert.assertTrue(downloadInvoice.verifyRegisterPage(), "Register page not found");
    }

   /* @And("User is required to create an account")
    public void user_is_required_to_create_an_account(){
        actions.loadDataFromExcel();
        actions.signUpInput();
        actions.clickSignUpBtn();
        actions.selectTitle();
        actions.accInformationInput();
        actions.personalInformationInput();
        actions.addressInformationInput();
        actions.enterMobileNumber();
        actions.clickCreateAccBtn();
    }

    @When("User successfully created an acc")
    public void user_successfully_created_an_acc(){
        Assert.assertTrue(actions.isAccountCreatedDisplayed(), "Account creation failed");
        actions.clickContinueBtn();
        Assert.assertTrue(actions.isLoggedInASUNDisplayed(), "Login failed");
    }

    @Then("User proceeds to view cart and checks out")
    public void user_views_cart_and_checks_out(){
        actions3.checkOut();
    }

    @And("User places order and proceeds to payment")
    public void user_places_order(){
        actions3.verifyAddress();
        actions3.placeOrder();
        actions3.payment();
    } */

    @Then("User downloads invoice")
    public void user_downloads_invoice(){
        downloadInvoice.downloadInvoice();
    }

  /*  @And("User deletes their account")
    public void user_deletes_acc(){
        actions.clickDeleteAccBtn();
        Assert.assertTrue(actions.isAccountDeletedDisplayed(), "Account deletion failed");
        actions.clickDeletedAccContinueBtn();
    } */

}
