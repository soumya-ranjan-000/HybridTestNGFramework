package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class Utilities {
    public static final long IMPLICIT_WAIT_TIME = 10;
    public static final long PAGE_LOAD_TIME = 5;

    public static Object[][] getTestDataFromExcel(String sheetName) {
        File excelFile = new File(System.getProperty("user.dir") + "\\src\\main\\testdata\\login_cred.xlsx");
        XSSFWorkbook workbook = null;

        try {
            FileInputStream fisExcel = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fisExcel);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i + 1);

            for (int j = 0; j < cols; j++) {
                XSSFCell cell = row.getCell(j);
                data[i][j] = cell.getStringCellValue();
            }
        }

        return data;
    }


}
