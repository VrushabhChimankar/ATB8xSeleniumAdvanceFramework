package ATB8xVrushabh.tests.vwoLogin.PageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandlingAmazon {

    @Test
    public void handle_amazon_site() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        //handle popup
        Thread.sleep(3000);       //
        //driver.findElement(By.xpath("//span[@role='button']")).click();

        //click on the mobile section

        List<WebElement> element = driver.findElements(By.xpath("//ul[@class='nav-ul']//li"));

        for (WebElement el : element){
            if (el.getText().contains("Mobiles")){
                el.click();
                break;
            }
        }

        //scroll up the page
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(1000);



        //select 10k to 15k

        List<WebElement> elementList = driver.findElements(By.xpath("//ul[@aria-labelledby='p_36-title']//li"));
        for (WebElement list : elementList){
            if (list.getText().contains("₹10,000 - ₹20,000")){
                list.click();
                break;

            }
        }


        //click on oneplus
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='OnePlus Nord CE4 Lite 5G (Super Silver, 8GB RAM, 128GB Storage)']")).click();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.in/OnePlus-Super-Silver-128GB-Storage/dp/B0D5YCYS1G/ref=sr_1_1?dib=eyJ2IjoiMSJ9.9d3JJHt_Mb7bCieb19LZEEwPgBMYJGybkKPgyZsFvLcpeexyFKhFeaeBAKclErHGA5tyzeOhkvvuaGoOSgCcku0pNZtMz3vVSysa-AdULoAWBC03I8tYyb26zAG5Vv2hgcJDCONtvzxOlURkIBExLjMIQlnB75nwAPOxv2hkH6y77Z4eAoN__jFWtv43hnbt0wh0qwe-5TPF1qldlplhOHIj-Ugd9m2losPoAX7YC6L3bbMl934zMGb5COTBqVJZhYcFq6od0YQW2OfqcGPeW_L0FuRylsOqUdoYtQYIkIg.mIBlR1GMq0fvZ0Ef--96DUCDoeuy1FCB4Y0BfiOvJeA&dib_tag=se&qid=1743687314&refinements=p_36%3A1318506031&rnid=1318502031&s=electronics&sr=1-1");

        //user clicks the links then it is jumping to the next tab

        Set<String> WindoHandle = driver.getWindowHandles();
        ArrayList<String> handle = new ArrayList();
        handle.addAll(WindoHandle);

        ////button[@class='QqFHMw vslbG+ In9uk2 JTo6b7']

       //scroll window upto 500 pixels
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("window.scrollBy(0, 500)");

        //click on add to cart button

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@id='submit.add-to-cart'])[2]"))).click();



        Thread.sleep(2000);
        //click on cart button
        ////span[@id='attach-sidesheet-view-cart-button']
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='attach-sidesheet-view-cart-button']"))).click();


        //validate that product is in cart page or not and check for product is more than 0

        List<WebElement> cart_items = driver.findElements(By.xpath("//span[@class='a-truncate-cut'][contains(text(),'OnePlus Nord CE4 Lite 5G (Super Silver, 8GB RAM, 1')]"));

               if (cart_items.size() > 0 ){
                   System.out.println("product added succesfully in the cart");
               }
               else {
                   System.out.println("product not found in the cart");
               }



               driver.close();
               driver.switchTo().window(handle.get(0));
               driver.quit();
    }
}
