package ATB8xVrushabh.driver;

import ATB8xVrushabh.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.io.IOException;

public class DriverManager  {



    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init()  {

        String browser = null;
        browser = PropertyReader.readKey("browser");
        browser = browser.toLowerCase();

        if (driver==null){
            switch (browser){
                case "chrome":

                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    break;

                default:
                    System.out.println("No browser found");


            }
        }




    }

    public static void tearDown(){

        if (driver!=null){
            driver.quit();
            driver = null;
        }

    }







}
