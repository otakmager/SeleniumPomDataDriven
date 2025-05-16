package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;
import utils.ReportManager;
import utils.Utils;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public static JavascriptExecutor js;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser) {
        // Init reports
        ReportManager.initReports();

        // Setup browser
        setupDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    @BeforeMethod
    public void beforeMethod(Method testMethod, ITestResult result) {
        ReportManager.createTest(testMethod.getName());
        Utils.logTestStart(logger, result);
        driver.get(getUrl());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ReportManager.reportFailure(result.getName() + " testcase skipped.");
        } else if (result.getStatus() == ITestResult.SKIP) {
            ReportManager.reportSkip(result.getName() + " testcase skipped.");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ReportManager.reportPass(result.getName() + " testcase passed.");
        }
    }

    @AfterTest
    public void afterTest() {
        ReportManager.flushReports();
        if (driver != null) {
            driver.quit();
        }
    }

    protected String getUrl() {
        return Constants.baseUrl;
    }

    private void setupDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }
}
