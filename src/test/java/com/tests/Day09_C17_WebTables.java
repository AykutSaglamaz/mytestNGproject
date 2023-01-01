package com.tests;

import com.pages.Day09_C12_LoginPage;
import com.pages.Day09_C13_DefaultPage;
import com.pages.Day09_C16_HotelRoomPage;
import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day09_C17_WebTables {
//    When kullanici application'da HotelRoom sayfasina gider
        // Log in https://www.carettahotel.com/
        // Hotel Management'e Click yapar
        // Hotel Rooms'a Click yapar
//    test method: entireTable() ve tum header'lari yazdir
//    test method: printRows() ve tum row'lari ile 4 row'daki elementi yazdir
//    test method: printCells() ve table body'dek' cells'lerin toplam sayilarini yazdir ve tum cell'leri yazdir
//    test method: printColumns() ve columns'larin toplam sayisini yazdir ve 5. column yazdir
//    test method: printData(int row, int column); Bu method veriline cell'i yazdirmali
//    ornek : printData(2,3); 2. row ve 3 column yazdirmali


    Day09_C12_LoginPage loginPage;
    Day09_C13_DefaultPage defaultPage;
    Day09_C16_HotelRoomPage hotelRoomsPage;
    //    When kullanici application'da HotelRoom sayfasina gider
    public void setUp(){
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url_login"));
        loginPage= new Day09_C12_LoginPage();
        //private isterse
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        loginPage.username.sendKeys(Day09_C6_ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(Day09_C6_ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        //login basarili oldugunu assert et
        defaultPage= new Day09_C13_DefaultPage();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());

        //Hotel Management'e Click yapar
        defaultPage.hotelManagementTab.click();

        //Hotel Rooms'a Click yapar
        defaultPage.hotelRoomsTab.click();

        //Add Hotel Room'a click yapar
        hotelRoomsPage=new Day09_C16_HotelRoomPage();
    }

//    test method: entireTable() ve tum header'lari yazdir
    @Test(groups = "regression-group-1")
    public void entireTable(){
        setUp();
        System.out.println("*Entire Table*");
        System.out.println("*Table Body*");

        WebElement tableBody = Day09_C4_Driver.getDriver().findElement(By.xpath("//table//tbody"));
        System.out.println(tableBody.getText());
        List<WebElement> allHeaders = Day09_C4_Driver.getDriver().findElements(By.xpath("//th"));
        for (WebElement eachHeader : allHeaders){
            System.out.println(eachHeader.getText());
        }
    }

//    test method: printRows() olustur ve row sayisini ve 4. row'daki elementi yazdir
    @Test(groups = "regression-group-1")
    public void printRows(){
        setUp();
        System.out.println("*Print Rows*");
        List<WebElement> allRows = Day09_C4_Driver.getDriver().findElements(By.xpath("//tbody//tr"));

        //row sayisi
        int rowNum=1;
        for (WebElement eachRow : allRows){
            System.out.println("Row Number "+rowNum + " => "+eachRow.getText());
            rowNum++;
        }
        //yalnizca row4 yazdir
        WebElement row4 = Day09_C4_Driver.getDriver().findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("ROW 4 => "+row4.getText());
    }

//   test method: printCells() ve table body'dek' cells'lerin toplam sayilarini yazdir ve tum cell'leri yazdir
    @Test
    public void printCells(){
        setUp();
        System.out.println("*Print Cells*");
        List<WebElement> allCells = Day09_C4_Driver.getDriver().findElements(By.xpath("//tbody//td"));
        System.out.println("Total Cell Number => " +allCells.size());
        int cellNum=1;
        for (WebElement eachCell : allCells){
            System.out.println(cellNum +" : "+eachCell.getText());
            cellNum++;
        }
    }

//    test method: printColumns() ve columns'larin toplam sayisini yazdir ve 5. column yazdir
    @Test
    public void printColumns(){
        setUp();
        //columns'larin toplam sayisini yazdir
        List<WebElement> allHeaders = Day09_C4_Driver.getDriver().findElements(By.xpath("//th"));
        int numberOfColumn = allHeaders.size();
        System.out.println("There are "+numberOfColumn + " column.");

        // 5. column yazdir
        List<WebElement> column5Data = Day09_C4_Driver.getDriver().findElements(By.xpath("//table//tbody//tr//td[5]"));
        int columnNum=1;
        for (WebElement eachColumn : column5Data){
            System.out.println("Data "+columnNum+" : "+eachColumn.getText());
            columnNum++;
        }
    }

//    test method: printData(int row, int column); Bu method veriline cell'i yazdirmali
//    ornek : printData(2,3); 2. row ve 3 column yazdirmali

    @AfterMethod
    public void tearDown(){
        Day09_C4_Driver.closeDriver();
    }
}
