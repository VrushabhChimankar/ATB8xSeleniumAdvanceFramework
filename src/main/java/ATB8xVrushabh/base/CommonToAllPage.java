package ATB8xVrushabh.base;

import ATB8xVrushabh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ATB8xVrushabh.driver.DriverManager.driver;
import static ATB8xVrushabh.driver.DriverManager.getDriver;

public class CommonToAllPage {


    public void enterInput (By by, String key){

       getDriver().findElement(by).sendKeys(key);
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public WebElement getElement(By key){
      return  getDriver().findElement(key);
    }

   public WebElement visibilityOFElement(By elementLocation){
         return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));

   }







}
