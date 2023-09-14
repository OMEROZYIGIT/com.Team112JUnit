package day06_annotation_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClass_AfterClass {

    //div[@class='********'] --> to get uniqe locator

    // create 3 test method
    // 1) go to the amazon.com and test that you are in amazon.com
    // 2) search for nutella and test that you have searched for nutella
    // 3) test that there are more than 50 result of nutella

    static WebDriver driver;

    @BeforeClass
    public static void  setUp(){


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public  void tearDown () throws InterruptedException {

        Thread .sleep(2000);
        driver.close();
    }

    @Test
    public  void test01(){

        driver.get("https://www.amazon.com/");
        String expectedUrlWord = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlWord)){
            System.out.println("URL check Test PASSED");
        }else {
            System.out.println("URL check Test FAILED");
        }
    }

    @Test
    public void test02(){

        // 2) search for nutella and test that you have searched for nutella
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("nutella"+ Keys.ENTER);

        WebElement text = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedText = "Nutella";
        String actualText = text.getText();

        if (actualText.contains(expectedText)){
            System.out.println("Text Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }


    }

}
