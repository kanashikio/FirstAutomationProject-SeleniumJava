package actions;

import base.excelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.loginCheckOutPage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class loginCheckOutActions extends commonActions{
    private static final Logger logs = LogManager.getLogger(loginCheckOutActions.class);
    public loginCheckOutPage loginCheckOut;
    String excelPath = System.getProperty("user.dir") + "/src/test/java/testData/try-data.xlsx";

    public loginCheckOutActions(WebDriver driver) {
        super(driver);
        loginCheckOut = new loginCheckOutPage(driver);
    }

    public void clickLogout(){
        logs.info("✦•┈๑⋅⋯ User logs out ⋯⋅๑┈•✦");
        try{
            pause();
            //Initiates logout
            loginCheckOut.logoutBtn.click();
            logs.info("✅ Successfully logged out");
        } catch (Exception e) {
            Assert.fail("Error logging out: " + e.getMessage());
            logs.error("❌ Logout Failed", e);
        }
    }

    public void loginToDashboard(){
        logs.info("✦•┈๑⋅⋯ User logs in using created account ⋯⋅๑┈•✦ ");
        try{
            Map<String, String> login = excelReader.getRowData(excelPath, "signupData", 1);

            //enters login credentials
            loginCheckOut.loginEmailInputField.sendKeys(login.get("email"));
            loginCheckOut.loginPasswordInput.sendKeys(login.get("password"));
            logs.info("✅ Successfully entered login credentials");
        } catch (Exception e) {
            Assert.fail("Error logging in:" + e.getMessage() );
            logs.error("❌ Failed to enter credentials", e);
        }
    }

    public void addProducts(){
        logs.info("✦•┈๑⋅⋯ User adds products to cart ⋯⋅๑┈•✦ ");
        try{
            scrolldown();
            //reads spreadsheet column data (from excelReader class)
            List<String> products = excelReader.getColumnData(
                    "src/test/java/testData/try-data.xlsx",
                    "productsData",
                    "products"
            );

            //list for printing added products (verifying)
            List<String> addedProducts = new ArrayList<>();

            //scans product page then adds products to cart that matches product data from Excel
            IntStream.range(0, loginCheckOut.productNameList.size())
                    .filter(i -> products.contains(loginCheckOut.productNameList.get(i).getText()))
                    .forEach(i -> {
                        try {
                            String cartProduct = loginCheckOut.productNameList.get(i).getText();
                            //adds product to list for printing
                            addedProducts.add(cartProduct);
                            //clicks add to cart button
                            loginCheckOut.addToCartBtn.get(i).click();
                            pause();
                            loginCheckOut.continueShoppingBtn.click();
                        } catch (Exception e) {
                            Assert.fail("Product not found: " + e.getMessage());
                            logs.error("❌ Product not found", e);
                        }
                    });
            //added products prints in console
            logs.info("╰┈➤ Added products: {}", addedProducts);
            logs.info("✅ Products added successfully");
        } catch (Exception e) {
            Assert.fail("Error adding products: " + e.getMessage());
            logs.error("❌ Add to cart failed", e);
        }
    }

    public void checkOut(){
        logs.info("✦•┈๑⋅⋯ User proceeds to checkout ⋯⋅๑┈•✦ ");
        try{ //navigates to shopping cart
            loginCheckOut.cartBtn.click();
            //proceeds to check out selected products
            loginCheckOut.clickCheckOutBtn.click();
        } catch (Exception e) {
            Assert.fail("Error checking out: " + e.getMessage());
            logs.error("❌ Checkout failed", e);
        }
    }

    public void placeOrder(){
        logs.info("✅ Products checked out");
        logs.info("✦•┈๑⋅⋯ User places order and leaves a comment ⋯⋅๑┈•✦ ");
        try{
            //gets data from productData sheet in spreadsheet
            Map<String, String> comment = excelReader.getRowData(excelPath, "productsData", 1);

            //inputs comment before placing order
            loginCheckOut.textArea.sendKeys(comment.get("comment"));
            pause();
            //clicks place order button
            loginCheckOut.placeOrderBtn.click();
            logs.info("✅ Successfully placed order");
        } catch (Exception e) {
            Assert.fail("Error placing order: " + e.getMessage());
            logs.error("❌ Failed to place order", e);
        }
    }

    public void paymentDetails(){
        logs.info("✦•┈๑⋅⋯ User proceeds to payment ⋯⋅๑┈•✦ ");
        try{ //reads and stores data from productsData sheet in Excel
            Map<String, String> payment = excelReader.getRowData(excelPath, "productsData",1);

            scrolldown();
            //inputs payment details
            loginCheckOut.cardNameInput.sendKeys(payment.get("cardName"));
            loginCheckOut.cardNumberInput.sendKeys(payment.get("cardNum").replace(".0", "").trim());
            loginCheckOut.cvcInput.sendKeys(payment.get("cvc").replace(".0", "").trim());
            loginCheckOut.expiryMonthInput.sendKeys(payment.get("expiryMonth"));
            loginCheckOut.expiryYearInput.sendKeys(payment.get("expiryYr").replace(".0", "").trim());
            logs.info("✅ Payment info provided");
        } catch (Exception e) {
            Assert.fail("Error payment info details: " + e.getMessage());
            logs.error("❌ Payment info details missing", e);
        }
    }

    public void confirmPayment(){
        logs.info("✦•┈๑⋅⋯ User confirms payment ⋯⋅๑┈•✦ ");
        try{ //clicks button for payment confirmation
            loginCheckOut.payBtn.click();
            logs.info("✅ Payment confirmation success");
        } catch (Exception e) {
            Assert.fail("Error payment confirmation: " + e.getMessage());
            logs.error("❌ Payment confirmation failed", e);
        }
    }

    //<editor-fold desc="Verify Methods">
    public boolean verifyCartPage(){
        return loginCheckOut.cartContainer.isDisplayed();
    }

   /* public void verifyAddressDetails(int rowIndex){
        try{
            String excelPath = System.getProperty("user.dir") + "/src/test/java/testData/try-data.xlsx";
            Map<String, String> data = excelReader.getRowData(excelPath, "signupData", rowIndex);



        } catch (Exception e) {
            Assert.fail("Wrong address details: " + e.getMessage());
        }
    } */

    public void verifyProducts(){
        try{ //reads column data from productsData sheet in Excel (from excelReader class)
            List<String> expectedProducts = excelReader.getColumnData(
                    "src/test/java/testData/try-data.xlsx",
                    "productsData",
                    "products"
            );

            //lists products from cart
            List<String> actualProducts = loginCheckOut.verifyProduct.stream()
                    .map(WebElement::getText)
                    .toList();

            //verifies if products from Excel and cart match
            Assert.assertEqualsNoOrder(
                    actualProducts.toArray(),
                    expectedProducts.toArray(),
                    "Products mismatch"
            );
        } catch (Exception e) {
            Assert.fail("Products mismatch: " + e.getMessage());
            logs.error("❌ Products mismatch", e);
        }
    }

    public boolean verifyClickedPlaceOrderBtn(){
        boolean flag = false;
        try{ //checks if payment heading is visible
            if(waitForVisibilityOfElement(loginCheckOut.paymentHeading)){
                flag = true;
            }
        } catch (Exception e) {
            logs.error("❌ Place order click button failed", e);
        }
        return flag;
    }

    public void verifyAddress(){
        try{ //reads data from signupData sheet in Excel
            Map<String, String> actualDetails = excelReader.getRowData(excelPath, "signupData", 1);

            //concatenates title, first name, and last name as well as city, state, and zipcode
            String fullName = actualDetails.get("title") + " " + actualDetails.get("firstName") + " " + actualDetails.get("lastName");
            String cityStateZip = actualDetails.get("city") + " " + actualDetails.get("state") + " " + actualDetails.get("zipcode").replace(".0", "").trim();

            //lists concatenated details and other necessary details for verification
            String expectedAddress = String.join("\n",
                    fullName.trim(),
                    actualDetails.get("company"),
                    actualDetails.get("address1"),
                    actualDetails.get("address2"),
                    cityStateZip,
                    actualDetails.get("country"),
                    actualDetails.get("mobileNum")
            );

            //gets the delivery address info displayed on the website
            String actualDeliveryAddress = loginCheckOut.deliveryAddressList.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.joining("\n"));

            //gets the billing invoice address info displayed on the website
            String actualInvoiceAddress = loginCheckOut.billingInvoiceList.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.joining("\n"));

            //verifies if the Excel and website addresses match
            Assert.assertEquals(actualDeliveryAddress, expectedAddress, "Delivery Address mismatch!");
            Assert.assertEquals(actualInvoiceAddress, expectedAddress, "Invoice Address mismatch!");
        } catch (Exception e) {
            Assert.fail("Error verifying address: " + e.getMessage());
            logs.error("❌ Address not verified", e);
        }
    }

    /*public boolean successMsg(){
            return loginCheckOut.successMessage.isDisplayed();
    }


    public void success(){
        waitForWebElementToAppear(loginCheckOut.successMessage);

       String success = loginCheckOut.successMessage.getText();
       String expected = "Your order has been placed successfully!";
       Assert.assertEquals(expected, success, "Message mismatch");
    }*/
    //</editor-fold>
}
