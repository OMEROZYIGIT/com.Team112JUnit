package day06_annotation_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C03_Assertion {

    int P1age = 66;
    int P2age = 70;
    int P3age = 77;

    @Test
    public void test01(){
        Assert.assertTrue(P3age>70);
    }

    @Test
    public void test02(){

        Assert.assertFalse(P1age>70);

    }
    @Test
    public void test03(){

        Assert.assertEquals(14,14);
        Assert.assertNotEquals(14,95);

    }
}


