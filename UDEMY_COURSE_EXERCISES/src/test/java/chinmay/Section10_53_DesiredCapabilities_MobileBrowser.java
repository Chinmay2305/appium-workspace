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

public class Section10_53_DesiredCapabilities_MobileBrowser extends BaseTest_MobileBrowser
{
	@Test
	public void BrowserTest() throws InterruptedException, MalformedURLException, URISyntaxException
	{		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("chinmay agrawal");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
}