package day09_actions_faker;

import org.junit.Test;
import utilities.TestBase;

public class C03_DragAndDrop extends TestBase {

    // Let's create a new class: MouseActions2
    //1 Let's go to https://demoqa.com/droppable
    //2 Let's hold the "Drag me" button and drop it above the "Drop here" box
    //3 Test that Instead of “Drop here” text “Dropped!” text is there


    @Test
    public void test01() {
        //1) Let's go to https://demoqa.com/droppable
        driver.get("https://demoqa.com/droppable");

        //2) Let's hold the "Drag me" button and drop it above the "Drop here" box
    }
}
