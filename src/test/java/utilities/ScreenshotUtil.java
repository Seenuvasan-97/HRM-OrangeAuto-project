package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String getScreenshot(WebDriver driver, String testName){
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String destination = "test-output/screenshots/"+testName+"_"+timeStamp+".png";
        try {
            FileUtils.copyFile(source,new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
}
