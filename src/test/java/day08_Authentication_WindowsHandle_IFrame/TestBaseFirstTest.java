package day08_Authentication_WindowsHandle_IFrame;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class TestBaseFirstTest extends TestBase {

    @Test
    public void test01(){

        // go to amazon.com
        // Test that url has amazon
        driver.get("https://amazon.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrlWord = "amazon";

        Assert.assertTrue(actualUrl.contains(expectedUrlWord));
    }
}
