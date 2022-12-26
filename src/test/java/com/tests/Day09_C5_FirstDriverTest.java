package com.tests;

import com.utilities.Day09_C4_Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_C5_FirstDriverTest {
    /*
    Amazon'a git
    title'in 'Amazon'u icerdigini verify et-
    Day09_C4_Driver class calistigini check et
     */

    @Test
    public void amazonTitleTest(){
        // driver ----->>>>>> Day09_C4_Driver.getDriver()
        Day09_C4_Driver.getDriver().get("https://www.amazon.com");

        //title'in 'Amazon'u icerdigini verify et-
        String actualTitle = Day09_C4_Driver.getDriver().getTitle();

        //Day09_C4_Driver class calistigini check et
        Assert.assertTrue(actualTitle.contains("Amazon"));
    }

}
