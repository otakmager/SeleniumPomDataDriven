package keyword;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Utils;

public class ValidationKeyword {
    private static final Logger logger = LogManager.getLogger(ValidationKeyword.class);
    private String message;

    public void assertContainsText(String actual, String expectedSubstring) {
        try {
            Assert.assertTrue(actual.contains(expectedSubstring), "Validation failed: expectedSubstring '" + expectedSubstring + "' but found '" + actual + "'");
            message = "Validation passed: expectedSubstring '" + expectedSubstring + "' and found '" + actual + "'";
            Utils.createReportInfo(logger, message);
        } catch (AssertionError e) {
            message = "Validation failed: expectedSubstring '" + expectedSubstring + "' but found '" + actual + "'";
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

    public void assertTextEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
            message = "Validation passed: expected '" + expected + "' and found '" + actual + "'";
            Utils.createReportInfo(logger, message);
        } catch (AssertionError e) {
            message = "Validation failed: expected '" + expected + "' but found '" + actual + "'";
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

    public void assertElementVisible(WebElement element, String elementName) {
        try {
            Assert.assertTrue(element.isDisplayed(), elementName + " is not visible");
            message = "Element visible: " + elementName;
            Utils.createReportInfo(logger, message);
        } catch (AssertionError e) {
            message = "Element NOT visible: " + elementName;
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

    public void assertElementNotVisible(WebElement element, String elementName) {
        try {
            Assert.assertFalse(element.isDisplayed(), elementName + " is visible");
            message = "Element NOT visible: " + elementName;
            Utils.createReportInfo(logger, message);
        } catch (AssertionError e) {
            message = "Element visible: " + elementName;
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

    public void assertDoubleValuesEqual(Double value1, Double value2) {
        final double EPSILON = 1e-9; // tolerance value

        try {
            Assert.assertTrue(Math.abs(value1 - value2) < EPSILON);
            message = "Validation passed: " + value1 + " equals " + value2;
            Utils.createReportInfo(logger, message);
        } catch (AssertionError e) {
            message = "Validation failed: " + value1 + " does not equal " + value2;
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

}
