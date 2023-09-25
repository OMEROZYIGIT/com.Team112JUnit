package day10_waits_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {

    // 1. let's create a class under the Tests package:
    // 2. go to https://the-internet.herokuapp.com/download
    // 3. Download the testpage.png file my hand
    // 4. let's test if the file was downloaded successfully


    @Test
    public void test01() {

        // 2. go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        // 3. Download the logo.png file my hand
        driver.findElement(By.xpath("//a[normalize-space()='testImage.png']")).click();
        ReusableMethods.waitFor(5);

                                                     // C:\Users\Zenbook\
        String downloadedFileDynamicPath = System.getProperty("user.home")+"\\Downloads\\testImage.png";
        // String staticPath = "C:\\Users\\Zenbook\\Downloads\\testImage.png";

        Assert.assertTrue(Files.exists(Paths.get(downloadedFileDynamicPath)));

        ReusableMethods.waitFor(5);

    }
}
