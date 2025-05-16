package testCases.length;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.WebPageEvents;
import utils.Constants;
import utils.ExcelDataProvider;
import utils.Utils;

public class LengthConverterTest extends BaseTest {
    private final String title = "Convert Length";
    WebPageEvents events = new WebPageEvents();

    @Test
    public void testTitle() {
        events.verifyPageTitle(title);
    }

    @Test
    public void testVerifyConverterTitleHeader() {
        events.verifyConverterTitleHeader(title);
    }

    @Override
    protected String getUrl() {
        return Constants.lengthConverterUrl;
    }

    @Test(dataProvider = "lengthData", dataProviderClass = ExcelDataProvider.class)
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
