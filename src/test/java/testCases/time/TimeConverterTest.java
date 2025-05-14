package testCases.time;

import base.BaseTest;
import utils.Constants;

public class TimeConverterTest extends BaseTest {
    @Override
    protected String getUrl() {
        return Constants.timeConverterUrl;
    }
    // 1. hour to minute
    // 2. minute to second
    // 3. second to millisecond

}
