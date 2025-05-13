package pageEvents;

import base.BaseTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.PageElements;
import utils.ElementFetch;

public class PageEvents {
    ElementFetch el = new ElementFetch();

    public void verifyPageTitle() {
        verifyPageTitle(null);
    }

    public void verifyPageTitle(String additionalTitle) {
        String templateTitle = "- Unit Converter";
        String actualTitle = el.getPageTitle();
        String expectedTitle;

        Assert.assertTrue(actualTitle.contains(templateTitle), "Page title is not as expected");

        if(additionalTitle != null && !additionalTitle.isEmpty()) {
            expectedTitle = additionalTitle + " " + templateTitle;
            Assert.assertEquals(actualTitle, expectedTitle, "Page title is not as expected");
        }
    }

    public void verifyBannerTitleHeader() {
        String expectedHeading = "Unit Converter";
        String actualHeading = el.getWebElement("ID", PageElements.bannerTitleHeaderId).getText();
        Assert.assertEquals(actualHeading, expectedHeading, "Heading is not as expected");
    }

    public void verifyConverterTitleHeader(String expectedTitle) {
        WebElement element = el.getWebElement("ID", PageElements.converterTitleHeaderId);
        String actualTitle = element.getText();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected");
    }

    public void verifyLogoOnBanner() {
        WebElement element = el.getWebElement("ID", PageElements.digitalDutchLogoId);
        Assert.assertTrue(element.isDisplayed(), "Logo is not displayed on the banner");
    }

    public void verifyEmailOnFooter() {
        WebElement element = el.getWebElement("ID", PageElements.emailFooterXPath);
        String expectedEmail = "info@digitaldutch.com";
        String actualEmail = element.getText();
        Assert.assertTrue(element.isDisplayed(), "Email is not displayed on the footer");
        Assert.assertEquals(actualEmail, expectedEmail, "Email is not as expected");
    }

    public void testWhatsNewVisibility() {
        WebElement whatsNewButton = el.getWebElement("XPATH", PageElements.whatsNewFooterXPath);
        WebElement whatsNewArea = el.getWebElement("XPATH", PageElements.whatsNewDivXPath);

        Assert.assertTrue(whatsNewButton.isDisplayed(), "What's New Button is not displayed");
        Assert.assertFalse(whatsNewArea.isDisplayed(), "What's New Area is displayed");

        whatsNewButton.click();
        Assert.assertTrue(whatsNewArea.isDisplayed(), "What's New Area is not displayed");
    }

    public void testTipsVisibility() {
        WebElement tipsButton = el.getWebElement("XPATH", PageElements.tipsFooterXPath);
        WebElement tipsArea = el.getWebElement("XPATH", PageElements.tipsDivXPath);

        Assert.assertTrue(tipsButton.isDisplayed(), "Tips Button is not displayed");
        Assert.assertFalse(tipsArea.isDisplayed(), "Tips Area is displayed");

        tipsButton.click();
        Assert.assertTrue(tipsArea.isDisplayed(), "Tips Area is not displayed");
    }

    public void testDisclaimerVisibility() {
        WebElement disclaimerButton = el.getWebElement("XPATH", PageElements.disclaimerFooterXPath);
        WebElement disclaimerArea = el.getWebElement("XPATH", PageElements.disclaimerDivXPath);

        Assert.assertTrue(disclaimerButton.isDisplayed(), "Tips Button is not displayed");
        Assert.assertFalse(disclaimerArea.isDisplayed(), "Tips Area is displayed");

        disclaimerButton.click();
        Assert.assertTrue(disclaimerArea.isDisplayed(), "Tips Area is not displayed");
    }

    public void testSidebarVisibilityOnLargeScreen() {
        WebElement sideBar = el.getWebElement("XPATH", PageElements.sideBarXPath);
        WebElement sideBarAlt = el.getWebElement("XPATH", PageElements.sideBarAlternateXPath);

        BaseTest.driver.manage().window().maximize();
        Assert.assertTrue(sideBar.isDisplayed(), "Side bar is not displayed on Max Screen");
        Assert.assertFalse(sideBarAlt.isDisplayed(), "Side bar alternative is displayed on Max Screen");
    }

    public void testSidebarVisibilityOnSmallScreen() {
        WebElement sideBar = el.getWebElement("XPATH", PageElements.sideBarXPath);
        WebElement sideBarAlt = el.getWebElement("XPATH", PageElements.sideBarAlternateXPath);
        Dimension targetSize = new Dimension(500, 720);

        BaseTest.driver.manage().window().setSize(targetSize);
        Assert.assertFalse(sideBar.isDisplayed(), "Side bar is displayed on Small Screen");
        Assert.assertTrue(sideBarAlt.isDisplayed(), "Side bar alternative is not displayed on Small Screen");
    }
}
