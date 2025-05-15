package pageEvents;

import base.BaseTest;
import keyword.ActionKeyword;
import keyword.ValidationKeyword;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import pageObjects.PageElements;
import utils.ElementFetch;

public class WebPageEvents {
    ElementFetch el = new ElementFetch();
    ActionKeyword action = new ActionKeyword();
    ValidationKeyword validation = new ValidationKeyword();

    public void verifyPageTitle() {
        verifyPageTitle(null);
    }

    public void verifyPageTitle(String additionalTitle) {
        String templateTitle = "- Unit Converter";
        String actualTitle = el.getPageTitle();

        validation.assertContainsText(actualTitle, templateTitle);

        if (additionalTitle != null && !additionalTitle.isEmpty()) {
            String expectedTitle = additionalTitle + " " + templateTitle;
            validation.assertTextEquals(actualTitle, expectedTitle);
        }
    }

    public void verifyBannerTitleHeader() {
        WebElement element = el.getWebElement("ID", PageElements.bannerTitleHeaderId);
        String expectedHeading = "Unit Converter";
        String actualHeading = action.getText(element, "Banner Title Header");

        validation.assertTextEquals(actualHeading, expectedHeading);
    }

    public void verifyLogoOnBanner() {
        WebElement element = el.getWebElement("ID", PageElements.digitalDutchLogoId);
        validation.assertElementVisible(element, "Logo on Banner");
    }

    public void verifyConverterTitleHeader(String expectedTitle) {
        WebElement element = el.getWebElement("ID", PageElements.converterTitleHeaderId);
        String actualTitle = action.getText(element, "Converter Title Header");

        validation.assertTextEquals(actualTitle, expectedTitle);
    }

    public void verifyEmailOnFooter() {
        WebElement element = el.getWebElement("XPATH", PageElements.emailFooterXPath);
        String expectedEmail = "info@digitaldutch.com";
        String actualEmail = action.getText(element, "Email Footer");

        validation.assertElementVisible(element, "Email Footer");
        validation.assertTextEquals(actualEmail, expectedEmail);
    }

    public void testWhatsNewVisibility() {
        WebElement whatsNewButton = el.getWebElement("XPATH", PageElements.whatsNewFooterXPath);
        WebElement whatsNewArea = el.getWebElement("XPATH", PageElements.whatsNewDivXPath);

        // Default state
        validation.assertElementVisible(whatsNewButton, "Whats New Button");
        validation.assertElementNotVisible(whatsNewArea, "Whats New Area");

        // Click to show
        action.click(whatsNewButton, "Whats New Button");
        validation.assertElementVisible(whatsNewArea, "Whats New Area");
    }

    public void testTipsVisibility() {
        WebElement tipsButton = el.getWebElement("XPATH", PageElements.tipsFooterXPath);
        WebElement tipsArea = el.getWebElement("XPATH", PageElements.tipsDivXPath);

        // Default state
        validation.assertElementVisible(tipsButton, "Tips Button");
        validation.assertElementNotVisible(tipsArea, "Tips Area");

        // Click to show
        action.click(tipsButton, "Tips Button");
        validation.assertElementVisible(tipsArea, "Tips Area");
    }

    public void testDisclaimerVisibility() {
        WebElement disclaimerButton = el.getWebElement("XPATH", PageElements.disclaimerFooterXPath);
        WebElement disclaimerArea = el.getWebElement("XPATH", PageElements.disclaimerDivXPath);

        // Default state
        validation.assertElementVisible(disclaimerButton, "Disclaimer Button");
        validation.assertElementNotVisible(disclaimerArea, "Disclaimer Area");

        // Click to show
        action.click(disclaimerButton, "Disclaimer Button");
        validation.assertElementVisible(disclaimerArea, "Disclaimer Area");
    }

    public void testSidebarVisibilityOnLargeScreen() {
        WebElement sideBar = el.getWebElement("XPATH", PageElements.sideBarXPath);
        WebElement sideBarAlt = el.getWebElement("XPATH", PageElements.sideBarAlternateXPath);

        // Ensure the screen is large screen
        BaseTest.driver.manage().window().maximize();

        // Validate sidebar visibility
        validation.assertElementVisible(sideBar, "Sidebar");
        validation.assertElementNotVisible(sideBarAlt, "Sidebar Alternate");
    }

    public void testSidebarVisibilityOnSmallScreen() {
        WebElement sideBar = el.getWebElement("XPATH", PageElements.sideBarXPath);
        WebElement sideBarAlt = el.getWebElement("XPATH", PageElements.sideBarAlternateXPath);
        Dimension targetSize = new Dimension(500, 720);

        // Ensure the screen is small screen
        BaseTest.driver.manage().window().setSize(targetSize);

        // Validate sidebar visibility
        validation.assertElementNotVisible(sideBar, "Sidebar");
        validation.assertElementVisible(sideBarAlt, "Sidebar Alternate");

        // Restore screen dimension
        BaseTest.driver.manage().window().maximize();
    }

    public void changeOptionDigits(Integer digit) {
        WebElement settingButton = el.getWebElement("XPATH", PageElements.buttonSettingXPath);
        WebElement settingBox = el.getWebElement("ID", PageElements.settingBoxId);
        WebElement inputDigit = el.getWebElement("ID", PageElements.inputDigitId);

        // Validate visibility
        validation.assertElementVisible(settingButton, "Setting Button");
        validation.assertElementNotVisible(settingBox, "Setting Box");
        validation.assertElementNotVisible(inputDigit, "Input Digit");

        // Click to show setting box
        action.click(settingButton, "Setting Button");
        validation.assertElementVisible(settingBox, "Setting Box");
        validation.assertElementVisible(inputDigit, "Input Digit");

        // Input digit
        action.sendKeys(inputDigit, digit.toString(), "Input Digit");
    }

    public void testInputConverter(Boolean value1, Boolean value2, String fromUnit, String toUnit) {
        WebElement selectUnitFrom = el.getWebElement("XPATH", PageElements.selectUnitFromXPath);
        WebElement selectUnitTo = el.getWebElement("XPATH", PageElements.selectUnitToXPath);
        WebElement inputFrom = el.getWebElement("XPATH", PageElements.inputFromXPath);
        WebElement inputTo = el.getWebElement("XPATH", PageElements.inputToXPath);

        // Change Unit
        action.selectByVisibleText(selectUnitFrom, fromUnit, "Select From Unit");
        action.selectByVisibleText(selectUnitTo, toUnit, "Select To Unit");

        // Input value1
        action.sendKeys(inputFrom, value1.toString(), "Input From");
        String resultTo = action.getValue(inputTo, "Input To");
        validation.assertDoubleValuesEqual(value1.toString(), resultTo);

        // Input value2
        action.sendKeys(inputTo, value2.toString(), "Input To");
        String resultFrom = action.getValue(inputFrom, "Input From");
        validation.assertDoubleValuesEqual(value2.toString(), resultFrom);
    }
}
