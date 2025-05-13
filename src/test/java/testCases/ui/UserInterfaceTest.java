package testCases.ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.WebPageEvents;

public class UserInterfaceTest extends BaseTest {
    WebPageEvents events = new WebPageEvents();

    @Test
    public void testTitle() {
        events.verifyPageTitle();
    }

    @Test
    public void testBanner() {
        events.verifyBannerTitleHeader();
        events.verifyLogoOnBanner();
    }

    @Test
    public void testFooter() {
        events.verifyEmailOnFooter();
        events.testWhatsNewVisibility();
        events.testTipsVisibility();
        events.testDisclaimerVisibility();
    }

    @Test
    public void testSideBarOnLargeScreen() {
        events.testSidebarVisibilityOnLargeScreen();
    }

    @Test
    public void testSideBarSmallOnScreen() {
        events.testSidebarVisibilityOnSmallScreen();

        // restore screen size
        BaseTest.driver.manage().window().maximize();
    }
}
