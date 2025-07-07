package chinmay;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class Section4and5_BasicTest extends BaseTest
{
	@BeforeSuite
	public void setupReport()
	{
		ExtentReportUtil.setupExtentReport();
	}
	
	@Test
	public void BasicTest()
	{
		ExtentReportUtil.startTest("Basic Test");
		
		try
		{
			ExtentReportUtil.logInfo("Clicking on Preferences");
			driver.findElement(AppiumBy.accessibilityId("Preference")).click();
			
			ExtentReportUtil.logInfo("Clicking on Preferences Dependencies");
			driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
			
			ExtentReportUtil.logInfo("Selecting the checkbox");
			driver.findElement(AppiumBy.id("android:id/checkbox")).click();
			
			ExtentReportUtil.logInfo("Clicking on WiFi Settings");
			driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();
			
			//ASSERTION OF POP-UP BOX
			ExtentReportUtil.logInfo("Confirming visibility of pop-up");
			String alerttitle = driver.findElement(By.id("android:id/alertTitle")).getText();
			Assert.assertEquals(alerttitle, "WiFi settings");
			
			ExtentReportUtil.logInfo("Entering the Wi-Fi name");
			driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Testing Again");
			
			ExtentReportUtil.logInfo("Clicking on OK button");
			driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
			
			ExtentReportUtil.logInfo("Testcase passed successfully");
		}
		catch(Exception e)
		{
			ExtentReportUtil.logFail("Basic Test Failed", e);
			Assert.fail("Test case failed due to exception: "+e.getMessage());
		}
		finally
		{
			driver.close();
			teardown();
		}
	}
	
	@AfterSuite
	public void teardownReport()
	{
		ExtentReportUtil.flushReport();
	}
}