package chinmay;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest
{
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{
		//code to start the server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 8 API 31");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Redmi Note 8 API 31");
		options.setApp("C:\\Users\\DELL\\Downloads\\Practice Apps\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longpressaction(WebElement element)
	{
		((JavascriptExecutor)driver).
		executeScript("mobile: longclickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(), "duration",2000));
	}
	
	public void scrolltoendaction()
	{
		boolean scrollmore;
		do
		{
			scrollmore = (Boolean)((JavascriptExecutor)driver).
					executeScript("mobile: scrollGesture", 
							ImmutableMap.of("left",100, "top",100,"width", 200, 
									"height", 200, "direction", "down", "percent", 3.0));
		}
		while(scrollmore);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
		service.stop();
	}
}