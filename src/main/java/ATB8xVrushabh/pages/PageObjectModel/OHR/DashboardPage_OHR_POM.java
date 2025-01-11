package ATB8xVrushabh.pages.PageObjectModel.OHR;

import ATB8xVrushabh.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_OHR_POM extends CommonToAllPage {


    WebDriver driver;
    public DashboardPage_OHR_POM(WebDriver driver){
        this.driver = driver;
    }


    //page locators
    private By dashboard_page = By.xpath("//h6[normalize-space()='PIM']");

    //page actions
    public String loginUsername(){

      return  getElement(dashboard_page).getText();
    }

}
