package com.javascriptexecutor;

import com.pages.Day09_C12_LoginPage;
import com.utilities.Day09_C18_ReusableMethods;
import com.utilities.Day09_C19_JSUtils;
import com.utilities.Day09_C4_Driver;
import com.utilities.Day09_C6_ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_C24_JSUtilTest {

    Day09_C12_LoginPage loginPage;

    @Test
    public void scrollIntoView(){
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url"));

        loginPage = new Day09_C12_LoginPage();
            loginPage.advancedLink.click();
            loginPage.proceedLink.click();

        WebElement haveAQuestion = Day09_C4_Driver.getDriver().findElement(By.xpath("//*[.='Have a Questions?']"));
        Day09_C19_JSUtils.scrollIntoViewJS(haveAQuestion);
        Day09_C18_ReusableMethods.waitFor(3);
//        What could be the reason waitfor doesn't work before
        // we need to wait AFTER SCROLLING for the TEXT to display properly
        Assert.assertEquals(haveAQuestion.getText(),"Have a Questions?");
        Day09_C4_Driver.closeDriver();
    }

    @Test
    public void clickWithJS(){
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url"));
        loginPage = new Day09_C12_LoginPage();
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        WebElement checkAvailabilityButton = Day09_C4_Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        Day09_C19_JSUtils.clickElementByJS(checkAvailabilityButton);
        Day09_C4_Driver.closeDriver();
    }

    @Test
    public void flashJS(){
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url"));
        loginPage = new Day09_C12_LoginPage();
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        WebElement checkAvailabilityButton = Day09_C4_Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        Day09_C19_JSUtils.flash(checkAvailabilityButton);
        Day09_C4_Driver.closeDriver();

    }

    @Test
    public void changeColorJS(){
        Day09_C4_Driver.getDriver().get(Day09_C6_ConfigReader.getProperty("app_url"));
        loginPage = new Day09_C12_LoginPage();
        loginPage.advancedLink.click();
        loginPage.proceedLink.click();

        WebElement checkAvailabilityButton = Day09_C4_Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        Day09_C19_JSUtils.changeColor("red",checkAvailabilityButton);
        Day09_C4_Driver.closeDriver();

    }

}
