package day13_excel_ScreenShoot_JsExecuter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C06_ScreenShotOfDesiredElement extends TestBase {

    @Test
    public void test01() throws IOException {
        // go the amazon.com
        // write "Nutella" to searchBox
        // and test that result has nutella keyword

        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualResultStr = result.getText();
        String expectedResultStr = "Nutella";

        Assert.assertTrue(actualResultStr.contains(expectedResultStr));

        // test a SS of result element
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHmmss");
        String date = ldt.format(dtf);

        String filePath = "target/ScreenShotsElements/SSElements"+date+".jpeg";

        File elementSS = new File(filePath);
        File tempFile = result.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(tempFile,elementSS);



    }
}
