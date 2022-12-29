package com.tests.smoketest;

import com.pages.Day09_C12_LoginPage;
import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_C14_NegativeLoginTest {
    @Test

    public void invalidPassword(){
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url_login"));
//        Test Data:
//        Url: http://www.carettahotel.com/Account/Logon
//        user: manager
//        pw: Manager!

        Day09_C12_LoginPage loginPage = new Day09_C12_LoginPage();
  // eger private isterse
  loginPage.advancedLink.click();
  loginPage.proceedLink.click();
 //        When user enters wrong password only
        loginPage.username.sendKeys("manager");//right id
        loginPage.password.sendKeys("Manage!");//wrong pass
        loginPage.loginButton.click();

// Then verify the error message includes “Wrong password”
        String actualErrorMessage=loginPage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains("Wrong password"));

        Day09_C4_Driver.closeDriver();

    }
    @Test
    public void invalidID(){
//        invalidID()
//        When user enters wrong id only
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url_login"));
        Day09_C12_LoginPage loginPage = new Day09_C12_LoginPage();

        // eger private isterse
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        loginPage.username.sendKeys(Day09_C6_ConfigReader.getProperty("wrong_manager_username"));//wrong id

        loginPage.password.sendKeys(Day09_C6_ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();


//        Then verify the error message includes “Try again please”
        String actualErrorMessage = loginPage.errorMessage.getText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue(actualErrorMessage.contains("Try again please"));

        Day09_C4_Driver.closeDriver();
//        Test Data:
//        Url: http://www.carettahotel.com/Account/Logon
//        user: manager123
//        pw: Manager1!
    }

    @Test
    public void invalidIDandPassword(){
//        invalidIDAndPassword()
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url_login"));
        Day09_C12_LoginPage loginPage = new Day09_C12_LoginPage();

        // eger private isterse
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        loginPage.username.sendKeys(Day09_C6_ConfigReader.getProperty("wrong_manager_username"));//wrong id
        loginPage.password.sendKeys(Day09_C6_ConfigReader.getProperty("wrong_manager_password"));//wrong password
        loginPage.loginButton.click();

//        Then verify the error message includes “Username or password is incorrect, please correct them and try again”
        String actualErrorMessage = loginPage.errorMessage.getText();
        System.out.println(actualErrorMessage);
        Assert.assertTrue(actualErrorMessage.contains("Username or password is incorrect, please correct them and try again"));

        Day09_C4_Driver.closeDriver();
        //        Test Data:
//        Url: http://www.carettahotel.com/Account/Logon
//        user: manager123
//        pw: Manage!
    }
}
