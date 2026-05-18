package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ResetPasswordPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class ForgotPassword extends BaseTest {
    @Test
    public void forgotPassword(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.clickForgotPass();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(DriverFactory.getDriver());
        resetPasswordPage.enterUsername(ConfigReader.getProperty("username"));
        resetPasswordPage.clickResetPassButton();
    }


}
