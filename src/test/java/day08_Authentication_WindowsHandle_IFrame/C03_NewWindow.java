package day08_Authentication_WindowsHandle_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_NewWindow {

    WebDriver driver;

    @Before
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown () throws InterruptedException {

        Thread.sleep(500);
        // driver.close();
        // to close all dirver
        driver.quit();

    }

    @Test
    public void test01() throws InterruptedException {


        driver.get("https://www.amazon.com/");

        String actualTitleText = driver.getTitle();
        String expectedKey = "Amazon";

        Assert.assertTrue(actualTitleText.contains(expectedKey));
        Thread.sleep(500);

        // to open new tab we use this code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com/");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
}
