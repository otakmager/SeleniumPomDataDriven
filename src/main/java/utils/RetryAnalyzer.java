package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger logger = LogManager.getLogger(RetryAnalyzer.class);
    private static final int maxRetry = 1;
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            logger.info("Retrying test {} with status {} for the {} time(s).",
                    result.getName(),
                    getResultStatusName(result.getStatus()),
                    this.retryCount + 1);
            if (retryCount < maxRetry) {
                retryCount++;
                return true;
            }
        }
        return false;
    }

    private String getResultStatusName(int status) {
        return switch (status) {
            case 1 -> "SUCCESS";
            case 2 -> "FAILURE";
            case 3 -> "SKIP";
            default -> "UNKNOWN";
        };
    }
}
