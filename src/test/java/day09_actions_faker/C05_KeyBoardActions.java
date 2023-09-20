package day09_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_KeyBoardActions extends TestBase {

    // 1) Let's create a Class KeyboardActions1
    // 2) Go to https://www.amazon.com
    // 3) Type S amsung A71 using actions methods in the search box and press Enters to search
    // 4) test that the search is completed in amazon website


    @Test
    public void test01() {

        // 2) Go to https://www.amazon.com
        driver.get("https://www.amazon.com/");

        // 3) Type Samsung A71 using actions methods in the search box and press Enters to search
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
        actions.keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71"+Keys.ENTER)
                .perform();

        ReusableMethods.waitFor(5);
    }
}
