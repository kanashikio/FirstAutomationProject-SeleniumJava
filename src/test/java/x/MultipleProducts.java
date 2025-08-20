package x;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

public class MultipleProducts {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:/Users/Alijah/Downloads/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/v1/index.html");

        //-----------------login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

       //-----------------add-to-cart
        String[] products = {"Sauce Labs Bike Light", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket"};
        List<WebElement> itemSelection = driver.findElements(By.cssSelector("div.inventory_item_name"));

        for(int i = 0; i < itemSelection.size(); i++){
            String productName = itemSelection.get(i).getText();
            List itemstoCart = Arrays.asList(products);

            if(itemstoCart.contains(productName)){
                driver.findElements(By.xpath("//div[@class='pricebar']/button")).get(i).click();
                Thread.sleep(1500);
            }
        }

        //-------------check shopping cart
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
