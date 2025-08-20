package x;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class tryqa {
        public static void main(String[] args) throws InterruptedException{
            System.setProperty("webdriver.chrome.driver", "C:/Users/Alijah/Downloads/chromedriver-win64/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://automationexercise.com/");

            driver.findElement(By.cssSelector("a[href*='/login']")).click();
            WebElement signup = driver.findElement(By.cssSelector("a[href*='/login']"));
            Assert.assertTrue(signup.isDisplayed(), "Signup button is available");

            WebElement userSignup = driver.findElement(By.xpath("//div[@class='signup-form']/h2[text()='New User Signup!']"));
            Assert.assertTrue(userSignup.isDisplayed(), "New User Signup! is displayed");

            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mica");
            driver.findElement(By.cssSelector("form[action*='signup'] input[type='email']")).sendKeys("i_mica.pontaoe@stratpoint.com");
            driver.findElement(By.cssSelector("form[action*='signup'] button[type='submit']")).click();

            WebElement enterAcc = driver.findElement(By.cssSelector("div[class='login-form'] h2:nth-child(1)"));
            Assert.assertTrue(enterAcc.isDisplayed(), "Enter Account Information is displayed");

            driver.findElement(By.cssSelector("label[for='id_gender2']")).click();

            driver.findElement(By.id("password")).sendKeys("123456789");

            driver.findElement(By.id("days")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//select[@id='days']/option[@value='3']")).click();
            driver.findElement(By.id("months")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//select[@id='months']/option[@value='4']")).click();
            driver.findElement(By.id("years")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//select[@id='years']/option[@value='2003']")).click();


        }
    }

