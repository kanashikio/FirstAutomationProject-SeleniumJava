package actions;

import base.baseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class commonActions extends baseUtil {
    WebDriverWait wait;

    public commonActions(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void waitForWebElementToAppear(WebElement findBy){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public boolean waitForVisibilityOfElement(WebElement element){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public void scrollDown(){
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,400)");
    }

    public void pause() throws InterruptedException {
        Thread.sleep(1000);
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void dropDownValue(WebElement dropdownElement, String visibleText) {
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(visibleText);
        }


    // common assertions
    public boolean isInputEntered(WebElement element) {
        return !element.getAttribute("value").trim().isEmpty();
    }

    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isDropdownValueSelected(WebElement element, String expectedValue) {
        Select select = new Select(element);
        String actualText = select.getFirstSelectedOption().getText().trim();
        String actualValue = select.getFirstSelectedOption().getAttribute("value").replace(".0", "").trim();
        String expected = expectedValue.trim();

        return actualText.equalsIgnoreCase(expected) || actualValue.equalsIgnoreCase(expected);
    }

}
