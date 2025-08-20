package x;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoqa {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Alijah/Downloads/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 600)");

        //start automation
        driver.findElement(By.id("firstName")).sendKeys("Alijah Czareen");
        driver.findElement(By.id("lastName")).sendKeys("Andres");
        driver.findElement(By.id("userEmail")).sendKeys("i_alijahczareen.andres@stratpoint.com");
        driver.findElement(By.cssSelector("label[for='gender-radio-2']")).click();

        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']/option[@value='2']")).click();
        driver.findElement(By.cssSelector(".react-datepicker__year-select option[value='2003']")).click();
        driver.findElement(By.cssSelector("div[aria-label='Choose Monday, March 10th, 2003']")).click();








    }
}
