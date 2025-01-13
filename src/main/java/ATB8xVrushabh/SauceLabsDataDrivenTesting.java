package ATB8xVrushabh;

import io.qameta.allure.Description;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class SauceLabsDataDrivenTesting {

    @Description("Login to the sauce labs using data driven testing")
    @Test
    public void test_data_driven() throws IOException {

        WebDriver driver;
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "//src//TestData//TestDataFile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int totalRows = sheet.getLastRowNum();
        int totalcells = sheet.getRow(0).getLastCellNum();

        System.out.println("total rows: " + totalRows);
        System.out.println("total cells: " + totalcells );

        for (int i = 1; i<=totalRows; i++){


            System.out.println("Execution Started");

            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/v1/");

            //find username and password
            driver.findElement(By.id("user-name")).sendKeys(sheet.getRow(i).getCell(0).toString());

            driver.findElement(By.id("password")).sendKeys(sheet.getRow(1).getCell(1).toString());

            driver.findElement(By.id("login-button")).click();

            driver.quit();

            System.out.println("Execution Finished");


        }




    }
}
