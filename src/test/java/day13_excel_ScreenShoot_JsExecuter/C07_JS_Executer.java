package day13_excel_ScreenShoot_JsExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_JS_Executer extends TestBase {

    @Test
    public void test01() {

        driver.get("https://www.amazon.com");

        WebElement giftCards = driver.findElement(By.xpath("//a[normalize-space()='Gift Cards']"));

        // 1) First create a JavaScriptExecuter Object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();",giftCards);
        js.executeScript("alert('Thats it')");

        ReusableMethods.waitFor(5);

    }
}
