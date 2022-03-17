package work.selenium.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelReader {
    private static XSSFSheet sheet;
    private static final String pathToExcelFile = "src/test/resources/testdata.xlsx";  //Файл Excel с данными

    //Выбор вкладки в Excel файле
    public static void setExcelSheet(String sheetName) {
        try {
            InputStream inputStream = new FileInputStream(pathToExcelFile);
            XSSFWorkbook book = new XSSFWorkbook(inputStream);
            sheet = book.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Получение данных из Excel
    public static String[][] getTestData(String boundary) {
        DataFormatter formatter = new DataFormatter();
        XSSFCell[] boundaryCells = getBoundaryCells(boundary);
        String[][] testData;


        XSSFCell startCell = boundaryCells[0];
        XSSFCell endCell = boundaryCells[1];

        int startRow = startCell.getRowIndex() + 1;
        int startCol = startCell.getColumnIndex() + 1;
        int endRow = endCell.getRowIndex() - 1;
        int endCol = endCell.getColumnIndex() - 1;

        testData = new String[endRow - startRow + 1][endCol - startCol + 1];

        for (int i = startRow; i < endRow + 1; i++) {
            for (int j = startCol; j < endCol + 1; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                testData[i - startRow][j - startCol] = formatter.formatCellValue(cell);
            }
        }
        return testData;
    }


    //Поиск границ таблицы
    private static XSSFCell[] getBoundaryCells(String boundary) {
        DataFormatter formatter = new DataFormatter();
        XSSFCell[] cells = new XSSFCell[2];

        int boundaryCount = 0;
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (boundaryCount == 2) {
                    break;
                }
                if (boundary.equals(formatter.formatCellValue(cell))) {
                    cells[boundaryCount] = (XSSFCell) cell;
                    boundaryCount++;
                }
            }
        }
        return cells;
    }
}
