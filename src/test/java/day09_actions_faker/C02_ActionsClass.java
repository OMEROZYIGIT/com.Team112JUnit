package day09_actions_faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class C02_ActionsClass extends TestBase {
    /*
        1) Let's create a new class: MouseActions1
        2) Go to https://the-internet.herokuapp.com/context_menu
        3) Right-click on the drawn area
        4) Test that the text in Alert is “You selected a context menu.”
        5) Let's close the alert by saying OK
        6) Click on Elemental Selenium link
        7) Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.
     */

    @Test
    public void test01(){
        // 2) Go to https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3) Right-click on the drawn area
        WebElement rightClickArea = driver.findElement(By.id("hot-spot"));

        // to use premade methods from Actions class, we need to create an object from it
        Actions actions = new Actions(driver);

        // to right-click on a webelement: contectClick(WenElement)
        // to use action class in action, at the end we need to write perform() method
        actions.contextClick(rightClickArea).perform();

        // 4) Test that the text in Alert is “You selected a context menu.”
        String actualAlertTest = driver.switchTo().alert().getText();
        String expectedAlertTest = "You selected a context menu";

        assertEquals(expectedAlertTest,actualAlertTest);

        ReusableMethods.waitFor(1);

        // 5) Let's close the alert by saying OK
        driver.switchTo().alert().accept();

        // 6) Click on Elemental Selenium link
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        // 7) Let's test that "Elemental Selenium" is written in the h1 tag on the page that opens.
        String firstPageHW = driver.getWindowHandle();
        Set<String> handleValuesSet = driver.getWindowHandles();
        String secondTabHW ="";
        for (String each:handleValuesSet
             ) {
            if (!each.equals(firstPageHW)){
                secondTabHW = each;
            }
        }

        driver.switchTo().window(secondTabHW);
        WebElement elementalSelenium = driver.findElement(By.tagName("h1"));
        String actualText = elementalSelenium.getText();
        System.out.println(actualText);
        String expectedText = "Make sure your code lands";
        Assert.assertEquals(expectedText,actualText);

    }
}
