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

public class C02_IFrame {
    /*
    1) Go to https://the-internet.herokuapp.com/iframe
    2 ) Create a method: iframeTest
    -
    -“An IFrame containing….” Test that the text is accessible and print it in the
    console.
    -
    Write "Hello World!" to Text
    -
    Verify that the text of the “Elemental Selenium” link at the bottom of the
    TextBox is visible and print it on the console
     */
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
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // 1 Create a class: BasicAuthentication
        // 2 Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        Thread.sleep(500);

        WebElement bigText = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(bigText.isEnabled());
        System.out.println(bigText.getText());

        Thread.sleep(500);

        // to locate an element inside an iframe, you need to switch your driver to the that frame
        // first we can use iframe's is or name
        // driver.switchTo().frame("mce_0_ifr");

        // second, we can use iframe index
        // driver.switchTo().frame(0);

        // third, we can locate the iframe first than use the webelement to switch
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Hello Word!");

        Thread.sleep(1000);

        // to back to main page(main framepage) driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        WebElement elemantalSelenium = driver.findElement(By.id("page-footer"));

        // it will test if the selenium text is display
        Assert.assertTrue(elemantalSelenium.isDisplayed());
        System.out.println(elemantalSelenium.getText());


    }
}
