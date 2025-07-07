package chinmay;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil
{
	private static ExtentReports extent;
	private static ExtentTest test;

    public static void setupExtentReport()
    {
    	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
    	sparkReporter.config().setTheme(Theme.STANDARD);
    	sparkReporter.config().setDocumentTitle("Test Report");
    	sparkReporter.config().setReportName("Appium Test Execution Report");
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    
    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message, Throwable t) {
        test.fail(message).fail(t);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}