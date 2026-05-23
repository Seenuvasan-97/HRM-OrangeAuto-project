package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DirectoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class jsDirectoryOrange extends BaseTest {
    @Test
    private void scrollDownTest(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
        DirectoryPage directoryPage = new DirectoryPage(DriverFactory.getDriver());
        directoryPage.clickDirectory();
        directoryPage.scrollDownToBottom();
    }
}
