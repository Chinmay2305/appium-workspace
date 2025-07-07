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

public class Section6_35_AdvancedGestures_LongPress extends BaseTest
{
	@Test
	public void LongPress() throws MalformedURLException, InterruptedException
	{
		//APPIUMBY LOCATORS FOR MOBILE APP - xpath, id, accessibilityId, class name, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longpressAction(element);
		String menutext = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menutext, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	}
}