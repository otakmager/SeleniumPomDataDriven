package utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
    private static final String basePath = System.getProperty("user.dir") + "/src/test/resources/";

    @DataProvider(name = "lengthData")
    public Object[][] getLengthData() {
        String filePath = basePath + "datasets.xlsx";
        ExcelUtils excel = new ExcelUtils(filePath, "length");
        return excel.getSheetDataAsArray(2);
    }

    @DataProvider(name = "massData")
    public Object[][] getMassData() {
        String filePath = basePath + "datasets.xlsx";
        ExcelUtils excel = new ExcelUtils(filePath, "mass");
        return excel.getSheetDataAsArray(2);
    }

    @DataProvider(name = "timeData")
    public Object[][] getTimeData() {
        String filePath = basePath + "datasets.xlsx";
        ExcelUtils excel = new ExcelUtils(filePath, "time");
        return excel.getSheetDataAsArray(2);
    }
}
