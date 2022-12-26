package com.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_C4_Driver {
    private static WebDriver driver;
    /*
            getDriver() method is used for:
            1. SetUp driver
            2. driver olustur
            3. return driver
            *driver ----->>>>>> Day09_C4_Driver.getDriver()
     */
    public static WebDriver getDriver(){
        if (driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

//        if (driver==null){// Eger driver bir yeri isaret etmiyorsa/kullanilmiyorsa, driver calistir
//            switch (ConfigReader.getProperty("browser")){
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    break;
//                /* headless browser ekranda actual (gercek) browser olmadan background (arkaplanda)'da kosar
//
//                 */
//                case "chrome-headless":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
//                    break;
//            }

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){ // eger driver bir yeri isaret ediyorsa veya kullaniliyorsa
            driver.quit();//close the driver
            driver=null;// driver null yap böylece sürücüyü yeniden başlatabiliriz/calistirabiliriz.
        }

    }

}
