package ATB8xVrushabh.tests.vwoLogin.PageObjectModel;

import ATB8xVrushabh.base.CommonToAllTest;
import ATB8xVrushabh.driver.DriverManager;
import ATB8xVrushabh.pages.PageObjectModel.VWO.DashboardPage_POM;
import ATB8xVrushabh.pages.PageObjectModel.VWO.LoginPage_POM;
import ATB8xVrushabh.utils.PropertyReader;
import io.qameta.allure.Description;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestLoginVWO_POM extends CommonToAllTest {


    @Description("Verify that invalid credentials gives error message")
     @Test
    public void testLoginNegativeVWO()  {

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        String error_message = loginPagePom.testLoginVWONegative(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));

        assertThat(error_message).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_message, PropertyReader.readKey("error_message"));

    }

   @Description("Verify that successful login with valid credentials")
    @Test
    public void testLoginPositiveVWO(){

        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        loginPagePom.testLoginVWONegative(PropertyReader.readKey("username"), PropertyReader.readKey("password"));

        DashboardPage_POM dashboardPagePom = new DashboardPage_POM(DriverManager.getDriver());
        String loginusername = dashboardPagePom.loggedInUserName();

       assertThat(loginusername).isNotBlank().isNotNull().isNotEmpty();
       Assert.assertEquals(loginusername, PropertyReader.readKey("expected_username"));


   }




}
