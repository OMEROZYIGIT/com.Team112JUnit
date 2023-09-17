package day07_dropDown_JsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    // 1) locate the webElement

    WebDriver driver;

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
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com/");
        WebElement dropDownWebElement = driver.findElement(By.id("searchDropdownBox"));

        // selenium developers have created a select class for us
        // if we face a problem shown by a red line, we can always hold down ctrl key, and
        // when we create a select object, we have to write dropdown
        Select select = new Select(dropDownWebElement);
        select.selectByVisibleText("Books");

        // getFirstSelectedOptions returns the selected option
        String expectedSelectedObjectText = "Books";
        String actualSelectedObjectText = select.getFirstSelectedOption().getText(); // Books

        Assert.assertEquals(expectedSelectedObjectText,actualSelectedObjectText);

        select.selectByIndex(7);  // because of this numnber, it chose index 7th option starting from zero

        select.selectByValue("search-alias=digital-music");

        // search for "java" in search-alias=digital-music and test that title has java word

        // refresh the page
        driver.navigate().refresh();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);

        String expectedWord = "Java";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedWord));

        /*
        When we refresh the page, it takes new information from the servers so a system will create a newer page for us
        it can be totally same with the previous one, but it is actually a newer version,
        so we can need to relocate all elements to use them,otherwise we may face StaleElementException
         */
        dropDownWebElement = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(dropDownWebElement);

        // to get all the options of a dropdown
        List<WebElement> listOfOptions = select.getOptions();
        //test that the dropdown has 28 options
        int expectedOptionsNumber = 28;
        int actualOptionsNumber = listOfOptions.size();

        Assert.assertEquals(expectedOptionsNumber,actualOptionsNumber);


        Thread.sleep( 1000);
    }
}
