package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import shreepatan.shreepatan.BaseTest;

public class LoginPage
{
	AndroidDriver driver;

    public LoginPage(AndroidDriver driver)
    {
    	this.driver = driver;
    }
    
    public void handleNotificationPopup()
    {
        By allow = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
        By deny = AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button");
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
            if(wait.until(d -> d.findElements(allow).size() > 0))
            {
                driver.findElement(allow).click();
                return;
            }
        }
        catch(Exception e)
        {
        }

        try
        {
            if(driver.findElements(deny).size() > 0)
            {
                driver.findElement(deny).click();
            }
        }
        catch(Exception e)
        {
        }
    }
    
    public void waitForLoginScreen()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }
    
    // Locators
    private By title = AppiumBy.accessibilityId("Welcome");
    private By title2 = AppiumBy.accessibilityId("Please Sign in to Continue");
    private By loginheading = AppiumBy.accessibilityId("Enter Mobile Number");
    private By btnLogin = AppiumBy.accessibilityId("LOGIN");
    private By txtMobile = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(1)");
    private By toast = AppiumBy.xpath("//android.widget.Toast");
    
    public void confirmLabels()
    {
        String actualTitle = driver.findElement(title).getAttribute("contentDescription");
        String actualTitle2 = driver.findElement(title2).getAttribute("contentDescription");
        String actualHeading = driver.findElement(loginheading).getAttribute("contentDescription");
        
        //Labels verification
        Assert.assertEquals(actualTitle, "Welcome");
        BaseTest.test.pass("Verified Title: Welcome");
        Assert.assertEquals(actualTitle2, "Please Sign in to Continue");
        BaseTest.test.pass("Verified Subtitle: Please Sign in to Continue");
        Assert.assertEquals(actualHeading, "Enter Mobile Number");
        BaseTest.test.pass("Verified Login Heading: Enter Mobile Number");

        //Button UI verifications
        Assert.assertTrue(driver.findElement(btnLogin).isDisplayed());
        BaseTest.test.pass("Button is displayed on the mobile screen");
        Assert.assertTrue(driver.findElement(btnLogin).isEnabled());
        BaseTest.test.pass("Button on the mobile screen is in enabled mode");
    }
    
    public void enterMobileNumber(String mobile)
    {
        driver.findElement(txtMobile).click();
        driver.findElement(txtMobile).clear();
        driver.findElement(txtMobile).sendKeys(mobile);
    }
    
    public String getEnteredMobileNumber()
    {
        return driver.findElement(txtMobile).getAttribute("text");
    }

    public void clickLogin()
    {
        driver.findElement(btnLogin).click();
    }

    public void login(String mobile)
    {
        enterMobileNumber(mobile);
        clickLogin();
    }
    
    public String getToastMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(toast)).getAttribute("text");
    }
    
    public void verifyToast(String expected)
    {
    	String actual = getToastMessage();

        try
        {
            Assert.assertEquals(actual, expected);
            BaseTest.test.pass("Verified Toast : " + actual);
        }
        catch (AssertionError e)
        {
            BaseTest.test.fail("Expected : " + expected);
            BaseTest.test.fail("Actual : " + actual);
            throw e;
        }
    }
}