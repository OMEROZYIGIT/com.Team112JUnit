package day08_Authentication_WindowsHandle_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C05_WindowsHandle {
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
        // to close all driver
        driver.quit();

    }

    @Test
    public void test01() throws InterruptedException {

        // go to webpage https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        // click on a selenium link
        driver.findElement(By.xpath("//a[normalize-space()='Elemental Selenium']")).click();

        // when you clicked test that the new tabs title has EthernalSelenium
        String actualTitle = driver.getTitle();
        String expectedTitleWord = "Elemental Selenium";

        // test the text "Elemental Selenium"
        Assert.assertEquals(expectedTitleWord,actualTitle);
        System.out.println(actualTitle);


        // we cannot get the second tab's unique handle value without visiting there
        // driver.getWindowHandles() this method will bring all tab's unique handle values.Our drive is still in the first
        // tab, so we can reach the first tab's unique handle value
        // by comparing these handle values I can reach the different handle value, and it will be second tab's handle value

        String firstTabHandleValue = driver.getWindowHandle();
        Set<String> handleValues = driver.getWindowHandles();
        String secondTabsHandleValues ="";
        for (String each:handleValues
             ) {
            if (!firstTabHandleValue.equals(each)){
                secondTabsHandleValues = each; // here we will be able to receive the second tab's handle value
            }
        }
        // to take my driver to the second tab
        driver.switchTo().window(secondTabsHandleValues);

        String expectedTitleWord2 = "Selenium";
        String actualTitle2 = driver.getTitle();
        System.out.println(actualTitle2);

        Assert.assertTrue(actualTitle2.contains(expectedTitleWord2));


        Thread.sleep(2000);

    }
}
