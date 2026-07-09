package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.ServerCloneException;
import java.time.Duration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pages.LoginPage;
import shreepatan.shreepatan.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class LoginTest extends BaseTest
{
	private LoginPage c;
	
	@BeforeClass
	public void initPage()
	{
		c = new LoginPage(driver);
	}
		
	@Test(priority=1)
	public void loginPage()
	{
		test = extent.createTest("Login Page");
	    test.info("Verifying Login UI");
	    c.handleNotificationPopup();   // If popup appears, close it
	    c.waitForLoginScreen();        // Wait until login screen is visible
	    c.confirmLabels();             // Verify labels
	    test.pass("Login UI elements verified successfully");
	}
	
	@Test(priority = 2)
	public void emptyLogin()
	{
	    test = extent.createTest("Empty Login");
	    c.login("");
	    c.verifyToast("Please Enter Phone Number");
	}
	
	@Test(priority = 3)
	public void unregisteredMobileNumber()
	{
		test = extent.createTest("Unregistered Mobile Number");
	    c.login("9898989898");
	    c.verifyToast("User not exist");
	    test.pass("User not exist");
	}
	
	@Test(priority = 4)
	public void invalidMobileFormat()
	{
		test = extent.createTest("Invalid Mobile Format");
	    c.login("1231231231");
	    c.verifyToast("Please Enter Valid Contact Number");
	    test.pass("Verified invalid mobile number format.");
	}
	
	@Test(priority = 5)
	public void invalidDigits()
	{
	    test = extent.createTest("Invalid Digits");
	    c.login("12345");
	    c.verifyToast("Please Enter Valid Contact Number");
	}
	
	@Test(priority = 6)
	public void verifyAlphabetNotAllowed()
	{
	    test = extent.createTest("Alphabet Input Validation");
	    c.login("abcdef");
	    c.verifyToast("Please Enter Phone Number");
	    test.pass("Application ignored alphabet input and displayed the correct validation message.");
	}
	
	@Test(priority = 7)
	public void verifySpecialCharactersNotAllowed()
	{
	    test = extent.createTest("Special Character Validation");
	    c.login("@#$%^&*");
	    c.verifyToast("Please Enter Phone Number");
	    test.pass("Application ignored special characters and displayed the correct validation message.");
	}
	
	@Test(priority = 8)
	public void verifySpacesNotAllowed()
	{
	    test = extent.createTest("Space Validation");
	    c.login(" 2  3 ");
	    c.verifyToast("Please Enter Phone Number");
	    test.pass("Application ignored spaces and displayed the correct validation message.");
	}
	
	@Test(priority = 9)
	public void verifyMaximumTenDigits()
	{
		test = extent.createTest("Maximum 10 Digits Validation");
	    String input = "98765432101234";
	    c.enterMobileNumber(input);
	    String actual = c.getEnteredMobileNumber();
	    Assert.assertEquals(actual.length(), 10, "Application accepted more than 10 digits");
	    Assert.assertEquals(actual, input.substring(0,10),"Application did not retain only the first 10 digits");
	    test.pass("Application accepted only first 10 digits : " + actual);
	}
}