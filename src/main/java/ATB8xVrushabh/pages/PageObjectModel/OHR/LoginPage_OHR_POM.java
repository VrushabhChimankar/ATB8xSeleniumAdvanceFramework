package ATB8xVrushabh.pages.PageObjectModel.OHR;

import ATB8xVrushabh.base.CommonToAllPage;
import ATB8xVrushabh.driver.DriverManager;
import ATB8xVrushabh.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_OHR_POM extends CommonToAllPage {

    WebDriver driver;

    //param Constructor
    public LoginPage_OHR_POM(WebDriver driver){

        this.driver = driver;
    }


    //page locators
    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By SignIn = By.xpath("//button[normalize-space()='Login']");


    //Page actions
    public void loginOHR_POM(String user, String pass){



        driver.get(PropertyReader.readKey("orange_hr_url"));
        visibilityOFElement(username);
        enterInput(username, user);
        enterInput(password, pass);
        clickElement(SignIn);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }




}
