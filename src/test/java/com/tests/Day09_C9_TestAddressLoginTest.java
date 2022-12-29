package com.tests;

import com.github.javafaker.Faker;
import com.pages.Day09_C8_TestAddressLoginPage;
import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;
import org.testng.annotations.Test;

public class Day09_C9_TestAddressLoginTest {

    @Test
    public void testAddressLogin(){
        //Going to the application page
        //Day09_C4_Driver.getDriver().get("https://www.testyou.in/Login.aspx);
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("test_address_url"));

        //Creating page object
        Day09_C8_TestAddressLoginPage testAddressLoginPage = new Day09_C8_TestAddressLoginPage();

        //Signing in
        testAddressLoginPage.email.sendKeys(Day09_C6_ConfigReader.getProperty("test_address_email"));
        testAddressLoginPage.password.sendKeys(Day09_C6_ConfigReader.getProperty("test_address_password"));
        testAddressLoginPage.loginButton.click();

        //closing the driver
        Day09_C4_Driver.closeDriver();

        //Diyelim ki 100 tane test case'niz var ve hepsinde password kullanmissiniz
        // daha sonra password degirse ne yaparsiniz
        //config.properties olmadan tum 100 test'e gidip her biri icin password degistirmemis lazim
        // config.properties ile configuration.properties'deki file gidip sadece passwork key icin value kismini degistir
    }
}
