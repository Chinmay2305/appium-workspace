package chinmay;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CropSearch extends BaseTest
{	
	@Test
	public void Search() throws InterruptedException, IOException
	{
		waitforelement(AppiumBy.xpath("//android.widget.Button[@content-desc='Continue']"), 10);
		waitforelement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Are you\nBUYER ?']"), 10);
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Continue']")).click();
		System.out.println("------Pressed Continue------");
        waitforelement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"), 10);
		System.out.println("------Pressed GPS------");
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='loading...']/android.view.View/android.view.View")));
		waitforelement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"), 60);
		
		String keyword = "Potato";
		
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys(keyword);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		
		By resultslocator = By.xpath("//android.view.View[contains(@content-desc, '" + keyword + "')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(resultslocator));
		List<WebElement> results = driver.findElements(resultslocator);
		System.out.println(results.size());
		for(WebElement el:results)
		{
			System.out.println(el.getAttribute("content-desc"));
		}
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}
}