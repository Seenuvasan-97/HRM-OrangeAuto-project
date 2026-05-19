package pages;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends BasePage {
    private static final Logger log = LogManager.getLogger(FramePage.class);

    public FramePage(WebDriver driver){
        super(driver);
    }
    private static final By iFrameLink = By.linkText("iFrame");
    private static final By frameID = By.id("mce_0_ifr");
    private static final By textArea = By.id("tinymce");

    public void verifyClickingiFrameLink(){
        log.info("clicking iframe link");
        click(iFrameLink);
    }
    public void verifySwitchtoFrameTextBox(String newText){
        log.info("clearing existing text and entering new text");
        frameSwitch(frameID);
        sendKeys(textArea,newText);
    }

}
