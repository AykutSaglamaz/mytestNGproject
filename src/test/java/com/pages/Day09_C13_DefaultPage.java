package com.pages;

import com.utilities.Day09_C4_Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day09_C13_DefaultPage {

    public Day09_C13_DefaultPage(){
        PageFactory.initElements(Day09_C4_Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addUserButton;

    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagementTab;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsTab;

    @FindBy(xpath = "(//span)[contains(@class,'username')]")
    public WebElement userID;
}
