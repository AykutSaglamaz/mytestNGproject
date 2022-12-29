package com.pages;

import com.utilities.Day09_C4_Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day09_C12_LoginPage {

    public Day09_C12_LoginPage(){
        PageFactory.initElements(Day09_C4_Driver.getDriver(),this);
    }
    @FindBy(id="UserName")
    public WebElement username;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement errorMessage;

    @FindBy(id="details-button")
    public WebElement advancedLink;

    @FindBy(id="proceed-link")
    public WebElement proceedLink;

}
