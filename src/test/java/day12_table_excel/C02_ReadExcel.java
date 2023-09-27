package day12_table_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel  {

    @Test
    public void test01() throws IOException {

        /*
        when we use Excel file, actually we are not using that file,
        Java will create a copy of it, and it will work on it
         */

        // file the path from content root
        String filePath = "src/test/java/day12_table_excel/countries.xlsx";

        // adding file to the project by creating a fis object
        FileInputStream fis = new FileInputStream(filePath);

        // we will create a copy of the file to work on
        Workbook workBook = WorkbookFactory.create(fis);

        // now we have a copy of Excel file
        Sheet sheet = workBook.getSheet("Sayfa1"); // reaching the sheet

        // let's try to reach row
        Row row = sheet.getRow(5);  // the index starts from zero that's why reach 6th row

        // reach 3rd column
        Cell cell = row.getCell(2);

        System.out.println("value of cell: "+cell);



    }
}
