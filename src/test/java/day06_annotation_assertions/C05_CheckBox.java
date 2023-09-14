package day06_annotation_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_CheckBox {
    /*
    Create the required structure and complete the following task.
    a. Go to the given web page.
    https://the internet.herokuapp.com/checkboxes
    b. Locate the checkbox1 and checkbox2 elements.
    c. Click the checkbox if Checkbox1 is not selected
    d. Click the checkbox if Checkbox2 is not selected
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

        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // a. Go to the given web page.
        // https://the internet.herokuapp.com/checkboxes
       driver.get("https://the-internet.herokuapp.com/checkboxes");

        // b. Locate the checkbox1 and checkbox2 elements.
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));

        // c. Click the checkbox if Checkbox1 is not selected.
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }

        // d. Click the checkbox if Checkbox2 is not selected
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
        Thread.sleep(500);

    }

}
