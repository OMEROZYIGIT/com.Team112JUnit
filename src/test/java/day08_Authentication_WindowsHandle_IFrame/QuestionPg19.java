package day08_Authentication_WindowsHandle_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class QuestionPg19 {
    /*
    1) Go to http://demo.guru99.com/test/guru99home/
    2) Find the number of iframes on the page.
    3) Click the (YouTube) play button in the first iframe
    4)exit the first iframe and return to the main page
    5)Click the (Jmeter Made Easy) link (https://www.guru99.com/live
    selenium project.html) in the second iframe
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
        // 2 Go to https://demo.guru99.com/test/guru99home/
        driver.get("https://demo.guru99.com/test/guru99home/");

        Thread.sleep(500);

        // 2) Find the number of iframes on the page.
        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        // print your number of frames
        System.out.println(iframes.size());

        // 3) Click the (YouTube) play button in the first iframe
        WebElement iframe = driver.findElement(By.xpath(""));






    }

}
