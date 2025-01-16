package ATB8xVrushabh.tests.vwoLogin.PageFactory;

import ATB8xVrushabh.base.CommonToAllTest;
import ATB8xVrushabh.driver.DriverManager;
import ATB8xVrushabh.listeners.RetryAnalyser;
import ATB8xVrushabh.pages.PageFactory.LoginPage_PF;
import ATB8xVrushabh.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(retryAnalyzer = RetryAnalyser.class)
public class TestLoginVWO_PF extends CommonToAllTest {


    private final Logger logger = LogManager.getLogger(TestLoginVWO_PF.class);

    @Test
    public void test_login_negative_vwo_PF(){

        logger.info("Staring the test with page factory");
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertyReader.readKey("url"));
        LoginPage_PF loginPagePf = new LoginPage_PF(driver);
       String text =  loginPagePf.testLoginNegativeVWO(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));



        logger.info("Ending the test with page factory");
        Assert.assertEquals(text, PropertyReader.readKey("error_message"));




    }




}
