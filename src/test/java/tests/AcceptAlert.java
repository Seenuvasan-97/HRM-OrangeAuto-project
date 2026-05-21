package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AlertsPage;
import utilities.DriverFactory;

public class AcceptAlert extends BaseTest {
    @Test
    private void acceptAlert(){
        AlertsPage alertsPage = new AlertsPage(DriverFactory.getDriver());
        alertsPage.clickJSAlert();
        alertsPage.switchToAlert();
    }
    @Test
    private void confirmAlert(){
        AlertsPage alertsPage = new AlertsPage(DriverFactory.getDriver());
        alertsPage.clickConfirmAlert();
        alertsPage.switchToAlert2();
    }

}
