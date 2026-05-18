package pages;

import base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.LoggerUtil;

public class ResetPasswordPage extends BasePage{
    private final Logger log = LoggerUtil.getLogger(this.getClass());

    public ResetPasswordPage(WebDriver driver){
        super(driver);
    }
    private final By userName = By.xpath("//input[@name='username']");
    private final By resetPassButton = By.xpath("//button[@type='submit']");

    public void enterUsername(String user){
        log.info("Entering username for forgot password");
        sendKeys(userName, user);
    }
    public void clickResetPassButton(){
        log.info("Clicking reset password button");
        click(resetPassButton);
    }

}
