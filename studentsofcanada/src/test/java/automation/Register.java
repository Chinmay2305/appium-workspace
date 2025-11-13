package automation;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register extends BaseTest
{
	String currentstatus = "Student";
	
	@Test(priority = 1)
	public void ClickSkip() throws InterruptedException
	{
		WebElement skip = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Skip']"));
		skip.click();
	}
	@Test(priority = 2)
	public void Register() throws InterruptedException
	{
		WebElement registerbtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Register']"));
		registerbtn.click();
		WebElement nextbtn = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));
		nextbtn.click();
		
		WebElement dropdown = driver.findElement(AppiumBy.accessibilityId("Select Current Status"));
		dropdown.click();
		
		WebElement studentOption = driver.findElement(AppiumBy.accessibilityId("Student"));
		studentOption.click();
		
		WebElement fullname = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
		fullname.sendKeys("Chinmay Agrawal");
	}
	
}