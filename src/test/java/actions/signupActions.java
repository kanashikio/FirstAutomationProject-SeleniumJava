package actions;

import base.excelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.signupPage;
import stepDefinitions.signupSteps;
import stepDefinitions.commonSteps.*;

import java.util.Map;

public class signupActions extends commonActions{
    private static final Logger logs = LogManager.getLogger(signupActions.class);
    public signupPage signUp;
    public Map<String, String> data;

    public signupActions(WebDriver driver) {
        super(driver);
        signUp = new signupPage(driver);
    }

    public void loadDataFromExcel() {
        try { //load excel
            String excelPath = System.getProperty("user.dir") + "/src/test/java/testData/try-data.xlsx";
            data = excelReader.getRowData(excelPath, "signupData", 1);
        } catch (Exception e) {
            Assert.fail("Failed to load Excel data: " + e.getMessage());
            logs.error("❌  Error loading excel", e);
        }
    }

    public void loginSignUpLink(){
        logs.info("✦•┈๑⋅⋯ User lands on login/signup page ⋯⋅๑┈•✦");
        try{ //waits for sign up link to appear
            waitForWebElementToAppear(signupPage.loginSignUpLink);
            //clicks on sign up link
            signupPage.loginSignUpLink.click();
            logs.info("✅ Successfully landed on Login/Sign Up Page");
        } catch (Exception e){
            Assert.fail("Error navigating to sign up page: " + e.getMessage());
            logs.error("❌ Sign up navigation failed", e);
        }
    }

    public void signUpInput(){
        logs.info("✦•┈๑⋅⋯ User enters username and email ⋯⋅๑┈•✦");
        try{ //inputs sign up credentials: username & email
            signUp.usernameField.sendKeys(data.get("username"));
            signUp.emailField.sendKeys(data.get("email"));
            logs.info("✅ Successfully entered username and email");
        } catch (Exception e) {
            Assert.fail("Error during signup: " + e.getMessage());
            logs.error("❌ Failed to input credentials", e);
        }
    }

    public void clickSignUpBtn(){
        logs.info("✦•┈๑⋅⋯ Clicks sign up button ⋯⋅๑┈•✦ ");
        try{ //clicks sign up button
            signUp.signUpBtn.click();
            logs.info("✅  Successfully redirected to the account information entry form");
        } catch (Exception e) {
            Assert.fail("Error clicking sign up button: " + e.getMessage());
            logs.error("❌ Failed to navigate to account information entry form" );
        }
    }

    public void selectTitle(){
        logs.info("✦•┈๑⋅⋯ User selects title ⋯⋅๑┈•✦");
        try{ //selects proper honorific title
            for(WebElement radioBtn : signUp.titleRadioBtn){
                String radioBtnLabel = radioBtn.getText().trim();
                if(radioBtnLabel.equalsIgnoreCase(data.get("title"))){
                    radioBtn.click();
                }
            }
            logs.info("✅ Successfully entered password and other details");
        } catch (Exception e) {
            Assert.fail("Error selecting title: " + e.getMessage());
            logs.error("❌ Failed to select title", e);
        }
    }

    public void accInformationInput(){
        logs.info("✦•┈๑⋅⋯ User enters details ⋯⋅๑┈•✦ ");
        try{
            waitForWebElementToAppear(signUp.enterAccInfoDisplay);
            scrollDown();
            //enters other details: password and birthday
            signUp.passwordField.sendKeys(data.get("password"));
            dropDownValue(signUp.days, data.get("day").replace(".0", "").trim());
            dropDownValue(signUp.months, data.get("month"));
            dropDownValue(signUp.years, data.get("year").replace(".0", "").trim());
            signUp.newsletterCheckBox.click();
            signUp.offersCheckBox.click();
            logs.info("✅ Details provided");
        } catch (Exception e) {
            Assert.fail("Error providing acc info: " + e.getMessage());
            logs.error("❌ Failed to provide account information", e);
        }
    }

