package pages;

import base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.LoggerUtil;

public class AdminUser extends BasePage {

    private final Logger log = LoggerUtil.getLogger(this.getClass());

    public AdminUser(WebDriver driver){
        super(driver);
    }
    private final By deleteButton = By.xpath("(//div[text()='Admin']/ancestor::div[@role='row']//button)[1]");
    private final By toastMessage = By.xpath("//p[contains(@class,'toast-message')]");

    public void clickDeleteButton(){
        log.info("Clicking delete button");
        click(deleteButton);
    }
    public String getErrorToastMessage(){
        log.info("Validating toast message");
        return getText(toastMessage);
    }
}
