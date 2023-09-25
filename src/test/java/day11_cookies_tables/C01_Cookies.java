package day11_cookies_tables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    // Create a new class : cookiesAutomation
    //1) Go to Amazon homepage
    //2) list all cookies
    //3) Test that the number of cookies on the page is greater than 5
    //4) Test the value of the cookie with the name i18n prefs is USD
    //5) Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page
    //6) test that the cookie you added is added to the page
    //7) Delete the cookie whose name is skin and test it is deleted
    //8) delete all cookies and test if they are deleted

    @Test
    public void test01() {

        // 1) Go to Amazon homepage
        driver.get("https://www.amazon.com/");

        // 2) list all cookies
        Set<Cookie> cookies = driver.manage().getCookies();

        int index = 1;
        for (Cookie each: cookies
             ) {
            System.out.println(index+"- "+each);
            index++;
        }

        System.out.println("================= Test#1 ==============");
        System.out.println("Cookies size test");
        // 3) Test that the number of cookies on the page is greater than 5
        Assert.assertTrue(cookies.size()>5);

        System.out.println("================= Test#2 ==============");
        System.out.println("Value of cookie test");
        // 4) Test the value of the cookie with the name i18n prefs is USD
        String expectedCookieValue = "USD";
        String actualCookieValue = "";
        for (Cookie each: cookies
             ) {
            if (each.getName().equals("i18n-prefs")){
                actualCookieValue = each.getValue();
            }
        }
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // 5) Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page
        Cookie myCookie = new Cookie("my favorite cookie","chocolate");
        driver.manage().addCookie(myCookie);

        System.out.println("================= Test#3 ==============");
        System.out.println("my cookie page test");
        // 6) test that the cookie you added is added to the page
        Set<Cookie> amazonCookies = driver.manage().getCookies();
        int index2 = 1;
        for (Cookie eachCookie: amazonCookies
             ) {
            System.out.println(index2+"- "+eachCookie);
            index2++;
        }
        int expectedCookieNumber = 9;
        int actualCookieNumber = amazonCookies.size();
        Assert.assertEquals(expectedCookieNumber,actualCookieNumber);

        System.out.println("================= Test#4 ==============");
        System.out.println("delete the cookies");
        // 7) Delete the cookie whose name is skin and test it is deleted
        driver.manage().deleteCookieNamed("skin");
        amazonCookies = driver.manage().getCookies();
        boolean skincookie = true;
        for (Cookie eachCookie: amazonCookies
             ) {
            if (eachCookie.getName().equals("skin")){
                skincookie = false;
            }
        }
        Assert.assertTrue(skincookie);

        System.out.println("================= Test#5 ==============");
        System.out.println("delete all cookies");
        // 8) delete all cookies and test if they are deleted
        driver.manage().deleteAllCookies();
        amazonCookies = driver.manage().getCookies();
        Assert.assertEquals(0,amazonCookies.size());


    }
}
