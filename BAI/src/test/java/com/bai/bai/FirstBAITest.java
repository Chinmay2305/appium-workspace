package com.bai.bai;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.awt.Point;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.util.List;


public class FirstBAITest extends BaseTest
{
	@Test
	public void Search() throws InterruptedException, IOException
	{
		clearClipboard();
		
		String search = "contech";
		
		waitforelement(AppiumBy.xpath("//android.widget.EditText[@resource-id='ratname']"), 10);
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='ratname']")).sendKeys(search);
		Thread.sleep(5000);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(5000);
		List<WebElement> textViews = driver.findElements(AppiumBy.androidUIAutomator("new UISelector().textcontains(\""+search+"\")"));
		for(WebElement e:textViews)
		{
			String elementText = e.getText();
			System.out.println("THIS IS THE ONE: "+elementText);
	/*		if(elementText!=null && elementText.contains(search))
			{
				System.out.println("Match found: "+elementText);
			}
			else
			{
				System.out.println("No match for: "+elementText);
			}*/
		}
		
		
/*		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence click = new Sequence(finger,0)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 888, 560))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singletonList(click));*/
	}
}