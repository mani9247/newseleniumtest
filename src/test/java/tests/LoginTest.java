package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setup() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");

    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");             // Run Chrome in headless mode
    	options.addArguments("--no-sandbox");           // Bypass OS security model (required in CI sometimes)
    	options.addArguments("--disable-dev-shm-usage");// Overcome limited resource problems in containers
    	options.addArguments("--window-size=1920,1080");// Optional: define screen size

    	driver = new ChromeDriver(options);
    	driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        test = extent.createTest("Login Test", "Login to demo website")
                     .assignAuthor("Manikanta")
                     .assignCategory("Regression");

        try {
            test.info("Launching browser");
            driver.get("https://example.com/login");

            test.info("Entering username");
            driver.findElement(By.id("username")).sendKeys("admin");

            test.info("Entering password");
            driver.findElement(By.id("password")).sendKeys("admin123");

            test.info("Clicking login");
            driver.findElement(By.id("loginButton")).click();

            // Example check
            String title = driver.getTitle();
            if (title.contains("Dashboard")) {
                test.pass("Login successful, Dashboard loaded");
            } else {
                test.fail("Login failed - Dashboard not found");
            }

        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @AfterTest
    public void finishReport() {
        extent.flush(); // Write results to HTML report
    }
}
