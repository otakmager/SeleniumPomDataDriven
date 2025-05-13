package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    public String baseUrl = Constants.baseUrl;

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "test-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Host Name", "localhost");
        extent.setSystemInfo("Username", "root");

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Selenium Test Report");

        setupDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    @BeforeMethod
    public void beforeMethod(Method testMethod) {
        logger = extent.createTest(testMethod.getName());
        driver.get(baseUrl);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " testcase failed.", ExtentColor.RED));
            logger.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable() + " testcase failed.", ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP,
                    MarkupHelper.createLabel(result.getName() + " testcase skipped.", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS,
                    MarkupHelper.createLabel(result.getName() + " testcase passed.", ExtentColor.GREEN));
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest() {
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
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
