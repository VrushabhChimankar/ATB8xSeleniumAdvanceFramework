package ATB8xVrushabh.pages.PageObjectModel.VWO;

import ATB8xVrushabh.base.CommonToAllPage;
import ATB8xVrushabh.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM extends CommonToAllPage {

    WebDriver driver;

    //Param Constructor
    public LoginPage_POM(WebDriver driver){
        this.driver = driver;
    }


    //Page locator
    private By username = By.xpath("//input[@id='login-username']");
    private By password = By.xpath("//input[@id='login-password']");
    private By SignInButton  = By.xpath("//button[@id='js-login-btn']");
    private By message = By.id("js-notification-box-msg");

    //Page actions

    public String testLoginVWONegative(String user, String pwd)  {

        driver.get(PropertyReader.readKey("url"));
        enterInput(username,user);
        enterInput(password, pwd);
        clickElement(SignInButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String error_message_text = driver.findElement(message).getText();
        return error_message_text;





    }


}
