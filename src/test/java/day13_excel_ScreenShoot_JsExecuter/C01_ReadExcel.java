package day13_excel_ScreenShoot_JsExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        // to work on a file, complete step 3
        // 1) file path
        String filePath = "src/test/java/day12_table_excel/countries.xlsx";

        // 2) introduce the file to Java
        FileInputStream fis = new FileInputStream(filePath);

        // 3) create a copy file with depencies
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        String desiredCellStr = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();
        System.out.println(desiredCellStr);

        // test that 2. row 4. cell value is Kabil
        String actualCellValue = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedCellValue = "Kabil";
        Assert.assertEquals(expectedCellValue,actualCellValue);

        //try to find how many rows are being used
        System.out.println("Last number of the sheet: "+workbook.getSheet("Sayfa2").getLastRowNum());

        // how many used rows we have in the second sheet
        System.out.println("number of used rows in the sheet: "+workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());

        Map<String,String> countriesMap = new TreeMap<>();
        String key;
        String value;
        int lastRowNumberOfSheet = workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <lastRowNumberOfSheet ; i++) {
            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+"-"+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+"-"+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            countriesMap.put(key,value);
        }
        System.out.println(countriesMap);

        for (String eachkey: countriesMap.keySet()
             ) {
            System.out.println(eachkey);
            System.out.println(countriesMap.get(eachkey));
        }




    }
}
