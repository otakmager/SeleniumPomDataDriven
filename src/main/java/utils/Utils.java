package utils;

import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

public interface Utils {
    static double parseLocalizedNumber(String raw) {
        try {
            if (raw.contains(",")) {
                raw = raw.replace(",", ".");
            }
            return Double.parseDouble(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format: " + raw, e);
        }
    }

    static void createReportInfo(Logger logger, String message) {
        logger.info(message);
        ReportManager.reportInfo(message);
    }

    static void createReportFailure(Logger logger, String message) {
        logger.info(message);
        ReportManager.reportFailure(message);
    }

    static void infoInputTest(Logger logger, String value1, String fromUnit, String value2, String toUnit){
        String message = "Test data: " + value1 + ", " + fromUnit + ", " + value2 + ", " + toUnit;
        logger.info(message);
        ReportManager.reportInfo(message);
    }

    static void logTestStart(Logger logger, ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String className = result.getTestClass().getName();
        logger.info("\n\n================== START TEST: {}.{} ==================\n", className, methodName);
    }
}
