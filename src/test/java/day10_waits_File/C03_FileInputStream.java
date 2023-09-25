package day10_waits_File;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C03_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {

        String filePath = "C:\\Users\\Zenbook\\OneDrive\\Masaüstü\\HelloJava.txt";   // the path is not dynamic it will only work local pc

        FileInputStream fis = new FileInputStream(filePath);

        // to create a dynamic path
        System.out.println(System.getProperty("user.dir"));
        // C:\Users\Zenbook\IdeaProjects\com.Team112JUnit

        System.out.println(System.getProperty("user.home"));
        // C:\Users\Zenbook

        String dynamicPath = System.getProperty("user.home")+"\\Masaüstü\\HelloJava.txt";
        FileInputStream fis2 = new FileInputStream(dynamicPath);


    }
}
