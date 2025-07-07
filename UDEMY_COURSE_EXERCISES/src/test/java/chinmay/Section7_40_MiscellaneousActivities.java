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
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Section7_40_MiscellaneousActivities extends BaseTest
{
	@Test
	public void Miscellaneous()
	{

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//Set Wifi name in Preferences
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.id("android:id/checkbox")).click();
		//DEVICE ROTATING
		DeviceRotation landscape = new DeviceRotation(0, 0, 270);
		driver.rotate(landscape);
		
		driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
		//COPY TO CLIPBOARD AND PASTE FROM CLIPBOARD
		driver.setClipboardText("COPied teXT");
		driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		//PRESSING KEYS FROM DEVICE (HOME, BACK, ENTER)
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}