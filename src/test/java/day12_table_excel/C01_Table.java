package day12_table_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_Table extends TestBase {

    //Create a Class D19_WebtablesHomework
    //Go to “https://demoqa.com/webtables” page
    //Print the headers found in Headers
    //Print the title of the 3rd column
    //Print all the data in the table
    //Print how many nonempty cells (data) are in the table
    //Print the number of rows in the table
    //Print the number of columns in the table
    //Print the 3rd column in the table
    //Print the Salary of the person whose "First Name" is Kierra in the table
    //Create a method on the Page , it will print the data for me when I enter the number of rows and columns from the Test page.

    @Test
    public void test01() {

        //Go to “https://demoqa.com/webtables” page
        driver.get("https://demoqa.com/webtables");

        //Print the headers found in Headers
        WebElement headersWebElement = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("Headers: \n--------\n"+headersWebElement.getText());

        //Print the title of the 3rd column
        /*
                *save all tittles in a list
                * from the list take the third element
         */
        System.out.println("============ 3. Header =================");
        List<WebElement> tittleList = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println(tittleList.get(2).getText());

        //Print all the data in the table
        System.out.println("============ Datas =================");
        WebElement tableBody = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("Body of the table: \n---------\n"+tableBody.getText());

        //Print how many nonempty cells (data) are in the table
        System.out.println("==================== DataList =================");
        List<WebElement> allDataList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        int counter = 0;
        for (WebElement each:allDataList
             ) {
            if (!each.getText().equals("") || each.getText().equals(" ")){
                counter++;
                System.out.println(each.getText());
            }
        }
        System.out.println("number of data: "+counter);

        //Print the number of rows in the table
        System.out.println("==================== Number of Rows =================");
        List<WebElement> rowsList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Number of Rows: "+rowsList.size());

        //Print the number of columns in the table
        System.out.println("==================== Number of Columns =================");
        List<WebElement> columnList = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("Number of Columns: "+columnList.size());

        //Print the 3rd column in the table
        System.out.println("==================== 3rd column in the table =================");
        List<WebElement> tirdrdColumnDataValues = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])//div[3]"));
        for (WebElement each:tirdrdColumnDataValues
             ) {
            System.out.println(each.getText());
        }

        //Print the Salary of the person whose "First Name" is Kierra in the table
        System.out.println("=========== the Salary of the person whose First Name is Kierra in the table ==============");
        for (int i = 0; i < allDataList.size() ; i++) {
            if(allDataList.get(i).getText().equals("Kierra")){
                System.out.println(allDataList.get(i+4).getText());
            }
        }

        //Create a method on the Page, it will print the data for me when I enter the number of rows and columns from the Test page.
        String valueOfData = getTableValueUsingRowAndColumn(1,4);
        System.out.println("value of desired data: "+valueOfData);


    }

    public String getTableValueUsingRowAndColumn(int row, int column) {

        String xpath = "//div[@class='rt-tr-group']["+row+"]//div["+column+"]";
        WebElement valueWebElement = driver.findElement(By.xpath(xpath));
        String valueOfElement = valueWebElement.getText();
        return valueOfElement;

    }
}
