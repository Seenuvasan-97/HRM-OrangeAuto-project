package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class OrangeHRMValidLogin extends BaseTest {

    @Test
    private void validLogin(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        String url = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("dashboard"));
    }
    @Test
    private void invalidLogin(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("invalidPassword"));
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertEquals(errorMsg, "valid credentials");

    }
}
