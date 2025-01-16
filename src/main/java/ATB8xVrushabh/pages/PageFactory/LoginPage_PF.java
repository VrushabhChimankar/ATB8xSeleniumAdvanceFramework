package ATB8xVrushabh.pages.PageFactory;

import ATB8xVrushabh.base.CommonToAllPage;
import ATB8xVrushabh.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ATB8xVrushabh.driver.DriverManager.driver;

public class LoginPage_PF extends CommonToAllPage {

    //params constructor
    public LoginPage_PF (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Use @FindBy annotations to find elements
    @FindBy (xpath = "//input[@id='login-username']") WebElement username;
    @FindBy (xpath = "//input[@id='login-password']") WebElement password;
    @FindBy (xpath = "//button[@id='js-login-btn']") WebElement signInButton;
    @FindBy (id = "js-notification-box-msg") WebElement error_message;

    //Actions
    public String testLoginNegativeVWO(String user, String pass){

     driver.get(PropertyReader.readKey("url"));
     enterInput(username, user);
     enterInput(password, pass);
     clickElement(signInButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return error_message.getText();



    }




}
