package testCases.time;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.WebPageEvents;
import utils.Constants;

public class TimeConverterTest extends BaseTest {
    private final String title = "Convert Time";
    WebPageEvents events = new WebPageEvents();

    @Override
    protected String getUrl() {
        return Constants.timeConverterUrl;
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
        Double value1 = 1.57;
        Double value2 = 94.2;
        String fromUnit = "hours [h]";
        String toUnit = "minutes [min]";

        events.changeOptionDigits(Constants.maxDigits);
        events.testInputConverter(value1, value2, fromUnit, toUnit);
    }

}
