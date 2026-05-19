package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUser;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class DeleteAdminUser extends BaseTest {
    @Test
    private void deleteUser(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
        dashboardPage.clickingAdmin();
        dashboardPage.enteringAdminUserame(ConfigReader.getProperty("adminUsername"));
        dashboardPage.clickingSearchButton();
        AdminUser adminUser = new AdminUser(DriverFactory.getDriver());
        adminUser.clickDeleteButton();
        String errorMsg = adminUser.getErrorToastMessage();
        Assert.assertTrue(errorMsg.contains("Cannot be deleted"), "Toast message not displayed");
    }
}
