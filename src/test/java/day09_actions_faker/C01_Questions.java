package day09_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Questions extends TestBase {

    // go to the http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe
    // locate "The iframe element" texted element
    // then print the text of this element

    @Test
    public void test01(){
        // go to the http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");


        // locate "The iframe element" texted element
        /*
        1) first locate the iframe the use it in switch to method
        WebElement iframe = driver.findElement(By.id("iframeResult")
        driver.switchTo().frame(iframe);

        2)we can use index of iframe
        driver.switchTo().frame.(1);

        3)we can use iframe id to switch it
        driver.switchTo().frame("iframeResult");
         */
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);
        WebElement iFrame = driver.findElement(By.xpath("//h1[normalize-space()='The iframe element']"));

        // then print the text of this element
        System.out.println(iFrame);


    }
}
