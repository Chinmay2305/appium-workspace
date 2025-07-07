package chinmay;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.io.File;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.android.nativekey.*;

public class Section9_51_52_HybridApp_Handle_Objects_InWebView_Context extends BaseTest_eCom
{
	@Test
	public void FillForm() throws InterruptedException, MalformedURLException, URISyntaxException
	{		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("chromedriver_autodownload", true);
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "Android Emulator");  // or specify a real device
		caps.setCapability("browserName", "chrome");
		caps.setCapability("chromedriverExecutable", "C:\\Users\\DELL\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Chinmay Agrawal");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double sum = 0;
		for(int i=0;i<count;i++)
		{
			String amountString = productPrices.get(i).getText();
			Double price = getFormattedAmount(amountString);
			sum = sum+price;
		}
		System.out.println(sum);
		Double actualPrice = getFormattedAmount(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
		Assert.assertEquals(actualPrice, sum);
		if(actualPrice.equals(sum))
		{
			System.out.println("Price is right");
		}
		else
		{
			System.out.println("Price is wrong");
		}
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		
		//This is a Hybrid App - Shows browser also
		//CONTEXT SWITCHING
		//CONTEXT NAME can be different for app and web each time. So ask the name from developer.
		Set<String> contexts = driver.getContextHandles();
		for(String contextName :contexts)
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3a API 32");
		options.setCapability("browserName", "Chrome");
		options.setChromedriverExecutable("C:\\Users\\DELL\\Downloads\\Softwares\\chromedriver-win64\\chromedriver.exe");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Chinmay Agrawal");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		
/*		URL appiumserverURL = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(appiumserverURL, caps);
		//Now i am in browser
		driver.findElement(By.name("q")).sendKeys("Chinmay Agrawal");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
*/		
//		teardown();
	}
}