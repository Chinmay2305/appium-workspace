package chinmay;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProduct extends BaseTest
{
	@Test
	public void Search() throws InterruptedException
	{	
		WebElement editText = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Find your coffee']"));
		editText.click();
		Thread.sleep(5000);
		String searchtext = "CORTADO";
		editText.sendKeys(searchtext);
		driver.hideKeyboard();
		Thread.sleep(5000);
		String searchresult = driver.findElement(AppiumBy.className("android.widget.ImageView")).getAttribute("content-desc").split("\\n")[0];
		if(searchtext.equalsIgnoreCase(searchresult))
		{
			System.out.println("\n\n");
			System.out.println("-x-x-x-x-x-Search page: The result is coming-x-x-x-x-x-");
			System.out.println("\n\n");
		}
		else
		{
			System.out.println("\n\n");
			System.out.println("-x-x-x-x-x-Search page: The result is not coming-x-x-x-x-x-");
			System.out.println("\n\n");
		}
		//Now going inside the product
		driver.findElement(AppiumBy.className("android.widget.ImageView")).click();
		Thread.sleep(5000);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement pricetitle = w.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc='Price']")));
		System.out.println("-x-x-x-x-"+pricetitle.getText().toString());
		

/*		System.out.println(title.getAttribute("content-desc"));
		
		if(searchtext.equalsIgnoreCase(title.getAttribute("content-desc")))
		{
			System.out.println("\n\n");
			System.out.println("-x-x-x-x-x-Product page: The result is coming-x-x-x-x-x-");
			System.out.println("\n\n");
		}
		else
		{
			System.out.println("\n\n");
			System.out.println("-x-x-x-x-x-Product page: The result is not coming-x-x-x-x-x-");
			System.out.println("\n\n");
		}*/				
	}
}