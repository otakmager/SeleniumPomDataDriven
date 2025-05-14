package utils;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {

    public String getPageTitle() {
        try {
            String title = BaseTest.driver.getTitle();
            ReportManager.reportInfo("Page title fetched: " + title);
            return title;
        } catch (Exception e) {
            ReportManager.reportFailure("Failed to fetch page title: " + e.getMessage());
            throw e;
        }
    }

    public WebElement getWebElement(String identifierType, String identifierValue) {
        WebElement el;

        try {
            switch (identifierType) {
                case "XPATH" -> {
                    el = BaseTest.driver.findElement(By.xpath(identifierValue));
                    ReportManager.reportInfo("Element fetched using XPATH: " + identifierValue);
                }
                case "CSS" -> {
                    el = BaseTest.driver.findElement(By.cssSelector(identifierValue));
                    ReportManager.reportInfo("Element fetched using CSS: " + identifierValue);
                }
                case "ID" -> {
                    el = BaseTest.driver.findElement(By.id(identifierValue));
                    ReportManager.reportInfo("Element fetched using ID: " + identifierValue);
                }
                case "NAME" -> {
                    el = BaseTest.driver.findElement(By.name(identifierValue));
                    ReportManager.reportInfo("Element fetched using NAME: " + identifierValue);
                }
                case "CLASS" -> {
                    el = BaseTest.driver.findElement(By.className(identifierValue));
                    ReportManager.reportInfo("Element fetched using CLASS: " + identifierValue);
                }
                case "LINK" -> {
                    el = BaseTest.driver.findElement(By.linkText(identifierValue));
                    ReportManager.reportInfo("Element fetched using LINK: " + identifierValue);
                }
                case "TAGNAME" -> {
                    el = BaseTest.driver.findElement(By.tagName(identifierValue));
                    ReportManager.reportInfo("Element fetched using TAGNAME: " + identifierValue);
                }
                default -> {
                    ReportManager.reportFailure("Invalid identifier type: " + identifierType);
                    throw new IllegalArgumentException("Invalid identifier type: " + identifierType);
                }
            }
        } catch (Exception e) {
            ReportManager.reportFailure("Failed to fetch element: " + e.getMessage());
            throw e;
        }

        return el;
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        List<WebElement> el;

        try {
            switch (identifierType) {
                case "XPATH" -> {
                    el = BaseTest.driver.findElements(By.xpath(identifierValue));
                    ReportManager.reportInfo("Elements fetched using XPATH: " + identifierValue);
                }
                case "CSS" -> {
                    el = BaseTest.driver.findElements(By.cssSelector(identifierValue));
                    ReportManager.reportInfo("Elements fetched using CSS: " + identifierValue);
                }
                case "ID" -> {
                    el = BaseTest.driver.findElements(By.id(identifierValue));
                    ReportManager.reportInfo("Elements fetched using ID: " + identifierValue);
                }
                case "NAME" -> {
                    el = BaseTest.driver.findElements(By.name(identifierValue));
                    ReportManager.reportInfo("Elements fetched using NAME: " + identifierValue);
                }
                case "CLASS" -> {
                    el = BaseTest.driver.findElements(By.className(identifierValue));
                    ReportManager.reportInfo("Elements fetched using CLASS: " + identifierValue);
                }
                case "LINK" -> {
                    el = BaseTest.driver.findElements(By.linkText(identifierValue));
                    ReportManager.reportInfo("Elements fetched using LINK: " + identifierValue);
                }
                case "TAGNAME" -> {
                    el = BaseTest.driver.findElements(By.tagName(identifierValue));
                    ReportManager.reportInfo("Elements fetched using TAGNAME: " + identifierValue);
                }
                default -> {
                    ReportManager.reportFailure("Invalid identifier type: " + identifierType);
                    throw new IllegalArgumentException("Invalid identifier type: " + identifierType);
                }
            }
        } catch (Exception e) {
            ReportManager.reportFailure("Failed to fetch elements: " + e.getMessage());
            throw e;
        }

        return el;
    }

}
