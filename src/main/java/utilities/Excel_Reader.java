package utilities;

import com.automationpractice.test.common.CommanFunction;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

/**
 * Created by neeraj.bhatnagar on 1/16/2017.
 * https://www.youtube.com/watch?v=2vaVbnL-4iQ&t=128s
 */
public class Excel_Reader extends CommanFunction {
    public String path;

    private FileInputStream fis;
    private XSSFWorkbook workBook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    public Excel_Reader(String path) {
        this.path = path;
        try {
            fis = new FileInputStream(path);
            workBook = new XSSFWorkbook(fis); // Making object of workbook with input stream as argument
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            int col_mum = 0;
            int sheetIndex = workBook.getSheetIndex(sheetName); // Index of sheet to be worked upon.
            sheet = workBook.getSheetAt(sheetIndex);           // Get Sheet.
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {       // This will get you how many column excel sheet have
                if (row.getCell(i).getStringCellValue().equals(colName)) {
                    int col_num = i;
                }
            }
            row = sheet.getRow(rowNum - 1);
            cell = row.getCell(col_mum);
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                return String.valueOf(cell.getStringCellValue());
            } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                return String.valueOf(cell.getStringCellValue());
            } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Oevrloading of method getCellData to get all row & columns, based on Columan Index & row index.
     * @param sheetName
     * @param colNum
     * @param rowNum
     * @return
     */

    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            int sheetIndex = workBook.getSheetIndex(sheetName); // Index of sheet to be worked upon.
            sheet = workBook.getSheetAt(sheetIndex);           // Get Sheet.
            row = sheet.getRow(0);
            row = sheet.getRow(rowNum - 1);
            cell = row.getCell(colNum);
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                return cell.getStringCellValue();
            } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                return String.valueOf(cell.getStringCellValue());
            } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                return String.valueOf(cell.getStringCellValue());
            } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getRowCount(String sheetName) {
        try{
        int index = workBook.getSheetIndex(sheetName);
        if (index == -1) {
            return 0;
        } else {
            sheet = workBook.getSheetAt(index);
            int number = sheet.getLastRowNum() + 1;
            return number;
        }

    } catch(Exception e){
        e.printStackTrace();

    }
    return 0;
    }

    public int getColumnCount(String sheetName) {
        try {
            int index = workBook.getSheetIndex(sheetName);
            if (index == -1) {
                return 0;
            } else {
                sheet = workBook.getSheet(sheetName);
                row = sheet.getRow(0);
                return row.getLastCellNum();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"\\testdata\\testData.xlsx";
        Excel_Reader obj = new Excel_Reader(path);
        System.out.println(obj.getCellData("userData", "Password" , 3  ));
        System.out.println(obj.getRowCount("userData"));
        System.out.println(obj.getColumnCount("userData"));
        System.out.println(obj.getCellData("userData",0,4));
    }
}
