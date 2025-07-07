package chinmay;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
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

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest_eCom
{
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{
		//Code to start server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
			
/*		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3a API 32");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);*/

		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3a API 32");
		options.setApp("C:\\Users\\DELL\\Downloads\\Softwares\\appium-workspace\\UDEMY_COURSE_EXERCISES\\src\\test\\java\\resources\\General-Store.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longpressAction(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"duration",2000));
	}
	
	public void scrollToEndAction()
	{
		boolean scrollMore;
		do
		{
			scrollMore = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width", 200, "height", 200, "direction", "down", "percent", 3.0));
		}
		while(scrollMore);
	}
	
	public void swipeAction(WebElement element, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
			    "direction", direction,
			    "percent", 0.05
			));
	}
	
	public Double getFormattedAmount(String amountString)
	{
		Double price = Double.parseDouble(amountString.substring(1));	//to remove $ sign and convert String to double
		return price;
	}
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		try
		{
			String command = "taskkill /F /IM C:\\Users\\DELL\\AppData\\Roaming\\npm\\appium.exe";
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", command);
			Process process = pb.start();
			process.waitFor();
			System.out.println("Killed");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}