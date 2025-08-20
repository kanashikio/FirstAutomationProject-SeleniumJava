package stepDefinitions;

import actions.contactUsFormActions;
import base.baseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class contactUsFormSteps extends baseUtil {
    contactUsFormActions contactUsForm;


    @Given("User navigates to contact us form page")
    public void user_navigates_to_contact_form_page(){
        contactUsForm = new contactUsFormActions(driver);
        contactUsForm.contactUsLink();
        Assert.assertTrue(contactUsForm.isGetInTouchTextVisible(), "'Get In Touch' text missing");
    }

    @Given("User inputs personal details and a message")
    public void user_inputs_personal_details_and_a_message(){
        contactUsForm.loadDataFromExcel();
        contactUsForm.fillContactForm();
        //<editor-fold desc="contact form input assertions">
        Assert.assertTrue(contactUsForm.isInputEntered(contactUsForm.contactUsForm.nameInput), "Name not entered");
        Assert.assertTrue(contactUsForm.isInputEntered(contactUsForm.contactUsForm.emailInput), "Email not entered");
        Assert.assertTrue(contactUsForm.isInputEntered(contactUsForm.contactUsForm.subjectInput), "Subject not entered");
        Assert.assertTrue(contactUsForm.isInputEntered(contactUsForm.contactUsForm.messsageInput), "Message not entered");
        //</editor-fold>

    }

    @And("User uploads file")
    public void user_uploads_file(){
        contactUsForm.uploadFile();
        Assert.assertTrue(contactUsForm.isInputEntered(contactUsForm.contactUsForm.uploadFileInput), "No file chosen");
    }

    @Then("User submits form")
    public void user_submits_form(){
        contactUsForm.submit();
        Assert.assertTrue(contactUsForm.isSuccessTextVisible(), "Submission success missing");
    }

    @And("User returns home")
    public void user_returns_home(){
        contactUsForm.returnToHome();
        verifyHomePageVisibility();
    }

}
