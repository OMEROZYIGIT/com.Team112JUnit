package day13_excel_ScreenShoot_JsExecuter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_TakeScreenShotOfAllPage extends TestBase {

    @Test
    public void test01() throws IOException {

        // go the amazon.com
        // write "Nutella" to searchBox
        // and test that result has nutella keyword

        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualResultStr = result.getText();
        String expectedResultStr = "Nutella";

        Assert.assertTrue(actualResultStr.contains(expectedResultStr));

        // take a screenshot of page
        // 1) create a screenshot object
        TakesScreenshot ss = (TakesScreenshot) driver;

        // 2) create a new file under the target file to locate the ss
        String filePath = "target/ScreenShots/fullPageSS.jpeg";
        File FullPageSS = new File(filePath);

        // 3) Step 3: Let's run the getScreenshotAs() method using the Takescreenshot object and
        // assign the incoming image to a temporary file
        File tempFile = ss.getScreenshotAs(OutputType.FILE);

        // 4): Let's copy the recorded image to the file we want to
        FileUtils.copyFile(tempFile,FullPageSS);


        ReusableMethods.fullPageScreenShot(driver);



    }
}
