package actions;

import org.openqa.selenium.WebDriver;
import base.excelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageObjects.downloadInvoicePage;

public class downloadInvoiceActions extends commonActions{
    private static final Logger logs = LogManager.getLogger(downloadInvoiceActions.class);
    downloadInvoicePage downloadInvoice;

    public downloadInvoiceActions(WebDriver driver) {
        super(driver);
        downloadInvoice = new downloadInvoicePage(driver);
    }

    public void registerLogin(){
        logs.info("✅ User is required to register/create an account before checking out");
        try{ //clicks on register button
            downloadInvoice.registerLoginBtn.click();
            logs.info("✅ Successfully navigated to login/sign up page");
        } catch (Exception e) {
            Assert.fail("Error clicking register/login link: " + e.getMessage());
            logs.error("❌ Failed to navigate to login/signup page", e);
        }
    }

    public void downloadInvoice(){
        logs.info("✦•┈๑⋅⋯ User downloads invoice ⋯⋅๑┈•✦ ");
        try{ //initiates invoice download
            downloadInvoice.downloadInvoiceBtn.click();
            downloadInvoice.invoiceContinueBtn.click();
            logs.info("✅ Invoice successfully downloaded");
        } catch (Exception e) {
            Assert.fail("Invoice download failed: " + e.getMessage());
            logs.error("❌ Failed to download invoice", e);
        }
    }

    //assertions
    public boolean verifyRegisterPage(){
        boolean flag = false;
        try{ //checks for visibility of login and sign up texts
            if(waitForVisibilityOfElement(downloadInvoice.verifyTexts)){
                flag = true;
            }
        } catch (Exception e) {
            logs.error("register texts not found", e);
        }
        return flag;
    }
}