    public void personalInformationInput(){
        logs.info("✦•┈๑⋅⋯ User enters personal information ⋯⋅๑┈•✦");
        try{ //enters full name and company name
            signUp.firstNameInput.sendKeys(data.get("firstName"));
            signUp.lastNameInput.sendKeys(data.get("lastName"));
            signUp.companyInput.sendKeys(data.get("company"));
            logs.info("✅ Successfully entered personal details");
        } catch (Exception e) {
            Assert.fail("Error entering personal details: " + e.getMessage());
            logs.error("❌ Failed to enter personal details", e);
        }
    }

   public void addressInformationInput(){
       logs.info("✦•┈๑⋅⋯ User enters address details ⋯⋅๑┈•✦");
       try{ //inputs full address
           signUp.address1Input.sendKeys(data.get("address1"));
           signUp.address2Input.sendKeys(data.get("address2"));
           dropDownValue(signUp.countryContainer, data.get("country"));
           pause();
           signUp.stateInput.sendKeys(data.get("state"));
           signUp.cityInput.sendKeys(data.get("city"));
           signUp.zipcodeInput.sendKeys(data.get("zipcode").replace(".0", "").trim());
           logs.info("✅ Successfully provided address details");
       } catch (Exception e) {
           Assert.fail("Error entering address: " + e.getMessage());
           logs.error("❌ Failed to provide address information", e);
       }
    }

    public void enterMobileNumber(){
        logs.info("✦•┈๑⋅⋯ User provides mobile number ⋯⋅๑┈•✦");
        try{ //provides mobile number
            signUp.mobileNumInput.sendKeys(data.get("mobileNum"));
            logs.info("✅ Successfully provided mobile number");
        } catch (Exception e) {
            Assert.fail("Error entering mobile number: " + e.getMessage());
            logs.error("❌ Failed to provide mobile number", e);
        }
    }

    public void clickCreateAccBtn(){
        logs.info("✦•┈๑⋅⋯ Initiates account creation ⋯⋅๑┈•✦");
        try { //clicks create account button
            signUp.createAccountBtn.click();
            logs.info("✅ Successfully created an account");
        } catch (Exception e) {
            Assert.fail("Error creating account: " + e.getMessage());
            logs.error("❌ Failed to create account", e);
        }
    }

    public void clickContinueBtn(){
        logs.info("✦•┈๑⋅⋯ User is logged in ⋯⋅๑┈•✦");
        try { //clicks continue button after creating an account
            signUp.continueBtn.click();
            logs.info("✅ Login Successful");
        } catch (Exception e) {
            Assert.fail("Error clicking continue button: " + e.getMessage());
            logs.error("❌ Login Failed", e);
        }
    }

    public void clickDeleteAccBtn(){
        logs.info("✦•┈๑⋅⋯ Initiates account deletion ⋯⋅๑┈•✦");
        try{ //clicks button for account deletion
            signUp.clickDeleteAccBtn.click();
        } catch (Exception e) {
            Assert.fail("Error clicking delete account button: " + e.getMessage());
            logs.error("❌ Failed to delete account", e);
        }
    }

    public void clickDeletedAccContinueBtn(){
        logs.info("✅ Account Deletion Successful");
        try{ //clicks continue button after deleting account
            signUp.deletedAccContinueBtn.click();
        } catch (Exception e) {
            Assert.fail("Error clicking continue button after deletion: " + e.getMessage());
            logs.error("❌ Account deletion unsuccessful", e);
        }
    }


    //Assertions

    //<editor-fold desc="assertion: radio button">
    public boolean isTitleSelected(String title) {
        for (WebElement radioBtn : signUp.selectBtn) {
            if (radioBtn.getText().trim().equalsIgnoreCase(title) && radioBtn.isSelected()) {
                return true;
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold desc="assertion: web display">
    public boolean isEnterAccInfoDisplayed(){
        return signUp.enterAccInfoDisplay.isDisplayed();
    }

    public boolean isAccountCreatedDisplayed(){
        return signUp.accountCreatedDisplay.isDisplayed();
    }

    public boolean isLoggedInASUNDisplayed(){
        return signUp.loggedInAsUN.isDisplayed();
    }

    public boolean isAccountDeletedDisplayed(){
        return signUp.accountDeletedDisplay.isDisplayed();
    }
    //</editor-fold>

}
