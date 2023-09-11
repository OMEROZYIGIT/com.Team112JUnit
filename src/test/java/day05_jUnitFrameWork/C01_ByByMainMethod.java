package day05_jUnitFrameWork;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C01_ByByMainMethod {

     @Before
    public void setUp(){
         System.out.println("Setup method is executed");
    }
    @After
    public void tearDown(){
        System.out.println("Tear method is executed");
        System.out.println("______________________________________");
    }

    @Test
    public void test01(){
        // Test to the @Test annotation a method can be executed
        // if there ise no assert

        System.out.println("Test01 is executed");
    }
    @Test
    public void test02(){

        System.out.println("Test02 is executed");
    }

    @Test
    public void test03(){

        System.out.println("Test03 is executed");
    }

}
