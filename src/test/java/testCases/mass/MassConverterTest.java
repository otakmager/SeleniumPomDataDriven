package testCases.mass;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.WebPageEvents;
import utils.Constants;

public class MassConverterTest extends BaseTest {
    private final String title = "Convert Mass";
    WebPageEvents events = new WebPageEvents();

    @Override
    protected String getUrl() {
        return Constants.massConverterUrl;
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
        Double value1 = 325.75;
        Double value2 = 325750.0;
        String fromUnit = "grams [g]";
        String toUnit = "milligrams [mg]";

        events.changeOptionDigits(Constants.maxDigits);
        events.testInputConverter(value1, value2, fromUnit, toUnit);
    }

}
