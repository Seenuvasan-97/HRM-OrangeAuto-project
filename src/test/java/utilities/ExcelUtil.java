package utilities;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtil {
    public static String excelReusable(String sheetName, int rowNumber, int cellNumber) throws IOException {
        String value = null;
        File file = new File("C:\\Users\\seenuvasan.s\\Documents\\HRM-OrangeAuto-framework\\src\\test\\resources\\testData\\TestDataForOrangeHRM.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        CellType cellType = cell.getCellType();
        switch (cellType){
            case STRING:
                value = cell.getStringCellValue();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    value = sdf.format(date);
                    break;
                }else {
                    double d = cell.getNumericCellValue();
                    long l = (long) d;
                    value= String.valueOf(l);
                    break;

                }
        }
        return value;
        

    }
}
