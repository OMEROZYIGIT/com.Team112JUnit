package day06_annotation_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_RadioButton {
    /*
    Create the required structure and complete the following task.
    a. Go to the given web page.
    https://facebook.com
    b. Accept cookies
    c. Press the Create an account button
    d. Locate the radio button elements and choose the one that suits you
     */
    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }
    @After
    public void tearDown(){

        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // a. Go to the given web page.
        //    https://facebook.com
        driver.get("https://www.facebook.com/");

        // c. Press the Create an account button
        WebElement createAccount = driver.findElement(By.xpath(""));
        createAccount.click();
    }
}
