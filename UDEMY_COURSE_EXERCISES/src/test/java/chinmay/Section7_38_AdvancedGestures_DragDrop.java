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

public class Section7_38_AdvancedGestures_DragDrop extends BaseTest
{
	@Test
	public void Swipe() throws MalformedURLException, InterruptedException
	{
		//APPIUMBY LOCATORS FOR MOBILE APP - xpath, id, accessibilityId, class name, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement sourcepoint = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) sourcepoint).getId(),
			    "endX", 800,
			    "endY", 800
			));
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");
	}
}