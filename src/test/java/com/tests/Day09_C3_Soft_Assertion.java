package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day09_C3_Soft_Assertion {
    /*
     * when kullanici application home page gider //http://www.carettahotel.com/
     * then title'in 'Caretta Hotel' oldugunu verify eder
     * And login button'a click eder
     * then page title'in 'Caretta Hotel - Log in' oldugunu verify eder
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
//        driver.close();
    }
    @Test
    public void softAssert(){
        driver.get("http://www.carettahotel.com/");

        //eger your connection is not private cikarsa
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        /*Step 1 : SoftAssert object olustur*/
        SoftAssert softAssert = new SoftAssert();

        /*Step 2 : softAssert object kullanarak assertion yap*/
        System.out.println(driver.getTitle());
        softAssert.assertTrue(driver.getTitle().equals("Caretta Hotels"));
        //Line 46 fails. fakat test calismaya devam eder cunku bu SOFT ASSERTION.

        //And login button'a click eder
        driver.findElement(By.linkText("Log in")).click();

        //then page title'in 'Caretta Hotel - Log in' oldugunu verify eder
        System.out.println(driver.getTitle());
        softAssert.assertTrue(driver.getTitle().equals("Caretta Hotel - Log in"));

        /*     !!! assertAll() kullan
         * Eger assertAll kallanmazsaniz, yanlis test sonucu alirsiniz
         */
        softAssert.assertAll();
    }
}