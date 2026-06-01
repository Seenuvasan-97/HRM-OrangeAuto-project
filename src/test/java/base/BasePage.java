package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.time.Duration;
import java.util.Set;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected WebElement waitForVisibility(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void click(By locator){
        waitForVisibility(locator).click();

    }
    protected void sendKeys(By locator, String text){
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }
    protected String getText(By locator){

        return waitForVisibility(locator).getText();
    }
    protected void mouseHover(By locator){
        WebElement element = waitForVisibility(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    protected void frameSwitch(By locator){
        WebElement element = waitForVisibility(locator);
        driver.switchTo().frame(element);
    }
    protected void alertAcceptHandling(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    protected void confirmAlertHandling(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    protected void promptAlertHandling(String text){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
    protected void windowsHandlingToNextTab(){
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for (String x: allWindow){
            if (!parentWindow.equals(x)) {
                driver.switchTo().window(x);
            }

        }
    }
    protected void rightClick(By locator){
        Actions actions = new Actions(driver);
        WebElement element = waitForVisibility(locator);
        actions.contextClick(element).perform();
    }
    protected void keyboardActions() throws AWTException {
        Robot robot = new Robot();
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


}
