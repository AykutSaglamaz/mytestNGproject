package com.tests.smoketest;

import com.pages.Day09_C12_LoginPage;
import com.pages.Day09_C13_DefaultPage;
import com.pages.Day09_C16_HotelRoomPage;
import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day09_C15_HotelRoomCreation {

    Day09_C12_LoginPage loginPage;
    Day09_C13_DefaultPage defaultPage;
    Day09_C16_HotelRoomPage hotelRoomsPage;

    @BeforeMethod
    public void setUp(){
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url_login"));
        loginPage= new Day09_C12_LoginPage();

        // eger private isterse
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        loginPage.username.sendKeys(Day09_C6_ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(Day09_C6_ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();

        //asserting login success
        defaultPage= new Day09_C13_DefaultPage();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
    }


    @Test
    public void hotelRoomCreate() throws InterruptedException {
//Click on Hotel Management
        defaultPage.hotelManagementTab.click();
//Click on Hotel Rooms
        defaultPage.hotelRoomsTab.click();
//Click on Add Hotel Room
        hotelRoomsPage=new Day09_C16_HotelRoomPage();
        hotelRoomsPage.addHotelRoomLink.click();
//Enter All required fields
        //ID IS DROPDOWN
        Select select = new Select(hotelRoomsPage.idDropdown);
        select.selectByIndex(2);

        //Code
        hotelRoomsPage.code.sendKeys("discount code");

        //Name
        hotelRoomsPage.name.sendKeys("Royal King Room");

        //Location
        hotelRoomsPage.location.sendKeys("Royal King Palace Hotel in Downtown- New York");

        //Description
        hotelRoomsPage.description.sendKeys("This is the best room in the hotel");
//To enter a price, we can send keys, OR we can use actions class to drag and drop

        //Price
//        hotelRoomsPage.price.sendKeys("700");// WAY 1
        Actions actions = new Actions(Day09_C4_Driver.getDriver());//WAY 2
        Thread.sleep(2000);

//        actions.dragAndDrop(source,target).build().perform();
        actions.dragAndDrop(hotelRoomsPage.price700,hotelRoomsPage.price).build().perform();

        //Room Type
        Select roomTypeDropdown = new Select(hotelRoomsPage.roomTypeDropdown);
        roomTypeDropdown.selectByVisibleText("Studio");

        //Adult
        hotelRoomsPage.maxAdultCount.sendKeys("2");

        //Child
        hotelRoomsPage.maxChildrenCount.sendKeys("4");

        //approved
        hotelRoomsPage.isApprovedCheckbox.click();

        //save
        hotelRoomsPage.saveButton.click();


        //ASSERTION FAILS CAUSE WINDOW POP UP TAKES SOME TIME TO OPEN-less than a sec
        //synchronization ISSUE

        //WAY 1- Thread.sleep(1000) - not recommended - lazy
        //WAY 2- Explicit Wait - hardworking

        WebDriverWait wait = new WebDriverWait(Day09_C4_Driver.getDriver(),10);
        WebElement popupMessageElement = wait.until(ExpectedConditions.visibilityOf(hotelRoomsPage.popupMessage));
        //Verify the message: HotelRoom was inserted successfully
        //Asserting message
        Assert.assertEquals(popupMessageElement.getText(),"HotelRoom was inserted successfully");

        //Click OK
        hotelRoomsPage.okButton.click();

    }
}
