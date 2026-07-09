package FirstContacts.FirstContacts;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.ReportManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

    protected AndroidDriver driver;
    protected WebDriverWait wait;
    private AppiumDriverLocalService service;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass
    public void setUp() throws MalformedURLException
    {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Quality Analyst 3\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("LAVA LXX518 API 36.0");
        options.setPlatformName("Android");
        options.setAutomationName("UIAutomator2");
        options.setApp(
                "C:\\Users\\Quality Analyst 3\\Downloads\\Softwares\\android-workspace\\FirstContacts\\app\\build\\outputs\\apk\\debug\\FirstContacts.apk");
        options.setNewCommandTimeout(Duration.ofSeconds(120));
        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        extent = ReportManager.getReport();
    }

    @AfterClass
    public void tearDown()
    {
    	if (driver != null)
    		driver.quit();
    	if (service != null)
    		service.stop();
    	extent.flush();
    	try
    	{
    		java.awt.Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+ "/test-output/ExtentReport.html").toURI());
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}