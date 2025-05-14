package testCases.length;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import utils.Constants;
import utils.ReportManager;

import java.lang.reflect.Method;

public class LengthConverterTest extends BaseTest {
    @Override
    protected String getUrl() {
        return Constants.lengthConverterUrl;
    }

    // using url Constants.lengthConverterUrl
    // 1. meter to kilometer
    // 2. kilometer to meter
    // 3. centimeter to meter
    // 4. meter to centimeter

}
