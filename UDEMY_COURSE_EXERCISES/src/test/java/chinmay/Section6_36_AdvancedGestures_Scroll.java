package chinmay;

import java.net.URL;
import java.io.File;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Section6_36_AdvancedGestures_Scroll extends BaseTest
{
	@Test
	public void Scroll() throws MalformedURLException, InterruptedException
	{
		//APPIUMBY LOCATORS FOR MOBILE APP - xpath, id, accessibilityId, class name, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//when you know exact position or text to scroll to
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Search View\"));"));
		
		//when you don't have fixed position to scroll to and want to scroll randomly
		boolean scrollMore = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left",100, "top",100,"width", 200, "height", 200, "direction", "down", "percent", 3.0));
		
		//scroll till end
	//	scrollToEndAction();
	}
}