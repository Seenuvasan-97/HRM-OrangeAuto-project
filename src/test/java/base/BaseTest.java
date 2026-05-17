package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.DriverFactory;
import utilities.LoggerUtil;

import java.time.Duration;

public class BaseTest {

    private final Logger log = LoggerUtil.getLogger(this.getClass());
    protected WebDriver driver;

@BeforeMethod
    public void setUp(){
    log.info("Initializing Browser");
    DriverFactory.initializeDriver();
    log.info("Browser launched successfully");
}
@AfterMethod
    public void tearDown(){
    log.info("Closing Browser");
    DriverFactory.quitDriver();
    log.info("Browser closed successfully");
}

}
