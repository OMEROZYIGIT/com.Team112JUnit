package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void waitFor(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void getValueOfExcelFileUsingRowAndCell(int row, int cell) {

        String filePath = "src/test/java/day12_table_excel/countries.xlsx";
        Workbook workbook = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(workbook.getSheet("Sayfa1").getRow(row).getCell(cell));


    }

    public static void fullPageScreenShot(WebDriver driver) throws IOException {

        TakesScreenshot ss = (TakesScreenshot) driver;
        /*
        we saved different SS by using the same way and name;
        only the last SS will remain in the project
        To solve this problem we need to change the name automatically
         */
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHmmss");
        String date = ldt.format(dtf);

        String filePath = "target/ScreenShots/fullPageSS"+date+".jpeg";
        File FullPageSS = new File(filePath);
        File tempFile = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tempFile,FullPageSS);


    }
}
