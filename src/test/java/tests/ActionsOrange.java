package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMpage;
import utilities.DriverFactory;
import utilities.ExcelUtil;

import java.awt.*;
import java.io.IOException;

public class ActionsOrange extends BaseTest {
    @Test
    private void mouseHover() throws IOException {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ExcelUtil.excelReusable("Data1",1,1),ExcelUtil.excelReusable("Data1",2,1));
        PIMpage piMpage = new PIMpage(DriverFactory.getDriver());
        piMpage.clickingPIM();
        piMpage.mouseHoverUserDD();
        Assert.assertEquals(piMpage.validateAbout(), "About");

    }
    @Test
    private void rightClickTest() throws IOException, AWTException {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ExcelUtil.excelReusable("Data1",1,1),ExcelUtil.excelReusable("Data1",2,1));
        PIMpage piMpage = new PIMpage(DriverFactory.getDriver());
        piMpage.clickingPIM();
        piMpage.rightClickOnAddEmployee();

    }
}
