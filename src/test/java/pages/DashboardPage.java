package pages;

import base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.LoggerUtil;

public class DashboardPage extends BasePage {

    private final Logger log = LoggerUtil.getLogger(this.getClass());

    public DashboardPage(WebDriver driver){
        super(driver);
    }
    private final By admin = By.xpath("//span[text()='Admin']");
    private final By username = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By userRoleDD = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    private final By adminDD = By.xpath("//div[@role='option']//span[text()='Admin']");
    private final By statusDD = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
    private final By enabledDD = By.xpath("//div[@role='option']//span[text()='Enabled']");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By noRecordMessage = By.xpath("//span[text()='No Records Found']");
    private final By profileDD = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private final By logoutDD = By.linkText("Logout");
    private final By loginMessage = By.xpath("//h5[text()='Login']");

public void clickingAdmin(){
    log.info("Clicking Admin Button");
    click(admin);
}
public void enteringAdminUserame(String user){
    log.info("Entering Admin username");
    sendKeys(username, user);
}
public void clickingUserRoleDD(){
    log.info("Selecting User role drop down");
    click(userRoleDD);
}
public void clickingAdminOption(){
    log.info("Selecting Admin option");
    mouseHover(adminDD);
}
public void clickingStatusDD(){
    log.info("Selecting status drop down");
    click(statusDD);
}
public void clickingEnabledDD(){
    log.info("Selecting Enabled option");
    mouseHover(enabledDD);
}
public void clickingSearchButton(){
    log.info("Clicking search button");
    click(searchButton);
}
public void systemUserSearch(String user){
    clickingAdmin();
    enteringAdminUserame(user);
    clickingUserRoleDD();
    clickingAdminOption();
    clickingStatusDD();
    clickingEnabledDD();
    clickingSearchButton();
}
public void clickProfileDD(){
    log.info("Clicking profile dropdown");
    click(profileDD);
}
public void clickLogoutDD(){
    log.info("Clicking logout dropdown");
    click(logoutDD);
}
public String getNoRecordsErrorMessage(){
    return getText(noRecordMessage);
}
public String getLoginMessage(){
    return getText(loginMessage);
}
public void loggingOut(){
    clickProfileDD();
    clickLogoutDD();

}





}
