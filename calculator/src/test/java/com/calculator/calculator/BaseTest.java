package com.calculator.calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.ServerCloneException;
import java.time.Duration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class BaseTest
{
	public AndroidDriver driver;
	private AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws IOException, MalformedURLException, InterruptedException
	{
		//Code to start server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		if(service.isRunning())
		{
			System.out.println("Service running on: "+service);
		}
		else
		{
			System.out.println("Failed to start server");
		}
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 8 API 31");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);

				
		UiAutomator2Options options = new UiAutomator2Options()
				.setDeviceName("Redmi Note 8 API 31")
				.setPlatformName("Android")
				.setApp("C:\\Users\\DELL\\Downloads\\Softwares\\appium-workspace\\calculator\\src\\test\\java\\resources\\Calculator_buttons.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void stopserver()
	{
		try
		{
			Process p = Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			p.waitFor();
			System.out.println("----------APPIUM PROCESS TERMINATED----------");
/*			if(service!=null && service.isRunning())
			{
				service.stop();
				System.out.println("Appium server stopped");
			}
			else
			{
				System.out.println("Appium server was not running");
			}*/
		}
		catch(Exception e)
		{
			System.out.println("Error stopping appium server "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public boolean isServerRunning()
	{
		return service!=null && service.isRunning();
	}
	
	public static int getDigitCount(int number)
	{
		return String.valueOf(Math.abs(number)).length();
	}
	
	public static String[] getDigits(double number)
	{
		String numberString = String.valueOf(number);
		int[] digits = new int[numberString.length()];
		for(int i=0;i<numberString.length();i++)
		{
			digits[i] = numberString.charAt(i) - '0';
		}
		//return digits;
		return numberString.split("");
	}
	
	public void waitforelement(By locator, int time)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = w.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
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
	
	public void createFile(String expectedresult, String actualresult, String statement) throws IOException
	{
		File f = new File("C:\\Users\\DELL\\OneDrive\\Desktop\\TestResult.txt");
		if(!f.exists())
		{
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(f, false);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(expectedresult);
		bw.newLine();
		bw.append(actualresult);
		bw.newLine();
		bw.append(statement);
		bw.newLine();
		bw.write("Time of result: "+java.time.LocalDateTime.now());
		bw.close();
	}
}