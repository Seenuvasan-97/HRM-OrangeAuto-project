package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class LogoutTest extends BaseTest {
    @Test
    public void logOut(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
        dashboardPage.clickProfileDD();
        dashboardPage.clickLogoutDD();
        String loginMsg = dashboardPage.getLoginMessage();
        Assert.assertEquals(loginMsg, "Login");

    }
}
