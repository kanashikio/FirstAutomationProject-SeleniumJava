package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class incorrectLoginPage {

    public incorrectLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // <editor-fold desc="Page Elements">
//    @FindBy(css = "a[href*='/login']")
//    public static WebElement loginLink;
    @FindBy(css = "div[class='login-form'] h2")
    public WebElement loginTextDisplay;

    @FindBy(css = "input[data-qa='login-email']")
    public WebElement loginEmailInputField;

    @FindBy(css = "input[data-qa='login-password']")
    public WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    public WebElement loginErrorText;

    // </editor-fold>
}
