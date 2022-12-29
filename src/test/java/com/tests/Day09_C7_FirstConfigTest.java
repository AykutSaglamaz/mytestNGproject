package com.tests;

import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_C7_FirstConfigTest {

    @Test
    public void firstConfigTest() throws InterruptedException {
      //   app_url  'e git
      //   Title'in' Caretta Hotel - Home oldugunu assert et

      //   Driver.getDriver().get("http://www.carettahotel.com/");
      //   ConfigReader.getProperty("app_url")   ===>>>> http://www.carettahotel.com/

        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url"));
        Thread.sleep(5000);

        //   Title'in' Caretta Hotel - Home oldugunu assert et
        String actualTitle = Day09_C4_Driver.getDriver().getTitle();
        String expectedTitle = Day09_C6_ConfigReader.getProperty("app_title");

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
