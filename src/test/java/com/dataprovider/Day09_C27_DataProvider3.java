package com.dataprovider;

import com.pages.Day09_C12_LoginPage;

import com.utilities.Day09_C18_ReusableMethods;
import com.utilities.Day09_C20_ExcelUtil;
import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day09_C27_DataProvider3 {
    /*EXCEL AND DATA PROVIDER kullanarak manager kullanici bilgileri ile login fonksiyonunu test et
     *test data'yi saklamak icin Excel kullaniriz
     *DATA'yi iletmek icin DATAPROVIDER kullaniriz
     *DATA PROVIDER, EXCEL ile TEST CLASS arasinda bir kopru gorevi gorecektir
     *Excel'den data provider ile data almak daha kolaydir bu nedenle DataProvider kullaniriz
     */

    @DataProvider
    public Object[][] getData(){

        String path ="./src/test/java/resources/smoketestdata.xlsx";
        String sheetName="manager_login_info";

        Day09_C20_ExcelUtil excelUtil = new Day09_C20_ExcelUtil(path,sheetName);

        Object [][] managerProfile = excelUtil.getDataArrayWithoutFirstRow();

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
