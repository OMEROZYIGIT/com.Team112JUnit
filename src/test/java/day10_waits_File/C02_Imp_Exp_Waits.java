package day10_waits_File;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_Imp_Exp_Waits {

    // 1. Create a class: WaitTest
    // 2. Create two methods: implicitWait
        // Test () , explicitWait Test
        // the following steps for both methods.
    // 3. Go to https://the-internet.herokuapp.com/dynamic_controls.
    // 4. Press the Remove button.
    // 5. “It's gone!” Verify that the message is displayed.
    // 6. Press Add button
    // 7. Test that its back message appears


    WebDriver driver;

    @Before
    public void setUp (){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown (){

        driver.close();
    }

    @Test
    public void implicitWaitTest(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Go to https://the-internet.herokuapp.com/dynamic_controls.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Press the Remove button.
        driver.findElement(By.xpath("//button[normalize-space()='Remove']")).click();

        // 5. “It's gone!” Verify that the message is displayed.
        String expectedMessage = "It's gone!";
        WebElement actualMessage = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(actualMessage.isDisplayed());

        // 6. Press Add button
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

        // 7. Test "It's back!" message appears
        WebElement actualMessage2 = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(actualMessage2.isDisplayed());

    }

    @Test
    public void explicitWaitTest(){

        // 3. Go to https://the-internet.herokuapp.com/dynamic_controls.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Press the Remove button.
        driver.findElement(By.xpath("//button[normalize-space()='Remove']")).click();

        // 5. “It's gone!” Verify that the message is displayed.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        WebElement actualMessage = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(actualMessage.isDisplayed());

        // 6. Press Add button
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

        // 7. Test that its back message appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement actualMessage2 = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(actualMessage2.isDisplayed());


    }
}
