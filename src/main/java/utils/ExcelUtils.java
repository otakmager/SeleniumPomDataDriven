package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {
    private static final Logger logger = LogManager.getLogger(ExcelUtils.class);
    private Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            logger.info("Loaded Excel file and sheet: {}", sheetName);
        } catch (Exception e) {
            logger.error("Failed to load Excel file: {} - {}", sheetName, e.getMessage());
        }
    }

    public Object[][] getSheetDataAsArray(int rowsToSkip) {
        List<Object[]> dataList = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();

        // Skip title/header rows
        for (int i = 0; i < rowsToSkip && rowIterator.hasNext(); i++) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Check if the first cell is empty or null
            Cell firstCell = row.getCell(0);
            if (firstCell == null || firstCell.getCellType() == CellType.BLANK ||
                    firstCell.toString().trim().isEmpty()) {
                logger.info("Found empty first cell in row {}, stopping read", row.getRowNum());
                break;
            }

            // Save data to arrayList
            List<Object> cellValues = new ArrayList<>();
            for (Cell cell : row) {
                cell.setCellType(CellType.STRING);
                cellValues.add(cell.getStringCellValue().trim());
            }

            dataList.add(cellValues.toArray());
        }

        logger.info("Finished extracting data from Excel sheet");
        return dataList.toArray(new Object[0][]);
    }


}
