package pages;

import base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.LoggerUtil;

public class AlertsPage extends BasePage {
    private static final Logger log = LoggerUtil.getLogger(AlertsPage.class);

    public AlertsPage(WebDriver driver){
        super(driver);
    }

    private final By alertJS = By.xpath("//button[text()='Click for JS Alert']");
    private final By alertConfirm = By.xpath("//button[text()='Click for JS Confirm']");
    private final By alertPrompt = By.xpath("//button[text()='Click for JS Prompt']");

    public void clickJSAlert(){
        log.info("Clicking JS Alert");
        click(alertJS);
    }
    public void switchToAlert(){
        log.info("Switching to Alert");
        alertAcceptHandling();
    }
    public void clickConfirmAlert(){
        log.info("Clicking confirm alert");
        click(alertConfirm);
    }
    public void switchToAlert2(){
        log.info("Switching to Alert");
        confirmAlertHandling();
    }
    public void clickJSPrompt(){
        log.info("clicking js prompt");
        click(alertPrompt);
    }
    public void switchToPromptAlert(){
        log.info("Switching to prompt alert");
        promptAlertHandling("Enter");
    }





}
