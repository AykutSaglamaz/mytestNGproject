package com.tests.smoketest;

import com.pages.Day09_C11_MainPage;
import com.pages.Day09_C12_LoginPage;
import com.pages.Day09_C13_DefaultPage;
import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_C10_PositiveLoginTest {
    @Test
    public void positiveLoginTest(){
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url"));

        //1. page object olustur -MainPage, LoginPage -
        /*2. test class olustur
        - Page Objects olustur
            -MainPage object olustur
            - object kullanarak page elementleri cagir
        */
        Day09_C11_MainPage mainPage = new Day09_C11_MainPage();
        mainPage.mainPageLoginLink.click();

        //Bu noktada LoginPage deyiz
        //LoginPage object olustur
        Day09_C12_LoginPage loginPage = new Day09_C12_LoginPage();
//        loginPage.username.sendKeys("manager");
//        loginPage.password.sendKeys("Manager1!");
        //or
        loginPage.username.sendKeys(Day09_C6_ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(Day09_C6_ConfigReader.getProperty("manager_password"));

        loginPage.loginButton.click();

        //We need to automate the login success
        //We choose a CORE ELEMENT on the page

        //adduser buttonunu kullanarak login page'e giris yaptiginizi verify edin
        //At this point, we are on the Default Page

        Day09_C13_DefaultPage defaultPage = new Day09_C13_DefaultPage();
        boolean isLoggedIn = defaultPage.addUserButton.isDisplayed();

        Assert.assertTrue(isLoggedIn);


    }
}
