package testCases.time;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.WebPageEvents;
import utils.Constants;
import utils.ExcelDataProvider;
import utils.Utils;

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

    @Test(dataProvider = "timeData", dataProviderClass = ExcelDataProvider.class)
    public void testConverter(String value1, String fromUnit, String value2, String toUnit) {
        // Create input log & report
        Utils.infoInputTest(logger, value1, fromUnit, value2, toUnit);

        // Parse data
        Double value1New = Utils.parseLocalizedNumber(value1);
        Double value2New = Utils.parseLocalizedNumber(value2);

        // action
        events.changeOptionDigits(Constants.maxDigits);
        events.testInputConverter(value1New, value2New, fromUnit, toUnit);
    }

}
