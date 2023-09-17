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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class QuestionPage7 {
    /*
    1. Go to
    http://zero.webappsecurity.com/
    2. Press Sign-in button
    3. Type “username” in Login box
    4. Type “password.” in the Password box.
    5. Press Sign-in button
    6. Go to the Pay Bills page
    7. Press the “Purchase Foreign Currency” key
    8. Select Eurozone from “Currency” drop down menu
    9. Enter a number in “amount” box
    10. Test that “US Dollars” is not selected
    11. Select “Selected currency” button
    12. Press the “Calculate Costs” button then “purchase” button
    13. “Foreign currency cash was successfully purchased.” Check that the text is visible
     */

    WebDriver driver ;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(1000);
        //driver.close();
    }

    @Test
    public void test01(){

        // 1. Go to http://zero.webappsecurity.com/
        driver.get("http://zero.webappsecurity.com/");

        // 2. Press Sign-in button
        WebElement singInButton = driver.findElement(By.xpath("//button[@id='signin_button']"));
        singInButton.click();

        // 3. Type “username” in Login box
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");
        // 4. Type “password.” in the Password box.
        WebElement passWord = driver.findElement(By.xpath("//input[@id='user_password']"));
        passWord.sendKeys("password");

        // 5. Press Sign-in button
        WebElement signin = driver.findElement(By.cssSelector("input[value='Sign in']"));
        signin.click();

        driver.navigate().back();

        // 6. Go to the Pay Bills page
        WebElement onlineBanking = driver.findElement(By.xpath("//strong[normalize-space()='Online Banking']"));
        onlineBanking.click();
        WebElement payBills = driver.findElement(By.xpath("//span[@id='pay_bills_link']"));
        payBills.click();

        // 7. Press the “Purchase Foreign Currency” key
        WebElement purchaseForeignCurrenncy = driver.findElement(By.xpath("//a[normalize-space()='Purchase Foreign Currency']"));
        purchaseForeignCurrenncy.click();

        // 8. Select Eurozone from “Currency” drop down menu
        WebElement dropDownElement = driver.findElement(By.id("pc_currency"));
        Select currency = new Select(dropDownElement);
        currency.selectByValue("EUR");

        // 9. Enter a number in “amount” box
        WebElement amount = driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amount.sendKeys("50");

        // 10. Test that “US Dollars” is not selected
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(radioButton.isSelected());

        // 11. Select “Selected currency” button
        WebElement selectedCurrency = driver.findElement(By.xpath("//input[@id='pc_inDollars_false']"));
        selectedCurrency.click();

        // 12. Press the “Calculate Costs” button then “purchase” button
        WebElement calculateCost = driver.findElement(By.xpath("//input[@id='pc_calculate_costs']"));
        calculateCost.click();
        WebElement purchase = driver.findElement(By.xpath("//input[@id='purchase_cash']"));
        purchase.click();

        // 13. “Foreign currency cash was successfully purchased.” Check that the text is visible
        String expectedTittle = "Foreign currency cash was successfully purchased";
        String actualTittle = driver.getTitle();

        if (actualTittle.contains(expectedTittle)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }









        // 6. Go to the Pay Bills page


    }
}
