package com.excelautomation;

import com.pages.Day09_C12_LoginPage;
import com.pages.Day09_C13_DefaultPage;
import com.utilities.Day09_C20_ExcelUtil;
import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day09_C23_LoginSmokeTest {

    // ExcelUtil object olustur (methodlara erisim icin)
    Day09_C20_ExcelUtil excelUtil;
    //data'yi  key-value pairs (username, password) olarak al

    //username-password degerlerini depolamak icin testData kullanacagim
    // one map ===>>> Map<String, String>    : {manager,	Manager1!}
    //list of Map ====>>>> List<Map<String,String>> : {{manager,	Manager1!},{manager5,	Manager5!},{manager12	Manager12!}}
    List<Map<String, String>> testData;

    //page objects model
    Day09_C12_LoginPage loginPage;
    Day09_C13_DefaultPage defaultPage;

    public void setUp() throws InterruptedException {
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url_login"));
        loginPage = new Day09_C12_LoginPage();
        Thread.sleep(1000);
//        if (loginPage.advancedLink.isDisplayed()){
        try{
            Thread.sleep(1000);
            loginPage.advancedLink.click();
            Thread.sleep(1000);
            loginPage.proceedLink.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Advanced Link and Proceed Link is not displayed");
        }

//        }
    }

    @Test
    public void adminLoginTest() throws InterruptedException {
        /*  1.yol
        setUp() aplikasyona giris icin kullanilir
        setUp();
        loginPage.username.sendKeys("manager");
        loginPage.password.sendKeys("Manager1!");
        loginPage.loginButton.click();

         */

        //2.yol

        String path ="./src/test/java/resources/smoketestdata.xlsx";
        String sheetName="admin_login_info";
        excelUtil= new Day09_C20_ExcelUtil(path,sheetName);

        testData = excelUtil.getDataList();
        System.out.println(testData);//[{password=Arcane123!, username=admin}]

        for(Map<String,String> eachData : testData ){//herData bir username-password pairs temsil eder
            setUp();//login in each loop
            loginPage.username.sendKeys(eachData.get("username"));//admin
            loginPage.password.sendKeys(eachData.get("password"));//Arcane123!
            loginPage.loginButton.click();
        }
    }
    @Test
    public void managerLoginTest() throws InterruptedException {

        String path ="./src/test/java/resources/smoketestdata.xlsx";
        String sheetName="manager_login_info";
        excelUtil= new Day09_C20_ExcelUtil(path,sheetName);

        testData=excelUtil.getDataList();
        System.out.println(testData);// [{password=Manager1!, username=manager}, {password=Manager5!, username=manager5}, {password=Manager12!, username=manager12}]

        for(Map<String,String> eachData : testData ){//herData bir username-password pairs temsil eder
            setUp();//login in each loop
            loginPage.username.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.loginButton.click();
        }
    }

    @AfterMethod
    public void tearDown(){
        Day09_C4_Driver.closeDriver();
    }
}

