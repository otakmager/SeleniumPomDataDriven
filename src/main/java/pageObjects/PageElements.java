package pageObjects;

public interface PageElements {
    String digitalDutchLogoId = "digitaldutch_logo";
    String bannerTitleHeaderId = "title";
    String converterTitleHeaderId = "quantity-title";

    String sideBarXPath = "//div[@id='left-content']";
    String sideBarAlternateXPath = "//div[@id='unitSelector']";

    String emailFooterXPath = "//a[starts-with(@href, 'mailto:')]";
    String whatsNewFooterXPath = "//a[text()='What\'s New']";
    String tipsFooterXPath = "//a[text()='Tips']";
    String disclaimerFooterXPath = "//a[text()='Disclaimer']";

    String whatsNewDivXPath = "//div[@id='whatsNew']";
    String tipsDivXPath = "//div[@id='tips']";
    String disclaimerDivXPath = "//div[@id='disclaimer']";

    String inputFromXPath = "//input[@id='inputFrom']";
    String selectUnitFromXPath = "//select[@id='selectFrom']";

    String inputToXPath = "//input[@id='inputTo']";
    String selectUnitToXPath = "//select[@id='selectTo]";
}
