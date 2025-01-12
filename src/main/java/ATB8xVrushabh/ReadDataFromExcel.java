package ATB8xVrushabh;

import io.qameta.allure.Description;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDataFromExcel {

    @Description("Read data from excel")
    @Test
    public void read_data_from_excel() throws  IOException {
        //Excel file ==> Workbook ==> Sheet==> Row==> cell


         FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//src//TestData//TestData.xlsx");
         XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

       int totalRows = sheet.getLastRowNum();
       int totalCells = sheet.getRow(0).getLastCellNum();

        System.out.println("total rows:" + totalRows);
        System.out.println("total cells:" + totalCells);

        for (int r = 0; r <= totalRows; r++) {
           XSSFRow currentRow = sheet.getRow(r);

            for (int c = 0; c <totalCells ; c++) {

                XSSFCell cell = currentRow.getCell(c);
                System.out.print(cell.toString()+"\t");
            }
            System.out.println();
        }
        workbook.close();
        file.close();




    }
}
