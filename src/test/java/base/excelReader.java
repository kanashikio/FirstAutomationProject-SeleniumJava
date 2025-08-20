package base;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import java.io.FileInputStream;
import java.util.*;

public class excelReader {

    public static Map<String, String> getRowData(String filePath, String sheetName, int rowIndex) {
        Map<String, String> data = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(rowIndex);

            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String key = headerRow.getCell(i).getStringCellValue();
                String value = dataRow.getCell(i).toString();
                data.put(key, value);
            }

        } catch (Exception e) {
            Assert.fail(("Error reading excel file: " + e.getMessage()));
        }

        return data;
    }

    public static List<String> getColumnData(String filePath, String sheetName, String columnName) {
        List<String> columnData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            // Find the column index for the given column name
            int columnIndex = -1;
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                if (headerRow.getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex == -1) {
                throw new RuntimeException("Column '" + columnName + "' not found in sheet '" + sheetName + "'");
            }

            // Loop through rows starting from row 1 (skip header)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(columnIndex);
                    if (cell != null) {
                        columnData.add(cell.toString().trim());
                    }
                }
            }

        } catch (Exception e) {
            Assert.fail("Error reading excel file: " + e.getMessage());
        }

        return columnData;
    }
}
