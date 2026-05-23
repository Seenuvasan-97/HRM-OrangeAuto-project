package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMpage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class EmployeeSearchPIM extends BaseTest {
    @Test
    private void employeeSearch(){
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        PIMpage piMpage = new PIMpage(DriverFactory.getDriver());
        piMpage.pimMethods(ConfigReader.getProperty("employeename"), ConfigReader.getProperty("employeeid"));
        Assert.assertEquals(piMpage.getNoRecordsFoundTM(), "No Records Found");
    }
}
