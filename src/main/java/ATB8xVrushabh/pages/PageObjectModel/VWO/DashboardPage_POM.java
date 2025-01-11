package ATB8xVrushabh.pages.PageObjectModel.VWO;

import ATB8xVrushabh.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_POM extends CommonToAllPage {

    WebDriver driver;

    //param constructor
    public DashboardPage_POM(WebDriver driver){
        this.driver = driver;
    }

    //page locator
     private By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");


    //By page actions
    public String loggedInUserName() {

        return getElement(userNameOnDashboard).getText();
    }






}
