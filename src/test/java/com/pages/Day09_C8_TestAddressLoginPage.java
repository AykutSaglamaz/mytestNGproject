package com.pages;

import com.utilities.Day09_C4_Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day09_C8_TestAddressLoginPage {
    //https://www.testyou.in/Login.aspx
    /*This is the page class
     Bu sinif yalnizca page objectleri ve onemli ana methodlari icerir*/
    //1.  constructor olustur
    //PageFactory.initElements  bu page objects'i calistirir
    public Day09_C8_TestAddressLoginPage(){
        PageFactory.initElements(Day09_C4_Driver.getDriver(),this);
    }

    //2.  page element bul/ olustur
    //NOTE:  8 locatorin Tumu kullanilabilir

    @FindBy(id="ctl00_CPHContainer_txtUserLogin")
    public WebElement email;

    @FindBy(id="ctl00_CPHContainer_txtPassword")
    public WebElement password;

    @FindBy(id="ctl00_CPHContainer_btnLoginn")
    public WebElement loginButton;
}
