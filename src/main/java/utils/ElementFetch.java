package utils;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {
    private static final Logger logger = LogManager.getLogger(ElementFetch.class);
    private String message;

    public String getPageTitle() {
        try {
            String title = BaseTest.driver.getTitle();
            message = "Page title fetched: " + title;
            Utils.createReportInfo(logger, message);
            return title;
        } catch (Exception e) {
            message = "Failed to fetch page title: " + e.getMessage();
            Utils.createReportFailure(logger, message);
            throw e;
        }
    }

    public WebElement getWebElement(String identifierType, String identifierValue) {
        WebElement el;

        try {
            switch (identifierType) {
                case "XPATH" -> {
                    el = BaseTest.driver.findElement(By.xpath(identifierValue));
                    message = "Element fetched using XPATH: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "CSS" -> {
                    el = BaseTest.driver.findElement(By.cssSelector(identifierValue));
                    message = "Element fetched using CSS: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "ID" -> {
                    el = BaseTest.driver.findElement(By.id(identifierValue));
                    message = "Element fetched using ID: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "NAME" -> {
                    el = BaseTest.driver.findElement(By.name(identifierValue));
                    message = "Element fetched using NAME: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "CLASS" -> {
                    el = BaseTest.driver.findElement(By.className(identifierValue));
                    message = "Element fetched using CLASS: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "LINK" -> {
                    el = BaseTest.driver.findElement(By.linkText(identifierValue));
                    message = "Element fetched using LINK: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "TAGNAME" -> {
                    el = BaseTest.driver.findElement(By.tagName(identifierValue));
                    message = "Element fetched using TAGNAME: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                default -> {
                    message = "Invalid identifier type: " + identifierType;
                    Utils.createReportFailure(logger, message);
                    throw new IllegalArgumentException("Invalid identifier type: " + identifierType);
                }
            }
        } catch (Exception e) {
            message = "Invalid identifier type: " + identifierType;
            Utils.createReportFailure(logger, message);
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
                    message = "Elements fetched using XPATH: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "CSS" -> {
                    el = BaseTest.driver.findElements(By.cssSelector(identifierValue));
                    message = "Elements fetched using CSS: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "ID" -> {
                    el = BaseTest.driver.findElements(By.id(identifierValue));
                    message = "Elements fetched using ID: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "NAME" -> {
                    el = BaseTest.driver.findElements(By.name(identifierValue));
                    message = "Elements fetched using NAME: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "CLASS" -> {
                    el = BaseTest.driver.findElements(By.className(identifierValue));
                    message = "Elements fetched using CLASS: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "LINK" -> {
                    el = BaseTest.driver.findElements(By.linkText(identifierValue));
                    message = "Elements fetched using LINK: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                case "TAGNAME" -> {
                    el = BaseTest.driver.findElements(By.tagName(identifierValue));
                    message = "Elements fetched using TAGNAME: " + identifierValue;
                    Utils.createReportInfo(logger, message);
                }
                default -> {
                    message = "Invalid identifier type: " + identifierType;
                    Utils.createReportFailure(logger, message);
                    throw new IllegalArgumentException("Invalid identifier type: " + identifierType);
                }
            }
        } catch (Exception e) {
            message = "Invalid identifier type: " + identifierType;
            Utils.createReportFailure(logger, message);
            throw e;
        }

        return el;
    }

}
