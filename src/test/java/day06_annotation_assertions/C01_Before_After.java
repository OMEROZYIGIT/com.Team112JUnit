package day06_annotation_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Before_After {

    // create 3 different test methods
    // for each method create a dirver

    // 1) go to https://www.amazon.com
    // 2) wisequarter.com
    // 3) youtube.com
    // in all method print the title of website


    // to be able to reach a variable from all method, we need to create in class level
    WebDriver driver;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("Setup is executed");

    }
    @After
    public void tearDown(){

        driver.close();
        System.out.println("tearDown is executed");
    }
    @Test
    public void test01(){

        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test02(){

        driver.get("https://wisequarter.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test03() {

        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());

    }
}
