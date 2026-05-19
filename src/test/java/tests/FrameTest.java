package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FramePage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class FrameTest extends BaseTest {
    @Test
    private void frameTest(){
        FramePage framePage = new FramePage(DriverFactory.getDriver());
        framePage.verifyClickingiFrameLink();
        framePage.verifySwitchtoFrameTextBox(ConfigReader.getProperty("framenewtext"));
    }
}
