package keyword;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ReportManager;

public class ActionKeyword {

    public void click(WebElement el, String elementName) {
        try {
            el.click();
            ReportManager.reportInfo("Clicking on element: " + elementName);
        } catch (Exception e) {
            ReportManager.reportFailure("Failed to click on element: " + elementName + " - " + e.getMessage());
            throw e;
        }
    }

    public void sendKeys(WebElement el, String keys, String elementName) {
        try {
            el.clear();
            el.sendKeys(keys);
            ReportManager.reportInfo("Sending keys: " + keys + " to element: " + elementName);
        } catch (Exception e) {
            ReportManager.reportFailure("Failed to send keys: " + keys + " to element: " + elementName + " - " + e.getMessage());
            throw e;
        }
    }

    public String getText(WebElement el, String elementName) {
        try {
            String text = el.getText();
            ReportManager.reportInfo("Getting text from element: " + elementName);
            return text;
        } catch (Exception e) {
            ReportManager.reportFailure("Failed to get text from element: " + elementName + " - " + e.getMessage());
            throw e;
        }
    }

    public String getValue(WebElement el, String elementName) {
        try {
            String value = (String) BaseTest.js.executeScript("return arguments[0].value;", el);
            ReportManager.reportInfo("Getting value from element: " + elementName);
            return value;
        } catch (Exception e) {
            ReportManager.reportFailure("Failed to get value from element: " + elementName + " - " + e.getMessage());
            throw e;
        }
    }

    public void selectByVisibleText(WebElement el, String text, String elementName) {
        try {
            Select select = new Select(el);
            select.selectByVisibleText(text);
            ReportManager.reportInfo("Successfully selected option: " + text + " on " + elementName);
        } catch (Exception e) {
            ReportManager.reportFailure("Failed to select option: " + text + " on " + elementName + " - " + e.getMessage());
            throw e;
        }
    }
}
