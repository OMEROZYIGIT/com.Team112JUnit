package day08_Authentication_WindowsHandle_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindowsHandle {

    // go to webpage https://the-internet.herokuapp.com/windows
    // test that "Opening a new window" text is a display
    // test that the tittle is "The Internet"
    // click on "Click Here" Button
    // test that "New Window" test is displayed.

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

        Thread.sleep(1000);
        // driver.close();
        // to close all dirver
        // driver.quit();

    }

    @Test
    public void test01() throws InterruptedException {

        // go to webpage https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        // test that "Opening a new window" text is a display
        WebElement text = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(text.isDisplayed());
        Thread.sleep(500);

        // test that the tittle is "The Internet"
        String tittle = driver.getTitle();
        Assert.assertTrue(tittle.contains("The Internet"));
        Thread.sleep(500);

        String firstPageHandleValue = driver.getWindowHandle();

        // click on "Click Here" Button
        WebElement newtab = driver.findElement(By.xpath("//a[normalize-space()='Click Here']"));
        newtab.click();
        Thread.sleep(500);

        // test that "New Window" test is displayed.
        WebElement text1 = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(text1.isDisplayed());

        Thread.sleep(1000);

        // test that the first page Url has internet
        driver.switchTo().window(firstPageHandleValue);
        String firstPageUrl = driver.getCurrentUrl();
        String expectedUrlWord = "internet";
        Assert.assertTrue(firstPageUrl.contains(expectedUrlWord));

        Thread.sleep(1000);

    }
}
