package keyword;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

public class ActionKeyword {
    private static final Logger logger = LogManager.getLogger(ActionKeyword.class);
    private String message;

    public void click(WebElement el, String elementName) {
        try {
            el.click();
            message = "Clicking on element: " + elementName;
            Utils.createReportInfo(logger, message);
        } catch (Exception e) {
            message = "Failed to click on element: " + elementName + " - " + e.getMessage();
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

    public void sendKeys(WebElement el, String keys, String elementName) {
        try {
            el.clear();
            el.sendKeys(keys);
            message = "Sending keys: " + keys + " to element: " + elementName;
            Utils.createReportInfo(logger, message);
        } catch (Exception e) {
            message = "Failed to send keys: " + keys + " to element: " + elementName + " - " + e.getMessage();
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

    public String getText(WebElement el, String elementName) {
        try {
            String text = el.getText();
            message = "Getting text from element: " + elementName;
            Utils.createReportInfo(logger, message);
            return text;
        } catch (Exception e) {
            message = "Failed to get text from element: " + elementName + " - " + e.getMessage();
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

    public String getValue(WebElement el, String elementName) {
        try {
            String value = (String) BaseTest.js.executeScript("return arguments[0].value;", el);
            message = "Getting value from element: " + elementName;
            Utils.createReportInfo(logger, message);
            return value;
        } catch (Exception e) {
            message = "Failed to get value from element: " + elementName + " - " + e.getMessage();
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

    public void selectByVisibleText(WebElement el, String text, String elementName) {
        try {
            Select select = new Select(el);
            select.selectByVisibleText(text);
            message = "Successfully selected option: " + text + " on " + elementName;
            Utils.createReportInfo(logger, message);
        } catch (Exception e) {
            message = "Failed to select option: " + text + " on " + elementName + " - " + e.getMessage();
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }
}
