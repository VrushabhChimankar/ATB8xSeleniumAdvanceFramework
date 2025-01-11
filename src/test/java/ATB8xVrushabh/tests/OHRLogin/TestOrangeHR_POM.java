package ATB8xVrushabh.tests.OHRLogin;

import ATB8xVrushabh.base.CommonToAllTest;
import ATB8xVrushabh.driver.DriverManager;
import ATB8xVrushabh.pages.PageObjectModel.OHR.DashboardPage_OHR_POM;
import ATB8xVrushabh.pages.PageObjectModel.OHR.LoginPage_OHR_POM;
import ATB8xVrushabh.utils.PropertyReader;
import io.qameta.allure.Description;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOrangeHR_POM extends CommonToAllTest {



    @Description("Verify that user login with valid credentials")
    @Test
    public void test_login_positive(){


        LoginPage_OHR_POM loginPageOhrPom = new LoginPage_OHR_POM(DriverManager.getDriver());
        loginPageOhrPom.loginOHR_POM(PropertyReader.readKey("ohr_username"), PropertyReader.readKey("ohr_password"));

        DashboardPage_OHR_POM dashboardPageOhrPom = new DashboardPage_OHR_POM(DriverManager.getDriver());
       String text_message = dashboardPageOhrPom.loginUsername();

        assertThat(text_message).isNotBlank().isNotNull().isNotEmpty();
       Assert.assertEquals(PropertyReader.readKey("ohr_expected_username"), text_message);

    }



}
