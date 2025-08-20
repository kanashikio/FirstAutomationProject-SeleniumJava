package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class signupPage{
    /*private By loginSignUpLink = By.cssSelector("a[href*='/login']");
    private By usernameField = By.xpath("//input[@type='text']");
    private By emailField = By.cssSelector("form[action*='signup'] input[type='email']");
    private By signUpBtn = By.cssSelector("form[action*='signup'] button[type='submit']");
    private By enterAccInfoDisplay = By.cssSelector("div[class='login-form'] h2:nth-child(1)");*/

    public signupPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // <editor-fold desc="Page Elements">
    @FindBy(css = "a[href*='/login']")
    public static WebElement loginSignUpLink;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameField;

    @FindBy(css = "form[action*='signup'] input[type='email']")
    public WebElement emailField;

    @FindBy(css = "form[action*='signup'] button[type='submit']")
    public WebElement signUpBtn;

    @FindBy(css = "div[class='login-form'] h2:nth-child(1)")
    public WebElement enterAccInfoDisplay;

    @FindBy(css = ".radio-inline label")
    public List<WebElement> titleRadioBtn;

    @FindBy(xpath = "//input[@name='title']")
    public List<WebElement> selectBtn;

    @FindBy(css = "#password")
    public WebElement passwordField;

    @FindBy(id = "days")
    public WebElement days;

    @FindBy(id = "months")
    public WebElement months;

    @FindBy(id = "years")
    public WebElement years;

    @FindBy(css = ".checkbox label[for='newsletter']")
    public WebElement newsletterCheckBox;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement letterCheckBtn;

    @FindBy(css = ".checkbox label[for='optin']")
    public WebElement offersCheckBox;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement offersCheckBtn;

    @FindBy(css = " *[name='first_name']")
    public WebElement firstNameInput;

    @FindBy(css = " *[name='last_name']")
    public WebElement lastNameInput;

    @FindBy(css = " *[name='company']")
    public WebElement companyInput;

    @FindBy(css = " *[name='address1']")
    public WebElement address1Input;

    @FindBy(css = " *[name='address2']")
    public WebElement address2Input;

    @FindBy(css = " *[name='country']")
    public WebElement countryContainer;

    @FindBy(css = " *[name='state']")
    public WebElement stateInput;

    @FindBy(css = " *[name='city']")
    public WebElement cityInput;

    @FindBy(css = " *[name='zipcode']")
    public WebElement zipcodeInput;

    @FindBy(css =  "*[name='mobile_number']")
    public WebElement mobileNumInput;

    @FindBy(css = "button[data-qa='create-account']")
    public WebElement createAccountBtn;

    @FindBy (css = "h2[data-qa='account-created'] b")
    public WebElement accountCreatedDisplay;

    @FindBy(css = "a[data-qa='continue-button']")
    public WebElement continueBtn;

    @FindBy(css = "li:nth-child(10)")
    public WebElement loggedInAsUN;

    @FindBy(css = "li:nth-child(5) a[href$='/delete_account']")
    public WebElement clickDeleteAccBtn;

    @FindBy(css = ".title b")
    public WebElement accountDeletedDisplay;

    @FindBy(css = ".pull-right a[data-qa='continue-button']")
    public WebElement deletedAccContinueBtn;
    // </editor-fold>
}
