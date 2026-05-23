package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class WindowsHandling extends BaseTest {
    @Test
    private void switchToLinkedIn(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.clickLinkedInLink();
        String linkedInUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(linkedInUrl.contains("orangehrm"), "orangehrm is not present");
    }
}
