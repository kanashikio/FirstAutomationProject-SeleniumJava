package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class baseUtil {

    public static WebDriver driver;

    public static void setUp() {
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//environment.properties");
            properties.load(file);
            String browser = properties.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();

        } catch (Exception e) {
            System.out.println("Error during WebDriver setup: " + e.getMessage());
        }
    }

    public static void navigateTo() {
        driver.get("https://automationexercise.com/");
    }

    public static void verifyHomePageVisibility() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(actualTitle, expectedTitle, "Homepage is not visible");
    }

    static {
        // Disable logs
        LogManager.getLogManager().reset();
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    public static void quit() {
        try {
            if (driver != null) {
                Thread.sleep(1000);
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Error during WebDriver quit: " + e.getMessage());
        }
    }
}
