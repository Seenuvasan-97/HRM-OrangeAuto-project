package pages;

import base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.LoggerUtil;

public class ClaimPage extends BasePage {
    private static final Logger log = LoggerUtil.getLogger(ClaimPage.class);

    public ClaimPage(WebDriver driver){
        super(driver);
    }

    private final By assignClaimButton = By.xpath("//button[text()=' Assign Claim ']");
    private final By employeeNameSearchBox = By.xpath("//input[@placeholder='Type for hints...']");
    private final By eventDD = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    private final By currencyDD = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
    private final By remarksTextBox = By.xpath("//label[text()='Remarks']");



}
