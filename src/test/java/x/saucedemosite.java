package x;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class saucedemosite {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Alijah/Downloads/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        //start automation
        //-----------------login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        //driver.switchTo().alert().accept();

        //error message
       // System.out.println(driver.findElement(By.tagName("h3")).getText());
       // Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Wrong password or username");

        //--------------view and add-to-cart
        driver.findElement(By.id("item_4_title_link")).click();
        Thread.sleep(1000);
        driver. findElement(By.className("btn_primary")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("inventory_details_back_button")).click();
        //driver.findElement(By.className("btn_secondary")).click();

        //------------------checkout
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("checkout_button")).click();
        Thread.sleep(1000);

        //------------------details fill out
        driver.findElement(By.id("first-name")).sendKeys("Alijah");
        driver.findElement(By.id("last-name")).sendKeys("Andres");
        driver.findElement(By.id("postal-code")).sendKeys("1300");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("btn_action")).click();
        Thread.sleep(1000);

        //-----------------logout
        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//nav//a[text()='Logout']")).click();

        //driver.quit();
    }
}
