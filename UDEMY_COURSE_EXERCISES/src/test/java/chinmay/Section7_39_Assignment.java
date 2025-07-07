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

public class Section7_39_Assignment extends BaseTest
{
	@Test
	public void Assignment() throws MalformedURLException, InterruptedException
	{
		//APPIUMBY LOCATORS FOR MOBILE APP - xpath, id, accessibilityId, class name, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		//First button of OK Cancel dialog box
/*		driver.findElement(AppiumBy.id("io.appium.android.apis:id/two_buttons")).click();
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/button2")).getText(), "Cancel");
		Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/button1")).getText(), "OK");
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		Thread.sleep(2000);
*/		
/*		//Fourth button to confirm the result on each text click - List Dialog
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/select_button")).click();
		Thread.sleep(2000);
		
		int number=2;
		String textnumber = String.valueOf(number-1);
		String commandnumber = null;
		
		switch(number)
		{
		case 1:
			commandnumber = "one";
			break;
		case 2:
			commandnumber = "two";
			break;
		case 3:
			commandnumber = "three";
			break;
		case 4:
			commandnumber = "four";
			break;
		default:
			System.out.println("Invalid number");
			return;
		}
		
		if(!commandnumber.isEmpty())
		{
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Command " + commandnumber + "']")).click();
			String expectedMessage = "You selected: " + textnumber + " , Command " + commandnumber;
		    String actualMessage = driver.findElement(AppiumBy.id("android:id/message")).getText();

		    Assert.assertEquals(actualMessage, expectedMessage, "Verification failed for Command " + commandnumber);			
		}
*/		
		
		//Sixth button for radio button confirm - Single choice list
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/radio_button")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Satellite']")).click();
		driver.findElement(AppiumBy.id("android:id/button2")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/radio_button")).click();
		Thread.sleep(1000);
		if(driver.findElement(AppiumBy.id("android:id/button2")).isSelected())
		{
			System.out.println("Selected");
		}
		else
		{
			System.out.println("Not Selected");
		}
	}
}