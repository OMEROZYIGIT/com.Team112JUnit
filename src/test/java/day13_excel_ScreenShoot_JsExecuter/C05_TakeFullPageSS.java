package day13_excel_ScreenShoot_JsExecuter;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.IOException;

public class C05_TakeFullPageSS extends TestBase {


    @Test
    public void test01() throws IOException {

        driver.get("https://www.wisequarter.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        ReusableMethods.fullPageScreenShot(driver);


    }
}
