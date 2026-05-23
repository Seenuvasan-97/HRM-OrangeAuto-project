package pages;

import base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.LoggerUtil;

import java.awt.*;

public class PIMpage extends BasePage {

    private final Logger log = LoggerUtil.getLogger(this.getClass());

    public PIMpage(WebDriver driver){
        super(driver);
    }
    private final By pim = By.xpath("//span[text()='PIM']/parent::a");
    private final By employeeName = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
    private final By employeeID = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By employeeStatusDD = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']/parent::div)[1]");
    private final By selectFreelance = By.xpath("//div[@role='option']//span[text()='Freelance']");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By noRecordsToastMessage = By.xpath("//p[contains(@class,'toast-message')]");
    private final By addEmployee = By.linkText("Add Employee");
    private final By userDD = By.cssSelector(".oxd-userdropdown-tab");
    private final By hoverToAbout = By.linkText("About");
    private final By about = By.xpath("//h6[text()='About']");

    public void clickingPIM(){
        log.info("clicking PIM");
        click(pim);
    }
    public void enterEmployeeName(String name){
        log.info("Entering Employee Name");
        sendKeys(employeeName, name);
    }
    public void enterEmployeeID(String id){
        log.info("Entering Employee ID");
        sendKeys(employeeID, id);
    }
    public void clickingEmpStatusDD(){
        log.info("Clicking Employee status DD");
        click(employeeStatusDD);
    }
    public void selectFreelance(){
        log.info("Selecting freelance option");
        click(selectFreelance);
    }
    public void clickingSearchButton(){
        log.info("Clicking search button");
        click(searchButton);
    }
    public String getNoRecordsFoundTM(){
        log.info("Toast message validated for no records found");
        return getText(noRecordsToastMessage);
    }
    public void pimMethods(String name, String id){
        clickingPIM();
        enterEmployeeName(name);
        enterEmployeeID(id);
        clickingEmpStatusDD();
        selectFreelance();
        clickingSearchButton();
    }
    public void clickAddEmployee(){
        click(addEmployee);
    }
    public void mouseHoverUserDD(){
        click(userDD);
        mouseHover(hoverToAbout);
        log.info("mouse hovered");
    }
    public String validateAbout(){
        return getText(about);
    }
    public void rightClickOnAddEmployee() throws AWTException {
        log.info("Clicking right on Add employee");
        rightClick(addEmployee);
        keyboardActions();
    }
}
