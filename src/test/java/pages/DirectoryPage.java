package pages;

import base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.LoggerUtil;

public class DirectoryPage extends BasePage {

    private static final Logger log = LoggerUtil.getLogger(DirectoryPage.class);

    public DirectoryPage(WebDriver driver){
        super(driver);
    }
    private final By directory = By.xpath("//a[@href=\"/web/index.php/directory/viewDirectory\"]");
    private final By scrollDownInc = By.linkText("OrangeHRM, Inc");

    public void clickDirectory(){
        log.info("Clicking directory");
        click(directory);
    }
    public void scrollDownToBottom(){
        log.info("Scrolling down to bottom of the page");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement(scrollDownInc);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",webElement);
    }
}
