package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day09_C19_JSUtils {


    // Bu method 2 tane parametre alir : WebElement, and WebDriver
    // element pass edildiginde, JS elementin uzerine click eder
    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Day09_C4_Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();", element);
    }

    //page title'i JS ile almak icin
    public static String getTitleByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Day09_C4_Driver.getDriver());
        String title = jsexecutor.executeScript("return document.title;").toString();
        return title;
    }

    //en asagiya kadar sayfayi kaydirmak icin (Scrolling all the way down)
    public static void scrollDownByJS() {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Day09_C4_Driver.getDriver());
        jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //Scroll into view with JS. THIS IS VERY USEFULL
    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Day09_C4_Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void changeColor(String color, WebElement element) {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Day09_C4_Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //Flashing the background color
    public static void flash(WebElement element) {
        String bgColor = element.getCssValue("backgroundcolor");
        for (int i = 0; i < 5; i++) {
            changeColor("rgb(0,200,0", element);
            changeColor(bgColor, element);
        }
    }
    //Ihtiyac duydugunda bir alert olusturur
    public static void generateAlert(String message) throws InterruptedException {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Day09_C4_Driver.getDriver());
        javascriptExecutor.executeScript("alert('" + message + "')");
        Thread.sleep(3000);
    }

    /*
     * executes the given JavaScript command on given web element
     */
    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Day09_C4_Driver.getDriver();
        jse.executeScript(command, element);
    }
    /*
     * executes the given JavaScript command on given web element
     */
    public static void executeJScommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Day09_C4_Driver.getDriver();
        jse.executeScript(command);
    }
}
