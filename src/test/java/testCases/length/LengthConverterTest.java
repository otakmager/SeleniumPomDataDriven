package testCases.length;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.WebPageEvents;
import utils.Constants;

public class LengthConverterTest extends BaseTest {
    private final String title = "Convert Length";
    WebPageEvents events = new WebPageEvents();

    @Override
    protected String getUrl() {
        return Constants.lengthConverterUrl;
    }

    @Test
    public void testTitle() {
        events.verifyPageTitle(title);
    }

    @Test
    public void testVerifyConverterTitleHeader() {
        events.verifyConverterTitleHeader(title);
    }

    @Test
    public void testConverter() {
        Double value1 = 12.500000;
        Double value2 = 12500.0;
        String fromUnit = "kilometers [km]";
        String toUnit = "meters [m]";

        events.changeOptionDigits(Constants.maxDigits);
        events.testInputConverter(value1, value2, fromUnit, toUnit);
    }

}
