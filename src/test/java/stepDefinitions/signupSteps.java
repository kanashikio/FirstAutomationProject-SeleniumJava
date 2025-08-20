package stepDefinitions;

import base.baseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import actions.signupActions;
import org.testng.Assert;


public class signupSteps extends baseUtil{
    signupActions signUp;

       /* @Before("@signup")
        public void startTest(){
            logs.info("========== STARTING SIGN UP / REGISTER TEST ==========");
            logs.info("✅ Setting up WebDriver and initializing test");
            setUp();
            signUp = new signupActions(driver);
            logs.info("✅ Set up Successful");
        }

      @Given("User lands on signup")
        public void user_lands_on_signup() {
            signUp = new signupActions(driver);
            navigateTo();
            verifyHomePageVisibility();
            signUp.loginSignUpLink();
        }*/

        @Given("User enters details username and email")
        public void user_enters_details(){
            signUp = new signupActions(driver);
            signUp.loadDataFromExcel();

            signUp.signUpInput();
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.usernameField), "Username was not entered");
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.emailField), "Email was not entered");

            signUp.clickSignUpBtn();
            Assert.assertTrue(signUp.isEnterAccInfoDisplayed(), "Sign Up unsuccessful");
        }

        @And("User enters password and other details")
        public void user_enters_password_and_other_details(){
            signUp.selectTitle();
            signUp.accInformationInput();
            //<editor-fold desc="acc info input assertions">
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.passwordField), "Password not entered");
            Assert.assertTrue(signUp.isDropdownValueSelected(signUp.signUp.days, signUp.data.get("day").replace(".0", "").trim()), "Day not selected");
            Assert.assertTrue(signUp.isDropdownValueSelected(signUp.signUp.months, signUp.data.get("month")), "Month not selected");
            Assert.assertTrue((signUp.isDropdownValueSelected(signUp.signUp.years, signUp.data.get("year").replace(".0", "").trim())));
            Assert.assertTrue(signUp.isElementSelected(signUp.signUp.letterCheckBtn), "Newsletter not selected");
            Assert.assertTrue(signUp.isElementSelected(signUp.signUp.offersCheckBtn), "Offers option not selected");
            //</editor-fold>
        }

        @And("User enters personal information")
        public void user_enters_personal_info(){
            signUp.personalInformationInput();
            //<editor-fold desc="personal info input assertions">
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.firstNameInput), "First Name not entered");
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.lastNameInput), "Last Name not entered");
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.companyInput), "Company not entered");
            //</editor-fold>
        }

        @And("User enters address information")
        public void user_enters_address_information(){
            signUp.addressInformationInput();
            //<editor-fold desc="address input assertions">
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.address1Input), "Address 1 not entered");
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.address2Input), "Address 2 not entered");
            Assert.assertTrue(signUp.isDropdownValueSelected(signUp.signUp.countryContainer, signUp.data.get("country")), "Country not selected");
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.stateInput),"State not entered");
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.cityInput), "City not entered");
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.zipcodeInput), "Zipcode not entered");
            //</editor-fold>
        }

       @And("User enters mobile number")
       public void user_enters_mobile_number(){
            signUp.enterMobileNumber();
            Assert.assertTrue(signUp.isInputEntered(signUp.signUp.mobileNumInput), "Mobile number not entered");
       }

        @Then("User creates account")
        public void user_creates_account() {
            signUp.clickCreateAccBtn();
            Assert.assertTrue(signUp.isAccountCreatedDisplayed(), "Account creation unsuccessful");
        }

        @When("User is logged in")
        public void user_is_logged_in() {
            signUp.clickContinueBtn();
            Assert.assertTrue(signUp.isLoggedInASUNDisplayed(), "Logged in as 'username' is not visible");
        }

        @Then("User deletes account")
        public void user_deletes_account() {
            signUp.clickDeleteAccBtn();
            Assert.assertTrue(signUp.isAccountDeletedDisplayed(), "Account deletion unsuccessful");
            signUp.clickDeletedAccContinueBtn();
            verifyHomePageVisibility();
        }

        /*@After("@signup")
        public void doneTest(){
            quit();
        }*/
}

