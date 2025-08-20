package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactUsFormPage {

    public contactUsFormPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // <editor-fold desc = "Page Elements">
    @FindBy(css = "a[href='/contact_us']")
    public static WebElement contactUsLink;

//    @FindBy(xpath = "//div[@id='contact-page']")
//    public WebElement contactPageContainer;

    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    public WebElement getInTouchText;

    @FindBy(css = "input[placeholder='Name']")
    public WebElement nameInput;

    @FindBy(css = "input[placeholder='Email']")
    public WebElement emailInput;

    @FindBy(css = "input[placeholder='Subject']")
    public WebElement subjectInput;

    @FindBy(css = "#message")
    public WebElement messsageInput;

    @FindBy(css = "input[name='upload_file']")
    public WebElement uploadFileInput;

    @FindBy(css = "input[data-qa='submit-button']")
    public WebElement submitBtn;

    @FindBy(css = ".status")
    public WebElement successText;

    @FindBy(css = ".contact-form .btn")
    public WebElement homeBtn;

    // </editor-fold>
}
