package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class AdminSystemUserFind extends BaseTest {
@Test
    public void findingUser(){
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
    String url = DriverFactory.getDriver().getCurrentUrl();
    Assert.assertTrue(url.contains("dashboard"));
    DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
    dashboardPage.systemUserSearch(ConfigReader.getProperty("adminUsername"));
    String errorMsg = dashboardPage.getNoRecordsErrorMessage();
    Assert.assertEquals(errorMsg,"No Records Found");
}

}
