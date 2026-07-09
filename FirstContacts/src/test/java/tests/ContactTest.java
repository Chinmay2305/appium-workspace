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
import pages.ContactPage;

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

import FirstContacts.FirstContacts.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class ContactTest extends BaseTest
{
	private ContactPage c;
	private final String name = "Tester Agrawal";
	private final String country = "+61";
	private final String phone = "1020304050";
	private final String email = "tester@gmail.com";
	
	private final String updatedname = "Automation Tester";
	private final String updatedcountry = "+44";
	private final String updatedphone = "2468024680";
	private final String updatedemail = "automator@testers.com";
	
	@BeforeClass
	public void initPage()
	{
		c = new ContactPage(driver);
	}
		
	@Test(priority=1)
	public void addContact()
	{
		test = extent.createTest("Add Contact");
	    test.info("Entering contact details");
		c.addContact(name, country, phone, email);
		
		test.info("Verifying contact is created");
	    Assert.assertTrue(c.isContactPresent(name, country+phone, email));
	    
	    test.pass("Contact added successfully");
	}
	
	@Test(priority=2)
	public void editContact()
	{
		test = extent.createTest("Edit Contact");
	    test.info("Editing existing contact");

	    c.editContact(updatedname,updatedcountry,updatedphone,updatedemail);
	    Assert.assertTrue(c.isContactPresent(updatedname,updatedcountry + updatedphone,updatedemail));
	    test.pass("Contact edited successfully");
	}
			
	public static int getDigitCount(int number)
	{
		return String.valueOf(Math.abs(number)).length();
	}
	
	public static String[] getDigits(double number)
	{
		String numberString = String.valueOf(number);
		int[] digits = new int[numberString.length()];
		for(int i=0;i<numberString.length();i++)
		{
			digits[i] = numberString.charAt(i) - '0';
		}
		//return digits;
		return numberString.split("");
	}
}