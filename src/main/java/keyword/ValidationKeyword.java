package keyword;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ReportManager;

public class ValidationKeyword {

    public void assertContainsText(String actual, String expectedSubstring) {
        try {
            Assert.assertTrue(actual.contains(expectedSubstring), "Validation failed: expectedSubstring '" + expectedSubstring + "' but found '" + actual + "'");
            ReportManager.reportPass("Validation passed: expectedSubstring '" + expectedSubstring + "' and found '" + actual + "'");
        } catch (AssertionError e) {
            ReportManager.reportFailure("Validation failed: expectedSubstring '" + expectedSubstring + "' but found '" + actual + "'");
            throw e;
        }
    }

    public void assertTextEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
            ReportManager.reportPass("Validation passed: expected '" + expected + "' and found '" + actual + "'");
        } catch (AssertionError e) {
            ReportManager.reportFailure("Validation failed: expected '" + expected + "' but found '" + actual + "'");
            throw e;
        }
    }

    public void assertElementVisible(WebElement element, String elementName) {
        try {
            Assert.assertTrue(element.isDisplayed(), elementName + " is not visible");
            ReportManager.reportPass("Element visible: " + elementName);
        } catch (AssertionError e) {
            ReportManager.reportFailure("Element NOT visible: " + elementName);
            throw e;
        }
    }

    public void assertElementNotVisible(WebElement element, String elementName) {
        try {
            Assert.assertFalse(element.isDisplayed(), elementName + " is visible");
            ReportManager.reportPass("Element NOT visible: " + elementName);
        } catch (AssertionError e) {
            ReportManager.reportFailure("Element visible: " + elementName);
            throw e;
        }
    }
}
