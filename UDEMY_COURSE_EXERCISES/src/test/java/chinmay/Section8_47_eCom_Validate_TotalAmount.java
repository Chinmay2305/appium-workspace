package chinmay;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.io.File;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Section8_47_eCom_Validate_TotalAmount extends BaseTest_eCom
{
	@Test
	public void FillForm() throws InterruptedException
	{
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Chinmay Agrawal");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(xpath((//android.widget.TextView[@text='ADD TO CART'])[2]));"));
		
/*		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[2]")).click();
		driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[4]")).click();
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
			Double price = Double.parseDouble(amountString.substring(1));	//to remove $ sign and convert String to double
			sum = sum+price;
		}
		System.out.println(sum);
		Double actualPrice = Double.parseDouble(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
		Assert.assertEquals(actualPrice, sum);
		if(actualPrice.equals(sum))
		{
			System.out.println("Price is right");
		}
		else
		{
			System.out.println("Price is wrong");
		}*/
	}
}