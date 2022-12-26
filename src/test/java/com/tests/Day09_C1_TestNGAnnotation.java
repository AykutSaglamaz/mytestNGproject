package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day09_C1_TestNGAnnotation {
    /*
     * @Test Test Cases olusturmak icin TestNG
     * @BeforeMethod her @Test Annotation once kosmasi icin kullanilir. JUnit deki @Before ile ayni
     * @AfterMethod her @Test annotation sonra kosmasi icin kullanilir
     * @Ignore bir @Test annotation atlamak icin
     *
     * @Test(enabled = false) de ayrica @Test annotation atlamak icin kullanilir.  @Ignore gibidir
     *
     * Test cases siralama:
     * TestNG test case'leri alfabetik siraya gore kosturur-NOT FROM TOP BOTTOM
     *  test case icinde priority kullanarak siralama yapabiliriz
     * @Test(priority = 1 )
     *
     *neden @BeforeMethod annotation?
     * - on conditions/sartlar - driver'i olustur, maximizing screen, timeouts, ... tekrari engeller
     *
     *neden @AfterMethod annotation?
     * -Post conditions - driver'i kapamak icin, tekrardan kacinmak icin, report generate
     *neden @Test annotation?
     * -test case olusturmak icin.
     * */
    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }
    @Test(priority = 1 )
    public void test6(){
        System.out.println("Test 1");
    }

    //    @Test(enabled = false)
//    public void test2(){
//        System.out.println("Test 2");
//    }
//    @Ignore
//    @Test
//    public void test3(){
//        System.out.println("Test 3");
//    }

    @Test(priority = -3, groups="regression-group-1")
    public void test4(){
        System.out.println("Test 4");
    }
    @Test(priority = 2, groups="regression-group-1")
    public void test5(){
        System.out.println("Test 5");
    }
}
