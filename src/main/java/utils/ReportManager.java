package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ReportManager {
    private static final ThreadLocal<ExtentTest> logger = new ThreadLocal<>();
    public static ExtentReports reports;
    public static ExtentSparkReporter sparkReporter;

    public static void initReports() {
        if (reports == null) {
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "test-report.html");
            reports = new ExtentReports();

            reports.setSystemInfo("Host Name", "localhost");
            reports.setSystemInfo("Username", "root");

            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Unit Converter Tests - https://www.digitaldutch.com/unitconverter/");

            reports.attachReporter(sparkReporter);
        }
    }

    public static ExtentReports getReports() {
        if (reports == null) {
            initReports();
        }
        return reports;
    }

    public static void flushReports() {
        if (reports != null) {
            reports.flush();
        }
    }

    public static void createTest(String testName) {
        ExtentTest test = getReports().createTest(testName);
        logger.set(test);
    }

    public static ExtentTest getLogger() {
        return logger.get();
    }

    public static void reportFailure(String message) {
        getLogger().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void reportInfo(String message) {
        getLogger().log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.BLUE));
    }

    public static void reportPass(String message) {
        getLogger().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }

    public static void reportSkip(String message) {
        getLogger().log(Status.SKIP, MarkupHelper.createLabel(message, ExtentColor.ORANGE));
    }
}
