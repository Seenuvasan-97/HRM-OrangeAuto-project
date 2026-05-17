package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.DriverFactory;
import utilities.ExtentManager;
import utilities.LoggerUtil;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {
    private static final ExtentReports extentReports = ExtentManager.getInstance();
    private static final Logger log = LoggerUtil.getLogger(TestListener.class);
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context){
        log.info("Execution Started");
    }
    @Override
    public void onTestStart(ITestResult result) {
        log.info("STARTING TEST: {}", result.getMethod().getMethodName());
        ExtentTest extentTest = extentReports.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result){
            log.info("TEST PASSED: {}", result.getMethod().getMethodName());
            test.get().pass("Test Passed");

        }
    @Override
    public void onTestFailure(ITestResult result){
        log.error("TEST FAILED: {}", result.getMethod().getMethodName());
        log.error("FAILURE REASON: ", result.getThrowable());
        test.get().fail(result.getThrowable());
        String screenshotPath = ScreenshotUtil.getScreenshot(DriverFactory.getDriver(),result.getMethod().getMethodName());
        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            log.error("unable to attach screenshot", e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result){
        log.warn("TEST SKIPPED: {}", result.getMethod().getMethodName());
        test.get().skip("Test Skipped");
    }
    @Override
    public void onFinish(ITestContext context){
        log.info("Execution finished");
        extentReports.flush();
    }



    }
