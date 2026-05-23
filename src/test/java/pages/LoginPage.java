package pages;

import base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.LoggerUtil;

import java.util.Set;

public class LoginPage extends BasePage {
    private final Logger log = LoggerUtil.getLogger(this.getClass());

    public LoginPage(WebDriver driver){
        super(driver);
    }
    private final By username = By.xpath("//input[@name='username']");
    private final By password = By.xpath("//input[@name='password']");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By invalidCreds = By.xpath("//p[text()='Invalid credentials']");
    private final By forgotPass = By.xpath("//p[text()='Forgot your password? ']");
    private final By linkedInLink = By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']");

    public void enterUsername(String user){
        log.info("Entering username");
        sendKeys(username, user);
    }
    public void enterPassword(String pass){
        log.info("Entering password");
        sendKeys(password, pass);
    }
    public void clickLogin(){
        log.info("Clicking login button");
        click(loginButton);
    }
    public void login(String user, String pass){
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
    public void clickForgotPass(){
        click(forgotPass);
    }
    public String getErrorMessage(){

        return getText(invalidCreds);
    }
    public void clickLinkedInLink(){
        click(linkedInLink);
        windowsHandlingToNextTab();
    }


}
