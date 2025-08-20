package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class downloadInvoicePage {

    public downloadInvoicePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //<editor-fold desc = "Page Elements">
    @FindBy(css = "p a[href='/login']")
    public WebElement registerLoginBtn;

    @FindBy(xpath = "//div[@class='signup-form']/h2")
    public WebElement verifyTexts;

    @FindBy(css = "a.check_out")
    public WebElement downloadInvoiceBtn;

    @FindBy(css = "a[data-qa='continue-button']")
    public WebElement invoiceContinueBtn;

    //</editor-fold>
}
