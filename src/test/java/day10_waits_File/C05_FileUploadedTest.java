package day10_waits_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_FileUploadedTest extends TestBase {

    @Test
    public void test01() {

        // 1. let's create a class under the Tests package:
        // 2. go to https://the-internet.herokuapp.com/upload
        // 3. press  chooseFile button
        // 4. select the file you want to upload
        // "File Uploaded" is display

        // 2. go to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        // 3. press chooseFile buttons
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

                                        // "C:\Users\Zenbook  + \OneDire\Masaüstü\HelloJava.txt
                                        // ortak kısım + istediğin dosya
                                        // her bilgisayar için ortak olan user.home
        String dynamicPath = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\HelloJava.txt";

        chooseFileButton.sendKeys(dynamicPath);

        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        WebElement uploadedText = driver.findElement(By.xpath("//div[@id='uploaded-files']"));
        Assert.assertTrue(uploadedText.isDisplayed());

        ReusableMethods.waitFor(3);


    }
}
