package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class loginCheckOutPage {

    public loginCheckOutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/logout']")
    public WebElement logoutBtn;

    @FindBy(css = "input[data-qa='login-email']")
    public WebElement loginEmailInputField;

    @FindBy(css = "input[data-qa='login-password']")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//div[@class='product-image-wrapper']/div/div/p")
    public List<WebElement> productNameList;

    @FindBy(xpath = "//div[@class='product-image-wrapper']/div/div/a")
    public List<WebElement> addToCartBtn;

    @FindBy(xpath = "//div[@class='modal-content']/div[@class='modal-footer']/button")
    public WebElement continueShoppingBtn;

    @FindBy(css = "a[href='/view_cart']")
    public WebElement cartBtn;

    @FindBy(css = "section[id='cart_items']")
    public WebElement cartContainer;

    @FindBy(css = "a.check_out")
    public WebElement clickCheckOutBtn;

    @FindBy(css = "tr td h4 a")
    public List<WebElement> verifyProduct;

    @FindBy(css = "textarea[name='message']")
    public WebElement textArea;

    @FindBy(css = "a[href='/payment']")
    public WebElement placeOrderBtn;

    @FindBy(xpath = "//h2[@class='heading']")
    public WebElement paymentHeading;

    @FindBy(xpath = "//div/input[@data-qa='name-on-card']")
    public WebElement cardNameInput;

    @FindBy(css = "input[name='card_number']")
    public WebElement cardNumberInput;

    @FindBy(css = "input[name='cvc']")
    public WebElement cvcInput;

    @FindBy(css = "input[name='expiry_month']")
    public WebElement expiryMonthInput;

    @FindBy(css = "input[name='expiry_year']")
    public WebElement expiryYearInput;

    @FindBy(css = "button[data-qa='pay-button']")
    public WebElement payBtn;

    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/p")
    public WebElement congratsText;

    @FindBy(css = "div[id='success_message'] div[class='alert-success alert']")
    public WebElement successMessage;

    @FindBy(css = "#address_delivery li:not(.address_title)")
    public List<WebElement> deliveryAddressList;

    @FindBy(css = "#address_invoice li:not(.address_title)")
    public List<WebElement> billingInvoiceList;

    //<editor-fold desc="verify">
    @FindBy(css = "li.address_lastname")
    public WebElement addressLN;

    @FindBy(css = "li.address_address1")
    public WebElement address1;
    //</editor-fold>
}
