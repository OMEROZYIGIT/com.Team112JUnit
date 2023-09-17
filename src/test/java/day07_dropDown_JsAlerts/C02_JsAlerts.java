package day07_dropDown_JsAlerts;

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

public class C02_JsAlerts  {

    // set required options
    // go to https://the-internet.herokuapp.com/javascript_alerts
    // create three different methods to click Alerts
    // handle them

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

    }
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickForJsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        clickForJsAlert.click();

        // when we see a js alert, we need to switch our driver to that alert
        // to accept the jsAlert
        // driver.switchTo().alert().accept();

        // test that jsAlert text is " I am a JS Alert"
        String actualTextOfJsAlert = driver.switchTo().alert().getText();
        String expectedTextOfJsAlert = "I am a JS Alert";
        Assert.assertEquals(expectedTextOfJsAlert,actualTextOfJsAlert);

        driver.switchTo().alert().accept();


    }
    @Test
    public void test(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();

        driver.switchTo().alert().accept();

        WebElement resultText =driver.findElement(By.xpath("//p[@id='result']"));

        String actualText = resultText.getText();
        String expectedText = "You clicked: Ok";

        Assert.assertEquals(expectedText,actualText);

    }
     @Test
    public void test03(){
        // test click for js prompt
         // after entering java and clicking ok,test that result text is "you entered:java"
         // go website
         driver.get("https://the-internet.herokuapp.com/javascript_alerts");

         // click on click for js Prompt buttom
         WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
         jsPrompt.click();

         // write "java" on JS alert
         driver.switchTo().alert().sendKeys("Java");

         // accept js alert
         driver.switchTo().alert().accept();

         // take the text of Result and test that result text is "You entered: java"
         String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
         String expectedResultRest = "You entered: Java";

         Assert.assertEquals(expectedResultRest,actualResultText);

     }
     @Test
    public void test04(){
        // test that when we click on 3rd button and cancel result text is "You entered: null"
         driver.get("https://the-internet.herokuapp.com/javascript_alerts");

         // click on click for js Prompt buttom
         WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
         jsPrompt.click();

         driver.switchTo().alert().dismiss();

         String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
         String expectedResultRest = "You entered: null";

         Assert.assertEquals(expectedResultRest,actualResultText);
     }
}
