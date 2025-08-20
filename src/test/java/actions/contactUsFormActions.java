package actions;

import base.excelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.contactUsFormPage;
import stepDefinitions.contactUsFormSteps;

import java.util.Map;

public class contactUsFormActions extends commonActions{
    private static final Logger logs = LogManager.getLogger(contactUsFormActions.class);
    public contactUsFormPage contactUsForm;
    Map<String, String> data;

    public contactUsFormActions(WebDriver driver) {
        super(driver);
        contactUsForm = new contactUsFormPage(driver);
    }

    public void loadDataFromExcel() {
        try { //loads spreadsheet
            String excelPath = System.getProperty("user.dir") + "/src/test/java/testData/try-data.xlsx";
            data = excelReader.getRowData(excelPath, "contactUsData", 1);
        } catch (Exception e) {
            Assert.fail("Failed to load Excel data: " + e.getMessage());
        }
    }

    public void contactUsLink(){
        logs.info("✦•┈๑⋅⋯ User navigates to contact us form page ⋯⋅๑┈•✦");
        try{ //navigates to contact us page
            waitForWebElementToAppear(contactUsFormPage.contactUsLink);
            contactUsFormPage.contactUsLink.click();
            logs.info("✅ Successfully navigated to Contact Us Page");
        } catch (Exception e) {
            Assert.fail("Error navigating to contact us form: " + e.getMessage());
            logs.error("❌ Failed to navigate to contact us page", e);
        }
    }

    public void fillContactForm() {
        logs.info("✦•┈๑⋅⋯ User inputs personal details and message ⋯⋅๑┈•✦");
        try { //fills contact form with details
            contactUsForm.nameInput.sendKeys(data.get("name"));
            contactUsForm.emailInput.sendKeys(data.get("email"));
            contactUsForm.subjectInput.sendKeys(data.get("subject"));
            contactUsForm.messsageInput.sendKeys(data.get("message"));
            logs.info("✅ Successfully entered personal details and message");
        } catch (Exception e) {
            Assert.fail("Error filling out contact form: " + e.getMessage());
            logs.error("❌ Failed to populate contact form", e);
        }
    }

    public void uploadFile(){
        logs.info("✦•┈๑⋅⋯ User uploads file⋯⋅๑┈•✦");
        try{ //uploads file
            String file = System.getProperty("user.dir") + "/src/test/java/testData/hello.txt";
            contactUsForm.uploadFileInput.sendKeys(file);
            pause();
            logs.info("✅ Uploaded file successfully");
        } catch (Exception e) {
            Assert.fail("Error uploading file: " + e.getMessage());
            logs.error("❌ Failed to upload file", e);
        }
    }

    public void submit(){
        logs.info("✦•┈๑⋅⋯ User submits form ⋯⋅๑┈•✦");
        try{ //initiates form submission
            contactUsForm.submitBtn.click();
            acceptAlert();
            logs.info("✅ Form submission successful");
        } catch (Exception e) {
            Assert.fail("Error submitting form: " + e.getMessage());
            logs.error("❌ Failed to submit form", e);
        }
    }

    public void returnToHome(){
        logs.info("✦•┈๑⋅⋯ User returns home ⋯⋅๑┈•✦ ");
        try{ //clicks button to return home
            contactUsForm.homeBtn.click();
            logs.info("✅ Successfully returned to home page");
        } catch (Exception e){
            Assert.fail("Error returning to home: " + e.getMessage());
            logs.error("❌ Failed to return home", e);
        }
    }

    //Assertions
    public boolean isGetInTouchTextVisible(){
        return contactUsForm.getInTouchText.isDisplayed();
    }

    public boolean isSuccessTextVisible(){
        return contactUsForm.successText.isDisplayed();
    }
}
