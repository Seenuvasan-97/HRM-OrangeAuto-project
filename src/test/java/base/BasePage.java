package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

}
