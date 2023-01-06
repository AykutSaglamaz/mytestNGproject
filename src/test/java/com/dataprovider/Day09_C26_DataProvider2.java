package com.dataprovider;

import com.pages.Day09_C12_LoginPage;

import com.utilities.Day09_C18_ReusableMethods;
import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day09_C26_DataProvider2 {
    /*
     Manager kullanici bilgileri ile login fonksiyonunu test et
     getData method'unda 2D array donduren bir object olustur
     */

    @DataProvider
    public Object[][] getData(){

        Object [][] managerProfile= {
                {"manager","Manager1!"},
                {"manager5","Manager5!"},
                {"manager12","Manager12!"}
        };
        return managerProfile;
    }

    Day09_C12_LoginPage loginPage;
    //Create setUp method for prerequisite

    public void setUp(){
        loginPage = new Day09_C12_LoginPage();
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url_login"));
        try{
            Day09_C18_ReusableMethods.waitFor(1);
            loginPage.advancedLink.click();
            Day09_C18_ReusableMethods.waitFor(1);
            loginPage.proceedLink.click();
            Day09_C18_ReusableMethods.waitFor(1);
        }catch (Exception e){
            System.out.println("Advanced Link and Proceed Link is not displayed");
        }

    }
    @Test(dataProvider = "getData")
    public void managerLoginTest(String managerID, String managerPass){
        setUp();
        loginPage.username.sendKeys(managerID);
        loginPage.password.sendKeys(managerPass);
        loginPage.loginButton.click();
    }

    @AfterMethod
    public void tearDown(){
        Day09_C4_Driver.closeDriver();
    }
}
