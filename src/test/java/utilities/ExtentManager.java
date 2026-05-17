package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extentReports;
    public static ExtentReports getInstance(){
        if (extentReports == null) {
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("test-output/OrangeHRMReport.html");
            extentSparkReporter.config().setReportName("Orange HRM Automation Report");
            extentSparkReporter.config().setDocumentTitle("Automation final report");
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);

            // Additional system information
            extentReports.setSystemInfo(
                    "Project Name",
                    "OrangeHRM Automation"
            );

            extentReports.setSystemInfo(
                    "Tester",
                    "Seenuvasan"
            );

            extentReports.setSystemInfo(
                    "Environment",
                    "QA"
            );

            extentReports.setSystemInfo(
                    "Browser",
                    "Chrome"
            );

            extentReports.setSystemInfo(
                    "OS",
                    System.getProperty("os.name")
            );

            extentReports.setSystemInfo(
                    "Java Version",
                    System.getProperty("java.version")
            );

        }
        return extentReports;
    }
}
