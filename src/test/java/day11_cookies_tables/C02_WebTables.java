package day11_cookies_tables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    // 1.Go to "https://www.amazon.com"
    // 2.Scroll to the bottom of page
    // 3.Print the entire body of the web table
    // 4.Test that the number of rows in the web table is 10
    // 5.Print all lines
    // 6.Test that the number of columns in the web table is 13
    // 7.print column 5
    // 8.Create a method that takes the number of rows and columns as parameters and returns the information in the cell


    @Test
    public void test01() {

        // 1.Go to "https://www.amazon.com"
        driver.get("https://www.amazon.com");

        // 2.Scroll to the bottom of the page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        // 3.Print the entire body of the web table
        WebElement tableBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tableBody.getText());

        // 4.Test that the number of rows in the web table is 9
        List<WebElement> trList = driver.findElements(By.xpath("//tbody/tr"));
        int actualNumberOfRows = trList.size();
        int expectedNumberOfRows = 8;

        Assert.assertEquals(expectedNumberOfRows,actualNumberOfRows);

        // 5.Print all lines
        for (WebElement eachElement: trList
             ) {
            System.out.println(eachElement.getText());
        }

        // 6.Test that the number of columns in the web table is 13
        List<WebElement> columnNumber = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedNumberOfColumn = 13;
        int actualNumberOfColumn = columnNumber.size();

        Assert.assertEquals(expectedNumberOfColumn,actualNumberOfColumn);

        // 7.print column 5
        System.out.println("================================");
        List<WebElement> ListOfColumn = driver.findElements(By.xpath("tbody/tr/td[5]"));
        for (WebElement eachElement: ListOfColumn
             ) {
            System.out.println(eachElement.getText());
        }

        // 8.Create a method that takes the number of rows and columns as parameters and returns the information in the cell
        WebElement cellValue = valueOfCell(3,7);

    }

    private WebElement valueOfCell(int rowNumber, int columnNumber) {

        String xpath = "//tbofy/tr["+ rowNumber +"]/td["+ columnNumber +"]";
        System.out.println(xpath);
        WebElement cellValueOfTable = driver.findElement(By.xpath(xpath));
        return cellValueOfTable;

    }
}
