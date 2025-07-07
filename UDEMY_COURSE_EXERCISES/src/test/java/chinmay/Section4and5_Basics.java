package chinmay;

import java.net.URL;
import java.io.File;
import org.aspectj.apache.bcel.classfile.Method;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Section4and5_Basics extends BaseTest
{
	@Test
	public void AppiumTest() throws MalformedURLException, InterruptedException
	{
		//APPIUMBY LOCATORS FOR MOBILE APP - xpath, id, accessibilityId, class name, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		//Set Wifi name in Preferences
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		//driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//ASSERTION OF POPUP BOX
		String alerttitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alerttitle, "WiFi settings");
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Testing Again");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}
}