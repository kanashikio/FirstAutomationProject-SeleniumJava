package x;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class multipleTab {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Alijah/Downloads/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");

    //====================================2 TABS====================================
        driver.get("https://www.facebook.com/");
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);
        driver.get("https://www.saucedemo.com/v1/index.html");
        String usernameText = driver.findElement(By.id("login_credentials")).getText().split("\n")[2].trim().replace("\"", "");
        //String[] un = usernameText.split("\n");
        //String valid = un[1].trim().replace("\"", "");

        driver.switchTo().window(parentWindow);
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys(usernameText);

        driver.switchTo().window(childWindow);
        String passwordText = driver.findElement(By.className("login_password")).getText().split("\n")[1].trim().replace("\"", "");
        //String[] pw = passwordText.split("\n")[1].trim().replace("\"", "")
       // String validPW = pw[1].trim().replace("\"", "");

        driver.switchTo().window(parentWindow);
        Thread.sleep(1000);
        driver.findElement(By.id("pass")).sendKeys(passwordText);

        //driver.findElement(By.xpath("//button[@type='submit']")).click();


    //===================================3 OR MORE TABS============================
       /* Set<String> handles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);

        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.facebook.com/");
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://mail.google.com/mail/u/0/#inbox");

        driver.switchTo().window(tabs.get(0));*/

    }
}
