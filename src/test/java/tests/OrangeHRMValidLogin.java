package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ExcelUtil;

import java.io.IOException;

public class OrangeHRMValidLogin extends BaseTest {

    @DataProvider(name = "Login with three different data")
    private Object[][] testData(){
        return new Object[][]{
                {"Username1","Password1"},
                {"Username2", "Password2"},
                {"Username3","Password3"}
        };
    }
    @Test(dataProvider = "Login with three different data")
    private void dataProviderLogin(String username, String password){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(username, password);
        System.out.println("Executing with Username: " + username +
                " Password: " + password);
    }

    @Test
    private void validLogin() throws IOException {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ExcelUtil.excelReusable("Data1",1,1),ExcelUtil.excelReusable("Data1",2,1));
        String url = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("dashboard"));
    }
    @Test
    private void invalidLogin(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("invalidPassword"));
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertEquals(errorMsg, "Invalid credentials");

    }
}
