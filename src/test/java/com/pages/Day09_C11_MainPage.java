package com.pages;

import com.utilities.Day09_C4_Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day09_C11_MainPage {

    public Day09_C11_MainPage(){
        PageFactory.initElements(Day09_C4_Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement mainPageLoginLink;
}
