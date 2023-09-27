package day13_excel_ScreenShoot_JsExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void test01() throws IOException {

        String filePath = "src/test/java/day12_table_excel/countries.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Products");
        // when we make a change in workbook, actually we are changing something in the copy of the original file

        workbook.getSheet("Sayfa1").getRow(4).createCell(4).setCellValue("Apple");
        workbook.getSheet("Sayfa1").getRow(5).createCell(4).setCellValue("Windows");
        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("Java");
        workbook.getSheet("Sayfa1").getRow(7).createCell(4).setCellValue("Mac");

        // now we will take something out of the project, so we will use fileoutputStream
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);



    }
}
